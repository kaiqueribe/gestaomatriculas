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
    private int idAtendido;

    private String nomeCompleto;
    private String rg;
    private String cpf;
    private LocalDate dataNascimento;
    private String municipioNascimento;
    private String idade;
    private String Sexo;
    @OneToOne
    @JoinColumn(name = "idMatricula")
    private Matricula matricula;

    @OneToMany
    @JoinColumn (name = "idResponsavel")
    private List<Responsavel> responsavelList;
    @OneToMany
    @JoinColumn(name = "idTelefone")
    private List <Telefone> telefones;
    @OneToOne
    @JoinColumn(name = "idEndereco")
    private Endereco endereco;
    @OneToOne
    @JoinColumn(name = "idDadosEscolares")
    private DadosEscolares dadosEscolares;
    @OneToMany
    @JoinColumn(name = "idDadosSociais")
    private List<DadosSociais> dadosSociais;



}
