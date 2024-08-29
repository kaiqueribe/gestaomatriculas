package com.imsjt.gestaomatriculas.mapper;

import com.imsjt.gestaomatriculas.dto.DadosSociaisDTO;
import com.imsjt.gestaomatriculas.entity.DadosSociais;

public interface DadosSociaisMapper {

    DadosSociaisDTO toDTO (DadosSociais entity);

    DadosSociais toEntity (DadosSociaisDTO dadosSociaisDTO);
}
