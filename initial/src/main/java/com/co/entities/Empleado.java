package com.co.entities;

import javax.persistence.*;
import java.math.BigDecimal;

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

    @Column(name = "EMPLE_TIPDOC")
    private String tipoDocEmpleado;

    @Column(name = "EMPLE_ID")
    private String numeroEmpleado;

    @Column(name = "EMPLE_PAPELLIDO")
    private String primerApellidoEmpleado;

    @Column(name = "EMPLE_SAPELLIDO")
    private String segundoApellidoEmpleado;

    @Column(name = "EMPLE_PNOMBRE")
    private String primerNombreEmpleado;

    @Column(name = "EMPLE_SNOMBRE")
    private String segundoNombreEmpleado;

    @Column(name = "TIPO_COTIZANTE")
    private BigDecimal tipoCotizante;

    @Column(name = "SUBTIPO_COTIZANTE")
    private BigDecimal subTipoCotizante;

    @Column(name = "IBC")
    private BigDecimal ibc;

    @Column(name = "TIPO_SALARIO")
    private BigDecimal tipoSalario;

    @Column(name = "EMPLE__FECNAC")
    private String empleFecNac;

    @Column(name = "EMPLE__GENERO")
    private String empleGenero;

    @Column(name = "EMPLE_EPS")
    private String empleEps;

    @Column(name = "EMPLE_AFP")
    private String empleAfp;

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

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getTipoDocEmpleado() {
        return tipoDocEmpleado;
    }

    public void setTipoDocEmpleado(String tipoDocEmpleado) {
        this.tipoDocEmpleado = tipoDocEmpleado;
    }

    public String getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public void setNumeroEmpleado(String numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    public String getPrimerApellidoEmpleado() {
        return primerApellidoEmpleado;
    }

    public void setPrimerApellidoEmpleado(String primerApellidoEmpleado) {
        this.primerApellidoEmpleado = primerApellidoEmpleado;
    }

    public String getSegundoApellidoEmpleado() {
        return segundoApellidoEmpleado;
    }

    public void setSegundoApellidoEmpleado(String segundoApellidoEmpleado) {
        this.segundoApellidoEmpleado = segundoApellidoEmpleado;
    }

    public String getPrimerNombreEmpleado() {
        return primerNombreEmpleado;
    }

    public void setPrimerNombreEmpleado(String primerNombreEmpleado) {
        this.primerNombreEmpleado = primerNombreEmpleado;
    }

    public String getSegundoNombreEmpleado() {
        return segundoNombreEmpleado;
    }

    public void setSegundoNombreEmpleado(String segundoNombreEmpleado) {
        this.segundoNombreEmpleado = segundoNombreEmpleado;
    }

    public BigDecimal getTipoCotizante() {
        return tipoCotizante;
    }

    public void setTipoCotizante(BigDecimal tipoCotizante) {
        this.tipoCotizante = tipoCotizante;
    }

    public BigDecimal getSubTipoCotizante() {
        return subTipoCotizante;
    }

    public void setSubTipoCotizante(BigDecimal subTipoCotizante) {
        this.subTipoCotizante = subTipoCotizante;
    }

    public BigDecimal getIbc() {
        return ibc;
    }

    public void setIbc(BigDecimal ibc) {
        this.ibc = ibc;
    }

    public BigDecimal getTipoSalario() {
        return tipoSalario;
    }

    public void setTipoSalario(BigDecimal tipoSalario) {
        this.tipoSalario = tipoSalario;
    }

    public String getEmpleFecNac() {
        return empleFecNac;
    }

    public void setEmpleFecNac(String empleFecNac) {
        this.empleFecNac = empleFecNac;
    }

    public String getEmpleGenero() {
        return empleGenero;
    }

    public void setEmpleGenero(String empleGenero) {
        this.empleGenero = empleGenero;
    }

    public String getEmpleEps() {
        return empleEps;
    }

    public void setEmpleEps(String empleEps) {
        this.empleEps = empleEps;
    }

    public String getEmpleAfp() {
        return empleAfp;
    }

    public void setEmpleAfp(String empleAfp) {
        this.empleAfp = empleAfp;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }
}
