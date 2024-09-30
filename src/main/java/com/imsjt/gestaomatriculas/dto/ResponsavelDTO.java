package com.imsjt.gestaomatriculas.dto;

import com.imsjt.gestaomatriculas.validation.GreaterThanOneWord;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
@RequiredArgsConstructor
public class ResponsavelDTO {

    @NotBlank(message = "O Nome do Responsável não deve estar em branco! ")
    @GreaterThanOneWord(message = "Por favor insira o nome completo do Responsável ")
    private String nomeCompleto;
    @NotBlank(message = "O Numero de RG não pode estar em branco! ")
    @Pattern(regexp = "\\d{2}\\.\\d{3}\\.\\d{3}\\-\\d{1}",message = "Numero de RG Inválido")
    private String rg;
    @NotBlank(message = "O Numero de CPF não pode estar em branco! ")
    @CPF
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}",message = "Numero de CPF Inválido")
    private String cpf;

    @NotBlank
    @Email
    private String email;

}
