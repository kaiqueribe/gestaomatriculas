package com.imsjt.gestaomatriculas.service;

import com.imsjt.gestaomatriculas.entity.Usuario;
import com.imsjt.gestaomatriculas.exceptions.NotFoundException;
import com.imsjt.gestaomatriculas.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioService {

    public UsuarioRepository usuarioRepository;

    public Usuario cadastrarUsuario(Usuario usuario) {
        Usuario novoUsuario = usuarioRepository.save(usuario);
        return novoUsuario;
    }

    public List<Usuario> listarTodosUsuarios() {
        List<Usuario> usuariosList = usuarioRepository.findAll();
        return usuariosList.stream().toList();
    }

    public Usuario buscarPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario com id: " + id + " não encontrado!"));
        return usuario;
    }

    public Usuario atualizarUsuario(Long id, Usuario usuario) {
        Usuario usuarioAtualizado = usuarioRepository.findById(id).orElseThrow(() -> new NotFoundException("Usuario com id: " + id + " não encontrado!"));
        usuarioAtualizado.setUsername(usuario.getUsername());
        usuarioAtualizado.setPassword(usuario.getPassword());
        return usuarioRepository.save(usuarioAtualizado);
    }

    public String removerUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new NotFoundException("Usuario com id: " + id + " não encontrado!"));
        usuarioRepository.delete(usuario);
        return "Usuario removido com sucesso!";
    }

}
