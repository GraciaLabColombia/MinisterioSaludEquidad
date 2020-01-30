package com.co.service;

import com.co.entities.Empleado;
import com.co.persistence.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

public class EmpleadoService {

    @Autowired
    EmpleadoRepository empleadoRepository;

    public List<Empleado> getEmpleadosPorCentro(BigDecimal id) {

        return this.empleadoRepository.getCentroBySedeId(id);
    }
}
