package com.imsjt.gestaomatriculas.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity (name = "beneficio")
public class Beneficio {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int idBeneficio;
    private String nomeBeneficio;
    private String tipoBeneficio;

}
