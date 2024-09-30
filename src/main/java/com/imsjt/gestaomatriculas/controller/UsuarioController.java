package com.imsjt.gestaomatriculas.controller;

import com.imsjt.gestaomatriculas.dto.UsuarioDTO;
import com.imsjt.gestaomatriculas.entity.Usuario;
import com.imsjt.gestaomatriculas.exceptions.NotFoundException;
import com.imsjt.gestaomatriculas.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



//TODO: Fazer Tratamento de exceptions criar DTOS e fazer validação de campos


@RestController
@RequestMapping("/api/usuario")
@AllArgsConstructor
public class UsuarioController {

    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioDTO> cadastrarUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO novoUsuario = usuarioService.cadastrarUsuario(usuarioDTO);
        return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listarTodosUsuarios() {
        List<UsuarioDTO> usuariosList = usuarioService.listarTodosUsuarios();
        return ResponseEntity.ok(usuariosList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> buscarPorId(@PathVariable Long id) {
        UsuarioDTO usuario = usuarioService.buscarPorId(id);
        return ResponseEntity.ok(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> atualizarUsuario(Long id, UsuarioDTO usuario) {
        UsuarioDTO usuarioAtualizado = usuarioService.atualizarUsuario(id, usuario);
        return ResponseEntity.ok(usuarioAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removerUsuario(Long id) {
        usuarioService.removerUsuario(id);
        return ResponseEntity.ok("Usuario com id: " +id+" removido com sucesso!");
    }

}
