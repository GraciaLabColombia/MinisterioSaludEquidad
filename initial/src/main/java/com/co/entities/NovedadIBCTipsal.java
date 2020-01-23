package com.co.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "SRV_NOVEDAD_IBC_TIPSAL")
public class NovedadIBCTipsal extends BaseEntity
{
    @Id
    @Column(name = "RV_NOVEDAD_IBC_TIPSAL_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigDecimal id;

    @Column(name = "CONSEC_DESENT")
    private String consecDesent;

    @Column(name = "SEDE_COD")
    private String sedeCod;

    @Column(name = "CENTRO_COD")
    private String centroCod;

    @Column(name = "FEC_NOV_IBC")
    private LocalDateTime fecIniNov;

    @Column(name = "EMPLE_TIPDOC")
    private LocalDateTime empleTipDoc;

    @Column(name = "EMPLE_ID")
    private LocalDateTime empleId;

    @Column(name = "EMPLE_PAPELLIDO")
    private LocalDateTime emprePapellido;

    @Column(name = "EMPLE_PNOMBRE")
    private LocalDateTime emprePnombre;

    @Column(name = "TIPO_COTIZANTE")
    private BigDecimal tipoCotizante;

    @Column(name = "SUBTIPO_COTIZANTE")
    private BigDecimal subTipoCotizante;

    @Column(name = "IBC")
    private BigDecimal ibc;

    @Column(name = "TIPO_SALARIO")
    private BigDecimal tipoSalario;

}
