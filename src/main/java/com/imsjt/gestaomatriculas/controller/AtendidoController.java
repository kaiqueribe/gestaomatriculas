package com.imsjt.gestaomatriculas.controller;

import com.imsjt.gestaomatriculas.entity.Atendido;
import com.imsjt.gestaomatriculas.service.AtendidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/atendidos")
public class AtendidoController {

    private AtendidoService atendidoService;


        @PostMapping
        public ResponseEntity<Atendido> cadastrar(@RequestBody Atendido atendido) {
            Atendido novoAtendido = atendidoService.cadastrarAtendido(atendido);
            return new ResponseEntity<>(novoAtendido, HttpStatus.CREATED);
        }

        @GetMapping
        public ResponseEntity<List<Atendido>> buscarTodos() {
            List<Atendido> atendidos = atendidoService.listarTodosAtendidos();
            return ResponseEntity.ok(atendidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Atendido> buscarPorId(@PathVariable Long id) {
        Atendido atendido = atendidoService.buscarAtendidoPorId(id);
        return ResponseEntity.ok(atendido);
    }
//TODO: Implementar o método de atualizar

//    @PutMapping("/{id}")
//    public ResponseEntity<Atendido> atualizar(@PathVariable Long id, @RequestBody Atendido atendido) {
//        Atendido atendidoAtualizado = atendidoService.atualizarAtendido(id, atendido);
//        return ResponseEntity.ok(atendidoAtualizado);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> remover(@PathVariable Long id) {
        atendidoService.deletarAtendido(id);
        return ResponseEntity.ok("Atendido deletado com sucesso!");

    }


}
