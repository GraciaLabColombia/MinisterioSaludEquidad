package com.co.service;

import com.co.entities.ReclasificacionCentroTrabajo;
import com.co.persistence.ReclasificacionCentroTrabajoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class ReclasificacionCentroTrabajoService {

    @Autowired
    private ReclasificacionCentroTrabajoRepository reclasificacionCentroTrabajoRepository;

    public List<ReclasificacionCentroTrabajo> getAll(){
        return (List<ReclasificacionCentroTrabajo>) this.reclasificacionCentroTrabajoRepository.findAll();
    }
}
