package com.co.service;

import com.co.dto.ConsultaEmpresaDTO;
import com.co.entities.ConsultaEmpresa;
import com.co.enums.CalculoFechas;
import com.co.persistence.ConsultaEmpresaRepository;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
@Service
public class ConsultaEmpresaService
{
    @Autowired
    ConsultaEmpresaRepository consultaEmpresaRepository;

    public void save(ConsultaEmpresa consultaEmpresa)
    {
        this.consultaEmpresaRepository.save(consultaEmpresa);
    }

    public void saveEmpresas(List<ConsultaEmpresa> empresas){
        empresas.forEach(this.consultaEmpresaRepository::save);
    }

    public List<ConsultaEmpresa> transformConsultaEmpresa(List<ConsultaEmpresaDTO> resultados, String token) throws InvocationTargetException, IllegalAccessException {
        List<ConsultaEmpresa> empresas = new ArrayList<>();
        for(ConsultaEmpresaDTO empresa: resultados)
        {
            ConsultaEmpresa consultaEmpresa = new ConsultaEmpresa();
            BeanUtils.copyProperties(consultaEmpresa, empresa);
            consultaEmpresa.setTokenMinIni(token);
            consultaEmpresa.setFecCapturaTokenIni(LocalDateTime.now().toString());
            consultaEmpresa.setFecIniCobertura(calculateCoberturaDate(calculateDate(empresa.getFechaSolicitud()), CalculoFechas.valueOf(empresa.getTipoReporte())).toString());
            empresas.add(consultaEmpresa);
        }
        return empresas;
    }

    private LocalDateTime calculateDate(String date)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")
                .withZone(ZoneId.of("UTC"));
        return LocalDateTime.parse(date, formatter);
    }

    private LocalDateTime calculateCoberturaDate(LocalDateTime date, CalculoFechas estado)
    {
        switch(estado)
        {
            case AF:
               return date.plusDays(estado.getDias());
            default:
                return date.plusDays(estado.getDias());
        }

    }
}
