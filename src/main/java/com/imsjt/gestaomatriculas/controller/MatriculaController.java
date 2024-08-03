package com.imsjt.gestaomatriculas.controller;

import com.imsjt.gestaomatriculas.entity.Matricula;
import com.imsjt.gestaomatriculas.service.MatriculaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//TODO: Implementar o método de atualizar


@RestController
@RequestMapping("/api/matriculas")
public class MatriculaController {

    private MatriculaService matriculaService;

    @PostMapping
    public ResponseEntity<Matricula> cadastrar(Matricula matricula) {
        Matricula novaMatricula = matriculaService.cadastrarMatricula(matricula);
        return new ResponseEntity<>(novaMatricula, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Matricula>> listarTodos() {
        List<Matricula> matriculasList = matriculaService.listarTodasMatriculas();
        return ResponseEntity.ok(matriculasList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Matricula> buscarPorId(@PathVariable Long id) {
        Matricula matricula = matriculaService.buscarPorId(id);
        return ResponseEntity.ok(matricula);
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
