package com.imsjt.gestaomatriculas.controller;

import com.imsjt.gestaomatriculas.dto.TelefoneDTO;
import com.imsjt.gestaomatriculas.entity.Telefone;
import com.imsjt.gestaomatriculas.service.TelefoneService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Classe esta funcioando porém falta criar aos DTOS e implementar os métodos de atualizar e tratar exceções



@RestController
@RequestMapping("api/telefones")
@AllArgsConstructor
public class TelefoneController {

    private final TelefoneService telefoneService;


    @PostMapping
    public ResponseEntity<TelefoneDTO> cadastrar(@Valid @RequestBody TelefoneDTO telefoneDTO) {

        TelefoneDTO telefoneCadastrado = telefoneService.cadastrarTelefone(telefoneDTO);

        return new ResponseEntity<>(telefoneCadastrado, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TelefoneDTO>> buscarTodos() {
        List<TelefoneDTO> telefones = telefoneService.listarTodosTelefones();
        return ResponseEntity.ok(telefones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TelefoneDTO> buscarPorId(@PathVariable Long id) {
        TelefoneDTO telefone = telefoneService.buscarTelefonePorId(id);
        return ResponseEntity.ok(telefone);
    }


    @PutMapping("/{id}")
    public ResponseEntity<TelefoneDTO> atualizar(@PathVariable Long id,@Valid @RequestBody TelefoneDTO telefoneDTO) {
        TelefoneDTO tefoneAtualizado = telefoneService.atualizarTelefone(id, telefoneDTO);
        return ResponseEntity.ok(tefoneAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> remover(@PathVariable Long id) {
        telefoneService.removerTelefone(id);
        return ResponseEntity.ok("Telefone deletado com sucesso! ");
    }

}
