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
}
