package com.co.service;

import com.co.entities.ParametroGeneral;
import com.co.persistence.ParametroGeneralRepository;
import com.co.utils.SisafitraConstant;
import org.springframework.beans.factory.annotation.Autowired;
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

    public ParametroGeneral getParametroGeneralParametroDocumento(String parametro, BigDecimal activo, String documento) {

        return this.parametroGeneralRepository.getParametroGeneralPorParametroAndDocumento(parametro, activo, documento);
    }

    public List<ParametroGeneral> parametros() {
        List<ParametroGeneral> parametros = new ArrayList<>();
        ParametroGeneral empresa = getParametroGeneralParametroDocumento(SisafitraConstant.ParameroGeneralConstant.SATARLSERVICIO, new BigDecimal(1), SisafitraConstant.ParameroGeneralConstant.EMPRESA);
        ParametroGeneral centro = getParametroGeneralParametroDocumento(SisafitraConstant.ParameroGeneralConstant.SATARLSERVICIO, new BigDecimal(1), SisafitraConstant.ParameroGeneralConstant.CENTRO);
        ParametroGeneral empleado = getParametroGeneralParametroDocumento(SisafitraConstant.ParameroGeneralConstant.SATARLSERVICIO, new BigDecimal(1), SisafitraConstant.ParameroGeneralConstant.EMPLEADO);
        ParametroGeneral sucursal = getParametroGeneralParametroDocumento(SisafitraConstant.ParameroGeneralConstant.SATARLSERVICIO, new BigDecimal(1), SisafitraConstant.ParameroGeneralConstant.SUCURSAL);

        parametros.add(empresa);
        parametros.add(centro);
        parametros.add(empleado);
        parametros.add(sucursal);

        return parametros;
    }
}
