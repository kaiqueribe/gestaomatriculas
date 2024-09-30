package com.imsjt.gestaomatriculas.mapper;

import com.imsjt.gestaomatriculas.dto.EnderecoDTO;
import com.imsjt.gestaomatriculas.entity.Endereco;
import org.mapstruct.Mapper;

@Mapper
public interface EnderecoMapper {
    EnderecoDTO toDTO(Endereco entity);

    Endereco toEntity(EnderecoDTO enderecoDTO);
}