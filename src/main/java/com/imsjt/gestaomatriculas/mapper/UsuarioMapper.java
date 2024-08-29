package com.imsjt.gestaomatriculas.mapper;

import com.imsjt.gestaomatriculas.dto.UsuarioDTO;
import com.imsjt.gestaomatriculas.entity.Usuario;

public interface UsuarioMapper {
    UsuarioDTO toDTO(Usuario entity);

    Usuario toEntity (UsuarioDTO usuarioDTO);
}
