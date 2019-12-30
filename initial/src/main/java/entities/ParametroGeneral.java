package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import java.math.BigDecimal;

@NamedQuery(name = "ParametroGeneral.keyParameters", query = "SELECT p FROM ParameroGeneral p")
@Entity(name = "SRV_PARAMETRO_GENERAL")
public class ParametroGeneral {

    @Id
    @Column(name = "SRV_PARAMETRO_GENERAL_ID")
    private BigDecimal srv_parametro_general_id;


}
