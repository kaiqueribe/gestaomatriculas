package com.imsjt.gestaomatriculas.controller;

import com.imsjt.gestaomatriculas.entity.DadosEscolares;
import com.imsjt.gestaomatriculas.service.DadosEscolaresService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//TODO: Integrar service e repository
//TODO: Implementar o método de atualizar

@RestController
@RequestMapping("/api/dados-escolares")
public class DadosEscolaresController {

   private DadosEscolaresService dadosEscolaresService;


    @PostMapping
    public ResponseEntity<DadosEscolares> cadastrarDadosEscolares() {
        return null;
    }

    @GetMapping
    public ResponseEntity<DadosEscolares> listarDadosEscolares() {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosEscolares> buscarDadosEscolaresPorId() {
        return null;
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<DadosEscolares> atualizarDadosEscolares() {
//        return null;
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removerDadosEscolares() {
        return null;
    }
}