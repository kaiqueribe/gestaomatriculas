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

    private MatriculaService matriculaService;



//    @PostMapping
//    public ResponseEntity<MatriculaDTO> matricularAtendido(@Valid @RequestBody MatriculaDTO matriculaDTO) {
//        MatriculaDTO novaMatricula = matriculaService.matricularAtendido(matriculaDTO);
//        return new ResponseEntity<>(novaMatricula, HttpStatus.CREATED);
//    }


    @PostMapping
    public ResponseEntity<MatriculaDTO> realizarMatricula( @Valid @RequestBody MatriculaDTO matriculaDTO) {
        MatriculaDTO matriculaRealizada = matriculaService.realizarMatricula(matriculaDTO);
        return new  ResponseEntity<>(matriculaRealizada,HttpStatus.CREATED);
    }

//    @PutMapping
//    public ResponseEntity<Matricula> realizarMatricula(@PathVariable Long id, @Valid @RequestBody Matricula matricula) {
//        Matricula matriculaAtualizada = matriculaService.atualizarMatricula(id, matricula);
//        return ResponseEntity.ok(matriculaAtualizada);
//    }


//    //Criar remoção de matricula ou permitir somente atualização da situação ?
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> remover(Long id) {
//        return null;
//    }


}
