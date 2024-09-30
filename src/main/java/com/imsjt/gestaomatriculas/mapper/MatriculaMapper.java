package com.imsjt.gestaomatriculas.mapper;

import com.imsjt.gestaomatriculas.dto.MatriculaDTO;
import com.imsjt.gestaomatriculas.entity.Matricula;
import org.mapstruct.Mapper;

@Mapper
public interface MatriculaMapper {
    MatriculaDTO toDTO(Matricula entity);

    Matricula toEntity(MatriculaDTO matriculaDTO);
}
