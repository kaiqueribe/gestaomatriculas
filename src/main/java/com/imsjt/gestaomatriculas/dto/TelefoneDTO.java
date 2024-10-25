package com.imsjt.gestaomatriculas.dto;

import com.imsjt.gestaomatriculas.enums.TipoTelefone;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class TelefoneDTO {

    @NotBlank
    private String tituloTelefone;
    @NotBlank(message = "O campo Telefone não deve estar em branco")
    @Pattern(regexp = "^\\([1-9]{2}\\) (?:[2-8]|9[0-9])[0-9]{3}\\-[0-9]{4}$" ,message = "O Numero de Telefone não de fugir dos padrões a seguir: (XX) YXXXX-XXXX  ou (XX) XXXX-XXXX ")
    private String numeroTelefone;

    @Enumerated(EnumType.STRING)
    private TipoTelefone tipoTelefone;
    private String atendidoId;




}
