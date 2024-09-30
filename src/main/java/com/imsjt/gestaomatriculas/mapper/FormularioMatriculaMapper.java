package com.imsjt.gestaomatriculas.mapper;

import com.imsjt.gestaomatriculas.dto.MatriculaDTO;
import org.mapstruct.Mapper;

@Mapper
public interface FormularioMatriculaMapper {
    MatriculaDTO toDTO(FormularioMatricula entity);

    FormularioMatricula toEntity(MatriculaDTO matriculaDTO);
}
