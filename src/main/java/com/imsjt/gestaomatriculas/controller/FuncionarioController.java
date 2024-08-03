package com.imsjt.gestaomatriculas.controller;

import com.imsjt.gestaomatriculas.entity.Funcionario;
import com.imsjt.gestaomatriculas.service.FuncionarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//TODO: Integrar service e repository

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {


    private FuncionarioService funcionarioService;


    public ResponseEntity<Funcionario> cadastrarFuncionario(@RequestBody Funcionario funcionario) {
        Funcionario funcionarioCadastrado = funcionarioService.cadastrarFuncionario(funcionario);
        return new ResponseEntity<>(funcionarioCadastrado, HttpStatus.CREATED);
    }

    public ResponseEntity<List<Funcionario>> listarTodosFuncionarios() {
        List<Funcionario> funcionarios = funcionarioService.listarTodosFuncionarios();
        return ResponseEntity.ok(funcionarios);
    }

    public ResponseEntity<Funcionario> buscarPorId(@PathVariable Long id) {
        Funcionario funcionario = funcionarioService.buscarPorId(id);
        return ResponseEntity.ok(funcionario);
    }

    public ResponseEntity<Funcionario> atualizarFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionario) {
        Funcionario funcionarioAtualizado = funcionarioService.atualizarFuncionario(id, funcionario);
        return ResponseEntity.ok(funcionarioAtualizado);
    }

    public ResponseEntity<String> removerFuncionario(@PathVariable Long id) {
        funcionarioService.removerFuncionario(id);
        return ResponseEntity.ok("Funcionario deletado com Sucesso!");
    }
}
