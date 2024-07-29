package com.imsjt.gestaomatriculas.controller;

import com.imsjt.gestaomatriculas.entity.Responsavel;
import com.imsjt.gestaomatriculas.service.ResponsavelService;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//TODO: Fazer Tratamento de exceptions criar DTOS e fazer validação de campos

@RestController
@RequestMapping("/api/responsavel")
@AllArgsConstructor
public class ResponsavelController {

    private ResponsavelService responsavelService;

    @PostMapping
    public ResponseEntity<Responsavel> cadastrarResponsavel(@RequestBody Responsavel responsavel) {
        Responsavel novoResponsavel = responsavelService.cadastrarResponsavel(responsavel);
        return new ResponseEntity<>(novoResponsavel, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Responsavel>> listarTodosResponsaveis() {
        List<Responsavel> responsavelList = responsavelService.listarTodosResponsaveis();
        return ResponseEntity.ok(responsavelList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Responsavel> buscarPorId(@PathVariable Long id) {
        Responsavel responsavel = responsavelService.buscarPorId(id);
        return ResponseEntity.ok(responsavel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Responsavel> atualizarResponsavel(@PathVariable Long id, @RequestBody Responsavel responsavel) {
        Responsavel responsavelAtualizado = responsavelService.atualizarResponsavel(id, responsavel);
        return ResponseEntity.ok(responsavelAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removerResponsavel(@PathVariable Long id) {
        responsavelService.removerResponsavel(id);
        return ResponseEntity.ok("Responsável deletado com sucesso!");
    }


}
