package com.co.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.math.BigDecimal;

@JsonIgnoreProperties(value = { "empre_form",  "tokenMin", "fechaCaptura", "fechaReporte", "fechaRespuesta", "estadoMin"})
@MappedSuperclass
public class BaseEntity implements Serializable
{
    @Column(name = "EMPRE_FORM")
    private String empre_form;

    @Column(name = "TOKEN_MIN")
    private String tokenMin;

    @Column(name = "FECCAPTURA")
    private String fechaCaptura;

    @Column(name = "FECREPORTE")
    private String  fechaReporte;

    @Column(name = "FECRESPUESTA")
    private String  fechaRespuesta;

    @Column(name = "ESTADO_MIN")
    private BigDecimal estadoMin;

    @Column(name = "EMPRE_TIPDOC")
    private String TipoDocumentoEmpleador;

    @Column(name = "EMPRE_ID")
    private String NumeroDocumentoEmpleador;

    public BaseEntity() {
    }

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

    public String getFechaCaptura() {
        return fechaCaptura;
    }

    public void setFechaCaptura(String fechaCaptura) {
        this.fechaCaptura = fechaCaptura;
    }

    public String getFechaReporte() {
        return fechaReporte;
    }

    public void setFechaReporte(String fechaReporte) {
        this.fechaReporte = fechaReporte;
    }

    public String getFechaRespuesta() {
        return fechaRespuesta;
    }

    public void setFechaRespuesta(String fechaRespuesta) {
        this.fechaRespuesta = fechaRespuesta;
    }

    public BigDecimal getEstadoMin() {
        return estadoMin;
    }

    public void setEstadoMin(BigDecimal estadoMin) {
        this.estadoMin = estadoMin;
    }

    public String getTipoDocumentoEmpleador() {
        return TipoDocumentoEmpleador  == null ? "null" : TipoDocumentoEmpleador;
    }

    @JsonProperty("TipoDocumentoEmpleador")
    public void setTipoDocumentoEmpleador(String tipoDocumentoEmpleador) {
        TipoDocumentoEmpleador = tipoDocumentoEmpleador;
    }

    public String getNumeroDocumentoEmpleador() {
        return NumeroDocumentoEmpleador  == null ? "null" : NumeroDocumentoEmpleador;
    }

    @JsonProperty("NumeroDocumentoEmpleador")
    public void setNumeroDocumentoEmpleador(String numeroDocumentoEmpleador) {
        NumeroDocumentoEmpleador = numeroDocumentoEmpleador;
    }
}
