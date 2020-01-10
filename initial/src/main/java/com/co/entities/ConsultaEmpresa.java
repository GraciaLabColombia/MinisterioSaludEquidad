package com.co.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "SRV_CONSULTA_EMPRESA")
public class ConsultaEmpresa
{
    @Id
    @Column(name = "SRV_CONSULTA_EMPRESA_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigDecimal afiliacionEmpresaId;

    @Column(name = "EMPRE_FORM")
    private String empreForm;

    @Column(name = "TOKEN_MIN_INI")
    private String tokenMinIni;

    @Column(name = "FEC_CAPTURA_TOKEN_INI")
    private String fecCapturaTokenIni;

    @Column(name = "FEC_RESPUESTA_TOKEN_INI")
    private String fecRespuestaTokenIni;

    @Column(name = "TIPO_REPORTE_MIN_TOKEN_INI")
    private String tipoReporteMinTokenIni;

    @Column(name = "TOKEN_MIN_FIN")
    private String tokenMinFin;

    @Column(name = "FEC_CAPTURA_TOKEN_FIN")
    private String fecCapturaTokenFin;

    @Column(name = "FEC_RESPUESTA_TOKEN_FIN")
    private String fecRespuestaTokenFin;

    @Column(name = "TIPO_REPORTE_MIN_TOKEN")
    private String tipoReporteMinTokenFin;

    @Column(name = "EMPRE_TIP_DOC")
    private String empreTipDoc;

    @Column(name = "EMPRE_ID")
    private String empreId;

    @Column(name = "EMPRE_NIT_DESCEN")
    private String empreNitDescen;

    @Column(name = "FEC_SOLICITUD")
    private String fecSolicitud;

    @Column(name = "FEC_INI_COBERTURA")
    private String fecIniCobertura;

    @Column(name = "FEC_FIN_AFILIACION")
    private String fecFinAfiliacion;

    public ConsultaEmpresa() {
    }

    public BigDecimal getAfiliacionEmpresaId() {
        return afiliacionEmpresaId;
    }

    public void setAfiliacionEmpresaId(BigDecimal afiliacionEmpresaId) {
        this.afiliacionEmpresaId = afiliacionEmpresaId;
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
        return tipoReporteMinTokenIni;
    }

    public void setTipoReporteMinTokenIni(String tipoReporteMinTokenIni) {
        this.tipoReporteMinTokenIni = tipoReporteMinTokenIni;
    }

    public String getTokenMinFin() {
        return tokenMinFin;
    }

    public void setTokenMinFin(String tokenMinFin) {
        this.tokenMinFin = tokenMinFin;
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
        return tipoReporteMinTokenFin;
    }

    public void setTipoReporteMinTokenFin(String tipoReporteMinTokenFin) {
        this.tipoReporteMinTokenFin = tipoReporteMinTokenFin;
    }

    public String getEmpreTipDoc() {
        return empreTipDoc;
    }

    public void setEmpreTipDoc(String empreTipDoc) {
        this.empreTipDoc = empreTipDoc;
    }

    public String getEmpreId() {
        return empreId;
    }

    public void setEmpreId(String empreId) {
        this.empreId = empreId;
    }

    public String getEmpreNitDescen() {
        return empreNitDescen;
    }

    public void setEmpreNitDescen(String empreNitDescen) {
        this.empreNitDescen = empreNitDescen;
    }

    public String getFecSolicitud() {
        return fecSolicitud;
    }

    public void setFecSolicitud(String fecSolicitud) {
        this.fecSolicitud = fecSolicitud;
    }

    public String getFecIniCobertura() {
        return fecIniCobertura;
    }

    public void setFecIniCobertura(String fecIniCobertura) {
        this.fecIniCobertura = fecIniCobertura;
    }

    public String getFecFinAfiliacion() {
        return fecFinAfiliacion;
    }

    public void setFecFinAfiliacion(String fecFinAfiliacion) {
        this.fecFinAfiliacion = fecFinAfiliacion;
    }
}
