package com.imsjt.gestaomatriculas.entity;

import com.imsjt.gestaomatriculas.enums.TipoTelefone;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity (name = "numero_telefone")
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tituloTelefone;
    private String numeroTelefone;

    @Enumerated(EnumType.STRING)
    private TipoTelefone tipoTelefone;

    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "atendido_id")
    private Atendido atendido;


}
