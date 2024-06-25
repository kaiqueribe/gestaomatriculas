package com.imsjt.gestaomatriculas.entity;

import jakarta.persistence.*;

import java.util.List;
@Entity (name = "dados_sociais")

public class DadosSociais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idDadosSociais;
    private boolean recebeBeneficio;
    @OneToMany
    @JoinColumn(name = "idBeneficio")
    private List<Beneficio> beneficios;
}
