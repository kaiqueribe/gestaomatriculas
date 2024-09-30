package com.imsjt.gestaomatriculas.mapper;

import com.imsjt.gestaomatriculas.dto.TelefoneDTO;
import com.imsjt.gestaomatriculas.entity.Telefone;
import org.mapstruct.Mapper;

@Mapper
public interface TelefoneMapper {
    TelefoneDTO toDTO(Telefone entity);

    Telefone toEntity(TelefoneDTO telefoneDTO);
}
