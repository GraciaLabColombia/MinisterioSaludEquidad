package com.co.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "SRV_CENTROS_TRABAJO")
public class CentrosTrabajo extends BaseEntity
{
    @Id
    @Column(name = "SRV_CENTROS_TRABAJO_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigDecimal id;

    @Column(name = "EMPRE_NIT_DESCENT")
    private String empreNitDescent;

    @Column(name = "COD_SEDE")
    private String codSede;

    @Column(name = "COD_CENTRO_TRAB")
    private String codCentroTrab;

    @Column(name = "CENTRO_TRAB")
    private String centroTrab;

    @Column(name = "CODACT_CENTRO_TRAB")
    private BigDecimal codactCentroTrab;

    @Column(name = "MUNI_CENTRO_TRAB")
    private String muniCentroTrab;

    @Column(name = "DIR_CENTRO_TRAB")
    private String dirCentroTrab;

    @Column(name = "ZONA_UBI_CENTRO_TRABAJO")
    private String zonaUbiCentroTrabajo;

    @Column(name = "TEL_CENTRO_TRAB")
    private String telCentroTrab;

    @Column(name = "EMAIL_CENTRO_TRAB")
    private String emailCentroTrab;

    @Column(name = "TIPDOC_RESP_CENTRAB")
    private String tipDocRespCentrab;

    @Column(name = "ID_RESP_CENTRAB")
    private String idRespCentrab;

    @Column(name = "RESP_CENTRAB_PRIAPE")
    private String RespCentrabPriApe;

    @Column(name = "RESP_CENTRAB_PRINOM")
    private String RespCentrabPriNom;

    @Column(name = "INDICADOR_ACT")
    private String indicadorAct;



}
