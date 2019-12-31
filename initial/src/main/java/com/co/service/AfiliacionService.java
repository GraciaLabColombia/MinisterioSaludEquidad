package com.co.service;

import com.co.entities.AfiliacionEmpresa;
import com.co.exception.MinSaludBusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.co.persistence.AfiliacionRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

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
        if (result.size() == 0)  throw new MinSaludBusinessException("No existen afiliaciones a tratar"); else return result;
    }

}
