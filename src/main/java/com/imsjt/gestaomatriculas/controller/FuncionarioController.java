package com.imsjt.gestaomatriculas.controller;

import com.imsjt.gestaomatriculas.entity.Funcionario;
import com.imsjt.gestaomatriculas.service.FuncionarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//TODO: Integrar service e repository

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {


    private FuncionarioService funcionarioService;


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
