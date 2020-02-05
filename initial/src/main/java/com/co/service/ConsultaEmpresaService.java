package com.co.service;

import com.co.dto.ConsultaEmpresaDTO;
import com.co.entities.*;
import com.co.enums.CalculoFechas;
import com.co.persistence.CentroRepository;
import com.co.persistence.ConsultaEmpresaRepository;
import com.co.persistence.EmpleadoRepository;
import com.co.persistence.SedesRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Component
@Service
public class ConsultaEmpresaService
{
    @Autowired
    ConsultaEmpresaRepository consultaEmpresaRepository;

    @Autowired
    EstructuraEmpresaService estructuraEmpresaService;

    @Autowired
    SedesRepository sedesRepository;

    @Autowired
    CentroRepository centroRepository;

    @Autowired
    EmpleadoRepository empleadoRepository;

    private LogService logService;

    public ConsultaEmpresaService() {
        this.logService = new LogService();
    }

    Logger log = LoggerFactory.getLogger(this.getClass().getName());

    public void save(ConsultaEmpresa consultaEmpresa)
    {
        this.consultaEmpresaRepository.save(consultaEmpresa);
    }


    public List<ConsultaEmpresa> consultaEmpresaPorFecha(String date, String fecToday)
    {
        return this.consultaEmpresaRepository.consultaEmpresaPorFechaCobertura(fecToday ,date);
    }

    public void writeBusinessLog(RespuestaSATARL respuestaSATARL) {
        this.logService.save(respuestaSATARL);
    }

    public List<ConsultaEmpresa> transformConsultaEmpresa(List<ConsultaEmpresaDTO> resultados, String token) throws InvocationTargetException, IllegalAccessException {
        List<ConsultaEmpresa> empresas = new ArrayList<>();
        for(ConsultaEmpresaDTO empresa: resultados)
        {
            log.info("Consultando empresa por: ".concat(empresa.getTipoDocumentoEmpleador()).concat("Y: ").concat(empresa.getNumeroDocumentoEmpleador()).concat("..."));

            ConsultaEmpresa empresa_o = this.empresaPorTipoDocumentoYNumeroDocumento(empresa.getTipoDocumentoEmpleador(), empresa.getNumeroDocumentoEmpleador());
            if(empresa_o == null) {
                log.info("La empresa con NumeroIdentificacion: ".concat(empresa.getTipoDocumentoEmpleador()).concat(" Va ser persistida"));
                ConsultaEmpresa consultaEmpresa = new ConsultaEmpresa();
                BeanUtils.copyProperties(consultaEmpresa, empresa);
                consultaEmpresa.setTokenMinIni(token);
                consultaEmpresa.setFecCapturaTokenIni(LocalDateTime.now().toString());
                consultaEmpresa.setFecIniCobertura(calculateCoberturaDate(calculateDate(empresa.getFechaSolicitud()), CalculoFechas.valueOf(empresa.getTipoReporte())).toString());
                empresas.add(consultaEmpresa);
            }else
            {
                empresa_o.setTokenMinIni(token);
                empresa_o.setFecCapturaTokenIni(LocalDateTime.now().toString());
                BeanUtils.copyProperties(empresa_o, empresa);
                log.info("Se actualizara la empresa con NumeroIdentificacion: ".concat(empresa_o.getNumeroDocumentoEmpleador()));
                this.save(empresa_o);
                log.info("Empresa actualizada correctamente!");
            }
        }
        return empresas;
    }

