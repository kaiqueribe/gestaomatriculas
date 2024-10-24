package com.imsjt.gestaomatriculas.dto;

import com.imsjt.gestaomatriculas.enums.Sexo;
import com.imsjt.gestaomatriculas.validation.GreaterThanOneWord;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

//TODO Verificar se atributos nullos vão ser inseridos através dos outros endpoints

@Getter
@Setter
@RequiredArgsConstructor
public class AtendidoDTO {

    @NotBlank
    private String numeroMatricula;

    @GreaterThanOneWord
    @NotBlank(message = "O Campo nome é Obrigatório")
    private String nomeCompleto;

    @NotBlank
    @Pattern(regexp = "\\d{2}\\.\\d{3}\\.\\d{3}\\-\\d{1}-[0-9X]",message = "Numero de RG Inválido")
    private String rg;

    @NotBlank
    @CPF
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}",message = "Numero de CPF Inválido")
    private String cpf;

    @Past(message = "A Data informada deve ser uma data passada")
    private LocalDate dataNascimento;

    @NotBlank
    private String municipioNascimento;



    @Enumerated(EnumType.STRING)
    private Sexo Sexo;
}
