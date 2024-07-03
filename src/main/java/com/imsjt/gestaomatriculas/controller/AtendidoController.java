package com.imsjt.gestaomatriculas.controller;

import com.imsjt.gestaomatriculas.entity.Atendido;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/atendido")
public class AtendidoController {


    @PostMapping
    public ResponseEntity<Atendido> cadastrar(){
        return null;
    }

    @GetMapping
    public ResponseEntity<Atendido> buscarTodos(){
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Atendido> buscarPorId(){
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Atendido> atualizar(){
        return null;
    }

    @DeleteMapping
    public void deletar(){

    }


    
}
