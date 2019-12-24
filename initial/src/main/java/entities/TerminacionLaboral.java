package entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "SRV_TERMINACION_LABORAL")
public class TerminacionLaboral extends BaseEntity
{
    @Id
    @Column(name = "SRV_TERMINACION_LABORAL_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigDecimal id;

    @Column(name = "CONSEC_DESENT")
    private String consecDesent;

    @Column(name = "SEDE_COD")
    private String sedeCod;

    @Column(name = "CENTRO_COD")
    private String centroCod;

    @Column(name = "FECFIN_LABORAL")
    private LocalDateTime fecIniNov;

    @Column(name = "EMPLE_TIPDOC")
    private String empleTipDoc;

    @Column(name = "EMPLE_ID")
    private String empleId;

    @Column(name = "TIPO_COTIZANTE")
    private BigDecimal tipoCotizante;

    @Column(name = "SUBTIPO_COTIZANTE")
    private BigDecimal subTipoCotizante;

}
