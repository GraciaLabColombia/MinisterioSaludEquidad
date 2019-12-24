package entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "SRV_INICIO_LABORAL")
public class InicioLaboral extends BaseEntity
{
    @Id
    @Column(name = "SRV_INICIO_LABORAL_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigDecimal id;

    @Column(name = "CONSEC_DESENT")
    private String consecDesent;

    @Column(name = "COD_SEDE")
    private String codSede;

    @Column(name = "COD_CENTRO")
    private String codCentro;

    @Column(name = "FECINI_NOV")
    private LocalDateTime fecIniNov;

    @Column(name = "EMPLE_TIPDOC")
    private LocalDateTime empleTipDoc;

    @Column(name = "EMPLE_ID")
    private LocalDateTime empleId;

    @Column(name = "EMPLE_PAPELLIDO")
    private LocalDateTime emprePapellido;

    @Column(name = "EMPLE_PNOMBRE")
    private LocalDateTime emprePnombre;

    @Column(name = "TIPO_COTIZANTE")
    private BigDecimal tipoCotizante;

    @Column(name = "SUBTIPO_COTIZANTE")
    private BigDecimal subTipoCotizante;

    @Column(name = "IBC")
    private BigDecimal ibc;

    @Column(name = "TIPO_SALARIO")
    private BigDecimal tipoSalario;

}
