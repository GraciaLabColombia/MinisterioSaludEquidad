package com.co.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "parametrosgenerales")
public class ParametroGeneral {

    @Id
    @Column(name = "idparametro")
    private BigDecimal id;

    @Column(name = "parametro")
    private String parametro;

    @Column(name = "consecutivo")
    private BigDecimal consecutivo;

    @Column(name = "documento")
    private String documento;

    @Column(name = "sigla")
    private String sigla;

    @Column(name = "activo")
    private BigDecimal activo;

    @Column(name = "tipodato")
    private String tipodato;

    @Column(name = "longitudmin")
    private BigDecimal longitudmin;

    @Column(name = "longitudmax")
    private BigDecimal longitudmax;

    @Column(name = "aplicaempresa")
    private BigDecimal aplicaempresa;

    @Column(name = "aplicaempleado")
    private BigDecimal aplicaempleado;

    @Column(name = "cantidad")
    private String cantidad;

    @Column(name = "valor")
    private String valor;

    @Column(name = "entecontrol")
    private String entecontrol;

    @Column(name = "normatividad")
    private String normatividad;

    @Column(name = "feccaptura")
    private LocalDateTime feccaptura;

    @Column(name = "usuariocaptura")
    private String usuariocaptura;

    @Column(name = "fecinactivacion")
    private String fecinactivacion;

    @Column(name = "usuarioinactiva")
    private String usuarioinactiva;

    @Column(name = "aplicarepresentante")
    private BigDecimal aplicarepresentante;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    public BigDecimal getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(BigDecimal consecutivo) {
        this.consecutivo = consecutivo;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public BigDecimal getActivo() {
        return activo;
    }

    public void setActivo(BigDecimal activo) {
        this.activo = activo;
    }

    public String getTipodato() {
        return tipodato;
    }

    public void setTipodato(String tipodato) {
        this.tipodato = tipodato;
    }

    public BigDecimal getLongitudmin() {
        return longitudmin;
    }

    public void setLongitudmin(BigDecimal longitudmin) {
        this.longitudmin = longitudmin;
    }

    public BigDecimal getLongitudmax() {
        return longitudmax;
    }

    public void setLongitudmax(BigDecimal longitudmax) {
        this.longitudmax = longitudmax;
    }

    public BigDecimal getAplicaempresa() {
        return aplicaempresa;
    }

    public void setAplicaempresa(BigDecimal aplicaempresa) {
        this.aplicaempresa = aplicaempresa;
    }

    public BigDecimal getAplicaempleado() {
        return aplicaempleado;
    }

    public void setAplicaempleado(BigDecimal aplicaempleado) {
        this.aplicaempleado = aplicaempleado;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getEntecontrol() {
        return entecontrol;
    }

    public void setEntecontrol(String entecontrol) {
        this.entecontrol = entecontrol;
    }

    public String getNormatividad() {
        return normatividad;
    }

    public void setNormatividad(String normatividad) {
        this.normatividad = normatividad;
    }

    public LocalDateTime getFeccaptura() {
        return feccaptura;
    }

    public void setFeccaptura(LocalDateTime feccaptura) {
        this.feccaptura = feccaptura;
    }

    public String getUsuariocaptura() {
        return usuariocaptura;
    }

    public void setUsuariocaptura(String usuariocaptura) {
        this.usuariocaptura = usuariocaptura;
    }

    public String getFecinactivacion() {
        return fecinactivacion;
    }

    public void setFecinactivacion(String fecinactivacion) {
        this.fecinactivacion = fecinactivacion;
    }

    public String getUsuarioinactiva() {
        return usuarioinactiva;
    }

    public void setUsuarioinactiva(String usuarioinactiva) {
        this.usuarioinactiva = usuarioinactiva;
    }

    public BigDecimal getAplicarepresentante() {
        return aplicarepresentante;
    }

    public void setAplicarepresentante(BigDecimal aplicarepresentante) {
        this.aplicarepresentante = aplicarepresentante;
    }
}
