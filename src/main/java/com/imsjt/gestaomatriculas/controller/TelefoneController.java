package com.imsjt.gestaomatriculas.controller;

import com.imsjt.gestaomatriculas.entity.Telefone;
import com.imsjt.gestaomatriculas.service.TelefoneService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Classe esta funcioando porém falta criar aos DTOS e implementar os métodos de atualizar e tratar exceções
//TODO: Fazer Tratamento de exceptions criar DTOS e fazer validação de campos


@RestController
@RequestMapping("api/telefones")
@AllArgsConstructor
public class TelefoneController {

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


    @PutMapping("/{id}")
    public ResponseEntity<Telefone> atualizar(@PathVariable Long id, @RequestBody Telefone telefone) {
        Telefone tefoneAtualizado = telefoneService.atualizarTelefone(id, telefone);
        return ResponseEntity.ok(tefoneAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> remover(@PathVariable Long id) {
        telefoneService.removerTelefone(id);
        return ResponseEntity.ok("Telefone deletado com sucesso! ");
    }

}