    public EstructuraEmpresa mapEstructura(EstructuraEmpresa empresa, String token) throws JsonProcessingException {
        /*JSONObject json = new JSONObject(response);
        JSONArray sedes = json.getJSONArray("sedes");
        ObjectMapper mapper = new ObjectMapper();
        EstructuraEmpresa empresa = mapper.readValue(response, EstructuraEmpresa.class);
        empresa.setFecCaptura(LocalDateTime.now().toString());
        for(int i = 0; i < sedes.length(); i++)
        {
            JSONObject sede = sedes.getJSONObject(i);
            Sede sede_o = mapper.readValue(sede.toString(), Sede.class);
            JSONArray centros = sede.getJSONArray("centrosTrabajo");
            for(int j = 0; j < centros.length(); j++){
                JSONObject centro = centros.getJSONObject(j);
                CentroTrabajo centro_o = mapper.readValue(centro.toString(), CentroTrabajo.class);
                JSONArray empleados = centro.getJSONArray("empleados");
                for(int k = 0; k < empleados.length(); k++)
                {
                    JSONObject empleado = empleados.getJSONObject(k);
                    Empleado empleado_o = mapper.readValue(empleado.toString(), Empleado.class);
                    centro_o.addEmpleados(empleado_o);
                }

                sede_o.addCentro(centro_o);
            }
            empresa.addSede(sede_o);
        }*/

        empresa.setTokenMin(token);
        empresa.getSedes().forEach(p -> {
            p.setEstructuraEmpresa(empresa);
            p.setTokenMin(token);
            p.setFecCaptura(LocalDateTime.now().toString());
            p.setFecRespuesta(LocalDateTime.now().toString());
            p.setCodSede(p.getCodSede().length() == 1 ? "0".concat(p.getCodSede()) : p.getCodSede());
        });
        empresa.getSedes().forEach(p -> p.getCentros().forEach(c -> {
            c.setSede(p);
            c.setTokenMin(token);
            c.setFecCaptura(LocalDateTime.now().toString());
            c.setFecRespuesta(LocalDateTime.now().toString());
        }));
        empresa.getSedes().forEach(p -> p.getCentros().forEach(c -> c.getEmpleados().forEach(e -> {
            e.setCentro(c);
            e.setTokenMin(token);
            e.setFecCaptura(LocalDateTime.now().toString());
            e.setFecRespuesta(LocalDateTime.now().toString());
        })));
        empresa.setFecRespuesta(LocalDateTime.now().toString());

        log.info("Mapeo de estructura completo exitosamente!");
        log.info("Consultando si la estructura esta en la base de datos...");

        EstructuraEmpresa estructuraEmpresa = null;

        if(empresa.getEmpreTipDoc() == null)
        {
            estructuraEmpresa = this.estructuraEmpresaService.consultaEmpresDocRepresentante(empresa.getEmpreId(), empresa.getDocRepresentante());

        }else
        {
            estructuraEmpresa = this.estructuraEmpresaService.consultaEstructuraEmpresa(empresa.getEmpreId(), empresa.getEmpreTipDoc());

        }
        log.info("Encontramos estructura con id: ".concat(estructuraEmpresa == null ? "Es nueva" : estructuraEmpresa.getId().toString()));
        if(estructuraEmpresa != null) {
            log.info("Preparando estructura para eliminar y guardar de nuevo! ");
            log.warn("Borrando estructuras con: ".concat(String.valueOf(estructuraEmpresa.sedes())).concat(" Sedes"));
            log.warn("Borrando estructuras con: ".concat(String.valueOf(estructuraEmpresa.centros())).concat(" Centros"));
            log.warn("Borrando estructuras con: ".concat(String.valueOf(estructuraEmpresa.empleados())).concat(" Empleados"));
            this.estructuraEmpresaService.delete(estructuraEmpresa); //cascade
            log.warn("Borrado exitoso!");
        }
        log.info("Lista para guardar ");

        return empresa;
    }

    public ConsultaEmpresa empresaPorTipoDocumentoYNumeroDocumento(String tipoDocumento, String numeroDocumento)
    {
        return this.consultaEmpresaRepository.consultaEmpresaPorTipoYNumeroDocumento(tipoDocumento, numeroDocumento);
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
            case TR:
                return estado.getDias() == 2L ?  getLocalDateMonthsPlus(date, ((int) estado.getDias())) : date.plusDays(estado.getDias());
            default:
                return date.plusDays(1);
        }

    }

    public static LocalDateTime getLocalDateMonthsPlus(final LocalDateTime localDate, int months) {
        final LocalDateTime localDateStartingWithNextMonth = localDate.with(TemporalAdjusters.firstDayOfNextMonth()).plusMonths(months);
        return IntStream.range(0, 1).boxed().map(localDateStartingWithNextMonth::plusDays).findAny().get();
    }

}
