package com.imsjt.gestaomatriculas.dto;


import com.imsjt.gestaomatriculas.enums.StatusMatricula;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class MatriculaDTO {


    private AtendidoDTO atendidoDTO;

    private List<TelefoneDTO> telefoneDTOList;

    private List<ResponsavelDTO> responsavelDTOList;

    private EnderecoDTO enderecoDTO;

    private DadosEscolaresDTO dadosEscolaresDTO;

    private List<DadosSociaisDTO> dadosSociaisDTOList;

    @Enumerated(EnumType.STRING)
    private StatusMatricula statusMatricula;

}
