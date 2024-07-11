package com.imsjt.gestaomatriculas.controller;

import com.imsjt.gestaomatriculas.entity.Telefone;
import com.imsjt.gestaomatriculas.service.TelefoneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/telefones")
public class TelefoneController {

    //TODO: Implementar TelefoneController
    private TelefoneService telefoneService;


    @PostMapping
    public ResponseEntity<Telefone> cadastrar(Telefone telefone){
        Telefone novoTelefone = telefoneService.cadastrarTelefone(telefone);
        return new ResponseEntity<>(novoTelefone, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Telefone>> buscarTodos(){
        return null;
    }

    public ResponseEntity<Telefone> buscarPorId(Long id){
        return null;
    }
    //TODO: Implementar o método de atualizar
    @PutMapping("/{id}")
    public ResponseEntity<Telefone> atualizar(Long id,Telefone telefone){
        return null;
    }
    public void remover(Long id){

    }




}
