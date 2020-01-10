package com.co.service;

import com.co.entities.ConsultaEmpresa;
import com.co.persistence.ConsultaEmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class ConsultaEmpresaService
{
    @Autowired
    ConsultaEmpresaRepository consultaEmpresaRepository;

    public void save(ConsultaEmpresa consultaEmpresa)
    {
        this.consultaEmpresaRepository.save(consultaEmpresa);
    }
}
