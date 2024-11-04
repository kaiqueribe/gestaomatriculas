package com.imsjt.gestaomatriculas.mapper;

import com.imsjt.gestaomatriculas.dto.MatriculaDTO;
import com.imsjt.gestaomatriculas.entity.Matricula;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface MatriculaMapper {
    MatriculaDTO toDTO(Matricula entity);

    Matricula toEntity(MatriculaDTO matriculaDTO);

//    @Mapping(source = "atendido", target = "id")
//    @Mapping(source = "endereco", target = "id")
//    @Mapping(source = "telefones", target = "id")
//    @Mapping(source = "responsaveis", target = "id")
//    MatriculaDTO toDTOComplete(Matricula matricula);
}
