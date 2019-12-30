package service;

import entities.ParametroGeneral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import persistence.ParametrosGeneralesRepository;

import java.math.BigDecimal;
import java.util.List;

@Component
public class ParametrosService
{
    @Autowired
    ParametrosGeneralesRepository respository;

    public void add(ParametroGeneral parametroGeneral) {this.respository.save(parametroGeneral);}
    public List<ParametroGeneral> findAllById(BigDecimal id){return (List<ParametroGeneral>) this.respository.findAllById((Iterable<Long>) id);}

    public List<ParametroGeneral> keyParameters(String key)
    {
        return this.respository.keyParameters(key);
    }

}
