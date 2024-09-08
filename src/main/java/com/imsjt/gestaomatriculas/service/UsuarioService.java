package com.imsjt.gestaomatriculas.service;

import com.imsjt.gestaomatriculas.dto.UsuarioDTO;
import com.imsjt.gestaomatriculas.entity.Usuario;
import com.imsjt.gestaomatriculas.exceptions.NotFoundException;
import com.imsjt.gestaomatriculas.mapper.UsuarioMapper;
import com.imsjt.gestaomatriculas.mapper.UsuarioMapperImpl;
import com.imsjt.gestaomatriculas.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioService {


    public UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public UsuarioDTO cadastrarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioMapper.toEntity(usuarioDTO);
        final Usuario novoUsuario = usuarioRepository.save(usuario);
        return usuarioMapper.toDTO(novoUsuario);
    }

    public List<UsuarioDTO> listarTodosUsuarios() {
        List<Usuario> usuariosList = usuarioRepository.findAll();
        return usuariosList.stream()
                .map(usuarioMapper::toDTO).toList();
    }

    public UsuarioDTO buscarPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new NotFoundException("Usuario com id: " + id + " não encontrado!"));
        return usuarioMapper.toDTO(usuario);
    }

    public UsuarioDTO atualizarUsuario(Long id, UsuarioDTO usuario) {
        usuarioMapper.toEntity(usuario);
        Usuario usuarioAtualizado = usuarioRepository.findById(id).orElseThrow(() -> new NotFoundException("Usuario com id: " + id + " não encontrado!"));
        usuarioAtualizado.setUsername(usuario.getUsername());
        usuarioAtualizado.setPassword(usuario.getPassword());
        usuarioRepository.save(usuarioAtualizado);
        return usuarioMapper.toDTO(usuarioAtualizado);
    }

    public String removerUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Usuario com id: " + id + " não encontrado!"));
        usuarioRepository.delete(usuario);
        return "Usuario removido com sucesso!";
    }

}
