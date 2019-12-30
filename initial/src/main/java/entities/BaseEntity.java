package entities;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class BaseEntity
{
    @Column(name = "EMPRE_FORM")
    private transient String empre_form;

    @Column(name = "TOKEN_MIN")
    private transient String tokenMin;

    @Column(name = "FECCAPTURA")
    private transient LocalDateTime fechaCaptura;

    @Column(name = "FECREPORTE")
    private transient LocalDateTime  fechaReporte;

    @Column(name = "FECRESPUESTA")
    private transient LocalDateTime  fechaRespuesta;

    @Column(name = "ESTADO_MIN")
    private transient BigDecimal estadoMin;

    @Column(name = "EMPRE_TIPDOC")
    private String TipoDocumentoEmpleador;

    @Column(name = "EMPRE_ID")
    private String NumeroDocumentoEmpleador;

    public String getEmpre_form() {
        return empre_form;
    }

    public void setEmpre_form(String empre_form) {
        this.empre_form = empre_form;
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

    public String getTipoDocumentoEmpleador() {
        return TipoDocumentoEmpleador;
    }

    public void setTipoDocumentoEmpleador(String tipoDocumentoEmpleador) {
        TipoDocumentoEmpleador = tipoDocumentoEmpleador;
    }

    public String getNumeroDocumentoEmpleador() {
        return NumeroDocumentoEmpleador;
    }

    public void setNumeroDocumentoEmpleador(String numeroDocumentoEmpleador) {
        NumeroDocumentoEmpleador = numeroDocumentoEmpleador;
    }
}
