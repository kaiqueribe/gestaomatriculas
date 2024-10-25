package com.imsjt.gestaomatriculas.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.imsjt.gestaomatriculas.enums.StatusMatricula;
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

    @Enumerated(EnumType.STRING)
    private StatusMatricula statusMatricula;

    @OneToOne
    @JoinColumn(name = "atendido_id")
    private Atendido atendido;

    //TODO Matricula realizada por funcionario tal, isso sera decidido através da permissão do spring security
}
