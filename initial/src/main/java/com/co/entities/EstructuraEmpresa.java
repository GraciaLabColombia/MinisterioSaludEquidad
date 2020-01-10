package com.co.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "SRV_ESTRUCTURA_EMPRESA")
public class EstructuraEmpresa
{
    @Id
    @Column(name = "SRV_ESTRUCTURA_EMPRESA_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigDecimal id;

    @Column(name = "TOKEN_MIN")
    private String tokenMin;

    @Column(name = "FECCAPTURA")
    private String fecCaptura;

    @Column(name = "FECRESPUESTA")
    private String fecRespuesta;

    @OneToMany
    @JoinColumn(name = "SRV_CONSULTA_EMPRESA_ID")
    private ConsultaEmpresa consultaEmpresa;

    @Column(name = "EMPRE_TIPDOC")
    private String empreTipDoc;

    @Column(name = "EMPRE_ID")
    private String empreId;

    @Column(name = "EMPRE_NIT_DESCEN")
    private String empreNitDescen;

    @Column(name = "EMPRE_TIPPERS")
    private String tipPerson;

    @Column(name = "NAT_JURIDICA")
    private String natJuridica;

    @Column(name = "TIPO_APOR")
    private String tipoAporte;
}
