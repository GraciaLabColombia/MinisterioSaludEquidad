package com.co.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "SRV_NOVEDADES_SEDE")
public class NovedadesSede extends BaseEntity
{
    @Id
    @Column(name = "SRV_NOVEDADES_SEDE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigDecimal novedadesSedeId;

    @Column(name = "EMPRE_NIT_DESCENT")
    private String empreNitDescent;

    @Column(name = "EMPRE_RAZSOC")
    private String empreRazsoc;

    @Column(name = "EMPRE_PERNAT_PRINOM")
    private String emprePernatPriNom;

    @Column(name = "EMPRE_PERNAT_PRIAPE")
    private String emprePernatPriApe;

    @Column(name = "FECNOV_SEDE")
    private LocalDateTime fechaNovedadSede;

    @Column(name = "COD_SEDE")
    private String codSede;

    @Column(name = "SEDE_PRINCIPAL")
    private BigDecimal sedePrincipal;

    @Column(name = "SEDE_NOMBRE")
    private String sedeNonbre;

    @Column(name = "SEDE_MUNIC")
    private String sedeMunicipio;

    @Column(name = "SEDE_DIR")
    private String sedeDir;

    @Column(name = "SEDE_ZONA_UBI")
    private String sedeZonaUbi;

    @Column(name = "SEDE_TEL")
    private BigDecimal sedeTel;

    @Column(name = "SEDE_EMAIL")
    private String sedeEmail;

    @Column(name = "TIPDOC_RESPO")
    private String tipDocRespo;

    @Column(name = "SEDE_NUMDOC_RESPO")
    private String sedeNumDocRespo;

    @Column(name = "SEDE_RESPO_PRIAPE")
    private String sedeRespoPriApe;

    @Column(name = "SEDE_RESPO_PRINOM")
    private String sedeRespoPriNom;

    @Column(name = "INDI_ACTU")
    private String indiActu;

    @Column(name = "SEDE_EMPRE_MISION")
    private BigDecimal sedeEmpreMision;

    @Column(name = "TIPDOC_EMPRE_MISION")
    private BigDecimal tipDocEmpreMision;

    @Column(name = "NUMDOC_EMPRE_MISION")
    private BigDecimal numDocEmpreMision;

    @Column(name = "EMPRE_MISION_NIT_DESCEN")
    private BigDecimal empreMisionNitDescen;

}
