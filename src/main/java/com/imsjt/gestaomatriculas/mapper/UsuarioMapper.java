package com.imsjt.gestaomatriculas.mapper;

import com.imsjt.gestaomatriculas.dto.UsuarioDTO;
import com.imsjt.gestaomatriculas.entity.Usuario;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
public interface UsuarioMapper {
    UsuarioDTO toDTO(Usuario entity);

    Usuario toEntity (UsuarioDTO usuarioDTO);
}
