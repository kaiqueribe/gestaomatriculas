package com.imsjt.gestaomatriculas.mapper;

import com.imsjt.gestaomatriculas.dto.ResponsavelDTO;
import com.imsjt.gestaomatriculas.entity.Responsavel;

public interface ResponsavelMapper {

    ResponsavelDTO toDTO (Responsavel entity);

    Responsavel toEntity(ResponsavelDTO responsavelDTO);
}
