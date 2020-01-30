package com.co.entities;

import com.co.builder.SerializerCustom;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.math.BigDecimal;

@JsonIgnoreProperties(value = { "id",
        "empre_form", "tokenMin", "fechaCaptura", "fechaReporte",
        "fechaRespuesta", "centro", "estadoMin", "naturalezaJuridica", "tipoAportante", "actividadEconomica" })
@Entity
@Table(name = "SRV_ESTRUCTURA_EMPLEADO")
public class Empleado
{
    @Id
    @Column(name = "SRV_ESTRUCTURA_EMPLEADO_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigDecimal id;

    @Column(name = "TOKEN_MIN")
    private String tokenMin;

    @Column(name = "FECCAPTURA")
    private String fecCaptura;

    @Column(name = "FECRESPUESTA")
    private String fecRespuesta;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SRV_ESTRUCTURA_CENTRO_ID")
    private CentroTrabajo centro;

    @Column(name = "FECINI_NOV")
    private String fechaInicio;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "EMPLE_TIPDOC")
    private String tipoDocEmpleado;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "EMPLE_ID")
    private String numeroEmpleado;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "EMPLE_PAPELLIDO")
    private String primerApellidoEmpleado;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "EMPLE_SAPELLIDO")
    private String segundoApellidoEmpleado;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "EMPLE_PNOMBRE")
    private String primerNombreEmpleado;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "EMPLE_SNOMBRE")
    private String segundoNombreEmpleado;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "TIPO_COTIZANTE")
    private String tipoCotizante;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "SUBTIPO_COTIZANTE")
    private String subTipoCotizante;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "IBC")
    private String ibc;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "TIPO_SALARIO")
    private String tipoSalario;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "EMPLE__FECNAC")
    private String empleFecNac;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "EMPLE__GENERO")
    private String empleGenero;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "EMPLE_EPS")
    private String empleEps;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "EMPLE_AFP")
    private String empleAfp;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "FECFIN_NOV")
    private String fechaFin;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getTokenMin() {
        return tokenMin;
    }

    public void setTokenMin(String tokenMin) {
        this.tokenMin = tokenMin;
    }

    public String getFecCaptura() {
        return fecCaptura;
    }

    public void setFecCaptura(String fecCaptura) {
        this.fecCaptura = fecCaptura;
    }

    public String getFecRespuesta() {
        return fecRespuesta;
    }

    public void setFecRespuesta(String fecRespuesta) {
        this.fecRespuesta = fecRespuesta;
    }

    public CentroTrabajo getCentro() {
        return centro;
    }

    public void setCentro(CentroTrabajo centro) {
        this.centro = centro;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    @JsonProperty("fechaInicio")
    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getTipoDocEmpleado() {
        return tipoDocEmpleado;
    }

    @JsonProperty("tipoDocumentoIdentificacion")
    public void setTipoDocEmpleado(String tipoDocEmpleado) {
        this.tipoDocEmpleado = tipoDocEmpleado;
    }

    public String getNumeroEmpleado() {
        return numeroEmpleado;
    }

    @JsonProperty("numeroDocumentoIdentificacion")
    public void setNumeroEmpleado(String numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    public String getPrimerApellidoEmpleado() {
        return primerApellidoEmpleado;
    }

    @JsonProperty("primerApellidoTrabajador")
    public void setPrimerApellidoEmpleado(String primerApellidoEmpleado) {
        this.primerApellidoEmpleado = primerApellidoEmpleado;
    }

    public String getSegundoApellidoEmpleado() {
        return segundoApellidoEmpleado;
    }

    @JsonProperty("segundoApellidoTrabajador")
    public void setSegundoApellidoEmpleado(String segundoApellidoEmpleado) {
        this.segundoApellidoEmpleado = segundoApellidoEmpleado;
    }

    public String getPrimerNombreEmpleado() {
        return primerNombreEmpleado;
    }

    @JsonProperty("primerNombreTrabajador")
    public void setPrimerNombreEmpleado(String primerNombreEmpleado) {
        this.primerNombreEmpleado = primerNombreEmpleado;
    }

    public String getSegundoNombreEmpleado() {
        return segundoNombreEmpleado;
    }

    @JsonProperty("segundoNombreTrabajador")
    public void setSegundoNombreEmpleado(String segundoNombreEmpleado) {
        this.segundoNombreEmpleado = segundoNombreEmpleado;
    }

    public String getTipoCotizante() {
        return tipoCotizante;
    }

    @JsonProperty("tipoCotizante")
    public void setTipoCotizante(String tipoCotizante) {
        this.tipoCotizante = tipoCotizante;
    }

    public String getSubTipoCotizante() {
        return subTipoCotizante;
    }

    @JsonProperty("subtipoCotizante")
    public void setSubTipoCotizante(String subTipoCotizante) {
        this.subTipoCotizante = subTipoCotizante;
    }

    public String getIbc() {
        return ibc;
    }

    @JsonProperty("ibc")
    public void setIbc(String ibc) {
        this.ibc = ibc;
    }

    public String getTipoSalario() {
        return tipoSalario;
    }

    @JsonProperty("tipoSalario")
    public void setTipoSalario(String tipoSalario) {
        this.tipoSalario = tipoSalario;
    }

    public String getEmpleFecNac() {
        return empleFecNac;
    }

    @JsonProperty("fechaNacimiento")
    public void setEmpleFecNac(String empleFecNac) {
        this.empleFecNac = empleFecNac;
    }

    public String getEmpleGenero() {
        return empleGenero;
    }

    @JsonProperty("sexoTrabajador")
    public void setEmpleGenero(String empleGenero) {
        this.empleGenero = empleGenero;
    }

    public String getEmpleEps() {
        return empleEps;
    }

    @JsonProperty("epsTrabajador")
    public void setEmpleEps(String empleEps) {
        this.empleEps = empleEps;
    }

    public String getEmpleAfp() {
        return empleAfp;
    }

    @JsonProperty("afpTrabajador")
    public void setEmpleAfp(String empleAfp) {
        this.empleAfp = empleAfp;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    @JsonProperty("fechafin")
    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }
}
