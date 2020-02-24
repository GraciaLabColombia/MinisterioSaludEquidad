package com.co.service;

import com.co.entities.ParametroGeneral;
import com.co.exception.MinSaludBusinessException;
import com.co.persistence.ParametroGeneralRepository;
import com.co.singleton.ConfiguracionSingleton;
import com.co.utils.SisafitraConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
@Service
public class ParametroGeneralService {

    @Autowired
    ParametroGeneralRepository parametroGeneralRepository;

    ConfiguracionSingleton configuracionSingleton;

    public ParametroGeneralService() {
        AnnotationConfigApplicationContext config = new AnnotationConfigApplicationContext(ConfiguracionSingleton.class);
        this.configuracionSingleton = config.getBean(ConfiguracionSingleton.class);
    }

    public ParametroGeneral getParametroGeneralParametroDocumentoDataBase(String parametro, BigDecimal activo, String documento) {

        return this.parametroGeneralRepository.getParametroGeneralPorParametroAndDocumento(parametro, activo, documento);
    }

    public List<ParametroGeneral> parametros() {
        List<ParametroGeneral> parametros = new ArrayList<>();
        ParametroGeneral empresa = this.parametroGeneralRepository.getParametroGeneralPorParametroAndDocumento(SisafitraConstant.ParameroGeneralConstant.SATARLSERVICIO, new BigDecimal(1), SisafitraConstant.ParameroGeneralConstant.EMPRESA);
        ParametroGeneral centro = this.parametroGeneralRepository.getParametroGeneralPorParametroAndDocumento(SisafitraConstant.ParameroGeneralConstant.SATARLSERVICIO, new BigDecimal(1), SisafitraConstant.ParameroGeneralConstant.CENTRO);
        ParametroGeneral empleado = this.parametroGeneralRepository.getParametroGeneralPorParametroAndDocumento(SisafitraConstant.ParameroGeneralConstant.SATARLSERVICIO, new BigDecimal(1), SisafitraConstant.ParameroGeneralConstant.EMPLEADO);
        ParametroGeneral sucursal = this.parametroGeneralRepository.getParametroGeneralPorParametroAndDocumento(SisafitraConstant.ParameroGeneralConstant.SATARLSERVICIO, new BigDecimal(1), SisafitraConstant.ParameroGeneralConstant.SUCURSAL);

        parametros.add(empresa);
        parametros.add(centro);
        parametros.add(empleado);
        parametros.add(sucursal);

        this.configuracionSingleton.setParametros(parametros);

        return parametros;
    }

    public ParametroGeneral getParametroGeneralParametroDocumento(String documento) throws MinSaludBusinessException {

        return this.configuracionSingleton.getParametroPorDocumento(documento);
    }
}
