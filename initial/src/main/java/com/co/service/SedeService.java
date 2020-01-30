package com.co.service;

import com.co.entities.Sede;
import com.co.persistence.SedesRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

public class SedeService
{
    @Autowired
    SedesRepository sedesRepository;

    public List<Sede> getSedePorEstructuraId(BigDecimal id) {
        return this.sedesRepository.getSedeByEstructuraId(id);
    }
}
