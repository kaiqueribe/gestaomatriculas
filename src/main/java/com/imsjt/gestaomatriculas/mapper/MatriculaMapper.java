package com.imsjt.gestaomatriculas.mapper;

import com.imsjt.gestaomatriculas.dto.DadosEscolaresDTO;
import com.imsjt.gestaomatriculas.entity.DadosEscolares;

public interface MatriculaMapper {
    DadosEscolaresDTO toDTO(DadosEscolares entity);

    DadosEscolares toEntity(DadosEscolaresDTO dadosEscolaresDTO);
}
