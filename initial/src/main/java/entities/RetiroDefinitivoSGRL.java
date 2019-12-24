package entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "SRV_RETIRO_DEFINITIVO_SGRL")
public class RetiroDefinitivoSGRL extends BaseEntity
{
    @Id
    @Column(name = "SRV_RETIRO_DEFINITIVO_SGRL")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigDecimal id;

    @Column(name = "CONSEC_DESENT")
    private String consecDesent;

    @Column(name = "FECFIN_DEFINITIVO")
    private LocalDateTime fecFinDefinitivo;

    @Column(name = "CAUSA_RETIRO")
    private String causaRetiro;
}
