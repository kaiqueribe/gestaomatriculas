package com.imsjt.gestaomatriculas.controller;

import com.imsjt.gestaomatriculas.entity.Endereco;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {


    @PostMapping
    public ResponseEntity<Endereco> cadastrar (){
        return null;
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> buscarTodos(){
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> buscarPorId(Long id){
        return null;
    }
    //TODO: Implementar o método de atualizar
    @PutMapping("/{id}")
    public ResponseEntity<Endereco> atualizar(Long id,Endereco endereco){
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> remover(Long id){
        return null;
    }


}
