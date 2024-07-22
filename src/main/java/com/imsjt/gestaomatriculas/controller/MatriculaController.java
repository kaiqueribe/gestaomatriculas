package com.imsjt.gestaomatriculas.controller;

import com.imsjt.gestaomatriculas.entity.Matricula;
import com.imsjt.gestaomatriculas.service.MatriculaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/matriculas")
public class MatriculaController {

    private MatriculaService matriculaService;


    public ResponseEntity<Matricula> cadastrar(Matricula matricula) {
        return null;
    }

    public ResponseEntity<Matricula> listarTodos() {
        return null;
    }

    public ResponseEntity<Matricula> buscarPorId(Long id) {
        return null;
    }
    //TODO: Implementar o método de atualizar
//    public ResponseEntity<Matricula> atualizarMatricula(Long id, Matricula matricula){
//        return null;
//    }
    //Criar remoção de matricula ou permitir somente atualização da situação ?
//    public ResponseEntity<String> remover (Long id){
//        return null;
//    }


}
