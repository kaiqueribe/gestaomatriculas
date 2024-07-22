package com.imsjt.gestaomatriculas.controller;

import com.imsjt.gestaomatriculas.entity.Endereco;

import com.imsjt.gestaomatriculas.service.EnderecoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enderecos")
@AllArgsConstructor
public class EnderecoController {


    private EnderecoService enderecoService;
//TODO Criar exceptions NotfoundException e InvalidRequestException

    @PostMapping
    public ResponseEntity<Endereco> cadastrar(@RequestBody Endereco endereco) {
        Endereco novoEndereco = enderecoService.cadastrarEndereco(endereco);
        return new  ResponseEntity<>(novoEndereco, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> buscarTodos() {
        List<Endereco> enderecosList = enderecoService.listarTodosEnderecos();
        return ResponseEntity.ok(enderecosList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> buscarPorId(@PathVariable Long id) {

        Endereco endereco = enderecoService.buscarEnderecoPorId(id);
        return ResponseEntity.ok(endereco);
    }

    //TODO: Implementar o método de atualizar
//    @PutMapping("/{id}")
//    public ResponseEntity<Endereco> atualizar(Long id, Endereco endereco) {
//        return null;
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> remover(@PathVariable Long id) {
        enderecoService.deletarEndereco(id);
        return ResponseEntity.ok("Endereço deletado com sucesso!");
    }


}
