package com.imsjt.gestaomatriculas.entity;

import jakarta.persistence.*;

@Entity(name = "funcionario")
public class Funcionario {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeFuncionario;
    private String emailFuncionario;
    private String cargoFuncionario;



}
