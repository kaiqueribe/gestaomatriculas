package com.imsjt.gestaomatriculas.controller;

import com.imsjt.gestaomatriculas.dto.EnderecoDTO;
import com.imsjt.gestaomatriculas.entity.Endereco;

import com.imsjt.gestaomatriculas.service.EnderecoService;
import jakarta.validation.Valid;
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


    @PostMapping
    public ResponseEntity<EnderecoDTO> cadastrar(@Valid @RequestBody EnderecoDTO enderecoDTO) {
        EnderecoDTO novoEndereco = enderecoService.cadastrarEndereco(enderecoDTO);
        return new ResponseEntity<>(novoEndereco, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EnderecoDTO>> buscarTodos() {
        List<EnderecoDTO> enderecosList = enderecoService.listarTodosEnderecos();
        return ResponseEntity.ok(enderecosList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoDTO> buscarPorId(@PathVariable Long id) {

        EnderecoDTO endereco = enderecoService.buscarEnderecoPorId(id);
        return ResponseEntity.ok(endereco);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnderecoDTO> atualizar(@Valid @PathVariable Long id, EnderecoDTO enderecoDTO) {
        EnderecoDTO enderecoAtualizado = enderecoService.atualizarEndereco(id, enderecoDTO);
        return ResponseEntity.ok(enderecoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> remover(@PathVariable Long id) {
        enderecoService.deletarEndereco(id);
        return ResponseEntity.ok("Endereço deletado com sucesso!");
    }


}
