package com.imsjt.gestaomatriculas.entity;

import jakarta.persistence.*;

@Entity (name = "beneficio")
public class Beneficio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeBeneficio;
    private String tipoBeneficio;

    @ManyToOne
    @JoinColumn(name = "dadosSociais_id")
    private DadosSociais dadosSociais;

}
