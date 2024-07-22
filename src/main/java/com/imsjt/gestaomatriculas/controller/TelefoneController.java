package com.imsjt.gestaomatriculas.controller;

import com.imsjt.gestaomatriculas.entity.Telefone;
import com.imsjt.gestaomatriculas.service.TelefoneService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/telefones")
@AllArgsConstructor
public class TelefoneController {

    //TODO: Criar exceptions NotfoundException e InvalidRequestException

    private final TelefoneService telefoneService;


    @PostMapping
    public ResponseEntity<Telefone> cadastrar(@RequestBody Telefone telefone) {

        var telefoneCadastrado = telefoneService.cadastrarTelefone(telefone);

        return new ResponseEntity<>(telefoneCadastrado, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Telefone>> buscarTodos() {
        List<Telefone> telefones = telefoneService.listarTodosTelefones();
        return ResponseEntity.ok(telefones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Telefone> buscarPorId(@PathVariable Long id) {
        Telefone telefone = telefoneService.buscarTelefonePorId(id);
        return ResponseEntity.ok(telefone);
    }

    //
//    //TODO: Implementar o método de atualizar
//    @PutMapping("/{id}")
//    public ResponseEntity<Telefone> atualizar(Long id, Telefone telefone) {
//        return null;
//    }
//
    @DeleteMapping("/{id}")
    public ResponseEntity<String> remover(@PathVariable Long id) {
        telefoneService.deletarTelefone(id);
        return ResponseEntity.ok("Telefone deletado com sucesso! ");
    }

}
