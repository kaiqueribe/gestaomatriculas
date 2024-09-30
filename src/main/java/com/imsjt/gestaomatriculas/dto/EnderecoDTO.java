package com.imsjt.gestaomatriculas.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class EnderecoDTO {


    @NotBlank
    private String titulo;
    @NotBlank(message = "O campo Rua não deve estar vazio")
    private String rua;
    @NotBlank(message = " O campo Numero não deve estar vazio")
    private String numero;

    private String complemento;
    @NotBlank(message = "O campo Bairro não deve estar vazio")
    private String bairro;
    @NotBlank(message = "O campo Cidade não deve estar vazio")
    private String cidade;
    @NotBlank(message = "O campo Estado não deve estar vazio")
    private String estado;
    @NotBlank(message = "O campo Cep não deve estar vazio")
    @Pattern(regexp = "\\d{5}\\-\\d{3}", message = "O Cep informado está incorreto")
    private String cep;


}
