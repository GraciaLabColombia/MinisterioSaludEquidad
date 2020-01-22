package com.co.entities;

import com.co.builder.SerializerCustom;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.math.BigDecimal;


@JsonPropertyOrder({ "TipoDocumentoEmpleador", "NumeroDocumentoEmpleador", "ConsecutivoNITEmpleador",
        "CodigoSede", "CodigoCentroTrabajo", "FechaInicioNovedad", "TipoDocumentoEmpleado",
        "NumeroDocumentoEmpleado", "PrimerNombreEmpleado", "PrimerApellidoEmpleado", "TipoCotizante", "SubTipoCotizante",
        "IBC", "TipoSalario"})
@JsonIgnoreProperties(value = { "id",
        "empreForm", "tokenMin", "fecCaptura", "fecReporte",
        "fecRespuesta", "estadoMin", "estadoMin" })
@Entity
@Table(name = "SRV_INICIO_LABORAL")
public class InicioLaboral extends BaseEntity
{
    @Id
    @Column(name = "SRV_INICIO_LABORAL_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigDecimal id;

    @Column(name = "EMPRE_FORM")
    private String empreForm;

    @Column(name = "EMPLE_FORM")
    private String empleForm;

    @Column(name = "TOKEN_MIN")
    private String tokenMin;

    @Column(name = "FECCACTURA")
    private String fecCaptura;

    @Column(name = "FECREPORTE")
    private String fecReporte;

    @Column(name = "FECRESPUESTA")
    private String fecRespuesta;

    @Column(name = "ESTADO_MIN")
    private BigDecimal estadoMin;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "EMPRE_TIPDOC")
    private String empreTipDoc;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "EMPRE_ID")
    private String empreId;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "CONSEC_DESENT")
    private BigDecimal consecDesent;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "COD_SEDE")
    private String codSede;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "COD_CENTRO")
    private String codCentro;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "FECINI_NOV")
    private String fecIniNov;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "EMPLE_TIPDOC")
    private String empleTipDoc;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "EMPLE_ID")
    private String empleId;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "EMPLE_PAPELLIDO")
    private String empleApellido;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "EMPLE_PNOMBRE")
    private String empleNombre;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "TIPO_COTIZANTE")
    private BigDecimal tipoCotizante;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "SUBTIPO_COTIZANTE")
    private BigDecimal subTipoCotizante;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "IBC")
    private BigDecimal ibc;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "TIPO_SALARIO")
    private BigDecimal tipoSalario;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getEmpreForm() {
        return empreForm;
    }

    public void setEmpreForm(String empreForm) {
        this.empreForm = empreForm;
    }

    public String getEmpleForm() {
        return empleForm;
    }

    public void setEmpleForm(String empleForm) {
        this.empleForm = empleForm;
    }

    @Override
    public String getTokenMin() {
        return tokenMin;
    }

    @Override
    public void setTokenMin(String tokenMin) {
        this.tokenMin = tokenMin;
    }

    public String getFecCaptura() {
        return fecCaptura;
    }

    public void setFecCaptura(String fecCaptura) {
        this.fecCaptura = fecCaptura;
    }

    public String getFecReporte() {
        return fecReporte;
    }

    public void setFecReporte(String fecReporte) {
        this.fecReporte = fecReporte;
    }

    public String getFecRespuesta() {
        return fecRespuesta;
    }

    public void setFecRespuesta(String fecRespuesta) {
        this.fecRespuesta = fecRespuesta;
    }

    public BigDecimal getEstadoMin_() {
        return estadoMin;
    }

    public void setEstadoMin(BigDecimal estadoMin) {
        this.estadoMin = estadoMin;
    }

    public String getEmpreTipDoc() {
        return empreTipDoc;
    }

    @JsonProperty("TipoDocumentoEmpleador")
    public void setEmpreTipDoc(String empreTipDoc) {
        this.empreTipDoc = empreTipDoc;
    }

    public String getEmpreId() {
        return empreId;
    }

    @JsonProperty("NumeroDocumentoEmpleador")
    public void setEmpreId(String empreId) {
        this.empreId = empreId;
    }

    public BigDecimal getConsecDesent() {
        return consecDesent;
    }

    @JsonProperty("ConsecutivoNITEmpleador")
    public void setConsecDesent(BigDecimal consecDesent) {
        this.consecDesent = consecDesent;
    }

    public String getCodSede() {
        return codSede;
    }

    @JsonProperty("CodigoSede")
    public void setCodSede(String codSede) {
        this.codSede = codSede;
    }

    public String getCodCentro() {
        return codCentro;
    }

    @JsonProperty("CodigoCentroTrabajo")
    public void setCodCentro(String codCentro) {
        this.codCentro = codCentro;
    }

    public String getFecIniNov() {
        return fecIniNov;
    }

    @JsonProperty("FechaInicioNovedad")
    public void setFecIniNov(String fecIniNov) {
        this.fecIniNov = fecIniNov;
    }

    public String getEmpleTipDoc() {
        return empleTipDoc;
    }

    @JsonProperty("TipoDocumentoEmpleado")
    public void setEmpleTipDoc(String empleTipDoc) {
        this.empleTipDoc = empleTipDoc;
    }

    public String getEmpleId() {
        return empleId;
    }

    @JsonProperty("NumeroDocumentoEmpleado")
    public void setEmpleId(String empleId) {
        this.empleId = empleId;
    }

    public String getEmpleApellido() {
        return empleApellido;
    }

    @JsonProperty("PrimerNombreEmpleado")
    public void setEmpleApellido(String empleApellido) {
        this.empleApellido = empleApellido;
    }

    public String getEmpleNombre() {
        return empleNombre;
    }

    @JsonProperty("PrimerApellidoEmpleado")
    public void setEmpleNombre(String empleNombre) {
        this.empleNombre = empleNombre;
    }

    public BigDecimal getTipoCotizante() {
        return tipoCotizante;
    }
    @JsonProperty("TipoCotizante")
    public void setTipoCotizante(BigDecimal tipoCotizante) {
        this.tipoCotizante = tipoCotizante;
    }

    public BigDecimal getSubTipoCotizante() {
        return subTipoCotizante;
    }

    @JsonProperty("SubTipoCotizante")
    public void setSubTipoCotizante(BigDecimal subTipoCotizante) {
        this.subTipoCotizante = subTipoCotizante;
    }

    public BigDecimal getIbc() {
        return ibc;
    }

    @JsonProperty("IBC")
    public void setIbc(BigDecimal ibc) {
        this.ibc = ibc;
    }

    public BigDecimal getTipoSalario() {
        return tipoSalario;
    }

    @JsonProperty("TipoSalario")
    public void setTipoSalario(BigDecimal tipoSalario) {
        this.tipoSalario = tipoSalario;
    }
}
