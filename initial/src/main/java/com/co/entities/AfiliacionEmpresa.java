package com.co.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@NamedQueries({
        @NamedQuery(name = "AfiliacionEmpresa.afiliacionesPorProcesarQuery", query = "SELECT a FROM AfiliacionEmpresa a WHERE a.estadoMin IN(:estados)")})
@Entity
@Table(name = "SRV_AFILIACION_EMPRESA")
public class AfiliacionEmpresa extends BaseEntity
{
    @JsonIgnore
    @Id
    @Column(name = "SRV_AFILIACION_EMPRESA_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigDecimal afiliacionEmpresaId;

    @Column(name = "EMPRE_NIT_DESCENT")
    private String ConsecutivoNITEmpleador;

    @Column(name = "EMPRE_TIPPERS")
    private String TipoPersona;

    @Column(name = "NAT_JURIDICA")
    private String NaturalezaJuridica;

    @Column(name = "TIPO_APOR")
    private String TipoAportante;

    @Column(name = "EMPRE_RAZSOC")
    private String RazonSocialEmpleador;

    @Column(name = "EMPRE_PERNAT_PRINOM")
    private String PrimerNombreEmpleador;

    @Column(name = "EMPRE_PERNAT_PRIAPE")
    private String PrimerApellidoEmpleador;

    @Column(name = "EMPRE_EMAIL")
    private String CorreoEmpleador;

    @Column(name = "EMPRE_CODACT")
    private String ActividadEconomica;

    @Column(name = "CLASE_APOR")
    private String ClaseAportante;

    @Column(name = "TIPDOC_REPRE")
    private String TipoDocumentoRepresentante;

    @Column(name = "ID_REPRE")
    private String NumeroDocumentoRepresentante;

    @Column(name = "EMPRE_REPRE_PRINOM")
    private String PrimerNombreRepresentante;

    @Column(name = "EMPRE_REPRE_PRIAPE")
    private String PrimerApellidoRepresentante;

    @Column(name = "FECCREAARL")
    private LocalDateTime FechaAfiliacion;

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

    public BigDecimal getAfiliacionEmpresaId() {
        return afiliacionEmpresaId;
    }

    public void setAfiliacionEmpresaId(BigDecimal afiliacionEmpresaId) {
        this.afiliacionEmpresaId = afiliacionEmpresaId;
    }

    public String getConsecutivoNITEmpleador() {
        return ConsecutivoNITEmpleador;
    }

    public void setConsecutivoNITEmpleador(String consecutivoNITEmpleador) {
        ConsecutivoNITEmpleador = consecutivoNITEmpleador;
    }

    public String getTipoPersona() {
        return TipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        TipoPersona = tipoPersona;
    }

    public String getNaturalezaJuridica() {
        return NaturalezaJuridica;
    }

    public void setNaturalezaJuridica(String naturalezaJuridica) {
        NaturalezaJuridica = naturalezaJuridica;
    }

    public String getTipoAportante() {
        return TipoAportante;
    }

    public void setTipoAportante(String tipoAportante) {
        TipoAportante = tipoAportante;
    }

    public String getRazonSocialEmpleador() {
        return RazonSocialEmpleador;
    }

    public void setRazonSocialEmpleador(String razonSocialEmpleador) {
        RazonSocialEmpleador = razonSocialEmpleador;
    }

    public String getPrimerNombreEmpleador() {
        return PrimerNombreEmpleador;
    }

    public void setPrimerNombreEmpleador(String primerNombreEmpleador) {
        PrimerNombreEmpleador = primerNombreEmpleador;
    }

    public String getPrimerApellidoEmpleador() {
        return PrimerApellidoEmpleador;
    }

    public void setPrimerApellidoEmpleador(String primerApellidoEmpleador) {
        PrimerApellidoEmpleador = primerApellidoEmpleador;
    }

    public String getCorreoEmpleador() {
        return CorreoEmpleador;
    }

    public void setCorreoEmpleador(String correoEmpleador) {
        CorreoEmpleador = correoEmpleador;
    }

    public String getActividadEconomica() {
        return ActividadEconomica;
    }

    public void setActividadEconomica(String actividadEconomica) {
        ActividadEconomica = actividadEconomica;
    }

    public String getClaseAportante() {
        return ClaseAportante;
    }

    public void setClaseAportante(String claseAportante) {
        ClaseAportante = claseAportante;
    }

    public String getTipoDocumentoRepresentante() {
        return TipoDocumentoRepresentante;
    }

    public void setTipoDocumentoRepresentante(String tipoDocumentoRepresentante) {
        TipoDocumentoRepresentante = tipoDocumentoRepresentante;
    }

    public String getNumeroDocumentoRepresentante() {
        return NumeroDocumentoRepresentante;
    }

    public void setNumeroDocumentoRepresentante(String numeroDocumentoRepresentante) {
        NumeroDocumentoRepresentante = numeroDocumentoRepresentante;
    }

    public String getPrimerNombreRepresentante() {
        return PrimerNombreRepresentante;
    }

    public void setPrimerNombreRepresentante(String primerNombreRepresentante) {
        PrimerNombreRepresentante = primerNombreRepresentante;
    }

    public String getPrimerApellidoRepresentante() {
        return PrimerApellidoRepresentante;
    }

    public void setPrimerApellidoRepresentante(String primerApellidoRepresentante) {
        PrimerApellidoRepresentante = primerApellidoRepresentante;
    }

    public LocalDateTime getFechaAfiliacion() {
        return FechaAfiliacion;
    }

    public void setFechaAfiliacion(LocalDateTime fechaAfiliacion) {
        FechaAfiliacion = fechaAfiliacion;
    }

    public String getCodigoSedeP() {
        return CodigoSedeP;
    }

    public void setCodigoSedeP(String codigoSedeP) {
        CodigoSedeP = codigoSedeP;
    }

    public String getNombreSedeP() {
        return NombreSedeP;
    }

    public void setNombreSedeP(String nombreSedeP) {
        NombreSedeP = nombreSedeP;
    }

    public String getMunicipioSedeP() {
        return MunicipioSedeP;
    }

    public void setMunicipioSedeP(String municipioSedeP) {
        MunicipioSedeP = municipioSedeP;
    }

    public String getDireccionSedeP() {
        return DireccionSedeP;
    }

    public void setDireccionSedeP(String direccionSedeP) {
        DireccionSedeP = direccionSedeP;
    }

    public String getZonaSedeP() {
        return ZonaSedeP;
    }

    public void setZonaSedeP(String zonaSedeP) {
        ZonaSedeP = zonaSedeP;
    }

    public String getTelefonoSedeP() {
        return TelefonoSedeP;
    }

    public void setTelefonoSedeP(String telefonoSedeP) {
        TelefonoSedeP = telefonoSedeP;
    }

    public String getCorreoSedeP() {
        return CorreoSedeP;
    }

    public void setCorreoSedeP(String correoSedeP) {
        CorreoSedeP = correoSedeP;
    }

    public String getTipoDocumentoResponsable() {
        return TipoDocumentoResponsable;
    }

    public void setTipoDocumentoResponsable(String tipoDocumentoResponsable) {
        TipoDocumentoResponsable = tipoDocumentoResponsable;
    }

    public String getNumeroDocumentoResponsable() {
        return NumeroDocumentoResponsable;
    }

    public void setNumeroDocumentoResponsable(String numeroDocumentoResponsable) {
        NumeroDocumentoResponsable = numeroDocumentoResponsable;
    }

    public String getPrimerNombreResponsable() {
        return PrimerNombreResponsable;
    }

    public void setPrimerNombreResponsable(String primerNombreResponsable) {
        PrimerNombreResponsable = primerNombreResponsable;
    }

    public String getPrimerApellidoResponsable() {
        return PrimerApellidoResponsable;
    }

    public void setPrimerApellidoResponsable(String primerApellidoResponsable) {
        PrimerApellidoResponsable = primerApellidoResponsable;
    }
}
