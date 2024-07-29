package com.imsjt.gestaomatriculas.controller;

import com.imsjt.gestaomatriculas.entity.DadosEscolares;
import com.imsjt.gestaomatriculas.service.DadosEscolaresService;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//TODO: Fazer Tratamento de exceptions criar DTOS e fazer validação de campos

@RestController
@RequestMapping("/api/dados-escolares")
@AllArgsConstructor
public class DadosEscolaresController {

    private DadosEscolaresService dadosEscolaresService;

    @PostMapping
    public ResponseEntity<DadosEscolares> cadastrarDadosEscolares(@RequestBody DadosEscolares dadosEscolares) {
        DadosEscolares dadosEscolaresAtualizado = dadosEscolaresService.cadastrarDadosEscolares(dadosEscolares);
        return new ResponseEntity<>(dadosEscolaresAtualizado, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DadosEscolares>> listarDadosEscolares() {
        List<DadosEscolares> dadosEscolares = dadosEscolaresService.listarTodosDadosEscolares();
        return ResponseEntity.ok(dadosEscolares);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosEscolares> buscarDadosEscolaresPorId(@PathVariable Long id) {
        DadosEscolares dadosEscolares = dadosEscolaresService.buscarDadosEscolaresPorId(id);
        return ResponseEntity.ok(dadosEscolares);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DadosEscolares> atualizarDadosEscolares(@PathVariable Long id, @RequestBody DadosEscolares dadosEscolares) {
        DadosEscolares dadosEscolaresAtualizado = dadosEscolaresService.atualizarDadosEscolares(id, dadosEscolares);
        return ResponseEntity.ok(dadosEscolaresAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removerDadosEscolares(@PathVariable Long id) {
        dadosEscolaresService.removerDadosEscolares(id);
        return ResponseEntity.ok("Dados escolares deletados com sucesso!");
    }
}