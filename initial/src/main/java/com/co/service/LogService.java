package com.co.service;

import com.co.entities.RespuestaSATARL;
import com.co.persistence.RespuestaSATARLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class LogService {

    @Autowired
    RespuestaSATARLRepository repository;

    public void save(RespuestaSATARL respuestaSATARL)
    {
        this.repository.save(respuestaSATARL);
    }

    public List<RespuestaSATARL> findAll()
    {
        return (List<RespuestaSATARL>) this.repository.findAll();
    }
}
