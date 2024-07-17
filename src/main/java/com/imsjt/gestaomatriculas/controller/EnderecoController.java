package com.imsjt.gestaomatriculas.controller;

import com.imsjt.gestaomatriculas.entity.Endereco;
import com.imsjt.gestaomatriculas.service.AtendidoService;
import com.imsjt.gestaomatriculas.service.EndereçoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {

    private final AtendidoService atendidoService;
    private EndereçoService endereçoService;

    public EnderecoController(AtendidoService atendidoService) {
        this.atendidoService = atendidoService;
    }


    @PostMapping
    public ResponseEntity<Endereco> cadastrar(@RequestBody Endereco endereco) {
        Endereco novoEndereco = endereçoService.cadastrarEndereco(endereco);
        return ResponseEntity.ok(novoEndereco);
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> buscarTodos() {
        List<Endereco> enderecos = endereçoService.listarTodosEnderecos();
        return ResponseEntity.ok(enderecos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> buscarPorId(@PathVariable Long id) {

        Endereco endereco = endereçoService.buscarEnderecoPorId(id);
        return ResponseEntity.ok(endereco);
    }

    //TODO: Implementar o método de atualizar
//    @PutMapping("/{id}")
//    public ResponseEntity<Endereco> atualizar(Long id, Endereco endereco) {
//        return null;
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> remover(@PathVariable Long id) {
        atendidoService.deletarAtendido(id);
        return ResponseEntity.ok("Endereço deletado com sucesso!");
    }


}
