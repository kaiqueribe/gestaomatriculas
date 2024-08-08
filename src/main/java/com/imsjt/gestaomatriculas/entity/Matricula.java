package com.imsjt.gestaomatriculas.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@Entity(name = "matricula")
public class Matricula {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataMatricula;
    private LocalDate dataFimMatricula;
    private boolean situacao;

    @OneToOne
    @JoinColumn(name = "id_Atendido")
    private Atendido atendido;

    //TODO Matricula realizada por funcionario tal
}
