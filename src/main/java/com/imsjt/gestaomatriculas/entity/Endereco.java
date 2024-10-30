package com.imsjt.gestaomatriculas.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Entity (name = "localidade")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String rua;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "atendido_id")
    private Atendido atendido;

}
