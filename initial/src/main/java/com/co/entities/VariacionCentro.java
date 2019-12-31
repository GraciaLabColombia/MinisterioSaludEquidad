package com.co.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "SRV_VARIACION_CENTRO")
public class VariacionCentro extends BaseEntity
{
    @Id
    @Column(name = "SRV_VARIACION_CENTRO_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigDecimal id;

    @Column(name = "CONSEC_DESENT")
    private String consecDesent;

    @Column(name = "COD_ANT_SEDE")
    private String codAntSede;

    @Column(name = "COD_NUEVA_SEDE")
    private String codNuevaSede;

    @Column(name = "COD_ANT_CENTRO")
    private String codAntCentro;

    @Column(name = "COD_NUEVA_CENTRO")
    private String codNuevaCentro;

    @Column(name = "FECINI_NOV")
    private LocalDateTime fecIniNov;

    @Column(name = "EMPLE_TIPDOC")
    private LocalDateTime empleTipDoc;

    @Column(name = "EMPLE_ID")
    private LocalDateTime empleId;

    @Column(name = "TIPO_COTIZANTE")
    private BigDecimal tipoCotizante;

    @Column(name = "SUBTIPO_COTIZANTE")
    private BigDecimal subTipoCotizante;
}
