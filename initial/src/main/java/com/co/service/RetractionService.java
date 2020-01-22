package com.co.service;

import com.co.entities.AfiliacionEmpresa;
import com.co.entities.Retractacion;
import com.co.exception.MinSaludBusinessException;
import com.co.persistence.RetractacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Component
@Service
public class RetractionService
{
    @Autowired
    private RetractacionRepository retractacionRepository;

    public List<Retractacion> getAll(BigDecimal... estados) throws MinSaludBusinessException {
        List<Retractacion> result = this.retractacionRepository.getAllRetractacionEstado(estados);
        if (result.size() == 0) {
            throw new MinSaludBusinessException("No existen afiliaciones en estado: ".concat(Arrays.toString(estados)));
        }

        return result;
    }
}
