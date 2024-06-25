package com.imsjt.gestaomatriculas.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity (name = "telefone")

public class Telefone {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int idTelefone;
    private String numeroTelefone;
    private String categoriaTelefone;
}
