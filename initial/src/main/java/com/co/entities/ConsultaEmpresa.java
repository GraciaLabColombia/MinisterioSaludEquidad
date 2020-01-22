package com.co.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;
import java.math.BigDecimal;

@JsonPropertyOrder({  "tipoDocumentoEmpleador", "numeroDocumentoEmpleador",
        "consecutivoNITEmpleador"})
@JsonIgnoreProperties(value = { "id",
        "empreForm", "tokenMinIni", "fecCapturaTokenIni", "fecRespuestaTokenIni",
        "tipoReporte", "tokenMinFin", "fecCapturaTokenFin", "fecRespuestaTokenFin", "tipoReporteTokenFin",
        "fechaSolicitud", "fecIniCobertura", "fechaFinAfiliacion"})
@Entity
@Table(name = "SRV_CONSULTA_EMPRESA")
public class ConsultaEmpresa
{
    @Id
    @Column(name = "SRV_CONSULTA_EMPRESA_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigDecimal id;

    @Column(name = "EMPRE_FORM")
    private String empreForm;

    @Column(name = "TOKEN_MIN_INI")
    private String tokenMinIni;

    @Column(name = "FEC_CAPTURA_TOKEN_INI")
    private String fecCapturaTokenIni;

    @Column(name = "FEC_RESPUESTA_TOKEN_INI")
    private String fecRespuestaTokenIni;

    @Column(name = "TIPO_REPORTE_MIN_TOKEN_INI")
    private String tipoReporte;

    @Column(name = "TOKEN_MIN_FIN")
    private String tokenMinFin;

    @Column(name = "FEC_CAPTURA_TOKEN_FIN")
    private String fecCapturaTokenFin;

    @Column(name = "FEC_RESPUESTA_TOKEN_FIN")
    private String fecRespuestaTokenFin;

    @Column(name = "TIPO_REPORTE_TOKEN_FIN")
    private String tipoReporteTokenFin;

    @Column(name = "EMPRE_TIP_DOC")
    private String tipoDocumentoEmpleador;

    @Column(name = "EMPRE_ID")
    private String numeroDocumentoEmpleador;

    @Column(name = "EMPRE_NIT_DESCEN")
    private String consecutivoNitDescentralizado;

    @Column(name = "FEC_SOLICITUD")
    private String fechaSolicitud;

    @Column(name = "FEC_INI_COBERTURA")
    private String fecIniCobertura;

    @Column(name = "FEC_FIN_AFILIACION")
    private String fechaFinAfiliacion;

    public ConsultaEmpresa() {
    }

    public BigDecimal getAfiliacionEmpresaId() {
        return id;
    }

    public void setAfiliacionEmpresaId(BigDecimal afiliacionEmpresaId) {
        this.id = afiliacionEmpresaId;
    }

    public String getEmpreForm() {
        return empreForm;
    }

    public void setEmpreForm(String empreForm) {
        this.empreForm = empreForm;
    }

    public String getTokenMinIni() {
        return tokenMinIni;
    }

    public void setTokenMinIni(String tokenMinIni) {
        this.tokenMinIni = tokenMinIni;
    }

    public String getFecCapturaTokenIni() {
        return fecCapturaTokenIni;
    }

    public void setFecCapturaTokenIni(String fecCapturaTokenIni) {
        this.fecCapturaTokenIni = fecCapturaTokenIni;
    }

    public String getFecRespuestaTokenIni() {
        return fecRespuestaTokenIni;
    }

    public void setFecRespuestaTokenIni(String fecRespuestaTokenIni) {
        this.fecRespuestaTokenIni = fecRespuestaTokenIni;
    }

    public String getTipoReporteMinTokenIni() {
        return tipoReporte;
    }

    public void setTipoReporteMinTokenIni(String tipoReporteMinTokenIni) {
        this.tipoReporte = tipoReporteMinTokenIni;
    }

    public String getTokenMinFin() {
        return tokenMinFin;
    }

    public void setTokenMinFin(String tokenMinFin) {
        this.tokenMinFin = tokenMinFin;
    }

    public String getTipoReporte() {
        return tipoReporte;
    }

    public void setTipoReporte(String tipoReporte) {
        this.tipoReporte = tipoReporte;
    }

    public String getTipoReporteTokenFin() {
        return tipoReporteTokenFin;
    }

    public void setTipoReporteTokenFin(String tipoReporteTokenFin) {
        this.tipoReporteTokenFin = tipoReporteTokenFin;
    }

    public String getFecCapturaTokenFin() {
        return fecCapturaTokenFin;
    }

    public void setFecCapturaTokenFin(String fecCapturaTokenFin) {
        this.fecCapturaTokenFin = fecCapturaTokenFin;
    }

    public String getFecRespuestaTokenFin() {
        return fecRespuestaTokenFin;
    }

    public void setFecRespuestaTokenFin(String fecRespuestaTokenFin) {
        this.fecRespuestaTokenFin = fecRespuestaTokenFin;
    }

    public String getTipoReporteMinTokenFin() {
        return tipoReporte;
    }

    public void setTipoReporteMinTokenFin(String tipoReporteMinTokenFin) {
        this.tipoReporte = tipoReporteMinTokenFin;
    }

    public String getTipoDocumentoEmpleador() {
        return tipoDocumentoEmpleador;
    }

    @JsonProperty("TipoDocumentoEmpleador")
    public void setTipoDocumentoEmpleador(String tipoDocumentoEmpleador) {
        this.tipoDocumentoEmpleador = tipoDocumentoEmpleador;
    }

    public String getNumeroDocumentoEmpleador() {
        return numeroDocumentoEmpleador;
    }

    @JsonProperty("NumeroDocumentoEmpleador")
    public void setNumeroDocumentoEmpleador(String numeroDocumentoEmpleador) {
        this.numeroDocumentoEmpleador = numeroDocumentoEmpleador;
    }

    public String getConsecutivoNitDescentralizado() {
        return consecutivoNitDescentralizado;
    }

    @JsonProperty("ConsecutivoNitDescentralizado")
    public void setConsecutivoNitDescentralizado(String consecutivoNitDescentralizado) {
        this.consecutivoNitDescentralizado = consecutivoNitDescentralizado;
    }

    public String getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(String fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getFecIniCobertura() {
        return fecIniCobertura;
    }

    public void setFecIniCobertura(String fecIniCobertura) {
        this.fecIniCobertura = fecIniCobertura;
    }

    public String getFechaFinAfiliacion() {
        return fechaFinAfiliacion;
    }

    public void setFechaFinAfiliacion(String fechaFinAfiliacion) {
        this.fechaFinAfiliacion = fechaFinAfiliacion;
    }

    @Override
    public String toString() {
        return "ConsultaEmpresa{" +
                "id=" + id +
                ", empreForm='" + empreForm + '\'' +
                ", tokenMinIni='" + tokenMinIni + '\'' +
                ", fecCapturaTokenIni='" + fecCapturaTokenIni + '\'' +
                ", fecRespuestaTokenIni='" + fecRespuestaTokenIni + '\'' +
                ", tipoReporte='" + tipoReporte + '\'' +
                ", tokenMinFin='" + tokenMinFin + '\'' +
                ", fecCapturaTokenFin='" + fecCapturaTokenFin + '\'' +
                ", fecRespuestaTokenFin='" + fecRespuestaTokenFin + '\'' +
                ", tipoReporteTokenFin='" + tipoReporteTokenFin + '\'' +
                ", tipoDocumentoEmpleador='" + tipoDocumentoEmpleador + '\'' +
                ", numeroDocumentoEmpleador='" + numeroDocumentoEmpleador + '\'' +
                ", consecutivoNitDescentralizado='" + consecutivoNitDescentralizado + '\'' +
                ", fechaSolicitud='" + fechaSolicitud + '\'' +
                ", fecIniCobertura='" + fecIniCobertura + '\'' +
                ", fechaFinAfiliacion='" + fechaFinAfiliacion + '\'' +
                '}';
    }
}
