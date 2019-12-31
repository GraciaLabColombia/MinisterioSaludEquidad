package com.co.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "SRV_TRANSLADO_EMPRESA_ARL")
public class TransladoEmpresaArl extends BaseEntity
{
    @Id
    @Column(name = "SRV_TRANSLADO_EMPRESA_ARL_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigDecimal transladoEmpresId;

    @Column(name = "CONSEC_DESENT")
    private String consecDesent;

    @Column(name = "FECSOLICITUD_TRANS")
    private LocalDateTime fechaSolicitudTranslado;
}
