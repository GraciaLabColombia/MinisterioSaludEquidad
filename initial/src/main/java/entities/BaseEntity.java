package entities;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class BaseEntity
{
    @Column(name = "EMPRE_FORM")
    private String empreForm;

    @Column(name = "TOKEN_MIN")
    private String tokenMin;

    @Column(name = "FECCAPTURA")
    private LocalDateTime fechaCaptura;

    @Column(name = "FECREPORTE")
    private LocalDateTime  fechaReporte;

    @Column(name = "FECRESPUESTA")
    private LocalDateTime  fechaRespuesta;

    @Column(name = "ESTADO_MIN")
    private BigDecimal estadoMin;

    @Column(name = "EMPRE_TIPDOC")
    private String empreTipDoc;

    @Column(name = "EMPRE_ID")
    private String empreId;

    public String getEmpreForm() {
        return empreForm;
    }

    public void setEmpreForm(String empreForm) {
        this.empreForm = empreForm;
    }

    public String getTokenMin() {
        return tokenMin;
    }

    public void setTokenMin(String tokenMin) {
        this.tokenMin = tokenMin;
    }

    public LocalDateTime getFechaCaptura() {
        return fechaCaptura;
    }

    public void setFechaCaptura(LocalDateTime fechaCaptura) {
        this.fechaCaptura = fechaCaptura;
    }

    public LocalDateTime getFechaReporte() {
        return fechaReporte;
    }

    public void setFechaReporte(LocalDateTime fechaReporte) {
        this.fechaReporte = fechaReporte;
    }

    public LocalDateTime getFechaRespuesta() {
        return fechaRespuesta;
    }

    public void setFechaRespuesta(LocalDateTime fechaRespuesta) {
        this.fechaRespuesta = fechaRespuesta;
    }

    public BigDecimal getEstadoMin() {
        return estadoMin;
    }

    public void setEstadoMin(BigDecimal estadoMin) {
        this.estadoMin = estadoMin;
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
}
