package com.imsjt.gestaomatriculas.mapper;

import com.imsjt.gestaomatriculas.dto.DadosEscolaresDTO;
import com.imsjt.gestaomatriculas.entity.DadosEscolares;
import org.mapstruct.Mapper;

@Mapper
public interface DadosEscolaresMapper {
    DadosEscolaresDTO toDTO(DadosEscolares entity);

    DadosEscolares toEntity(DadosEscolaresDTO dadosEscolaresDTO);
}
