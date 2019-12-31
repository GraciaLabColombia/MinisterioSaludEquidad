package com.co.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "SRV_NOVEDADES_TRANSITORIAS")
public class NovedadesTransitorias extends BaseEntity
{
    @Id
    @Column(name = "SRV_NOVEDADES_TRANSITORIAS_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigDecimal id;

    @Column(name = "CONSEC_DESENT")
    private String consecDesent;

    @Column(name = "FECINI_NOVTRANSITORIA")
    private LocalDateTime fecIniNovTransitoria;

    @Column(name = "FECFIN_NOVTRANSITORIA")
    private String fecFinNovTransitoria;

    @Column(name = "TIPO_NOVTRANSITORIA")
    private BigDecimal tipoNovTransitoria;

    @Column(name = "EMPLE_TIPDOC")
    private String empleTipDoc;

    @Column(name = "EMPLE_ID")
    private String empleId;

    @Column(name = "EMPLE_PAPELLIDO")
    private LocalDateTime emprePapellido;

    @Column(name = "EMPLE_PNOMBRE")
    private LocalDateTime emprePnombre;

    @Column(name = "TIPO_COTIZANTE")
    private BigDecimal tipoCotizante;

    @Column(name = "SUBTIPO_COTIZANTE")
    private BigDecimal subTipoCotizante;

    @Column(name = "INDICADOR_NOVEDAD")
    private String indicadorNovedad;
}
