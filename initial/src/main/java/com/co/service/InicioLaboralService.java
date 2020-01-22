package com.co.service;

import com.co.entities.InicioLaboral;
import com.co.exception.MinSaludBusinessException;
import com.co.persistence.InicioLaboralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Component
@Service
public class InicioLaboralService
{
    @Autowired
    private InicioLaboralRepository inicioLaboralRepository;

    public List<InicioLaboral> getIniciosLaborales(BigDecimal... estados) throws MinSaludBusinessException {
        List<InicioLaboral> result = this.inicioLaboralRepository.getIniciosLaborales(estados);
        if (result.size() == 0) {
            throw new MinSaludBusinessException("No existen iniciosLaborales en estado: ".concat(Arrays.toString(estados)));
        }

        return result;
    }
}
