package com.co.entities;

import com.co.builder.SerializerCustom;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.math.BigDecimal;

@JsonPropertyOrder({ "TipoDocumentoEmpleador", "NumeroDocumentoEmpleador",
        "ConsecutivoNITEmpleador", "CodigoSede", "CodigoCentroTrabajo", "NombreCentroTrabajo",
        "CodigoActividadEconomicaAnterior", "CodigoActividadEconomicaNueva", "SolicitanteReclasificacion"})
@JsonIgnoreProperties(value = { "id", "empre_form", "tokenMin", "fechaCaptura", "fechaReporte",
        "fechaRespuesta", "estadoMin" })
@Entity
@Table(name = "SRV_RECL_CENTRO_TRABAJO")
public class ReclasificacionCentroTrabajo
{
    @Id
    @Column(name = "SRV_RECL_CENTRO_TRABAJO_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigDecimal id;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "EMPLE_TIPDOC")
    private String empleTipdoc;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "EMPLE_ID")
    private String empleid;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "CONSEC_DESENT")
    private BigDecimal consecDesent;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "SEDE_COD")
    private String sedeCod;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "CENTRO_COD")
    private String codCentro;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "COD_ANTE_ACTIVIDAD")
    private BigDecimal codAnteactividad;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "COD_NUEVA_ACTIVIDAD")
    private BigDecimal codNuevaactividad;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "SOLICITANTE_RECLASIF")
    private BigDecimal solicitanteReClasif;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getEmpleTipdoc() {
        return empleTipdoc;
    }

    @JsonProperty("TipoDocumentoEmpleador")
    public void setEmpleTipdoc(String empleTipdoc) {
        this.empleTipdoc = empleTipdoc;
    }

    public String getEmpleid() {
        return empleid;
    }
    @JsonProperty("NumeroDocumentoEmpleador")
    public void setEmpleid(String empleid) {
        this.empleid = empleid;
    }

    public BigDecimal getConsecDesent() {
        return consecDesent;
    }

    @JsonProperty("ConsecutivoNITEmpleador")
    public void setConsecDesent(BigDecimal consecDesent) {
        this.consecDesent = consecDesent;
    }

    public String getSedeCod() {
        return sedeCod;
    }

    @JsonProperty("CodigoSede")
    public void setSedeCod(String sedeCod) {
        this.sedeCod = sedeCod;
    }

    public String getCodCentro() {
        return codCentro;
    }

    @JsonProperty("NombreCentroTrabajo")
    public void setCodCentro(String codCentro) {
        this.codCentro = codCentro;
    }

    public BigDecimal getCodAnteactividad() {
        return codAnteactividad;
    }

    @JsonProperty("CodigoActividadEconomicaAnterior")
    public void setCodAnteactividad(BigDecimal codAnteactividad) {
        this.codAnteactividad = codAnteactividad;
    }

    public BigDecimal getCodNuevaactividad() {
        return codNuevaactividad;
    }

    @JsonProperty("CodigoActividadEconomicaNueva")
    public void setCodNuevaactividad(BigDecimal codNuevaactividad) {
        this.codNuevaactividad = codNuevaactividad;
    }

    public BigDecimal getSolicitanteReClasif() {
        return solicitanteReClasif;
    }

    @JsonProperty("CodigoActividadEconomicaAnterior")
    public void setSolicitanteReClasif(BigDecimal solicitanteReClasif) {
        this.solicitanteReClasif = solicitanteReClasif;
    }
}
