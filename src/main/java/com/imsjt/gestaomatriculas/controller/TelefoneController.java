package com.imsjt.gestaomatriculas.controller;

import com.imsjt.gestaomatriculas.entity.Telefone;
import com.imsjt.gestaomatriculas.service.TelefoneService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/telefones")
@AllArgsConstructor
public class TelefoneController {

    //TODO: Implementar TelefoneController
    private final TelefoneService telefoneService;


    @PostMapping
    public ResponseEntity<Telefone> cadastrar(@RequestBody Telefone telefone) {

        var telefoneCadastrado = telefoneService.cadastrarTelefone(telefone);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{numeroTelefone}").buildAndExpand(telefoneCadastrado.getNumeroTelefone()).toUri();
        return ResponseEntity.created(uri).body(telefoneCadastrado);
    }

//    @GetMapping
//    public ResponseEntity<List<Telefone>> buscarTodos() {
//        return null;
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Telefone> buscarPorId(Long id) {
//        return null;
//    }
//
//    //TODO: Implementar o método de atualizar
//    @PutMapping("/{id}")
//    public ResponseEntity<Telefone> atualizar(Long id, Telefone telefone) {
//        return null;
//    }
//
//    @DeleteMapping("/{id}")
//    public void remover(Long id) {
//
//    }

}
