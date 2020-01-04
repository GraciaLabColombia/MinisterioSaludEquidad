package com.co.entities;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.math.BigDecimal;

@JsonPropertyOrder({ "CodigoARL", "TipoDocumentoEmpleador", "NumeroDocumentoEmpleador",
                    "ConsecutivoNITEmpleador", "TipoPersona", "NaturalezaJuridica", "TipoAportante",
"RazonSocialEmpleador", "PrimerNombreEmpleador", "PrimerApellidoEmpleador", "CorreoEmpleador", "ActividadEconomica",
"ClaseAportante", "TipoDocumentoRepresentante", "NumeroDocumentoRepresentante", "PrimerNombreRepresentante",
"PrimerApellidoRepresentante", "FechaAfiliacion", "CodigoSedeP", "NombreSedeP", "MunicipioSedeP", "DireccionSedeP", "ZonaSedeP",
"TelefonoSedeP", "CorreoSedeP", "TipoDocumentoResponsable", "NumeroDocumentoResponsable", "PrimerNombreResponsable", "PrimerApellidoResponsable"})
@JsonIgnoreProperties(value = { "afiliacionEmpresaId",
        "empre_form", "tokenMin", "fechaCaptura", "fechaReporte",
        "fechaRespuesta", "estadoMin" })
@NamedQueries({
        @NamedQuery(name = "AfiliacionEmpresa.afiliacionesPorProcesarQuery", query = "SELECT a FROM AfiliacionEmpresa a WHERE a.estadoMin IN(:estados)")})
