package com.co.service;

import com.co.entities.AfiliacionEmpresa;
import com.co.exception.MinSaludBusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.co.persistence.AfiliacionRepository;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Service
public class AfiliacionService
{
    @Autowired
    AfiliacionRepository repository;

    public void add(AfiliacionEmpresa afiliacionEmpresa)
    {
        this.repository.save(afiliacionEmpresa);
    }

    public List<AfiliacionEmpresa> afiliaciones()
    {
        return (List<AfiliacionEmpresa>) this.repository.findAll();
    }

    public List<AfiliacionEmpresa> afiliacionPorEstado(BigDecimal... estados) throws MinSaludBusinessException {
        List<AfiliacionEmpresa> result = this.repository.afiliacionesPorProcesarQuery(estados);
        if (result.size() == 0) {
            throw new MinSaludBusinessException("No existen afiliaciones en estado: ".concat(Arrays.toString(estados)));
        }
        else
        {
            result.stream().forEach(p ->
            {
                p.activiEconimi = Integer.parseInt(p.getActividadEconomica());
                p.tipAportante = Integer.parseInt(p.getTipoAportante());
                p.natuJuridica = Integer.parseInt(p.getNaturalezaJuridica());
            });
            return result;
        }
    }

}
