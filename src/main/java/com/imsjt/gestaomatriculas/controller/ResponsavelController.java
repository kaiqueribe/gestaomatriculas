package com.imsjt.gestaomatriculas.controller;

import com.imsjt.gestaomatriculas.entity.Responsavel;
import com.imsjt.gestaomatriculas.service.ResponsavelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/responsavel")
public class ResponsavelController {

    private ResponsavelService responsavelService;

    @PostMapping
    public ResponseEntity<Responsavel> cadastrarResponsavel(Responsavel responsavel) {
        return null;
    }

    @GetMapping
    public ResponseEntity<List<Responsavel>> listarTodosResponsaveis() {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Responsavel> buscarPorId(Long id) {
        return null;
    }
//    @PutMapping("/{id}")
//    public ResponseEntity<Responsavel> atualizarResponsavel(Long id, Responsavel responsavel ){
//        return null;
//    }

    @DeleteMapping
    public ResponseEntity<String> removerResponsavel(Long id) {
        return null;
    }


}
