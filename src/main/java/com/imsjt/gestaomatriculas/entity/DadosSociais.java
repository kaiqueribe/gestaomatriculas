package com.imsjt.gestaomatriculas.entity;

import jakarta.persistence.*;

import java.util.List;
@Entity (name = "dados_sociais")

public class DadosSociais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private boolean recebeBeneficio;
    @OneToMany
    @JoinColumn(name = "id_Beneficios")
    private List<Beneficio> beneficios;
}
