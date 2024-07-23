package com.imsjt.gestaomatriculas.controller;

import com.imsjt.gestaomatriculas.entity.Usuario;
import com.imsjt.gestaomatriculas.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//TODO: Integrar service e repository

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    private UsuarioService usuarioService;


    @PostMapping
    public ResponseEntity<Usuario> cadastrarUsuario(Usuario usuario) {
        return null;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarTodosUsuarios() {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(Long id) {
        return null;
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Usuario> atualizarUsuario(Long id, Usuario usuario) {
//        return null;
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removerUsuario(Long id) {
        return null;
    }

}
