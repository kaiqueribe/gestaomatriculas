package com.imsjt.gestaomatriculas.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity(name = "dados_escolares")
public class DadosEscolares {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeEscola;
    private String periodoEscolar;
    private String serie;
    private String turno;
    @OneToMany
    @JoinColumn(name = "telefones_id")
    private List<Telefone> telefones;

}
