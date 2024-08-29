package com.imsjt.gestaomatriculas.mapper;

import com.imsjt.gestaomatriculas.dto.FormularioMatriculaDTO;
import com.imsjt.gestaomatriculas.entity.FormularioMatricula;

public interface FormularioMatriculaMapper {
    FormularioMatriculaDTO toDTO(FormularioMatricula entity);

    FormularioMatricula toEntity(FormularioMatriculaDTO formularioMatriculaDTO);
}
