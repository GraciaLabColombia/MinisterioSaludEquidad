package entities;

import jdk.nashorn.internal.objects.annotations.Getter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@NamedQueries({
        @NamedQuery(name = "AfiliacionEmpresa.afiliacionesPorProcesarQuery", query = "SELECT a FROM AfiliacionEmpresa a WHERE a.estadoMin IN(:estados)")})
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

    public BigDecimal getAfiliacionEmpresaId() {
        return afiliacionEmpresaId;
    }

    public void setAfiliacionEmpresaId(BigDecimal afiliacionEmpresaId) {
        this.afiliacionEmpresaId = afiliacionEmpresaId;
    }

    public String getEmpreNitDescent() {
        return empreNitDescent;
    }

    public void setEmpreNitDescent(String empreNitDescent) {
        this.empreNitDescent = empreNitDescent;
    }

    public String getEmpreTipPerson() {
        return empreTipPerson;
    }

    public void setEmpreTipPerson(String empreTipPerson) {
        this.empreTipPerson = empreTipPerson;
    }

    public String getNatJuridica() {
        return natJuridica;
    }

    public void setNatJuridica(String natJuridica) {
        this.natJuridica = natJuridica;
    }

    public String getTipoApor() {
        return tipoApor;
    }

    public void setTipoApor(String tipoApor) {
        this.tipoApor = tipoApor;
    }

    public String getEmpreRazsoc() {
        return empreRazsoc;
    }

    public void setEmpreRazsoc(String empreRazsoc) {
        this.empreRazsoc = empreRazsoc;
    }

    public String getEmprePernatPriNom() {
        return emprePernatPriNom;
    }

    public void setEmprePernatPriNom(String emprePernatPriNom) {
        this.emprePernatPriNom = emprePernatPriNom;
    }

    public String getEmprePernatPriApe() {
        return emprePernatPriApe;
    }

    public void setEmprePernatPriApe(String emprePernatPriApe) {
        this.emprePernatPriApe = emprePernatPriApe;
    }

    public String getEmpreEmail() {
        return empreEmail;
    }

    public void setEmpreEmail(String empreEmail) {
        this.empreEmail = empreEmail;
    }

    public String getEmpreCodact() {
        return empreCodact;
    }

    public void setEmpreCodact(String empreCodact) {
        this.empreCodact = empreCodact;
    }

    public String getClaseApor() {
        return claseApor;
    }

    public void setClaseApor(String claseApor) {
        this.claseApor = claseApor;
    }

    public String getTipdoc_repre() {
        return tipdoc_repre;
    }

    public void setTipdoc_repre(String tipdoc_repre) {
        this.tipdoc_repre = tipdoc_repre;
    }

    public String getIdRepre() {
        return idRepre;
    }

    public void setIdRepre(String idRepre) {
        this.idRepre = idRepre;
    }

    public String getEmpreReprePriNom() {
        return empreReprePriNom;
    }

    public void setEmpreReprePriNom(String empreReprePriNom) {
        this.empreReprePriNom = empreReprePriNom;
    }

    public String getEmpreReprePriApe() {
        return empreReprePriApe;
    }

    public void setEmpreReprePriApe(String empreReprePriApe) {
        this.empreReprePriApe = empreReprePriApe;
    }

    public LocalDateTime getFecCreaArl() {
        return fecCreaArl;
    }

    public void setFecCreaArl(LocalDateTime fecCreaArl) {
        this.fecCreaArl = fecCreaArl;
    }

    public String getEmpreCodSedePrim() {
        return empreCodSedePrim;
    }

    public void setEmpreCodSedePrim(String empreCodSedePrim) {
        this.empreCodSedePrim = empreCodSedePrim;
    }

    public String getEmpreNomSedePrim() {
        return empreNomSedePrim;
    }

    public void setEmpreNomSedePrim(String empreNomSedePrim) {
        this.empreNomSedePrim = empreNomSedePrim;
    }

    public String getEmpreMuniSedePrim() {
        return empreMuniSedePrim;
    }

    public void setEmpreMuniSedePrim(String empreMuniSedePrim) {
        this.empreMuniSedePrim = empreMuniSedePrim;
    }

    public String getEmpreDirSedePrim() {
        return empreDirSedePrim;
    }

    public void setEmpreDirSedePrim(String empreDirSedePrim) {
        this.empreDirSedePrim = empreDirSedePrim;
    }

    public String getEmpreZonaSedePrim() {
        return empreZonaSedePrim;
    }

    public void setEmpreZonaSedePrim(String empreZonaSedePrim) {
        this.empreZonaSedePrim = empreZonaSedePrim;
    }

    public String getEmpreTelSedePrim() {
        return empreTelSedePrim;
    }

    public void setEmpreTelSedePrim(String empreTelSedePrim) {
        this.empreTelSedePrim = empreTelSedePrim;
    }

    public String getEmpreEmailSedePrim() {
        return empreEmailSedePrim;
    }

    public void setEmpreEmailSedePrim(String empreEmailSedePrim) {
        this.empreEmailSedePrim = empreEmailSedePrim;
    }

    public String getTipDocRespo() {
        return tipDocRespo;
    }

    public void setTipDocRespo(String tipDocRespo) {
        this.tipDocRespo = tipDocRespo;
    }

    public String getIdRespo() {
        return idRespo;
    }

    public void setIdRespo(String idRespo) {
        this.idRespo = idRespo;
    }

    public String getRespoPriApe() {
        return respoPriApe;
    }

    public void setRespoPriApe(String respoPriApe) {
        this.respoPriApe = respoPriApe;
    }

    public String getRespoPriNom() {
        return respoPriNom;
    }

    public void setRespoPriNom(String respoPriNom) {
        this.respoPriNom = respoPriNom;
    }
}