@Entity
@Table(name = "SRV_AFILIACION_EMPRESA")
public class AfiliacionEmpresa extends BaseEntity
{
    @Id
    @Column(name = "SRV_AFILIACION_EMPRESA_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigDecimal afiliacionEmpresaId;

    @Column(name = "EMPRE_NIT_DESCENT")
    private String ConsecutivoNITEmpleador;

    @Column(name = "EMPRE_TIPPERS")
    private String TipoPersona;

    @Column(name = "NAT_JURIDICA")
    private String naturalezaJuridica;

    @Column(name = "TIPO_APOR")
    private String tipoAportante;

    @Column(name = "EMPRE_RAZSOC")
    private String RazonSocialEmpleador;

    @Column(name = "EMPRE_PERNAT_PRINOM")
    private String PrimerNombreEmpleador;

    @Column(name = "EMPRE_PERNAT_PRIAPE")
    private String PrimerApellidoEmpleador;

    @Column(name = "EMPRE_EMAIL")
    private String CorreoEmpleador;

    @Column(name = "EMPRE_CODACT")
    private String actividadEconomica;

    @Column(name = "CLASE_APOR")
    private String ClaseAportante;

    @Column(name = "COD_ARL")
    private String CodigoARL;

    @Column(name = "TIPDOC_REPRE")
    private String TipoDocumentoRepresentante;

    @Column(name = "ID_REPRE")
    private String NumeroDocumentoRepresentante;

    @Column(name = "EMPRE_REPRE_PRINOM")
    private String PrimerNombreRepresentante;

    @Column(name = "EMPRE_REPRE_PRIAPE")
    private String PrimerApellidoRepresentante;

    @Column(name = "FECCREAARL")
    private String FechaAfiliacion;

    @Column(name = "EMPRE_COD_SEDEPRIN")
    private String CodigoSedeP;

    @Column(name = "EMPRE_NOM_SEDEPRIN")
    private String NombreSedeP;

    @Column(name = "EMPRE_MUNI_SEDEPRIN")
    private String MunicipioSedeP;

    @Column(name = "EMPRE_DIR_SEDEPRIN")
    private String DireccionSedeP;

    @Column(name = "EMPRE_ZONA_SEDEPRIN")
    private String ZonaSedeP;

    @Column(name = "EMPRE_TEL_SEDEPRIN")
    private String TelefonoSedeP;

    @Column(name = "EMPRE_EMAIL_SEDEPRIN")
    private String CorreoSedeP;

    @Column(name = "TIPDOC_RESPO")
    private String TipoDocumentoResponsable;

    @Column(name = "ID_RESPO")
    private String NumeroDocumentoResponsable;

    @Column(name = "RESPO_PRIAPE")
    private String PrimerNombreResponsable;

    @Column(name = "RESPO_PRINOM")
    private String PrimerApellidoResponsable;

    //Transient fields

    @JsonInclude()
    @Transient
    @JsonProperty("ActividadEconomica")
    public int activiEconimi;

    @JsonInclude()
    @Transient
    @JsonProperty("NaturalezaJuridica")
    public int natuJuridica;

    @JsonInclude()
    @Transient
    @JsonProperty("TipoAportante")
    public int tipAportante;

    public String getCodigoARL() {
        return CodigoARL == null ? "null" : CodigoARL;
    }

    @JsonProperty("CodigoARL")
    public void setCodigoARL(String codigoARL) {
        CodigoARL = codigoARL;
    }

    public BigDecimal getAfiliacionEmpresaId() {
        return afiliacionEmpresaId;
    }

    public void setAfiliacionEmpresaId(BigDecimal afiliacionEmpresaId) {
        this.afiliacionEmpresaId = afiliacionEmpresaId;
    }

    public String getConsecutivoNITEmpleador() {
        return ConsecutivoNITEmpleador == null ? "null" : ConsecutivoNITEmpleador;
    }

    @JsonProperty("ConsecutivoNITEmpleador")
    public void setConsecutivoNITEmpleador(String consecutivoNITEmpleador) {
        ConsecutivoNITEmpleador = consecutivoNITEmpleador;
    }

    public String getTipoPersona() {
        return TipoPersona  == null ? "null" : TipoPersona;
    }

    @JsonProperty("TipoPersona")
    public void setTipoPersona(String tipoPersona) {
        TipoPersona = tipoPersona;
    }

    public String getNaturalezaJuridica() {
        return naturalezaJuridica == null ? "null" : naturalezaJuridica;
    }

    @JsonIgnore
    public void setNaturalezaJuridica(String naturalezaJuridica) {
        this.naturalezaJuridica = naturalezaJuridica;
    }

    public String getTipoAportante() {
        return tipoAportante;
    }

    @JsonIgnore
    public void setTipoAportante(String tipoAportante) {
        this.tipoAportante = tipoAportante;
    }

    public String getRazonSocialEmpleador() {
        return RazonSocialEmpleador  == null ? "null" : RazonSocialEmpleador;
    }

    @JsonProperty("RazonSocialEmpleador")
    public void setRazonSocialEmpleador(String razonSocialEmpleador) {
        RazonSocialEmpleador = razonSocialEmpleador;
    }

    public String getPrimerNombreEmpleador() {
        return PrimerNombreEmpleador  == null ? "null" : PrimerNombreEmpleador;
    }

    @JsonProperty("PrimerNombreEmpleador")
    public void setPrimerNombreEmpleador(String primerNombreEmpleador) {
        PrimerNombreEmpleador = primerNombreEmpleador;
    }

    public String getPrimerApellidoEmpleador() {
        return PrimerApellidoEmpleador  == null ? "null" :  PrimerApellidoEmpleador;
    }

    @JsonProperty("PrimerApellidoEmpleador")
    public void setPrimerApellidoEmpleador(String primerApellidoEmpleador) {
        PrimerApellidoEmpleador = primerApellidoEmpleador;
    }

    public String getCorreoEmpleador() {
        return CorreoEmpleador  == null ? "null" : CorreoEmpleador;
    }

    @JsonProperty("CorreoEmpleador")
    public void setCorreoEmpleador(String correoEmpleador) {
        CorreoEmpleador = correoEmpleador;
    }

    public String getActividadEconomica() {
        return actividadEconomica;
    }

    @JsonIgnore
    public void setActividadEconomica(String actividadEconomica) {
        this.actividadEconomica = actividadEconomica;
    }

    public String getClaseAportante() {
        return ClaseAportante  == null ? "null" : ClaseAportante;
    }

    @JsonProperty("ClaseAportante")
    public void setClaseAportante(String claseAportante) {
        ClaseAportante = claseAportante;
    }

    public String getTipoDocumentoRepresentante() {
        return TipoDocumentoRepresentante  == null ? "null" :  TipoDocumentoRepresentante;
    }

    @JsonProperty("TipoDocumentoRepresentante")
    public void setTipoDocumentoRepresentante(String tipoDocumentoRepresentante) {
        TipoDocumentoRepresentante = tipoDocumentoRepresentante;
    }

    public String getNumeroDocumentoRepresentante() {
        return NumeroDocumentoRepresentante  == null ? "null" : NumeroDocumentoRepresentante;
    }

    @JsonProperty("NumeroDocumentoRepresentante")
    public void setNumeroDocumentoRepresentante(String numeroDocumentoRepresentante) {
        NumeroDocumentoRepresentante = numeroDocumentoRepresentante;
    }

    public String getPrimerNombreRepresentante() {
        return PrimerNombreRepresentante  == null ? "null" : PrimerNombreRepresentante;
    }

    @JsonProperty("PrimerNombreRepresentante")
    public void setPrimerNombreRepresentante(String primerNombreRepresentante) {
        PrimerNombreRepresentante = primerNombreRepresentante;
    }

    public String getPrimerApellidoRepresentante() {
        return PrimerApellidoRepresentante  == null ? "null" : PrimerApellidoRepresentante;
    }

    @JsonProperty("PrimerApellidoRepresentante")
    public void setPrimerApellidoRepresentante(String primerApellidoRepresentante) {
        PrimerApellidoRepresentante = primerApellidoRepresentante;
    }

    public String getFechaAfiliacion() {
        return FechaAfiliacion  == null ? "null" : FechaAfiliacion;
    }

    @JsonProperty("FechaAfiliacion")
    public void setFechaAfiliacion(String fechaAfiliacion) {
        FechaAfiliacion = fechaAfiliacion;
    }

    public String getCodigoSedeP() {
        return CodigoSedeP  == null ? "null" : CodigoSedeP;
    }

    @JsonProperty("CodigoSedeP")
    public void setCodigoSedeP(String codigoSedeP) {
        CodigoSedeP = codigoSedeP;
    }

    public String getNombreSedeP() {
        return NombreSedeP  == null ? "null" : NombreSedeP;
    }

    @JsonProperty("NombreSedeP")
    public void setNombreSedeP(String nombreSedeP) {
        NombreSedeP = nombreSedeP;
    }

    public String getMunicipioSedeP() {
        return MunicipioSedeP  == null ? "null" : MunicipioSedeP;
    }

    @JsonProperty("MunicipioSedeP")
    public void setMunicipioSedeP(String municipioSedeP) {
        MunicipioSedeP = municipioSedeP;
    }

    public String getDireccionSedeP() {
        return DireccionSedeP  == null ? "null" : DireccionSedeP;
    }

    @JsonProperty("DireccionSedeP")
    public void setDireccionSedeP(String direccionSedeP) {
        DireccionSedeP = direccionSedeP;
    }

    public String getZonaSedeP() {
        return ZonaSedeP  == null ? "null" : ZonaSedeP;
    }

    @JsonProperty("ZonaSedeP")
    public void setZonaSedeP(String zonaSedeP) {
        ZonaSedeP = zonaSedeP;
    }

    public String getTelefonoSedeP() {
        return TelefonoSedeP  == null ? "null" : TelefonoSedeP;
    }

    @JsonProperty("TelefonoSedeP")
    public void setTelefonoSedeP(String telefonoSedeP) {
        TelefonoSedeP = telefonoSedeP;
    }

    public String getCorreoSedeP() {
        return CorreoSedeP  == null ? "null" : CorreoSedeP;
    }

    @JsonProperty("CorreoSedeP")
    public void setCorreoSedeP(String correoSedeP) {
        CorreoSedeP = correoSedeP;
    }

    public String getTipoDocumentoResponsable() {
        return TipoDocumentoResponsable  == null ? "null" : TipoDocumentoResponsable;
    }

    @JsonProperty("TipoDocumentoResponsable")
    public void setTipoDocumentoResponsable(String tipoDocumentoResponsable) {
        TipoDocumentoResponsable = tipoDocumentoResponsable;
    }

    public String getNumeroDocumentoResponsable() {
        return NumeroDocumentoResponsable  == null ? "null" : NumeroDocumentoResponsable;
    }

    @JsonProperty("NumeroDocumentoResponsable")
    public void setNumeroDocumentoResponsable(String numeroDocumentoResponsable) {
        NumeroDocumentoResponsable = numeroDocumentoResponsable;
    }

    public String getPrimerNombreResponsable() {
        return PrimerNombreResponsable  == null ? "null" : PrimerNombreResponsable;
    }

    @JsonProperty("PrimerNombreResponsable")
    public void setPrimerNombreResponsable(String primerNombreResponsable) {
        PrimerNombreResponsable = primerNombreResponsable;
    }

    public String getPrimerApellidoResponsable() {
        return PrimerApellidoResponsable  == null ? "null" : PrimerApellidoResponsable;
    }

    @JsonProperty("PrimerApellidoResponsable")
    public void setPrimerApellidoResponsable(String primerApellidoResponsable) {
        PrimerApellidoResponsable = primerApellidoResponsable;
    }
}
