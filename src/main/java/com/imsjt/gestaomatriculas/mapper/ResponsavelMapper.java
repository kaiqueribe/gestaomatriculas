package com.imsjt.gestaomatriculas.mapper;

import com.imsjt.gestaomatriculas.dto.ResponsavelDTO;
import com.imsjt.gestaomatriculas.entity.Responsavel;
import org.mapstruct.Mapper;

@Mapper
public interface ResponsavelMapper {

    ResponsavelDTO toDTO (Responsavel entity);

    Responsavel toEntity(ResponsavelDTO responsavelDTO);
}
