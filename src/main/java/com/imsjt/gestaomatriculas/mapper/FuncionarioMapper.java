package com.imsjt.gestaomatriculas.mapper;

import com.imsjt.gestaomatriculas.dto.FuncionarioDTO;
import com.imsjt.gestaomatriculas.entity.Funcionario;

public interface FuncionarioMapper {

    FuncionarioDTO toDTO(Funcionario entity);

    Funcionario toEntity(FuncionarioDTO funcionarioDTO);

}
