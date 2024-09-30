package com.imsjt.gestaomatriculas.controller;

import com.imsjt.gestaomatriculas.dto.ResponsavelDTO;
import com.imsjt.gestaomatriculas.entity.Responsavel;
import com.imsjt.gestaomatriculas.service.ResponsavelService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/responsavel")
@AllArgsConstructor
public class ResponsavelController {

    private ResponsavelService responsavelService;

    @PostMapping
    public ResponseEntity<ResponsavelDTO> cadastrarResponsavel(@Valid @RequestBody ResponsavelDTO responsavelDTO) {
        ResponsavelDTO novoResponsavel = responsavelService.cadastrarResponsavel(responsavelDTO);
        return new ResponseEntity<>(novoResponsavel, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ResponsavelDTO>> listarTodosResponsaveis() {
        List<ResponsavelDTO> responsavelList = responsavelService.listarTodosResponsaveis();
        return ResponseEntity.ok(responsavelList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponsavelDTO> buscarPorId(@PathVariable Long id) {
        ResponsavelDTO responsavel = responsavelService.buscarPorId(id);
        return ResponseEntity.ok(responsavel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponsavelDTO> atualizarResponsavel(@PathVariable Long id,@Valid @RequestBody ResponsavelDTO responsavelDTO) {
        ResponsavelDTO responsavelAtualizado = responsavelService.atualizarResponsavel(id, responsavelDTO);
        return ResponseEntity.ok(responsavelAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removerResponsavel(@PathVariable Long id) {
        responsavelService.removerResponsavel(id);
        return ResponseEntity.ok("Responsável deletado com sucesso!");
    }


}
