package com.imsjt.gestaomatriculas.controller;

import com.imsjt.gestaomatriculas.dto.MatriculaDTO;
import com.imsjt.gestaomatriculas.entity.Matricula;
import com.imsjt.gestaomatriculas.service.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//TODO: Fazer Tratamento de exceptions criar DTOS e fazer validação de campos

@RestController
@RequestMapping("/api/matricula")
@AllArgsConstructor
public class MatriculaController {

    private final MatriculaService matriculaService;

    @PostMapping
    public ResponseEntity<MatriculaDTO> realizarMatricula(@RequestBody MatriculaDTO matriculaDTO) {
        MatriculaDTO matriculaRealizada = matriculaService.realizarMatricula(matriculaDTO);
        return new  ResponseEntity<>(matriculaRealizada,HttpStatus.CREATED);
    }



}
