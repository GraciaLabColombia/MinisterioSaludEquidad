package com.co.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "SRV_RESPUESTA_SATARL")
public class RespuestaSATARL
{
    @Id
    @Column(name = "SRV_RESPUESTA_SATARL_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigDecimal id;

    @Column(name = "SRV_ID")
    private BigDecimal srvId;

    @Column(name = "SRV_CONSEC")
    private BigDecimal srvConsec;

    @Column(name = "EMPRE_FORM")
    private String empreForm;

    @Column(name = "TOKEN_MIN")
    private String tokenMin;

    @Column(name = "FECRESPUESTA")
    @Temporal(TemporalType.DATE)
    private Date fecRespuesta;

    @Column(name = "ESTADO_MIN")
    private BigDecimal estadoMin;

    @Column(name = "IDERROR_MIN")
    private String iderrorMin;

    @Column(name = "ESTADO_ARL")
    private BigDecimal estadoArl;

    @Column(name = "FECCORRECCION")
    private String fecCorrecion;

    public RespuestaSATARL() {}

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getSrvId() {
        return srvId;
    }

    public void setSrvId(BigDecimal srvId) {
        this.srvId = srvId;
    }

    public BigDecimal getSrvConsec() {
        return srvConsec;
    }

    public void setSrvConsec(BigDecimal srvConsec) {
        this.srvConsec = srvConsec;
    }

    public String getEmpreForm() {
        return empreForm;
    }

    public void setEmpreForm(String empreForm) {
        this.empreForm = empreForm;
    }

    public String getTokenMin() {
        return tokenMin;
    }

    public void setTokenMin(String tokenMin) {
        this.tokenMin = tokenMin;
    }

    public Date getFecRespuesta() {
        return fecRespuesta;
    }

    public void setFecRespuesta(Date fecRespuesta) {
        this.fecRespuesta = fecRespuesta;
    }

    public BigDecimal getEstadoMin() {
        return estadoMin;
    }

    public void setEstadoMin(BigDecimal estadoMin) {
        this.estadoMin = estadoMin;
    }

    public String getIderrorMin() {
        return iderrorMin;
    }

    public void setIderrorMin(String iderrorMin) {
        this.iderrorMin = iderrorMin;
    }

    public BigDecimal getEstadoArl() {
        return estadoArl;
    }

    public void setEstadoArl(BigDecimal estadoArl) {
        this.estadoArl = estadoArl;
    }

    public String getFecCorrecion() {
        return fecCorrecion;
    }

    public void setFecCorrecion(String fecCorrecion) {
        this.fecCorrecion = fecCorrecion;
    }
}
