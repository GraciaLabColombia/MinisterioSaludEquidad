package com.co.entities;

import com.co.builder.SerializerCustom;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;

@JsonIgnoreProperties(value = { "id",
        "empre_form", "tokenMin", "fechaCaptura", "fechaReporte",
        "fechaRespuesta", "sede", "empleados", "estadoMin", "naturalezaJuridica", "tipoAportante", "actividadEconomica" })
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

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "COD_CENTRO_TRAB")
    private String codCentroTrab;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "CENTRO_TRAB")
    private String centroTrab;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "INDICADOR_ACT")
    private String indicadorAct;

    @Column(name = "CODACT_CENTRO_TRAB")
    private BigDecimal codActCentroTrabajo;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "MUNI_CENTRO_TRAB")
    private String muniCentroTrab;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "DIR_CENTRO_TRAB")
    private String dirCentroTrabajo;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "ZONA_UBI_CENTRO_TRABAJO")
    private String zonaUbiCentroTrabajo;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "TEL_CENTRO_TRAB")
    private String telCentroTrab;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "EMAIL_CENTRO_TRAB")
    private String emailCentroTrabajo;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "TIPDOC_RESP_CENTRAB")
    private String tipDocRespCentrab;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "ID_RESP_CENTRAB")
    private String idRespCentrab;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "RESP_CENTRAB_PRIAPE")
    private String respCentrabPrimerApellido;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "RESP_CENTRAB_SEGAPE")
    private String respCentrabSegundoApellido;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "RESP_CENTRAB_PRINOM")
    private String respCentrabPrimerNombre;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "RESP_CENTRAB_SEGNOM")
    private String respCentrabSegundoNombre;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "ID_PERSONA_RESP")
    private String idPersonaResp;

    @OneToMany(cascade = {PERSIST, MERGE, REMOVE}, mappedBy = "centro", fetch = FetchType.LAZY)
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

    @JsonProperty("codigoCentroTrabajo")
    public void setCodCentroTrab(String codCentroTrab) {
        this.codCentroTrab = codCentroTrab;
    }

    public String getCentroTrab() {
        return centroTrab;
    }

    @JsonProperty("nombreCentroTrabajo")
    public void setCentroTrab(String centroTrab) {
        this.centroTrab = centroTrab;
    }

    public String getIndicadorAct() {
        return indicadorAct;
    }

    @JsonProperty("idCodigoActividadEconomica")
    public void setIndicadorAct(String indicadorAct) {
        this.indicadorAct = indicadorAct;
    }

    public BigDecimal getCodActCentroTrabajo() {
        return codActCentroTrabajo;
    }

    @JsonProperty("codigoActividadEconomica")
    public void setCodActCentroTrabajo(BigDecimal codActCentroTrabajo) {
        this.codActCentroTrabajo = codActCentroTrabajo;
    }

    public String getMuniCentroTrab() {
        return muniCentroTrab;
    }

    @JsonProperty("municipio")
    public void setMuniCentroTrab(String muniCentroTrab) {
        this.muniCentroTrab = muniCentroTrab;
    }

    public String getDirCentroTrabajo() {
        return dirCentroTrabajo;
    }

    @JsonProperty("direccionCT")
    public void setDirCentroTrabajo(String dirCentroTrabajo) {
        this.dirCentroTrabajo = dirCentroTrabajo;
    }

    public String getZonaUbiCentroTrabajo() {
        return zonaUbiCentroTrabajo;
    }

    @JsonProperty("zonaUbicacion")
    public void setZonaUbiCentroTrabajo(String zonaUbiCentroTrabajo) {
        this.zonaUbiCentroTrabajo = zonaUbiCentroTrabajo;
    }

    public String getTelCentroTrab() {
        return telCentroTrab;
    }

    @JsonProperty("telefono")
    public void setTelCentroTrab(String telCentroTrab) {
        this.telCentroTrab = telCentroTrab;
    }

    public String getEmailCentroTrabajo() {
        return emailCentroTrabajo;
    }

    @JsonProperty("correoElectronico")
    public void setEmailCentroTrabajo(String emailCentroTrabajo) {
        this.emailCentroTrabajo = emailCentroTrabajo;
    }

    public String getTipDocRespCentrab() {
        return tipDocRespCentrab;
    }

    @JsonProperty("tipoDocumentoResponsableCT")
    public void setTipDocRespCentrab(String tipDocRespCentrab) {
        this.tipDocRespCentrab = tipDocRespCentrab;
    }

    public String getIdRespCentrab() {
        return idRespCentrab;
    }

    @JsonProperty("numeroDocumentoResponsableCT")
    public void setIdRespCentrab(String idRespCentrab) {
        this.idRespCentrab = idRespCentrab;
    }

    public String getRespCentrabPrimerApellido() {
        return respCentrabPrimerApellido;
    }

    @JsonProperty("primerApellidoResponsableCT")
    public void setRespCentrabPrimerApellido(String respCentrabPrimerApellido) {
        this.respCentrabPrimerApellido = respCentrabPrimerApellido;
    }

    public String getRespCentrabSegundoApellido() {
        return respCentrabSegundoApellido;
    }

    @JsonProperty("segundoApellidoResponsableCT")
    public void setRespCentrabSegundoApellido(String respCentrabSegundoApellido) {
        this.respCentrabSegundoApellido = respCentrabSegundoApellido;
    }

    public String getRespCentrabPrimerNombre() {
        return respCentrabPrimerNombre;
    }

    @JsonProperty("primerNombreResponsableCT")
    public void setRespCentrabPrimerNombre(String respCentrabPrimerNombre) {
        this.respCentrabPrimerNombre = respCentrabPrimerNombre;
    }

    public String getRespCentrabSegundoNombre() {
        return respCentrabSegundoNombre;
    }

    @JsonProperty("segundoNombreResponsableCT")
    public void setRespCentrabSegundoNombre(String respCentrabSegundoNombre) {
        this.respCentrabSegundoNombre = respCentrabSegundoNombre;
    }

    public String getIdPersonaResp() {
        return idPersonaResp;
    }

    @JsonProperty("id_PersonaResponsable")
    public void setIdPersonaResp(String idPersonaResp) {
        this.idPersonaResp = idPersonaResp;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    @JsonProperty("empleados")
    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public void addEmpleados(Empleado empleado){
        this.empleados.add(empleado);
    }

    public int empleados() {
        return this.getEmpleados() == null ? 0 : this.getEmpleados().size();
    }
}
