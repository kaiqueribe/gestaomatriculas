package com.imsjt.gestaomatriculas.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class DadosEscolaresDTO {

    private String nomeEscola;
    private String periodoEscolar;
    private String serie;
    private String turno;

}
