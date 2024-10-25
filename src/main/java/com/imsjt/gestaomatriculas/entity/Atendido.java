package com.imsjt.gestaomatriculas.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    private String numeroMatricula;
    private String nomeCompleto;
    private String rg;
    private String cpf;
    private LocalDate dataNascimento;
    private String municipioNascimento;
    private String idade;
    private String Sexo;

    @OneToMany
    @JoinColumn (name = "responsavel_id")
    private List<Responsavel> responsavelList;

    @OneToMany
    @JoinColumn(name = "telefones_id")
    private List <Telefone> telefonesList;

    @OneToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @OneToOne
    @JoinColumn(name = "dadosEscolares_id")
    @JsonIgnore
    private DadosEscolares dadosEscolares;

    @OneToMany
    @JoinColumn(name = "dadosSociais_id")
    @JsonIgnore
    private List<DadosSociais> dadosSociais;

}
