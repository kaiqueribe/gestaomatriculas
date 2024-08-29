package com.imsjt.gestaomatriculas.mapper;

import com.imsjt.gestaomatriculas.dto.BeneficioDTO;
import com.imsjt.gestaomatriculas.entity.Beneficio;

public interface BeneficioMapper {

    BeneficioDTO toDTO(Beneficio entity);

    Beneficio toEntity(BeneficioDTO beneficioDTO);
}