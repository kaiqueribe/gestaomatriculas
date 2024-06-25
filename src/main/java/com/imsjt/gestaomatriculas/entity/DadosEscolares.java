package com.imsjt.gestaomatriculas.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "dados_escolares")
public class DadosEscolares {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDadosEscolares;
    private String nomeEscola;
    private String periodoEscolar;
    private String serie;
    private String turno;
    @OneToMany
    @JoinColumn(name = "idTelefone")
    private List<Telefone> telefones;

}
