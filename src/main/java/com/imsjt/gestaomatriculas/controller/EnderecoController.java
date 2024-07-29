package com.imsjt.gestaomatriculas.controller;

import com.imsjt.gestaomatriculas.entity.Endereco;

import com.imsjt.gestaomatriculas.service.EnderecoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
//Classe esta funcioando porém falta criar aos DTOS e tratar exceções

//TODO Criar exceptions NotfoundException e InvalidRequestException
//TODO: Fazer Tratamento de exceptions criar DTOS e fazer validação de campos

@RestController
@RequestMapping("/api/enderecos")
@AllArgsConstructor
public class EnderecoController {


    private EnderecoService enderecoService;


    @PostMapping
    public ResponseEntity<Endereco> cadastrar(@RequestBody Endereco endereco) {
        Endereco novoEndereco = enderecoService.cadastrarEndereco(endereco);
        return new ResponseEntity<>(novoEndereco, HttpStatus.CREATED);
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

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> atualizar(@PathVariable Long id, Endereco endereco) {
        Endereco enderecoAtualizado = enderecoService.atualizarEndereco(id, endereco);
        return ResponseEntity.ok(enderecoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> remover(@PathVariable Long id) {
        enderecoService.deletarEndereco(id);
        return ResponseEntity.ok("Endereço deletado com sucesso!");
    }


}
