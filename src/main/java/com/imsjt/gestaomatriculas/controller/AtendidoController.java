package com.imsjt.gestaomatriculas.controller;

import com.imsjt.gestaomatriculas.dto.AtendidoDTO;

import com.imsjt.gestaomatriculas.service.AtendidoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Classe esta funcionando porém falta criar aos DTOS e implementar os métodos de atualizar e tratar exceções


@RestController
@RequestMapping("/api/atendidos")
@AllArgsConstructor
public class AtendidoController {

    private AtendidoService atendidoService;

    @PostMapping
    public ResponseEntity<AtendidoDTO> cadastrar(@Valid @RequestBody AtendidoDTO atendidoDTO) {
        AtendidoDTO novoAtendido = atendidoService.cadastrarAtendido(atendidoDTO);
        return new ResponseEntity<>(novoAtendido, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AtendidoDTO>> listarTodos() {
        List<AtendidoDTO> atendidos = atendidoService.listarTodosAtendidos();
        return ResponseEntity.ok(atendidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtendidoDTO> buscarPorId(@PathVariable Long id) {
        AtendidoDTO atendido = atendidoService.buscarAtendidoPorId(id);
        return ResponseEntity.ok(atendido);
    }
//TODO: Implementar o método de atualizar

    @PutMapping("/{id}")
    public ResponseEntity<AtendidoDTO> atualizar(@Valid @PathVariable Long id, @RequestBody AtendidoDTO atendidoDTO) {
        AtendidoDTO atendidoAtualizado = atendidoService.atualizarAtendido(id, atendidoDTO);
        return ResponseEntity.ok(atendidoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> remover(@PathVariable Long id) {
        atendidoService.deletarAtendido(id);
        return ResponseEntity.ok("Atendido deletado com sucesso!");

    }


}
