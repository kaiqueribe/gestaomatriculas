package com.imsjt.gestaomatriculas.mapper;

import com.imsjt.gestaomatriculas.dto.AtendidoDTO;
import com.imsjt.gestaomatriculas.entity.Atendido;

public interface AtendidoMapper {
    AtendidoDTO toDTO(Atendido entity);

    Atendido toEntity(AtendidoDTO atendidoDTO);
}
