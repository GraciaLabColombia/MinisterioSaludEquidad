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

    public EstructuraEmpresa consultaEmpresDocRepresentante(String empreId, String docRepresentante) {
        return this.estructuraEmpresaRepository.consultaEstructuraEmpresaDocRepresentante(empreId, docRepresentante);
    }

    public void delete(EstructuraEmpresa estructuraEmpresa) {
        this.estructuraEmpresaRepository.delete(estructuraEmpresa);
    }

}
