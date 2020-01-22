package com.co.service;

import com.co.entities.RetiroDefinitivoSGRL;
import com.co.persistence.RetiroDefinitivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class RetiroDefinitivoService
{
    @Autowired
    private RetiroDefinitivoRepository retiroDefinitivoRepository;

    public List<RetiroDefinitivoSGRL> getAll() {

        return (List<RetiroDefinitivoSGRL>) this.retiroDefinitivoRepository.findAll();
    }
}
