package com.imsjt.gestaomatriculas.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity(name = "atendido")
public class Atendido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCompleto;
    private String rg;
    private String cpf;
    private LocalDate dataNascimento;
    private String municipioNascimento;
    private String idade;
    private String Sexo;
    @OneToOne
    @JoinColumn(name = "id_Matricula")
    private Matricula matricula;

    @OneToMany
    @JoinColumn (name = "id_Responsavel")
    private List<Responsavel> responsavelList;
    @OneToMany
    @JoinColumn(name = "id_Telefones")
    private List <Telefone> telefones;
    @OneToOne
    @JoinColumn(name = "id_Endereco")
    private Endereco endereco;
    @OneToOne
    @JoinColumn(name = "id_DadosEscolares")
    private DadosEscolares dadosEscolares;
    @OneToMany
    @JoinColumn(name = "id_DadosSociais")
    private List<DadosSociais> dadosSociais;



}
