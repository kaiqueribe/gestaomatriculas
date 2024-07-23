package com.imsjt.gestaomatriculas.entity;

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
    @OneToOne
    @JoinColumn(name = "id_Endereco")
    private Endereco endereco;
    @OneToMany
    @JoinColumn(name = "id_Telefones")
    private List<Telefone> telefones;
    @ManyToOne
    @JoinColumn(name = "id_Atendido")
    private Atendido atendido;
}
