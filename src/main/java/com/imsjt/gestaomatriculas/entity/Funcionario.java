package com.imsjt.gestaomatriculas.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "funcionario")
public class Funcionario {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeFuncionario;
    private String emailFuncionario;
    private String cargoFuncionario;
    private String unidadeFuncionario;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;



}
