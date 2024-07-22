package com.imsjt.gestaomatriculas.controller;

import com.imsjt.gestaomatriculas.entity.Funcionario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    public ResponseEntity<Funcionario> cadastrarFuncionario(Funcionario funcionario){
        return null;
    }

    public ResponseEntity<List<Funcionario>> listarTodosFuncionarios(){
        return null;
    }

    public ResponseEntity<Funcionario> buscarPorId(Long id){
        return null;
    }

    public ResponseEntity<Funcionario> atualizarFuncionario(Long id, Funcionario funcionario){
        return null;
    }

    public ResponseEntity<String> removerFuncionario(Long id){
        return null;
    }




}
