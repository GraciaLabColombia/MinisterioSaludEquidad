package com.co.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "SRV_MORA_APORTES_SGRL")
public class MoraAportesSGRL extends BaseEntity
{
    @Id
    @Column(name = "SRV_MORA_APORTES_SGRL_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigDecimal id;

    @Column(name = "CONSEC_DESENT")
    private String consecDesent;

    @Column(name = "PERIODO")
    private String periodo;

    @Column(name = "TIPO_REPORTE")
    private String tipoReporte;

}
