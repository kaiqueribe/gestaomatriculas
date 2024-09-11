package com.imsjt.gestaomatriculas.controller;

import com.imsjt.gestaomatriculas.entity.Matricula;
import com.imsjt.gestaomatriculas.service.*;
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



    @PostMapping
    public ResponseEntity<Matricula> matricularAtendido(Matricula matricula) {
        Matricula novaMatricula = matriculaService.matricularAtendido(matricula);
        return new ResponseEntity<>(novaMatricula, HttpStatus.CREATED);
    }


    @PutMapping
    public ResponseEntity<Matricula> atualizarMatricula(@PathVariable Long id, @RequestBody Matricula matricula) {
        Matricula matriculaAtualizada = matriculaService.atualizarMatricula(id, matricula);
        return ResponseEntity.ok(matriculaAtualizada);
    }


//    //Criar remoção de matricula ou permitir somente atualização da situação ?
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> remover(Long id) {
//        return null;
//    }


}
