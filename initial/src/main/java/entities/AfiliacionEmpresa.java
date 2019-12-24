package entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "SRV_AFILIACION_EMPRESA")
public class AfiliacionEmpresa extends BaseEntity
{
    @Id
    @Column(name = "SRV_AFILIACION_EMPRESA_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigDecimal afiliacionEmpresaId;

    @Column(name = "EMPRE_NIT_DESCENT")
    private String empreNitDescent;

    @Column(name = "EMPRE_TIPPERS")
    private String empreTipPerson;

    @Column(name = "NAT_JURIDICA")
    private String natJuridica;

    @Column(name = "TIPO_APORT")
    private String tipoApor;

    @Column(name = "EMPRE_RAZSOC")
    private String empreRazsoc;

    @Column(name = "EMPRE_PERNAT_PRINOM")
    private String emprePernatPriNom;

    @Column(name = "EMPRE_PERNAT_PRIAPE")
    private String emprePernatPriApe;

    @Column(name = "EMPRE_EMAIL")
    private String empreEmail;

    @Column(name = "EMPRE_CODACT")
    private String empreCodact;

    @Column(name = "CLASE_APOR")
    private String claseApor;

    @Column(name = "TIPDOC_REPRE")
    private String tipdoc_repre;

    @Column(name = "ID_REPRE")
    private String idRepre;

    @Column(name = "EMPRE_REPRE_PRINOM")
    private String empreReprePriNom;

    @Column(name = "EMPRE_REPRE_PRIAPE")
    private String empreReprePriApe;

    @Column(name = "FECCREAARL")
    private LocalDateTime fecCreaArl;

    @Column(name = "EMPRE_COD_SEDEPRIM")
    private String empreCodSedePrim;

    @Column(name = "EMPRE_NOM_SEDEPRIM")
    private String empreNomSedePrim;

    @Column(name = "EMPRE_MUNI_SEDEPRIM")
    private String empreMuniSedePrim;

    @Column(name = "EMPRE_DIR_SEDEPRIM")
    private String empreDirSedePrim;

    @Column(name = "EMPRE_ZONA_SEDEPRIM")
    private String empreZonaSedePrim;

    @Column(name = "EMPRE_TEL_SEDEPRIM")
    private String empreTelSedePrim;

    @Column(name = "EMPRE_EMAIL_SEDEPRIM")
    private String empreEmailSedePrim;

    @Column(name = "TIPDOC_RESPO")
    private String tipDocRespo;

    @Column(name = "ID_RESPO")
    private String idRespo;

    @Column(name = "RESPO_PRIAPE")
    private String respoPriApe;

    @Column(name = "RESPO_PRINOM")
    private String respoPriNom;

}
