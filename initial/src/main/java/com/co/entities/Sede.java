package com.co.entities;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "SRV_ESTRUCTURA_SEDE")
public class Sede
{
    public Sede() {
        this.centros = new ArrayList<>();
    }

    @Id
    @Column(name = "SRV_ESTRUCTURA_SEDE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigDecimal id;

    @Column(name = "TOKEN_MIN")
    private String tokenMin;

    @Column(name = "FECCAPTURA")
    private String fecCaptura;

    @Column(name = "FECRESPUESTA")
    private String fecRespuesta;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "SRV_ESTRUCTURA_EMPRESA_ID")
    private EstructuraEmpresa estructuraEmpresa;

    @Column(name = "COD_SEDE")
    private String codSede;

    @Column(name = "SEDE_PRINCIPAL")
    private BigDecimal sedePrincipal;

    @Column(name = "SEDE_NOMBRE")
    private String sedeNombre;

    @Column(name = "SEDE_MUNIC")
    private String sedeMunic;

    @Column(name = "SEDE_DIR")
    private String sedeDir;

    @Column(name = "SEDE_ZONA_UBI")
    private String sedeZonaUbi;

    @Column(name = "SEDE_TEL")
    private String sedeTel;

    @Column(name = "SEDE_EMAIL")
    private String sedeEmail;

    @Column(name = "TIPDOC_RESPO")
    private String tipoDocResponsable;

    @Column(name = "SEDE_NUMDOC_RESPO")
    private String sedeNumDocRespo;

    @Column(name = "SEDE_RESPO_PRIAPE")
    private String sedeResponsablePrimerApellido;

    @Column(name = "SEDE_RESPO_SEGAPE")
    private String sedeRespoSegundoApellido;

    @Column(name = "SEDE_RESPO_PRINOM")
    private String sedeRespoPrimerNombre;

    @Column(name = "SEDE_RESPO_SEGNOM")
    private String sedeRespoSegundoNombre;

    @Column(name = "SEDE_EMPRE_MISION")
    private BigDecimal sedeEmpreMision;

    @Column(name = "TIPDOC_EMPRE_MISION")
    private String tipDocEmpreMision;

    @Column(name = "NUMDOC_EMPRE_MISION")
    private String numDocEmpreMision;

    @Column(name = "EMPRE_MISION_NIT_DESCEN")
    private String empreMisionNitDescen;

    @OneToMany(mappedBy = "sede", fetch = FetchType.LAZY)
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

    public EstructuraEmpresa getEstructuraEmpresa() {
        return estructuraEmpresa;
    }

    public void setEstructuraEmpresa(EstructuraEmpresa estructuraEmpresa) {
        this.estructuraEmpresa = estructuraEmpresa;
    }

    public String getCodSede() {
        return codSede;
    }

    public void setCodSede(String codSede) {
        this.codSede = codSede;
    }

    public BigDecimal getSedePrincipal() {
        return sedePrincipal;
    }

    public void setSedePrincipal(BigDecimal sedePrincipal) {
        this.sedePrincipal = sedePrincipal;
    }

    public String getSedeNombre() {
        return sedeNombre;
    }

    public void setSedeNombre(String sedeNombre) {
        this.sedeNombre = sedeNombre;
    }

    public String getSedeMunic() {
        return sedeMunic;
    }

    public void setSedeMunic(String sedeMunic) {
        this.sedeMunic = sedeMunic;
    }

    public String getSedeDir() {
        return sedeDir;
    }

    public void setSedeDir(String sedeDir) {
        this.sedeDir = sedeDir;
    }

    public String getSedeZonaUbi() {
        return sedeZonaUbi;
    }

    public void setSedeZonaUbi(String sedeZonaUbi) {
        this.sedeZonaUbi = sedeZonaUbi;
    }

    public String getSedeTel() {
        return sedeTel;
    }

    public void setSedeTel(String sedeTel) {
        this.sedeTel = sedeTel;
    }

    public String getSedeEmail() {
        return sedeEmail;
    }

    public void setSedeEmail(String sedeEmail) {
        this.sedeEmail = sedeEmail;
    }

    public String getTipoDocResponsable() {
        return tipoDocResponsable;
    }

    public void setTipoDocResponsable(String tipoDocResponsable) {
        this.tipoDocResponsable = tipoDocResponsable;
    }

    public String getSedeNumDocRespo() {
        return sedeNumDocRespo;
    }

    public void setSedeNumDocRespo(String sedeNumDocRespo) {
        this.sedeNumDocRespo = sedeNumDocRespo;
    }

    public String getSedeResponsablePrimerApellido() {
        return sedeResponsablePrimerApellido;
    }

    public void setSedeResponsablePrimerApellido(String sedeResponsablePrimerApellido) {
        this.sedeResponsablePrimerApellido = sedeResponsablePrimerApellido;
    }

    public String getSedeRespoSegundoApellido() {
        return sedeRespoSegundoApellido;
    }

    public void setSedeRespoSegundoApellido(String sedeRespoSegundoApellido) {
        this.sedeRespoSegundoApellido = sedeRespoSegundoApellido;
    }

    public String getSedeRespoPrimerNombre() {
        return sedeRespoPrimerNombre;
    }

    public void setSedeRespoPrimerNombre(String sedeRespoPrimerNombre) {
        this.sedeRespoPrimerNombre = sedeRespoPrimerNombre;
    }

    public String getSedeRespoSegundoNombre() {
        return sedeRespoSegundoNombre;
    }

    public void setSedeRespoSegundoNombre(String sedeRespoSegundoNombre) {
        this.sedeRespoSegundoNombre = sedeRespoSegundoNombre;
    }

    public BigDecimal getSedeEmpreMision() {
        return sedeEmpreMision;
    }

    public void setSedeEmpreMision(BigDecimal sedeEmpreMision) {
        this.sedeEmpreMision = sedeEmpreMision;
    }

    public String getTipDocEmpreMision() {
        return tipDocEmpreMision;
    }

    public void setTipDocEmpreMision(String tipDocEmpreMision) {
        this.tipDocEmpreMision = tipDocEmpreMision;
    }

    public String getNumDocEmpreMision() {
        return numDocEmpreMision;
    }

    public void setNumDocEmpreMision(String numDocEmpreMision) {
        this.numDocEmpreMision = numDocEmpreMision;
    }

    public String getEmpreMisionNitDescen() {
        return empreMisionNitDescen;
    }

    public void setEmpreMisionNitDescen(String empreMisionNitDescen) {
        this.empreMisionNitDescen = empreMisionNitDescen;
    }

    public List<CentroTrabajo> getCentros() {
        return centros;
    }

    public void setCentros(List<CentroTrabajo> centros) {
        this.centros = centros;
    }

    public void addCentro(CentroTrabajo centro){

        this.centros.add(centro);
    }
}
