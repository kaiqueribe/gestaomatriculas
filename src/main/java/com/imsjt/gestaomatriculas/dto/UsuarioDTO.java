package com.imsjt.gestaomatriculas.dto;

import com.imsjt.gestaomatriculas.validation.GreaterThanOneWord;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class UsuarioDTO {

    @NotNull(message = "Usuario é Obrigatório")
    private String username;
    @NotNull(message = "Senha é Obrigatória")
    private String password;
}
