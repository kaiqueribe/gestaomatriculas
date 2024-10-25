package com.imsjt.gestaomatriculas.dto;


import com.imsjt.gestaomatriculas.enums.StatusMatricula;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

//TODO quando estiver funcionando o as requisições, fazer validação dos campos faltantes
@Getter
@Setter
@RequiredArgsConstructor
public class MatriculaDTO {

//    private LocalDate dataMatricula;

    @Valid
    private AtendidoDTO atendidoDTO;
    private EnderecoDTO enderecoDTO;

    private List<TelefoneDTO> telefoneDTOList;

    private List<ResponsavelDTO> responsavelDTOList;

    //TODO Implementar depois que estiver funcionando com  os outros campos acima que são mais necessarios
    //    private DadosEscolaresDTO dadosEscolaresDTO;
    //
    //    private List<DadosSociaisDTO> dadosSociaisDTOList;

    @Enumerated(EnumType.STRING)
    private StatusMatricula statusMatricula;

}
