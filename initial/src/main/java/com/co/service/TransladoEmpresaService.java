package com.co.service;

import com.co.entities.TransladoEmpresaArl;
import com.co.persistence.TransladoEmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Component
@Service
public class TransladoEmpresaService {

    @Autowired
    private TransladoEmpresaRepository transladoEmpresaRepository;


    public List<TransladoEmpresaArl> getAll(BigDecimal... estados)
    {
        return this.transladoEmpresaRepository.getTransladoEmpresaArl(estados);
    }
}
