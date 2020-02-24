package com.co.entities;

import com.co.builder.SerializerCustom;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "parametrosgenerales")
public class ParametroGeneral {

    @Id
    @Column(name = "idparametro")
    private BigDecimal id;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "parametro")
    private String parametro;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "consecutivo")
    private BigDecimal consecutivo;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "documento")
    private String documento;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "sigla")
    private String sigla;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "activo")
    private BigDecimal activo;

    @JsonSerialize(using = SerializerCustom.class)
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

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "cantidad")
    private String cantidad;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "valor")
    private String valor;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "entecontrol")
    private String entecontrol;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "normatividad")
    private String normatividad;

    @Column(name = "feccaptura")
    private LocalDateTime feccaptura;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "usuariocaptura")
    private String usuariocaptura;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "fecinactivacion")
    private String fecinactivacion;

    @JsonSerialize(using = SerializerCustom.class)
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
