package com.co.entities;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "SRV_ESTRUCTURA_EMPRESA")
public class EstructuraEmpresa
{
    public EstructuraEmpresa() {
        this.sedes = new ArrayList<>();
    }

    @Id
    @Column(name = "SRV_ESTRUCTURA_EMPRESA_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigDecimal id;

    @Column(name = "TOKEN_MIN")
    private String tokenMin;

    @Column(name = "FECCAPTURA")
    private String fecCaptura;

    @Column(name = "FECRESPUESTA")
    private String fecRespuesta;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SRV_CONSULTA_EMPRESA_ID")
    private ConsultaEmpresa consultaEmpresa;

    @Column(name = "EMPRE_TIPDOC")
    private String empreTipDoc;

    @Column(name = "EMPRE_ID")
    private String empreId;

    @Column(name = "EMPRE_NIT_DESCEN")
    private String empreNitDescen;

    @Column(name = "EMPRE_TIPPERS")
    private String tipPerson;

    @Column(name = "NAT_JURIDICA")
    private String natJuridica;

    @Column(name = "TIPO_APOR")
    private String tipoAporte;

    @Column(name = "EMPRE_RAZSOC")
    private String razonSocial;

    @Column(name = "EMPRE_PERNAT_PRINOM")
    private String primerNombreEmpre;

    @Column(name = "EMPRE_PERNAT_SEGNOM")
    private String segundoNombreEmpre;

    @Column(name = "EMPRE_PERNAT_PRIAPE")
    private String primerApelidoEmpre;

    @Column(name = "EMPRE_PERNAT_SEGAPE")
    private String segundoApellidoEmpre;

    @Column(name = "EMPRE_EMAIL")
    private String empreEmail;

    @Column(name = "EMPRE_CODACT")
    private String codigoActividadEconomica;

    @Column(name = "CLASE_APOR")
    private String claseAportacion;

    @Column(name = "TIPDOC_REPRE")
    private String tipoDocRepresentante;

    @Column(name = "ID_REPRE")
    private String docRepresentante;

    @Column(name = "EMPRE_REPRE_PRIAPE")
    private String primerApellidoRepresentante;

    @Column(name = "EMPRE_REPRE_SEGAPE")
    private String segundopellidoRepresentante;

    @Column(name = "EMPRE_REPRE_PRINOM")
    private String primerNombreRepresentante;

    @Column(name = "EMPRE_REPRE_SEGNOM")
    private String segundoNombreRepresentante;

    @OneToMany(mappedBy = "estructuraEmpresa", fetch = FetchType.LAZY)
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private List<Sede> sedes;

    public List<Sede> getSedes() {
        return sedes;
    }

    public void setSedes(List<Sede> sedes) {
        this.sedes = sedes;
    }

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

    public ConsultaEmpresa getConsultaEmpresa() {
        return consultaEmpresa;
    }

    public void setConsultaEmpresa(ConsultaEmpresa consultaEmpresa) {
        this.consultaEmpresa = consultaEmpresa;
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

    public String getTipPerson() {
        return tipPerson;
    }

    public void setTipPerson(String tipPerson) {
        this.tipPerson = tipPerson;
    }

    public String getNatJuridica() {
        return natJuridica;
    }

    public void setNatJuridica(String natJuridica) {
        this.natJuridica = natJuridica;
    }

    public String getTipoAporte() {
        return tipoAporte;
    }

    public void setTipoAporte(String tipoAporte) {
        this.tipoAporte = tipoAporte;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getPrimerNombreEmpre() {
        return primerNombreEmpre;
    }

    public void setPrimerNombreEmpre(String primerNombreEmpre) {
        this.primerNombreEmpre = primerNombreEmpre;
    }

    public String getSegundoNombreEmpre() {
        return segundoNombreEmpre;
    }

    public void setSegundoNombreEmpre(String segundoNombreEmpre) {
        this.segundoNombreEmpre = segundoNombreEmpre;
    }

    public String getPrimerApelidoEmpre() {
        return primerApelidoEmpre;
    }

    public void setPrimerApelidoEmpre(String primerApelidoEmpre) {
        this.primerApelidoEmpre = primerApelidoEmpre;
    }

    public String getSegundoApellidoEmpre() {
        return segundoApellidoEmpre;
    }

    public void setSegundoApellidoEmpre(String segundoApellidoEmpre) {
        this.segundoApellidoEmpre = segundoApellidoEmpre;
    }

    public String getEmpreEmail() {
        return empreEmail;
    }

    public void setEmpreEmail(String empreEmail) {
        this.empreEmail = empreEmail;
    }

    public String getCodigoActividadEconomica() {
        return codigoActividadEconomica;
    }

    public void setCodigoActividadEconomica(String codigoActividadEconomica) {
        this.codigoActividadEconomica = codigoActividadEconomica;
    }

    public String getClaseAportacion() {
        return claseAportacion;
    }

    public void setClaseAportacion(String claseAportacion) {
        this.claseAportacion = claseAportacion;
    }

    public String getTipoDocRepresentante() {
        return tipoDocRepresentante;
    }

    public void setTipoDocRepresentante(String tipoDocRepresentante) {
        this.tipoDocRepresentante = tipoDocRepresentante;
    }

    public String getDocRepresentante() {
        return docRepresentante;
    }

    public void setDocRepresentante(String docRepresentante) {
        this.docRepresentante = docRepresentante;
    }

    public String getPrimerApellidoRepresentante() {
        return primerApellidoRepresentante;
    }

    public void setPrimerApellidoRepresentante(String primerApellidoRepresentante) {
        this.primerApellidoRepresentante = primerApellidoRepresentante;
    }

    public String getSegundopellidoRepresentante() {
        return segundopellidoRepresentante;
    }

    public void setSegundopellidoRepresentante(String segundopellidoRepresentante) {
        this.segundopellidoRepresentante = segundopellidoRepresentante;
    }

    public String getPrimerNombreRepresentante() {
        return primerNombreRepresentante;
    }

    public void setPrimerNombreRepresentante(String primerNombreRepresentante) {
        this.primerNombreRepresentante = primerNombreRepresentante;
    }

    public String getSegundoNombreRepresentante() {
        return segundoNombreRepresentante;
    }

    public void setSegundoNombreRepresentante(String segundoNombreRepresentante) {
        this.segundoNombreRepresentante = segundoNombreRepresentante;
    }

    public void addSede(Sede sede)
    {
        this.sedes.add(sede);
    }
}
