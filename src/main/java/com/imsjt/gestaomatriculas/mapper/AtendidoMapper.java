package com.imsjt.gestaomatriculas.mapper;

import com.imsjt.gestaomatriculas.dto.AtendidoDTO;
import com.imsjt.gestaomatriculas.entity.Atendido;
import org.mapstruct.Mapper;

@Mapper
public interface AtendidoMapper {
    AtendidoDTO toDTO(Atendido entity);

    Atendido toEntity(AtendidoDTO atendidoDTO);
}
