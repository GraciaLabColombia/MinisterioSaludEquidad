package entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "SRV_RETRACTACION")
public class Retractacion extends BaseEntity
{
    @Id
    @Column(name = "SRV_RETRACTACION_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigDecimal retractacionId;

    @Column(name = "CONSEC_DESENT")
    private String consecDesent;

    @Column(name = "TIPO_RETRACTACION")
    private String tipoRetractacion;

    @Column(name = "FECRETRACTACION")
    private LocalDateTime fechaRetractacion;
}
