package com.co.service;

import com.co.entities.ParametroGeneral;
import com.co.persistence.ParametroGeneralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Component
@Service
public class ParametroGeneralService {

    @Autowired
    ParametroGeneralRepository parametroGeneralRepository;

    public ParametroGeneral getParametroGeneralParametroDocumento(String parametro, BigDecimal activo, String documento) {

        return this.parametroGeneralRepository.getParametroGeneralPorParametroAndDocumento(parametro, activo, documento);
    }
}
