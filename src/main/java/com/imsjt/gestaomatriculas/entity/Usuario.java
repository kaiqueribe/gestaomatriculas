package com.imsjt.gestaomatriculas.entity;

import jakarta.persistence.*;
@Entity(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    @OneToOne
    @JoinColumn(name = "id_Funcionario")
    private Funcionario funcionario;

}
