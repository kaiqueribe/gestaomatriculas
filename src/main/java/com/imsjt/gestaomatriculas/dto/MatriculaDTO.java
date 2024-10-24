package com.imsjt.gestaomatriculas.dto;


import com.imsjt.gestaomatriculas.enums.StatusMatricula;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class MatriculaDTO {

    @Enumerated(EnumType.STRING)
    private StatusMatricula statusMatricula;

    @Valid
    private AtendidoDTO atendidoDTO;

    private EnderecoDTO enderecoDTO;

    private List<TelefoneDTO> telefoneDTOList;

    private List<ResponsavelDTO> responsavelDTOList;


//    private DadosEscolaresDTO dadosEscolaresDTO;

//    private List<DadosSociaisDTO> dadosSociaisDTOList;


}
