package entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "SRV_RESPUESTA_SATARL_ID")
public class SatArl
{
    @Id
    @Column(name = "SRV_RESPUESTA_SATARL_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigDecimal respuestaSatArlId;

    @Column(name = "SRV_ID")
    private BigDecimal srvId;

    @Column(name = "SRV_CONCEC")
    private String srvConcec;

    @Column(name = "EMPRE_FORM")
    private String empreForm;

    @Column(name = "TOKEN_MIN")
    private String tokenMin;

    @Column(name = "FECRESPUESTA")
    private LocalDateTime fechaRespuesta;

    @Column(name = "ESTADO_MIN")
    private BigDecimal estadoMin;

    @Column(name = "IDEEROR_MIN")
    private String idErrorMin;

    @Column(name = "ESTADO_ARL")
    private BigDecimal estadoArl;

    @Column(name = "FECCORRECCION")
    private LocalDateTime fechaCorreccion;
}
