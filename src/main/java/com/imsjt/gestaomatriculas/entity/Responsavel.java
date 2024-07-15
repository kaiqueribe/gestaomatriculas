package com.imsjt.gestaomatriculas.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "responsavel")
public class Responsavel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeCompleto;
    private String rg;
    private String cpf;
    @OneToMany
    @JoinColumn(name = "id_Telefones")
    private List<Telefone> telefones;
    @ManyToOne
    @JoinColumn(name = "id_Atendido")
    private Atendido atendido;
}
