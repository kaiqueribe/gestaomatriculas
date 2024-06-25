package com.imsjt.gestaomatriculas.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "matricula")
public class Matricula {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int idMatricula;
    private LocalDate dataMatricula;
    private LocalDate dataFimMatricula;
    private String situacao;
    @OneToOne
    @JoinColumn(name = "idAtendido")
    private Atendido atendido;
}
