package com.imsjt.gestaomatriculas.mapper;

import com.imsjt.gestaomatriculas.dto.MatriculaDTO;
import com.imsjt.gestaomatriculas.entity.FormularioMatricula;
import org.mapstruct.Mapper;

@Mapper
public interface FormularioMatriculaMapper {
    MatriculaDTO toDTO(FormularioMatricula entity);

    FormularioMatricula toEntity(MatriculaDTO matriculaDTO);
}
