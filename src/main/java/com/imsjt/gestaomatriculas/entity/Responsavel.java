package com.imsjt.gestaomatriculas.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity(name = "responsavel")
public class Responsavel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeCompleto;
    private String rg;
    private String cpf;
    private String email;
    @ManyToOne
    @JoinColumn(name = "atendido_id")
    @JsonIgnore
    private Atendido atendido;
}
