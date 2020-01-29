package com.co.service;

import com.co.entities.EstructuraEmpresa;
import com.co.persistence.EstructuraEmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class EstructuraEmpresaService
{
    @Autowired
    private EstructuraEmpresaRepository estructuraEmpresaRepository;

    public void save(EstructuraEmpresa estructuraEmpresa){

        this.estructuraEmpresaRepository.save(estructuraEmpresa);
    }

    public EstructuraEmpresa consultaEstructuraEmpresa(String empreId, String empreTipDoc){

        return this.estructuraEmpresaRepository.consultaEstructuraEmpresa(empreId, empreTipDoc);
    }

}
