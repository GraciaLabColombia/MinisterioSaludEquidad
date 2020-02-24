package com.co.entities;

import com.co.builder.SedesCustomSerializer;
import com.co.builder.SerializerCustom;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;

@JsonIgnoreProperties(value = { "id",
        "empre_form", "tokenMin", "fechaCaptura", "fechaReporte",
        "fechaRespuesta", "estructuraEmpresa", "centros", "centrosTrabajo", "estadoMin", "naturalezaJuridica", "tipoAportante", "actividadEconomica" })
@Entity
@Table(name = "SRV_ESTRUCTURA_SEDE")
public class Sede {
    public Sede() {
        this.centros = new ArrayList<>();
    }

    @Id
    @Column(name = "SRV_ESTRUCTURA_SEDE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigDecimal id;

    @Column(name = "TOKEN_MIN")
    private String tokenMin;

    @Column(name = "FECCAPTURA")
    private LocalDateTime fecCaptura;

    @Column(name = "FECRESPUESTA")
    private LocalDateTime fecRespuesta;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SRV_ESTRUCTURA_EMPRESA_ID")
    private EstructuraEmpresa estructuraEmpresa;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "COD_SEDE")
    private String codSede;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "SEDE_PRINCIPAL")
    private String sedePrincipal;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "SEDE_NOMBRE")
    private String sedeNombre;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "SEDE_MUNIC")
    private String sedeMunic;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "SEDE_DIR")
    private String sedeDir;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "SEDE_ZONA_UBI")
    private String sedeZonaUbi;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "SEDE_TEL")
    private String sedeTel;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "SEDE_EMAIL")
    private String sedeEmail;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "TIPDOC_RESPO")
    private String tipoDocResponsable;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "SEDE_NUMDOC_RESPO")
    private String sedeNumDocRespo;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "SEDE_RESPO_PRIAPE")
    private String sedeResponsablePrimerApellido;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "SEDE_RESPO_SEGAPE")
    private String sedeRespoSegundoApellido;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "SEDE_RESPO_PRINOM")
    private String sedeRespoPrimerNombre;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "SEDE_RESPO_SEGNOM")
    private String sedeRespoSegundoNombre;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "SEDE_EMPRE_MISION")
    private String sedeEmpreMision;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "TIPDOC_EMPRE_MISION")
    private String tipDocEmpreMision;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "NUMDOC_EMPRE_MISION")
    private String numDocEmpreMision;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "EMPRE_MISION_NIT_DESCEN")
    private String empreMisionNitDescen;

    @OneToMany(cascade = {PERSIST, MERGE, REMOVE}, mappedBy = "sede", fetch = FetchType.LAZY)
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    List<CentroTrabajo> centros;

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

    public LocalDateTime getFecCaptura() {
        return fecCaptura;
    }

    public void setFecCaptura(LocalDateTime fecCaptura) {
        this.fecCaptura = fecCaptura;
    }

    public LocalDateTime getFecRespuesta() {
        return fecRespuesta;
    }

    public void setFecRespuesta(LocalDateTime fecRespuesta) {
        this.fecRespuesta = fecRespuesta;
    }

    public EstructuraEmpresa getEstructuraEmpresa() {
        return estructuraEmpresa;
    }

    public void setEstructuraEmpresa(EstructuraEmpresa estructuraEmpresa) {
        this.estructuraEmpresa = estructuraEmpresa;
    }

    public String getCodSede() {
        return codSede;
    }

    @JsonProperty("codigoSede")
    public void setCodSede(String codSede) {
        this.codSede = codSede;
    }

    public String getSedePrincipal() {
        return sedePrincipal;
    }

    @JsonProperty("sedePrincipal")
    public void setSedePrincipal(String sedePrincipal) {
        this.sedePrincipal = sedePrincipal.toLowerCase().equals("true") ? "1" : "0";
    }

    public String getSedeNombre() {
        return sedeNombre;
    }

    @JsonProperty("nombreSede")
    public void setSedeNombre(String sedeNombre) {
        this.sedeNombre = sedeNombre;
    }

    public String getSedeMunic() {
        return sedeMunic;
    }

    @JsonProperty("municipioSede")
    public void setSedeMunic(String sedeMunic) {
        this.sedeMunic = sedeMunic;
    }

    public String getSedeDir() {
        return sedeDir;
    }

    @JsonProperty("direccionSede")
    public void setSedeDir(String sedeDir) {
        this.sedeDir = sedeDir;
    }

    public String getSedeZonaUbi() {
        return sedeZonaUbi;
    }

    @JsonProperty("zonaUbicacionSede")
    public void setSedeZonaUbi(String sedeZonaUbi) {
        this.sedeZonaUbi = sedeZonaUbi;
    }

    public String getSedeTel() {
        return sedeTel;
    }

    @JsonProperty("telefonoSede")
    public void setSedeTel(String sedeTel) {
        this.sedeTel = sedeTel;
    }

    public String getSedeEmail() {
        return sedeEmail;
    }

    @JsonProperty("correoSede")
    public void setSedeEmail(String sedeEmail) {
        this.sedeEmail = sedeEmail;
    }

    public String getTipoDocResponsable() {
        return tipoDocResponsable;
    }

    @JsonProperty("tipoDocumentoResponsable")
    public void setTipoDocResponsable(String tipoDocResponsable) {
        this.tipoDocResponsable = tipoDocResponsable;
    }

    public String getSedeNumDocRespo() {
        return sedeNumDocRespo;
    }

    @JsonProperty("numeroDocumentoResponsable")
    public void setSedeNumDocRespo(String sedeNumDocRespo) {
        this.sedeNumDocRespo = sedeNumDocRespo;
    }

    public String getSedeResponsablePrimerApellido() {
        return sedeResponsablePrimerApellido;
    }

    @JsonProperty("primerApellidoResponsable")
    public void setSedeResponsablePrimerApellido(String sedeResponsablePrimerApellido) {
        this.sedeResponsablePrimerApellido = sedeResponsablePrimerApellido;
    }

    public String getSedeRespoSegundoApellido() {
        return sedeRespoSegundoApellido;
    }

    @JsonProperty("segundoApellidoResponsable")
    public void setSedeRespoSegundoApellido(String sedeRespoSegundoApellido) {
        this.sedeRespoSegundoApellido = sedeRespoSegundoApellido;
    }

    public String getSedeRespoPrimerNombre() {
        return sedeRespoPrimerNombre;
    }

    @JsonProperty("primerNombreResponsable")
    public void setSedeRespoPrimerNombre(String sedeRespoPrimerNombre) {
        this.sedeRespoPrimerNombre = sedeRespoPrimerNombre;
    }

    public String getSedeRespoSegundoNombre() {
        return sedeRespoSegundoNombre;
    }

    @JsonProperty("segundoNombreResponsable")
    public void setSedeRespoSegundoNombre(String sedeRespoSegundoNombre) {
        this.sedeRespoSegundoNombre = sedeRespoSegundoNombre;
    }

    public String getSedeEmpreMision() {
        return sedeEmpreMision;
    }

    @JsonProperty("sedeEmpleadorMision")
    public void setSedeEmpreMision(String sedeEmpreMision) {
        this.sedeEmpreMision = sedeEmpreMision.toLowerCase().equals("true") ? "1" : "0";
    }

    public String getTipDocEmpreMision() {
        return tipDocEmpreMision;
    }

    @JsonProperty("tipoDocumentoEmpleadorMision")
    public void setTipDocEmpreMision(String tipDocEmpreMision) {
        this.tipDocEmpreMision = tipDocEmpreMision;
    }

    public String getNumDocEmpreMision() {
        return numDocEmpreMision;
    }

    @JsonProperty("numeroDocumentoEmpleadorMision")
    public void setNumDocEmpreMision(String numDocEmpreMision) {
        this.numDocEmpreMision = numDocEmpreMision;
    }

    public String getEmpreMisionNitDescen() {
        return empreMisionNitDescen;
    }

    @JsonProperty("consecutivoNITEmpleadorMision")
    public void setEmpreMisionNitDescen(String empreMisionNitDescen) {
        this.empreMisionNitDescen = empreMisionNitDescen;
    }

    public List<CentroTrabajo> getCentros() {
        return centros;
    }

    @JsonProperty("centrosTrabajo")
    public void setCentros(List<CentroTrabajo> centros) {
        this.centros = centros;
    }

    public void addCentro(CentroTrabajo centro){

        this.centros.add(centro);
    }

}
