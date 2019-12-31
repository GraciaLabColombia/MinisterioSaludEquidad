package com.co.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@MappedSuperclass
public class BaseEntity
{
    @JsonIgnore
    @Column(name = "EMPRE_FORM")
    private String empre_form;

    @JsonIgnore
    @Column(name = "TOKEN_MIN")
    private String tokenMin;

    @JsonIgnore
    @Column(name = "FECCAPTURA")
    private LocalDateTime fechaCaptura;

    @JsonIgnore
    @Column(name = "FECREPORTE")
    private LocalDateTime  fechaReporte;

    @JsonIgnore
    @Column(name = "FECRESPUESTA")
    private LocalDateTime  fechaRespuesta;

    @JsonIgnore
    @Column(name = "ESTADO_MIN")
    private BigDecimal estadoMin;

    @Column(name = "EMPRE_TIPDOC")
    private String TipoDocumentoEmpleador;

    @Column(name = "EMPRE_ID")
    private String NumeroDocumentoEmpleador;

    public String getEmpre_form() {
        return empre_form;
    }

    public void setEmpre_form(String empre_form) {
        this.empre_form = empre_form;
    }

    public String getTokenMin() {
        return tokenMin;
    }

    public void setTokenMin(String tokenMin) {
        this.tokenMin = tokenMin;
    }

    public LocalDateTime getFechaCaptura() {
        return fechaCaptura;
    }

    public void setFechaCaptura(LocalDateTime fechaCaptura) {
        this.fechaCaptura = fechaCaptura;
    }

    public LocalDateTime getFechaReporte() {
        return fechaReporte;
    }

    public void setFechaReporte(LocalDateTime fechaReporte) {
        this.fechaReporte = fechaReporte;
    }

    public LocalDateTime getFechaRespuesta() {
        return fechaRespuesta;
    }

    public void setFechaRespuesta(LocalDateTime fechaRespuesta) {
        this.fechaRespuesta = fechaRespuesta;
    }

    public BigDecimal getEstadoMin() {
        return estadoMin;
    }

    public void setEstadoMin(BigDecimal estadoMin) {
        this.estadoMin = estadoMin;
    }

    public String getTipoDocumentoEmpleador() {
        return TipoDocumentoEmpleador;
    }

    public void setTipoDocumentoEmpleador(String tipoDocumentoEmpleador) {
        TipoDocumentoEmpleador = tipoDocumentoEmpleador;
    }

    public String getNumeroDocumentoEmpleador() {
        return NumeroDocumentoEmpleador;
    }

    public void setNumeroDocumentoEmpleador(String numeroDocumentoEmpleador) {
        NumeroDocumentoEmpleador = numeroDocumentoEmpleador;
    }
}
