package com.imsjt.gestaomatriculas.entity;

import jakarta.persistence.*;
@Entity(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
    private String username;
    private String password;
    @OneToOne
    @JoinColumn(name = "idFuncionario")
    private Funcionario funcionario;

}
