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
import java.util.concurrent.atomic.AtomicInteger;

import static javax.persistence.CascadeType.*;

@JsonIgnoreProperties(value = { "id",
        "empre_form", "tokenMin", "fechaCaptura", "fechaReporte",
        "fechaRespuesta", "consultaEmpresa", "sedes", "estadoMin", "tipoAportante", "actividadEconomica", "afiliacionEmpresaId" })
@Entity
@Table(name = "SRV_ESTRUCTURA_EMPRESA")
public class EstructuraEmpresa
{
    public EstructuraEmpresa() {
        this.sedes = new ArrayList<>();
    }

    @Id
    @Column(name = "SRV_ESTRUCTURA_EMPRESA_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigDecimal id;

    @Column(name = "TOKEN_MIN")
    private String tokenMin;

    @Column(name = "FECCAPTURA")
    private String fecCaptura;

    @Column(name = "FECRESPUESTA")
    private String fecRespuesta;

    @ManyToOne(cascade = MERGE)
    @JoinColumn(name = "SRV_CONSULTA_EMPRESA_ID")
    private ConsultaEmpresa consultaEmpresa;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "EMPRE_TIPDOC")
    private String empreTipDoc;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "EMPRE_ID")
    private String empreId;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "EMPRE_NIT_DESCEN")
    private String empreNitDescen;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "EMPRE_TIPPERS")
    private String tipPerson;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "NAT_JURIDICA")
    private BigDecimal natJuridica;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "TIPO_APOR")
    private String tipoAporte;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "EMPRE_RAZSOC")
    private String razonSocial;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "EMPRE_PERNAT_PRINOM")
    private String primerNombreEmpre;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "EMPRE_PERNAT_SEGNOM")
    private String segundoNombreEmpre;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "EMPRE_PERNAT_PRIAPE")
    private String primerApelidoEmpre;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "EMPRE_PERNAT_SEGAPE")
    private String segundoApellidoEmpre;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "EMPRE_EMAIL")
    private String empreEmail;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "EMPRE_CODACT")
    private String codigoActividadEconomica;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "CLASE_APOR")
    private String claseAportacion;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "TIPDOC_REPRE")
    private String tipoDocRepresentante;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "ID_REPRE")
    private String docRepresentante;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "EMPRE_REPRE_PRIAPE")
    private String primerApellidoRepresentante;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "EMPRE_REPRE_SEGAPE")
    private String segundopellidoRepresentante;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "EMPRE_REPRE_PRINOM")
    private String primerNombreRepresentante;

    @JsonSerialize(using = SerializerCustom.class)
    @Column(name = "EMPRE_REPRE_SEGNOM")
    private String segundoNombreRepresentante;

    @OneToMany(cascade = {PERSIST, MERGE, REMOVE}, mappedBy = "estructuraEmpresa", fetch = FetchType.LAZY)
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private List<Sede> sedes;

    public List<Sede> getSedes() {
        return sedes;
    }

    @JsonProperty("sedes")
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

    @JsonProperty("tipoDocumentoEmpleador")
    public void setEmpreTipDoc(String empreTipDoc) {
        this.empreTipDoc = empreTipDoc;
    }

    public String getEmpreId() {
        return empreId;
    }

    @JsonProperty("numeroDocumentoEmpleador")
    public void setEmpreId(String empreId) {
        this.empreId = empreId;
    }

    public String getEmpreNitDescen() {
        return empreNitDescen;
    }

    @JsonProperty("consecutivoNITDescentralizado")
    public void setEmpreNitDescen(String empreNitDescen) {
        this.empreNitDescen = empreNitDescen;
    }

    public String getTipPerson() {
        return tipPerson;
    }

    @JsonProperty("tipoPersona")
    public void setTipPerson(String tipPerson) {
        this.tipPerson = tipPerson;
    }

    public BigDecimal getNatJuridica() {
        return natJuridica;
    }

    @JsonProperty("naturalezaJuridica")
    public void setNatJuridica(BigDecimal natJuridica) {
        this.natJuridica = natJuridica;
    }

    public String getTipoAporte() {
        return tipoAporte;
    }

    @JsonProperty("tipoAportante")
    public void setTipoAporte(String tipoAporte) {
        this.tipoAporte = tipoAporte;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    @JsonProperty("razonSocial")
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getPrimerNombreEmpre() {
        return primerNombreEmpre;
    }

    @JsonProperty("primerNombrePersonaNatural")
    public void setPrimerNombreEmpre(String primerNombreEmpre) {
        this.primerNombreEmpre = primerNombreEmpre;
    }

    public String getSegundoNombreEmpre() {
        return segundoNombreEmpre;
    }

    @JsonProperty("segundoNombrePersonaNatural")
    public void setSegundoNombreEmpre(String segundoNombreEmpre) {
        this.segundoNombreEmpre = segundoNombreEmpre;
    }

    public String getPrimerApelidoEmpre() {
        return primerApelidoEmpre;
    }

    @JsonProperty("primerApellidoPersonaNatural")
    public void setPrimerApelidoEmpre(String primerApelidoEmpre) {
        this.primerApelidoEmpre = primerApelidoEmpre;
    }

    public String getSegundoApellidoEmpre() {
        return segundoApellidoEmpre;
    }

    @JsonProperty("segundoApellidoPersonaNatural")
    public void setSegundoApellidoEmpre(String segundoApellidoEmpre) {
        this.segundoApellidoEmpre = segundoApellidoEmpre;
    }

    public String getEmpreEmail() {
        return empreEmail;
    }

    @JsonProperty("correoElectronico")
    public void setEmpreEmail(String empreEmail) {
        this.empreEmail = empreEmail;
    }

    public String getCodigoActividadEconomica() {
        return codigoActividadEconomica;
    }

    @JsonProperty("codigoActividadEconomica")
    public void setCodigoActividadEconomica(String codigoActividadEconomica) {
        this.codigoActividadEconomica = codigoActividadEconomica;
    }

    public String getClaseAportacion() {
        return claseAportacion;
    }

    @JsonProperty("claseAportante")
    public void setClaseAportacion(String claseAportacion) {
        this.claseAportacion = claseAportacion;
    }

    public String getTipoDocRepresentante() {
        return tipoDocRepresentante;
    }

    @JsonProperty("tipoDocumentoRepresentante")
    public void setTipoDocRepresentante(String tipoDocRepresentante) {
        this.tipoDocRepresentante = tipoDocRepresentante;
    }

    public String getDocRepresentante() {
        return docRepresentante;
    }

    @JsonProperty("numeroDocumentoRepresentante")
    public void setDocRepresentante(String docRepresentante) {
        this.docRepresentante = docRepresentante;
    }

    public String getPrimerApellidoRepresentante() {
        return primerApellidoRepresentante;
    }

    @JsonProperty("primerApellidoRepresentante")
    public void setPrimerApellidoRepresentante(String primerApellidoRepresentante) {
        this.primerApellidoRepresentante = primerApellidoRepresentante;
    }

    public String getSegundopellidoRepresentante() {
        return segundopellidoRepresentante;
    }

    @JsonProperty("segundoApellidoRepresentante")
    public void setSegundopellidoRepresentante(String segundopellidoRepresentante) {
        this.segundopellidoRepresentante = segundopellidoRepresentante;
    }

    public String getPrimerNombreRepresentante() {
        return primerNombreRepresentante;
    }

    @JsonProperty("primerNombreRepresentante")
    public void setPrimerNombreRepresentante(String primerNombreRepresentante) {
        this.primerNombreRepresentante = primerNombreRepresentante;
    }

    public String getSegundoNombreRepresentante() {
        return segundoNombreRepresentante;
    }

    @JsonProperty("segundoNombreRepresentante")
    public void setSegundoNombreRepresentante(String segundoNombreRepresentante) {
        this.segundoNombreRepresentante = segundoNombreRepresentante;
    }



    public void addSede(Sede sede)
    {
        this.sedes.add(sede);
    }

    public int sedes() {
        return this.getSedes() == null ? 0 : this.getSedes().size();
    }

    public int centros() {
        AtomicInteger i = new AtomicInteger();
        if (this.getSedes() != null) {
            this.getSedes().stream().filter(p -> p.centros != null).forEach(sede -> {
                sede.getCentros().forEach(c -> i.getAndIncrement());
            });
        }
        return i.get();
    }

    public int empleados() {
        AtomicInteger i = new AtomicInteger();
        if (this.getSedes() != null) {
            this.getSedes().stream().filter(p -> p.centros != null).forEach(sede -> {
                sede.getCentros().stream().filter(c -> c.getEmpleados() != null).forEach(centroTrabajo -> {
                    centroTrabajo.getEmpleados().forEach(e -> i.getAndIncrement());
                });
            });
        }
        return i.get();
    }

    @Override
    public String toString() {
        return "EstructuraEmpresa{" +
                "id=" + id +
                ", tokenMin='" + tokenMin + '\'' +
                ", fecCaptura='" + fecCaptura + '\'' +
                ", fecRespuesta='" + fecRespuesta + '\'' +
                ", consultaEmpresa=" + consultaEmpresa +
                ", empreTipDoc='" + empreTipDoc + '\'' +
                ", empreId='" + empreId + '\'' +
                ", empreNitDescen='" + empreNitDescen + '\'' +
                ", tipPerson='" + tipPerson + '\'' +
                ", natJuridica='" + natJuridica + '\'' +
                ", tipoAporte='" + tipoAporte + '\'' +
                ", razonSocial='" + razonSocial + '\'' +
                ", primerNombreEmpre='" + primerNombreEmpre + '\'' +
                ", segundoNombreEmpre='" + segundoNombreEmpre + '\'' +
                ", primerApelidoEmpre='" + primerApelidoEmpre + '\'' +
                ", segundoApellidoEmpre='" + segundoApellidoEmpre + '\'' +
                ", empreEmail='" + empreEmail + '\'' +
                ", codigoActividadEconomica='" + codigoActividadEconomica + '\'' +
                ", claseAportacion='" + claseAportacion + '\'' +
                ", tipoDocRepresentante='" + tipoDocRepresentante + '\'' +
                ", docRepresentante='" + docRepresentante + '\'' +
                ", primerApellidoRepresentante='" + primerApellidoRepresentante + '\'' +
                ", segundopellidoRepresentante='" + segundopellidoRepresentante + '\'' +
                ", primerNombreRepresentante='" + primerNombreRepresentante + '\'' +
                ", segundoNombreRepresentante='" + segundoNombreRepresentante + '\'' +
                ", sedes=" + sedes +
                '}';
    }
}
