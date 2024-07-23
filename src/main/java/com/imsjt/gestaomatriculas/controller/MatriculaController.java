package com.imsjt.gestaomatriculas.controller;

import com.imsjt.gestaomatriculas.entity.Matricula;
import com.imsjt.gestaomatriculas.service.MatriculaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//TODO: Implementar o método de atualizar


@RestController
@RequestMapping("/api/matriculas")
public class MatriculaController {

    private MatriculaService matriculaService;

    @PostMapping
    public ResponseEntity<Matricula> cadastrar(Matricula matricula) {
        return null;
    }

    @GetMapping
    public ResponseEntity<Matricula> listarTodos() {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Matricula> buscarPorId(Long id) {
        return null;
    }

//    @PutMapping
//    public ResponseEntity<Matricula> atualizarMatricula(Long id, Matricula matricula){
//        return null;
//    }


    //Criar remoção de matricula ou permitir somente atualização da situação ?
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> remover (Long id){
//        return null;
//    }


}
