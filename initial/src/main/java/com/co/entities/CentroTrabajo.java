package com.co.entities;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "SRV_ESTRUCTURA_CENTRO")
public class CentroTrabajo
{
    public CentroTrabajo() {
        this.empleados = new ArrayList<>();
    }

    @Id
    @Column(name = "SRV_ESTRUCTURA_CENTRO_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigDecimal id;

    @Column(name = "TOKEN_MIN")
    private String tokenMin;

    @Column(name = "FECCAPTURA")
    private String fecCaptura;

    @Column(name = "FECRESPUESTA")
    private String fecRespuesta;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SRV_ESTRUCTURA_SEDE_ID")
    private Sede sede;

    @Column(name = "COD_CENTRO_TRAB")
    private String codCentroTrab;

    @Column(name = "CENTRO_TRAB")
    private BigDecimal centroTrab;

    @Column(name = "INDICADOR_ACT")
    private String indicadorAct;

    @Column(name = "CODACT_CENTRO_TRAB")
    private BigDecimal codActCentroTrabajo;

    @Column(name = "MUNI_CENTRO_TRAB")
    private String muniCentroTrab;

    @Column(name = "DIR_CENTRO_TRAB")
    private String dirCentroTrabajo;

    @Column(name = "ZONA_UBI_CENTRO_TRABAJO")
    private String zonaUbiCentroTrabajo;

    @Column(name = "TEL_CENTRO_TRAB")
    private String telCentroTrab;

    @Column(name = "EMAIL_CENTRO_TRAB")
    private String emailCentroTrabajo;

    @Column(name = "TIPDOC_RESP_CENTRAB")
    private String tipDocRespCentrab;

    @Column(name = "ID_RESP_CENTRAB")
    private String idRespCentrab;

    @Column(name = "RESP_CENTRAB_PRIAPE")
    private String respCentrabPrimerApellido;

    @Column(name = "RESP_CENTRAB_SEGAPE")
    private String respCentrabSegundoApellido;

    @Column(name = "RESP_CENTRAB_PRINOM")
    private String respCentrabPrimerNombre;

    @Column(name = "RESP_CENTRAB_SEGNOM")
    private String respCentrabSegundoNombre;

    @Column(name = "ID_PERSONA_RESP")
    private String idPersonaResp;

    @OneToMany(mappedBy = "centro", fetch = FetchType.LAZY)
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private List<Empleado> empleados;

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

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public String getCodCentroTrab() {
        return codCentroTrab;
    }

    public void setCodCentroTrab(String codCentroTrab) {
        this.codCentroTrab = codCentroTrab;
    }

    public BigDecimal getCentroTrab() {
        return centroTrab;
    }

    public void setCentroTrab(BigDecimal centroTrab) {
        this.centroTrab = centroTrab;
    }

    public String getIndicadorAct() {
        return indicadorAct;
    }

    public void setIndicadorAct(String indicadorAct) {
        this.indicadorAct = indicadorAct;
    }

    public BigDecimal getCodActCentroTrabajo() {
        return codActCentroTrabajo;
    }

    public void setCodActCentroTrabajo(BigDecimal codActCentroTrabajo) {
        this.codActCentroTrabajo = codActCentroTrabajo;
    }

    public String getMuniCentroTrab() {
        return muniCentroTrab;
    }

    public void setMuniCentroTrab(String muniCentroTrab) {
        this.muniCentroTrab = muniCentroTrab;
    }

    public String getDirCentroTrabajo() {
        return dirCentroTrabajo;
    }

    public void setDirCentroTrabajo(String dirCentroTrabajo) {
        this.dirCentroTrabajo = dirCentroTrabajo;
    }

    public String getZonaUbiCentroTrabajo() {
        return zonaUbiCentroTrabajo;
    }

    public void setZonaUbiCentroTrabajo(String zonaUbiCentroTrabajo) {
        this.zonaUbiCentroTrabajo = zonaUbiCentroTrabajo;
    }

    public String getTelCentroTrab() {
        return telCentroTrab;
    }

    public void setTelCentroTrab(String telCentroTrab) {
        this.telCentroTrab = telCentroTrab;
    }

    public String getEmailCentroTrabajo() {
        return emailCentroTrabajo;
    }

    public void setEmailCentroTrabajo(String emailCentroTrabajo) {
        this.emailCentroTrabajo = emailCentroTrabajo;
    }

    public String getTipDocRespCentrab() {
        return tipDocRespCentrab;
    }

    public void setTipDocRespCentrab(String tipDocRespCentrab) {
        this.tipDocRespCentrab = tipDocRespCentrab;
    }

    public String getIdRespCentrab() {
        return idRespCentrab;
    }

    public void setIdRespCentrab(String idRespCentrab) {
        this.idRespCentrab = idRespCentrab;
    }

    public String getRespCentrabPrimerApellido() {
        return respCentrabPrimerApellido;
    }

    public void setRespCentrabPrimerApellido(String respCentrabPrimerApellido) {
        this.respCentrabPrimerApellido = respCentrabPrimerApellido;
    }

    public String getRespCentrabSegundoApellido() {
        return respCentrabSegundoApellido;
    }

    public void setRespCentrabSegundoApellido(String respCentrabSegundoApellido) {
        this.respCentrabSegundoApellido = respCentrabSegundoApellido;
    }

    public String getRespCentrabPrimerNombre() {
        return respCentrabPrimerNombre;
    }

    public void setRespCentrabPrimerNombre(String respCentrabPrimerNombre) {
        this.respCentrabPrimerNombre = respCentrabPrimerNombre;
    }

    public String getRespCentrabSegundoNombre() {
        return respCentrabSegundoNombre;
    }

    public void setRespCentrabSegundoNombre(String respCentrabSegundoNombre) {
        this.respCentrabSegundoNombre = respCentrabSegundoNombre;
    }

    public String getIdPersonaResp() {
        return idPersonaResp;
    }

    public void setIdPersonaResp(String idPersonaResp) {
        this.idPersonaResp = idPersonaResp;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public void addEmpleados(Empleado empleado){
        this.empleados.add(empleado);
    }
}
