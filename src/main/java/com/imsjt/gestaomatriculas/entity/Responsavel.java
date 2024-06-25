package com.imsjt.gestaomatriculas.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "responsavel")
public class Responsavel {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int idResponsavel;
    private String nomeCompleto;
    private String rg;
    private String cpf;
    @OneToMany
    @JoinColumn(name = "idTelefone")
    private List<Telefone> telefones;
    @ManyToOne
    @JoinColumn(name = "idAtendido")
    private Atendido atendido;
}
