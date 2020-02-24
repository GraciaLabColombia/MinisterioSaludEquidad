package com.co.app;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.co.annotation.ServiceConfig;
import com.co.builder.PropertiesBuilder;
import com.co.dto.*;
import com.co.entities.*;
import com.co.service.*;
import com.co.controller.BaseController;
import com.co.enums.EstadosEnum;
import com.co.exception.MinSaludBusinessException;
import com.co.singleton.ConfiguracionSingleton;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import com.co.utils.SisafitraConstant;

import javax.annotation.PostConstruct;

@Component
@RestController
@RequestMapping("/")
public class Controller extends BaseController
{
    @Autowired
	private AfiliacionService afiliacionService;

    @Autowired
	private LogService logService;

    @Autowired
    private ConsultaEmpresaService consultaEmpresaService;

    @Autowired
    private EstructuraEmpresaService estructuraEmpresaService;

    @Autowired
    private InicioLaboralService inicioLaboralService;

    @Autowired
    private TerminacionLaboralService terminacionLaboralService;

    @Autowired
    private ReclasificacionCentroTrabajoService reclasificacionCentroTrabajoService;

    @Autowired
    private RetiroDefinitivoService retiroDefinitivoService;

    @Autowired
    private RetractionService retractionService;

    @Autowired
    private TransladoEmpresaService transladoEmpresaService;

    @Autowired
    private ParametroGeneralService parametroGeneralService;

    List<ParametroGeneral> parametros;

	public Controller()
	{
		this.afiliacionService = new AfiliacionService();
		this.logService = new LogService();
		this.consultaEmpresaService = new ConsultaEmpresaService();
		this.estructuraEmpresaService = new EstructuraEmpresaService();
		this.inicioLaboralService = new InicioLaboralService();
		this.terminacionLaboralService = new TerminacionLaboralService();
		this.reclasificacionCentroTrabajoService = new ReclasificacionCentroTrabajoService();
		this.retiroDefinitivoService = new RetiroDefinitivoService();
		this.retractionService = new RetractionService();
		this.transladoEmpresaService = new TransladoEmpresaService();
		this.parametroGeneralService = new ParametroGeneralService();

		this.parametros = new ArrayList<>();

	}

	@PostConstruct
	public void singleton(){
		this.parametroGeneralService.parametros();
	}

	Logger log = LoggerFactory.getLogger(this.getClass().getName());

	@ApiOperation(value = "Retorna el Token", response = TokenDTO.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "username", defaultValue = "830008686", value = "Username en MinSalud", paramType = "form", dataType = "int"),
			@ApiImplicitParam(name = "password", defaultValue = "830008686", value = "Password del username en MinSalud",  paramType = "form", dataType = "int"),
			@ApiImplicitParam(name = "grant_type", defaultValue = "password", value = "Tipo de autenticacion",  paramType = "form", dataType = "string"),
			@ApiImplicitParam(name = "client_id", defaultValue = "9160f6412fad4b7fbc5f86d37a8dd680", value = "ClientId para el servicio en MinSalud",  paramType = "form", dataType = "string")
	})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = TokenDTO.class),
			@ApiResponse(code = 201, message = "Created", response = void.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 401, message = "Forbidden", response = String.class),
			@ApiResponse(code = 404, message = "Not found", response = ErrorDTO.class),
			@ApiResponse(code = 500, message = "Failure", response = InternalServerErrorDTO.class),
	})
	@PostMapping(path = "/token", consumes = "application/x-www-form-urlencoded", produces = "application/json")
	@ServiceConfig(protocol = "https", domain = "sisafitra.sispropreprod.gov.co", port = "8062",
			name = "Token", clientId = "9160f6412fad4b7fbc5f86d37a8dd680",
			uri = "/token", headers = {"Content-Type=application/x-www-form-urlencoded"},
			params = {"username=830008686", "password=830008686", "grant_type=password",
					"client_id=9160f6412fad4b7fbc5f86d37a8dd680"},
			method = RequestMethod.POST)
	public Object token()
	{
		Object response = null;
		log.info("Token init");
		try
		{
			Method method = new Object() {}.getClass().getEnclosingMethod();
			RequestFormPostDTO request_body = PropertiesBuilder.getAnnotationFeatures(method.getName(), this.getClass());
			log.info("Token request: ".concat(request_body.toString()));
			response =  super.responseFromPostFormRequest(request_body, TokenDTO.class);
			log.info("Token response: ".concat(response.toString()));
		}catch (NoSuchMethodException e)
		{
			log.error("Configuracion @ServiceConfig invalida: ERROR: ".concat(e.getMessage()));
		}catch (IllegalAccessException | NoSuchFieldException e)
		{
			log.error("Response es invalido para el objeto TokenDTO: ERROR: ".concat(e.getMessage()));
		} catch (IOException e)
		{
			log.error("Error de conexion con el servicio: ERROR: ".concat(e.getMessage()));
		}

		return response;

	}
	@ApiOperation(value = "Afilia todas las empresas de Equidad a MinSalud", response = ResponseContentExitFailDTO.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "Header con la autenticacion", paramType = "header", dataType = "string")
	})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = ResponseContentExitFailDTO.class),
			@ApiResponse(code = 201, message = "Created", response = void.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 401, message = "Forbidden", response = String.class),
			@ApiResponse(code = 404, message = "Not found", response = ErrorDTO.class),
			@ApiResponse(code = 500, message = "Failure", response = InternalServerErrorDTO.class),
	})
	@PostMapping(path = "/AfiliacionARL", consumes = "application/json", produces = "application/json")
	@ServiceConfig(protocol = "https", domain = "sisafitra.sispropreprod.gov.co", port = "8062",
			name = "AfiliacionARL", clientId = "f45d4049f9a44f839e692f2ca331ec77",
			uri = "/AfiliacionARL", headers = {"Content-Type=application/json"},
			method = RequestMethod.POST)
	public Object afiliacionARL(@RequestHeader("Authorization") String authorization)
	{
		log.info("AfiliacionARL init with authorization ".concat(authorization));
		List<String> afiliacionesCorrectas = new ArrayList<>();
		List<String> afiliacionesInCorrectas = new ArrayList<>();
		try
		{
			log.info("Consultamos afiliaciones en estado EN_TRAMITE o FALLIDO ");
			List<AfiliacionEmpresa> afiliaciones = this.afiliacionService.afiliacionPorEstado(EstadosEnum.EN_TRAMITE.getName(), EstadosEnum.FALLIDO.getName());
			log.info("Numero afiliaciones a registrar: ".concat(String.valueOf(afiliaciones.size())));
            Method method = new Object() {}.getClass().getEnclosingMethod();
			ParametroGeneral parametro = this.parametroGeneralService.getParametroGeneralParametroDocumento(SisafitraConstant.ParameroGeneralConstant.EMPRESA);
			for(AfiliacionEmpresa afiliacion: afiliaciones)
			{
				log.info("Afiliacion ID: ".concat(afiliacion.getAfiliacionEmpresaId().toPlainString()));
				RequestBodyDTO request_body = PropertiesBuilder.getAnnotationFeatures(mapperBody(afiliacion), method.getName(), this.getClass(), method.getParameterTypes());
				request_body.getHeaders().put(SisafitraConstant.AUTHORIZATION,  authorization);
				log.info("Afiliacion request: ".concat(request_body.toString()));
				Object response = null;
                try{
                	response = super.responseFromPostRequest(request_body, ResponseMinSaludDTO.class);
					log.info("Afiliacion response: ".concat(response.toString()));
					if(response instanceof ErrorDTO)
					{
						this.logService.save(writeLogSATARL(afiliacion.getEmpre_form(), new BigDecimal(parametro.getValor().trim()), afiliacion.getAfiliacionEmpresaId(), EstadosEnum.FALLIDO.getName(), ((ErrorDTO)response).getError_description(), authorization));
						afiliacion.setEstadoMin(EstadosEnum.FALLIDO.getName());
						afiliacionesInCorrectas.add(afiliacion.getNumeroDocumentoEmpleador());
					} else if(response instanceof ResponseMinSaludDTO)
					{
						this.logService.save(writeLogSATARL(afiliacion.getEmpre_form(), new BigDecimal(parametro.getValor().trim()), afiliacion.getAfiliacionEmpresaId(), EstadosEnum.EXITOSO.getName(), ((ResponseMinSaludDTO)response).getCodigo(), authorization));
						afiliacion.setEstadoMin(EstadosEnum.EXITOSO.getName());
						afiliacionesCorrectas.add(afiliacion.getNumeroDocumentoEmpleador());
					}

                }
                catch (Exception e)
                {
					this.logService.save(writeLogSATARL(afiliacion.getEmpre_form(), new BigDecimal(parametro.getValor().trim()), afiliacion.getAfiliacionEmpresaId(), EstadosEnum.FALLIDO.getName(), response instanceof ErrorDTO ? ((ErrorDTO)response).getError_description() : "FAIL", authorization));
					afiliacion.setEstadoMin(EstadosEnum.FALLIDO.getName());
                    log.error("Error interno: ".concat(e.getMessage()));
					afiliacionesInCorrectas.add(afiliacion.getNumeroDocumentoEmpleador());
                }

				afiliacion.setTokenMin(authorization);
				afiliacion.setFechaReporte(LocalDateTime.now());
				afiliacion.setFechaRespuesta(LocalDateTime.now());
				this.afiliacionService.add(afiliacion);
			}

            ResponseContentExitFailDTO responseContentExitFailDTO = new ResponseContentExitFailDTO();
			responseContentExitFailDTO.setExito(afiliacionesCorrectas);
			responseContentExitFailDTO.setFail(afiliacionesInCorrectas);

			return responseContentExitFailDTO;

		}catch (NoSuchMethodException e)
		{
			log.error("Configuracion @ServiceConfig invalida: ERROR: ".concat(e.getMessage()));
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}catch (IOException e)
		{
			log.error("Error de conexion con el servicio: ERROR: ".concat(e.getMessage()));
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (MinSaludBusinessException e)
		{
			log.error("Error de negocio. ERROR: ".concat(e.getMessage()));
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
    }

        @ApiOperation(value = "Inicia la relacion laboral en una ARL",  response = ResponseContentExitFailDTO.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Header con la autenticacion", paramType = "header", dataType = "string")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = ResponseContentExitFailDTO.class),
            @ApiResponse(code = 201, message = "Created", response = void.class),
            @ApiResponse(code = 400, message = "Bad Request", response = String.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = String.class),
            @ApiResponse(code = 401, message = "Forbidden", response = String.class),
            @ApiResponse(code = 404, message = "Not found", response = ErrorDTO.class),
            @ApiResponse(code = 500, message = "Failure", response = InternalServerErrorDTO.class),
    })
	@PostMapping(path = "/InicioRelacionLaboralARL", consumes = "application/json", produces = "application/json")
	@ServiceConfig(protocol = "https", domain = "sisafitra.sispropreprod.gov.co", port = "8062",
			name = "InicioRelacionLaboralARL", clientId = "37cf0135c6c5408eb474a8ac0cdd11f2",
			uri =  "/InicioRelacionLaboralARL", headers = {"Content-Type=application/json"},
			method = RequestMethod.POST)
	public Object inicioRelacionLaboralARL(@RequestHeader("Authorization") String authorization) {
		Object response = null;
		try {
			ParametroGeneral parametro = this.parametroGeneralService.getParametroGeneralParametroDocumento(SisafitraConstant.ParameroGeneralConstant.EMPRESA);
			for(InicioLaboral inicioLaboral: this.inicioLaboralService.getIniciosLaborales(EstadosEnum.FALLIDO.getName(), EstadosEnum.EN_TRAMITE.getName())) {
				try {
					Method method = new Object() {}.getClass().getEnclosingMethod();
					//Para crear request
					RequestBodyDTO request_body = PropertiesBuilder.getAnnotationFeatures(mapperBody(inicioLaboral), method.getName(), this.getClass(), method.getParameterTypes());
					request_body.getHeaders().put(SisafitraConstant.AUTHORIZATION, authorization);
					response = super.responseFromPostRequest(request_body, ResponseMinSaludDTO.class);
					this.logService.save(writeLogSATARL(inicioLaboral.getEmpre_form(), new BigDecimal(parametro.getValor().trim()), inicioLaboral.getId(), EstadosEnum.EXITOSO.getName(), ((ResponseMinSaludDTO) response).getCodigo(), authorization));
				} catch (NoSuchMethodException | NoSuchFieldException | IllegalAccessException e)
				{
					log.error("Configuracion @ServiceConfig invalida: ERROR: ".concat(e.getMessage()));
					return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
				}catch (IOException e)
				{
					log.error("Error de conexion con el servicio: ERROR: ".concat(e.getMessage()));
					return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}
		} catch (MinSaludBusinessException e) {
			log.error("Error de negocio. ERROR: ".concat(e.getMessage()));
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}

		return response;
	}

    @ApiOperation(value = "Termina la relacion laboral en una ARL",  response = ResponseContentExitFailDTO.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Header con la autenticacion", paramType = "header", dataType = "string")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = ResponseContentExitFailDTO.class),
            @ApiResponse(code = 201, message = "Created", response = void.class),
            @ApiResponse(code = 400, message = "Bad Request", response = String.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = String.class),
            @ApiResponse(code = 401, message = "Forbidden", response = String.class),
            @ApiResponse(code = 404, message = "Not found", response = ErrorDTO.class),
            @ApiResponse(code = 500, message = "Failure", response = InternalServerErrorDTO.class),
    })
	@PostMapping(path = "/TerminacionRelacionLaboralARL", consumes = "application/json", produces = "application/json")
	@ServiceConfig(protocol = "https", domain = "sisafitra.sispropreprod.gov.co", port = "8062",
			name = "TerminacionRelacionLaboralARL", clientId = "b09ba3fd1e1e4f05a05daf36bab5a552",
			uri = "/TerminacionRelacionLaboralARL", headers = {"Content-Type=application/json"},
			method = RequestMethod.POST)
	public Object terminacionRelacionLaboralARL(@RequestHeader("Authorization") String authorization)
	{
		Object response = null;
		try {
			ParametroGeneral parametro = this.parametroGeneralService.getParametroGeneralParametroDocumento(SisafitraConstant.ParameroGeneralConstant.EMPRESA);
			for(TerminacionLaboral terminacionLaboral: this.terminacionLaboralService.getTerminacionesLaborales(EstadosEnum.EN_TRAMITE.getName(), EstadosEnum.FALLIDO.getName()))
			{
				try {
					Method method = new Object() {}.getClass().getEnclosingMethod();
					RequestBodyDTO request_body = PropertiesBuilder.getAnnotationFeatures(mapperBody(terminacionLaboral), method.getName(), this.getClass(), method.getParameterTypes());
					request_body.getHeaders().put(SisafitraConstant.AUTHORIZATION, authorization);
					response = super.responseFromPostRequest(request_body, ResponseMinSaludDTO.class);

				} catch (NoSuchMethodException e) {
					log.error("Configuracion @ServiceConfig invalida: ERROR: ".concat(e.getMessage()));
					assert response != null;
					this.logService.save(writeLogSATARL(terminacionLaboral.getEmpre_form(), new BigDecimal(parametro.getValor().trim()), terminacionLaboral.getId(), EstadosEnum.FALLIDO.getName(), ((ErrorDTO)response).getError_description(), authorization));
				} catch (IllegalAccessException | NoSuchFieldException e) {
					log.error("Response es invalido para el objeto ResponseMinSaludDTO: ERROR: ".concat(e.getMessage()));
					assert response != null;
					this.logService.save(writeLogSATARL(terminacionLaboral.getEmpre_form(), new BigDecimal(parametro.getValor().trim()), terminacionLaboral.getId(), EstadosEnum.FALLIDO.getName(), ((ErrorDTO)response).getError_description(), authorization));
				} catch (IOException e) {
					log.error("Error de conexion con el servicio: ERROR: ".concat(e.getMessage()));
					assert response != null;
					this.logService.save(writeLogSATARL(terminacionLaboral.getEmpre_form(), new BigDecimal(parametro.getValor().trim()), terminacionLaboral.getId(), EstadosEnum.FALLIDO.getName(), ((ErrorDTO) response).getError_description(), authorization));
				}
				this.logService.save(writeLogSATARL(terminacionLaboral.getEmpre_form(), new BigDecimal(parametro.getValor().trim()), terminacionLaboral.getId(), EstadosEnum.EXITOSO.getName(), ((ResponseMinSaludDTO)response).getCodigo(), authorization));
			}
			} catch (MinSaludBusinessException ex) {
				log.error("Error de negocio. ERROR: ".concat(ex.getMessage()));
				return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	@ApiOperation(value = "Consulta empresas para el codigo de ARL enviado", response = ResponseContentExitFailDTO.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "Header con la autenticacion", paramType = "header", dataType = "string"),

	})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = ResponseContentExitFailDTO.class),
			@ApiResponse(code = 201, message = "Created", response = void.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 401, message = "Forbidden", response = String.class),
			@ApiResponse(code = 404, message = "Not found", response = ErrorDTO.class),
			@ApiResponse(code = 500, message = "Failure", response = InternalServerErrorDTO.class),
	})
	@PostMapping(path = "/ConsultaEmpresasTrasladadas", consumes = "application/json", produces = "application/json")
	@ServiceConfig(protocol = "https", domain = "sisafitra.sispropreprod.gov.co", port = "8062",
			name = "ConsultaEmpresasTrasladadas", clientId = "147171ef46c44b41b77b2aaac10ae39b",
			uri = "/ConsultaEmpresasTrasladadas", headers = {"Content-Type=application/json"},
			method = RequestMethod.POST)
	public Object consultaEmpresa(@RequestHeader("Authorization") String authorization, @RequestBody  String entity_body)
	{
		Object response = null;
		List<String> empresasConsultadas = new ArrayList<>();
		List<String> empresasIncorrectas = new ArrayList<>();
		try
		{
			log.info("Consulta empresa INIT: ");
			Method method = new Object() {}.getClass().getEnclosingMethod();
			RequestBodyDTO request_body = PropertiesBuilder.getAnnotationFeatures(entity_body, method.getName(), this.getClass(), method.getParameterTypes());
			log.info("Consulta empresa request BODY: ".concat(request_body.toString()));
			request_body.getHeaders().put(SisafitraConstant.AUTHORIZATION, authorization);
			response = super.responseFromPostListRequest(request_body, ConsultaEmpresaDTO.class);
			log.info("Consulta empresa response BODY: ".concat(response.toString()));
			if(response instanceof ErrorDTO)
				return response;
			List<ConsultaEmpresa> empresas =  this.consultaEmpresaService.transformConsultaEmpresa((List<ConsultaEmpresaDTO>) response, authorization);
			log.info("Consulta empresa Transform: ".concat(empresas.toString()));
			ParametroGeneral parametro = this.parametroGeneralService.getParametroGeneralParametroDocumento(SisafitraConstant.ParameroGeneralConstant.EMPRESA);
			for(ConsultaEmpresa consultaEmpresa: empresas) {
				try {
					this.consultaEmpresaService.save(consultaEmpresa);
					log.info("Consulta empresa Save Ok!");
					empresasConsultadas.add(consultaEmpresa.getNumeroDocumentoEmpleador());
					this.logService.save(writeLogSATARL(consultaEmpresa.getEmpreForm(), new BigDecimal(parametro.getValor()), consultaEmpresa.getId(), EstadosEnum.EXITOSO.getName(), "OK", authorization));
				}catch (Exception ex)
				{
					empresasIncorrectas.add(consultaEmpresa.getNumeroDocumentoEmpleador());
					this.logService.save(writeLogSATARL(consultaEmpresa.getEmpreForm(), new BigDecimal(parametro.getValor()), consultaEmpresa.getId(), EstadosEnum.FALLIDO.getName(), "FAIL", authorization));
					log.info("Consulta empresa Save fail! ".concat(ex.getMessage()));
				}
			}

			ResponseContentExitFailDTO responseContentExitFailDTO = new ResponseContentExitFailDTO();
			responseContentExitFailDTO.setExito(empresasConsultadas);
			responseContentExitFailDTO.setFail(empresasIncorrectas);

			return responseContentExitFailDTO;

		} catch (NoSuchMethodException e)
		{
			log.error("Configuracion @ServiceConfig invalida: ERROR: ".concat(e.getMessage()));
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}catch (IllegalAccessException | NoSuchFieldException e)
		{
			log.error("Response es invalido para el objeto ResponseMinSaludDTO: ERROR: ".concat(e.getMessage()));
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (IOException e)
		{
			log.error("Error de conexion con el servicio: ERROR: ".concat(e.getMessage()));
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (InvocationTargetException e) {
			log.error("Error al invocar el servicio: ERROR: ".concat(e.getMessage()));
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (MinSaludBusinessException e) {
			log.error("Error de negocio. ERROR: ".concat(e.getMessage()));
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation(value = "Consulta estructura de empresas", response = ResponseContentExitFailDTO.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "Header con la autenticacion", paramType = "header", dataType = "string")
	})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = ResponseContentExitFailDTO.class),
			@ApiResponse(code = 201, message = "Created", response = void.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 401, message = "Forbidden", response = String.class),
			@ApiResponse(code = 404, message = "Not found", response = ErrorDTO.class),
			@ApiResponse(code = 500, message = "Failure", response = String.class),
	})
	@PostMapping(path = "/ConsultaEstructuraEmpresa", consumes = "application/json", produces = "application/json")
	@ServiceConfig(protocol = "https", domain = "sisafitra.sispropreprod.gov.co", port = "8062",
			name = "ConsultaEstructuraEmpresa", clientId = "d99d20985fde4150b924c8d0177691b6",
			uri = "/ConsultaEstructuraEmpresa", headers = {"Content-Type=application/json"},
			method = RequestMethod.POST)
	public Object consultaEstructuraEmpresa(@RequestHeader("Authorization") String authorization) throws MinSaludBusinessException {
			List<String> documentosFull = new ArrayList<>();
			List<String> estructurasIncorrectas = new ArrayList<>();
			Object response = null;

			LocalDateTime now = LocalDateTime.now();
            log.info("Fecha para buscar estructuras Empresa es: ".concat(now.toString()));

			List<ConsultaEmpresa> empresasAConsultar = this.consultaEmpresaService.consultaEmpresaPorFecha(now.toString(), LocalDate.now().toString());
			ParametroGeneral parametro = this.parametroGeneralService.getParametroGeneralParametroDocumento(SisafitraConstant.ParameroGeneralConstant.EMPRESA);

		for(ConsultaEmpresa consultaEmpresa: empresasAConsultar) {
				try
				{
					log.info("Consulta estructura empresa INIT: Empresa a consultar: ".concat(consultaEmpresa.getNumeroDocumentoEmpleador()));
					Method method = new Object(){}.getClass().getEnclosingMethod();
					RequestBodyDTO request_body = PropertiesBuilder.getAnnotationFeatures(mapperBody(consultaEmpresa), method.getName(), this.getClass(), method.getParameterTypes());
					request_body.getHeaders().put(SisafitraConstant.AUTHORIZATION, authorization);
					log.info("Consulta estructura empresa REQUEST: ".concat(request_body.toString()));
					response = super.responseFromPostRequest(request_body, EstructuraEmpresa.class);
					if(response instanceof ErrorDTO)
						throw new MinSaludBusinessException(response.toString());
					log.info("Consulta estructura empresa RESPONSE: ".concat(response.toString()));
					EstructuraEmpresa estructuraEmpresa = this.consultaEmpresaService.mapEstructura((EstructuraEmpresa) response, authorization);
					estructuraEmpresa.setConsultaEmpresa(consultaEmpresa);
					log.info("Consulta Estructura MAP: ".concat(estructuraEmpresa.toString()));
					this.estructuraEmpresaService.save(estructuraEmpresa);
					log.info("Consulta Estructura persistida correctamente ".concat(estructuraEmpresa.getEmpreId()));
					documentosFull.add(consultaEmpresa.getNumeroDocumentoEmpleador());
					this.logService.save(writeLogSATARL(consultaEmpresa.getEmpreForm(), new BigDecimal(parametro.getValor().trim()),  consultaEmpresa.getId(),  EstadosEnum.EXITOSO.getName(), "OK", authorization));
				} catch (NoSuchMethodException e)
				{
					log.error("Configuracion @ServiceConfig invalida: ERROR: ".concat(e.getMessage()));
					this.logService.save(writeLogSATARL(consultaEmpresa.getEmpreForm(), new BigDecimal(parametro.getValor().trim()), consultaEmpresa.getId(), EstadosEnum.FALLIDO.getName(), response instanceof ErrorDTO ? ((ErrorDTO)response).getError_description() : "FAIL" , authorization));
					estructurasIncorrectas.add(consultaEmpresa.getNumeroDocumentoEmpleador());
				}catch (IllegalAccessException | NoSuchFieldException e)
				{
					log.error("Response es invalido para el objeto ResponseMinSaludDTO: ERROR: ".concat(e.getMessage()));
					this.logService.save(writeLogSATARL(consultaEmpresa.getEmpreForm(), new BigDecimal(parametro.getValor().trim()), consultaEmpresa.getId(), EstadosEnum.FALLIDO.getName(), response instanceof ErrorDTO ? ((ErrorDTO)response).getError_description() : "FAIL" , authorization));
					estructurasIncorrectas.add(consultaEmpresa.getNumeroDocumentoEmpleador());
				} catch (IOException e)
				{
					log.error("Error de conexion con el servicio: ERROR: ".concat(e.getMessage()));
					this.logService.save(writeLogSATARL(consultaEmpresa.getEmpreForm(), new BigDecimal(parametro.getValor().trim()), consultaEmpresa.getId(), EstadosEnum.FALLIDO.getName(), response instanceof ErrorDTO ? ((ErrorDTO)response).getError_description() : "FAIL" , authorization));
					estructurasIncorrectas.add(consultaEmpresa.getNumeroDocumentoEmpleador());
				} catch (MinSaludBusinessException e)
				{
					log.error("Error de negocio: ".concat(e.getMessage()));
					this.logService.save(writeLogSATARL(consultaEmpresa.getEmpreForm(), new BigDecimal(parametro.getValor().trim()), consultaEmpresa.getId(), EstadosEnum.FALLIDO.getName(), "FAIL", authorization));
					estructurasIncorrectas.add(consultaEmpresa.getNumeroDocumentoEmpleador());
				}
			}

			ResponseContentExitFailDTO responseContentExitFailDTO = new ResponseContentExitFailDTO();
			responseContentExitFailDTO.setExito(documentosFull);
			responseContentExitFailDTO.setFail(estructurasIncorrectas);

			return responseContentExitFailDTO;
	}

    @ApiOperation(value = "Translada el empleador",  response = ResponseContentExitFailDTO.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Header con la autenticacion", paramType = "header", dataType = "string")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = ResponseContentExitFailDTO.class),
            @ApiResponse(code = 201, message = "Created", response = void.class),
            @ApiResponse(code = 400, message = "Bad Request", response = String.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = String.class),
            @ApiResponse(code = 401, message = "Forbidden", response = String.class),
            @ApiResponse(code = 404, message = "Not found", response = ErrorDTO.class),
            @ApiResponse(code = 500, message = "Failure", response = InternalServerErrorDTO.class),
    })
	@PostMapping(path = "/TrasladoEmpleador", consumes = "application/json", produces = "application/json")
	@ServiceConfig(protocol = "https", domain = "sisafitra.sispropreprod.gov.co", port = "8062",
			name = "TrasladoEmpleador", clientId = "ecf9cfbadbe046f8b33f372dbbca31cd",
			uri = "/TrasladoEmpleador", headers = {"Content-Type=application/json"},
			method = RequestMethod.POST)
	public Object trasladoEmpleador(@RequestHeader("Authorization") String authorization) throws MinSaludBusinessException {
		Object response = null;
		ParametroGeneral parametro = this.parametroGeneralService.getParametroGeneralParametroDocumento(SisafitraConstant.ParameroGeneralConstant.EMPRESA);
		for(TransladoEmpresaArl transladoEmpresaArl: this.transladoEmpresaService.getAll(EstadosEnum.EN_TRAMITE.getName(), EstadosEnum.FALLIDO.getName())) {
			try {
				Method method = new Object() {}.getClass().getEnclosingMethod();
				RequestBodyDTO request_body = PropertiesBuilder.getAnnotationFeatures(mapperBody(transladoEmpresaArl), method.getName(), this.getClass(), method.getParameterTypes());
				request_body.getHeaders().put(SisafitraConstant.AUTHORIZATION, authorization);
				response = super.responseFromPostRequestWithPossibleMappingError(request_body, ResponseMinSaludDTO.class);
				this.logService.save(writeLogSATARL(transladoEmpresaArl.getEmpre_form(), new BigDecimal(parametro.getValor().trim()), transladoEmpresaArl.getTransladoEmpresId(), EstadosEnum.EXITOSO.getName(), ((ResponseMinSaludDTO)response).getCodigo(), authorization));

			} catch (NoSuchMethodException e) {
				log.error("Configuracion @ServiceConfig invalida: ERROR: ".concat(e.getMessage()));
				assert response != null;
				this.logService.save(writeLogSATARL(transladoEmpresaArl.getEmpre_form(), new BigDecimal(parametro.getValor().trim()), transladoEmpresaArl.getTransladoEmpresId(), EstadosEnum.FALLIDO.getName(), ((ResponseMinSaludDTO)response).getCodigo(), authorization));
			} catch (IllegalAccessException | NoSuchFieldException e) {
				log.error("Response es invalido para el objeto ResponseMinSaludDTO: ERROR: ".concat(e.getMessage()));
				assert response != null;
				this.logService.save(writeLogSATARL(transladoEmpresaArl.getEmpre_form(), new BigDecimal(parametro.getValor().trim()), transladoEmpresaArl.getTransladoEmpresId(), EstadosEnum.FALLIDO.getName(), ((ResponseMinSaludDTO)response).getCodigo(), authorization));
			} catch (IOException e) {
				log.error("Error de conexion con el servicio: ERROR: ".concat(e.getMessage()));
				assert response != null;
				this.logService.save(writeLogSATARL(transladoEmpresaArl.getEmpre_form(), new BigDecimal(parametro.getValor().trim()), transladoEmpresaArl.getTransladoEmpresId(), EstadosEnum.FALLIDO.getName(), ((ResponseMinSaludDTO)response).getCodigo(), authorization));
			}
		}

		return response;
	}

    @ApiOperation(value = "Retractacion del translado del empleador",  response = ResponseContentExitFailDTO.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Header con la autenticacion", paramType = "header", dataType = "string")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = ResponseContentExitFailDTO.class),
            @ApiResponse(code = 201, message = "Created", response = void.class),
            @ApiResponse(code = 400, message = "Bad Request", response = String.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = String.class),
            @ApiResponse(code = 401, message = "Forbidden", response = String.class),
            @ApiResponse(code = 404, message = "Not found", response = ErrorDTO.class),
            @ApiResponse(code = 500, message = "Failure", response = InternalServerErrorDTO.class),
    })
	@PostMapping(path = "/RetractoTrasladoEmpleador", consumes = "application/json", produces = "application/json")
	@ServiceConfig(protocol = "https", domain = "sisafitra.sispropreprod.gov.co", port = "8062",
			name = "RetractoTrasladoEmpleador", clientId = "13d29ae635514990810dd2c6ec54e6ea",
			uri = "/RetractoTrasladoEmpleador", headers = {"Content-Type=application/json"},
			method = RequestMethod.POST)
	public Object retractoTrasladoEmpleador(@RequestHeader("Authorization") String authorization) throws MinSaludBusinessException {
		Object response = null;
		ParametroGeneral parametro = this.parametroGeneralService.getParametroGeneralParametroDocumento(SisafitraConstant.ParameroGeneralConstant.EMPRESA);
		for(Retractacion retractacion: this.retractionService.getAll(EstadosEnum.EN_TRAMITE.getName(), EstadosEnum.FALLIDO.getName()))
		{
			try {
				Method method = new Object() {}.getClass().getEnclosingMethod();
				RequestBodyDTO request_body = PropertiesBuilder.getAnnotationFeatures(mapperBody(retractacion), method.getName(), this.getClass(), method.getParameterTypes());
				request_body.getHeaders().put(SisafitraConstant.AUTHORIZATION, authorization);
				response = super.responseFromPostRequestWithPossibleMappingError(request_body, ResponseMinSaludDTO.class);
				this.logService.save(writeLogSATARL(retractacion.getEmpre_form(), new BigDecimal(parametro.getValor().trim()), retractacion.getRetractacionId(), EstadosEnum.EXITOSO.getName(),((ResponseMinSaludDTO)response).getCodigo(), authorization));

			} catch (NoSuchMethodException e) {
				log.error("Configuracion @ServiceConfig invalida: ERROR: ".concat(e.getMessage()));
				assert response != null;
				this.logService.save(writeLogSATARL(retractacion.getEmpre_form(), new BigDecimal(parametro.getValor().trim()), retractacion.getRetractacionId(), EstadosEnum.FALLIDO.getName(), ((ResponseMinSaludDTO)response).getCodigo(), authorization));
			} catch (IllegalAccessException | NoSuchFieldException e) {
				log.error("Response es invalido para el objeto ResponseMinSaludDTO: ERROR: ".concat(e.getMessage()));
				assert response != null;
				this.logService.save(writeLogSATARL(retractacion.getEmpre_form(), new BigDecimal(parametro.getValor().trim()), retractacion.getRetractacionId(), EstadosEnum.FALLIDO.getName(), ((ResponseMinSaludDTO)response).getCodigo(), authorization));
			} catch (IOException e) {
				log.error("Error de conexion con el servicio: ERROR: ".concat(e.getMessage()));
				assert response != null;
				this.logService.save(writeLogSATARL(retractacion.getEmpre_form(), new BigDecimal(parametro.getValor().trim()), retractacion.getRetractacionId(), EstadosEnum.FALLIDO.getName(), ((ResponseMinSaludDTO)response).getCodigo(), authorization));
			}
		}


		return response;
	}

    @ApiOperation(value = "Retiro definitivo SGRL",  response = ResponseContentExitFailDTO.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Header con la autenticacion", paramType = "header", dataType = "string")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = ResponseContentExitFailDTO.class),
            @ApiResponse(code = 201, message = "Created", response = void.class),
            @ApiResponse(code = 400, message = "Bad Request", response = String.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = String.class),
            @ApiResponse(code = 401, message = "Forbidden", response = String.class),
            @ApiResponse(code = 404, message = "Not found", response = ErrorDTO.class),
            @ApiResponse(code = 500, message = "Failure", response = InternalServerErrorDTO.class),
    })
	@PostMapping(path = "/RetiroDefinitivoEmpresaSGRL", consumes = "application/json", produces = "application/json")
	@ServiceConfig(protocol = "https", domain = "sisafitra.sispropreprod.gov.co", port = "8062",
			name = "RetiroDefinitivoEmpresaSGRL", clientId = "697a4eff67b24efb8714e512bda5c818",
			uri = "/RetiroDefinitivoEmpresaSGRL", headers = {"Content-Type=application/json"},
			method = RequestMethod.POST)
	public Object retiroDefinitivoEmpresaSGRL(@RequestHeader("Authorization") String authorization) throws MinSaludBusinessException {
		Object response = null;
		ParametroGeneral parametro = this.parametroGeneralService.getParametroGeneralParametroDocumento(SisafitraConstant.ParameroGeneralConstant.EMPRESA);
		for(RetiroDefinitivoSGRL retiroDefinitivoSGRL: this.retiroDefinitivoService.getAll()) {
			try {
				Method method = new Object() {}.getClass().getEnclosingMethod();
				RequestBodyDTO request_body = PropertiesBuilder.getAnnotationFeatures(mapperBody(retiroDefinitivoSGRL), method.getName(), this.getClass(), method.getParameterTypes());
				request_body.getHeaders().put(SisafitraConstant.AUTHORIZATION, authorization);
				response =  super.responseFromPostRequest(request_body, ResponseMinSaludDTO.class);
				this.logService.save(writeLogSATARL(retiroDefinitivoSGRL.getEmpreId(), new BigDecimal(parametro.getValor().trim()), retiroDefinitivoSGRL.getId(), EstadosEnum.EXITOSO.getName(), ((ResponseMinSaludDTO)response).getCodigo(), authorization));

			} catch (NoSuchMethodException e) {
				log.error("Configuracion @ServiceConfig invalida: ERROR: ".concat(e.getMessage()));
				assert response != null;
				this.logService.save(writeLogSATARL(retiroDefinitivoSGRL.getEmpreId(), new BigDecimal(parametro.getValor().trim()), retiroDefinitivoSGRL.getId(), EstadosEnum.FALLIDO.getName(), ((ResponseMinSaludDTO)response).getCodigo(), authorization));
			} catch (IllegalAccessException | NoSuchFieldException e) {
				log.error("Response es invalido para el objeto ResponseMinSaludDTO: ERROR: ".concat(e.getMessage()));
				assert response != null;
				this.logService.save(writeLogSATARL(retiroDefinitivoSGRL.getEmpreId(), new BigDecimal(parametro.getValor().trim()), retiroDefinitivoSGRL.getId(), EstadosEnum.FALLIDO.getName(), ((ResponseMinSaludDTO)response).getCodigo(), authorization));
			} catch (IOException e) {
				log.error("Error de conexion con el servicio: ERROR: ".concat(e.getMessage()));
				assert response != null;
				this.logService.save(writeLogSATARL(retiroDefinitivoSGRL.getEmpreId(), new BigDecimal(parametro.getValor().trim()), retiroDefinitivoSGRL.getId(), EstadosEnum.FALLIDO.getName(), ((ResponseMinSaludDTO)response).getCodigo(), authorization));
			}
		}

		return response;
	}

    @ApiOperation(value = "Novedades sedes",  response = ResponseContentExitFailDTO.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Header con la autenticacion", paramType = "header", dataType = "string")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = ResponseContentExitFailDTO.class),
            @ApiResponse(code = 201, message = "Created", response = void.class),
            @ApiResponse(code = 400, message = "Bad Request", response = String.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = String.class),
            @ApiResponse(code = 401, message = "Forbidden", response = String.class),
            @ApiResponse(code = 404, message = "Not found", response = ErrorDTO.class),
            @ApiResponse(code = 500, message = "Failure", response = InternalServerErrorDTO.class),
    })
	@PostMapping(path = "/NovedadesSedes", consumes = "application/json", produces = "application/json")
	@ServiceConfig(protocol = "https", domain = "sisafitra.sispropreprod.gov.co", port = "8062",
			name = "NovedadesSedes", clientId = "f45d4049f9a44f839e692f2ca331ec77",
			uri = "/NovedadesSedes", headers = {"Content-Type=application/json"},
			method = RequestMethod.POST)
	public Object novedadesSedes(String authorization, String entity_body)
	{
		Object response = null;
		try
		{
			//ParametroGeneral parametro = this.parametroGeneralService.getParametroGeneralParametroDocumento(SisafitraConstant.ParameroGeneralConstant.EMPRESA);
			Method method = new Object() {}.getClass().getEnclosingMethod();
			RequestBodyDTO request_body = PropertiesBuilder.getAnnotationFeatures(entity_body, method.getName(), this.getClass(), method.getParameterTypes());
			request_body.getHeaders().put(SisafitraConstant.AUTHORIZATION, authorization);
			response = super.responseFromPostRequest(request_body, ResponseMinSaludDTO.class);

		} catch (NoSuchMethodException e)
		{
			log.error("Configuracion @ServiceConfig invalida: ERROR: ".concat(e.getMessage()));
		}catch (IllegalAccessException | NoSuchFieldException e)
		{
			log.error("Response es invalido para el objeto ResponseMinSaludDTO: ERROR: ".concat(e.getMessage()));
		} catch (IOException e)
		{
			log.error("Error de conexion con el servicio: ERROR: ".concat(e.getMessage()));
		}


		return response;
	}

    @ApiOperation(value = "Novedades centro de trabajo",  response = ResponseContentExitFailDTO.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Header con la autenticacion", paramType = "header", dataType = "string")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = ResponseContentExitFailDTO.class),
            @ApiResponse(code = 201, message = "Created", response = void.class),
            @ApiResponse(code = 400, message = "Bad Request", response = String.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = String.class),
            @ApiResponse(code = 401, message = "Forbidden", response = String.class),
            @ApiResponse(code = 404, message = "Not found", response = ErrorDTO.class),
            @ApiResponse(code = 500, message = "Failure", response = InternalServerErrorDTO.class),
    })
	@PostMapping(path = "/NovedadesCentroTrabajo", consumes = "application/json", produces = "application/json")
	@ServiceConfig(protocol = "https", domain = "sisafitra.sispropreprod.gov.co", port = "8062",
			name = "NovedadesCentroTrabajo", clientId = "f0dccc17a4b84772848fd5f3efe20f4b",
			uri = "/NovedadesCentroTrabajo", headers = {"Content-Type=application/json"},
			method = RequestMethod.POST)
	public Object novedadesCentroTrabajo(String authorization, String entity_body)
	{
		Object response = null;
		//ParametroGeneral parametro = this.parametroGeneralService.getParametroGeneralParametroDocumento(SisafitraConstant.ParameroGeneralConstant.EMPRESA);
		try
		{
			Method method = new Object() {}.getClass().getEnclosingMethod();
			RequestBodyDTO request_body = PropertiesBuilder.getAnnotationFeatures(entity_body, method.getName(), this.getClass(), method.getParameterTypes());
			request_body.getHeaders().put(SisafitraConstant.AUTHORIZATION, authorization);
			response = super.responseFromPostRequest(request_body, ResponseMinSaludDTO.class);

		} catch (NoSuchMethodException e)
		{
			log.error("Configuracion @ServiceConfig invalida: ERROR: ".concat(e.getMessage()));
		}catch (IllegalAccessException | NoSuchFieldException e)
		{
			log.error("Response es invalido para el objeto ResponseMinSaludDTO: ERROR: ".concat(e.getMessage()));
		} catch (IOException e)
		{
			log.error("Error de conexion con el servicio: ERROR: ".concat(e.getMessage()));
		}


		return response;
	}

    @ApiOperation(value = "Reclasificacion de centro de trabajo",  response = ResponseContentExitFailDTO.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Header con la autenticacion", paramType = "header", dataType = "string")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = ResponseContentExitFailDTO.class),
            @ApiResponse(code = 201, message = "Created", response = void.class),
            @ApiResponse(code = 400, message = "Bad Request", response = String.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = String.class),
            @ApiResponse(code = 401, message = "Forbidden", response = String.class),
            @ApiResponse(code = 404, message = "Not found", response = ErrorDTO.class),
            @ApiResponse(code = 500, message = "Failure", response = InternalServerErrorDTO.class),
    })
	@PostMapping(path = "/ReclasificacionCentroTrabajo", consumes = "application/json", produces = "application/json")
	@ServiceConfig(protocol = "https", domain = "sisafitra.sispropreprod.gov.co", port = "8062",
			name = "ReclasificacionCentroTrabajo", clientId = "a1829924eb1642a2adbe48799a905e55",
			uri = "/ReclasificacionCentroTrabajo", headers = {"Content-Type=application/json"},
			method = RequestMethod.POST)
	public Object reclasificacionCentroTrabajo(@RequestHeader("Authorization") String authorization) throws MinSaludBusinessException {
		Object response = null;
		ParametroGeneral parametro = this.parametroGeneralService.getParametroGeneralParametroDocumento(SisafitraConstant.ParameroGeneralConstant.EMPRESA);

		for (ReclasificacionCentroTrabajo reclasificacionCentroTrabajo : this.reclasificacionCentroTrabajoService.getAll()) {
				try {
					Method method = new Object() {}.getClass().getEnclosingMethod();
					RequestBodyDTO request_body = PropertiesBuilder.getAnnotationFeatures(mapperBody(reclasificacionCentroTrabajo), method.getName(), this.getClass(), method.getParameterTypes());
					request_body.getHeaders().put(SisafitraConstant.AUTHORIZATION, authorization);
					response = super.responseFromPostRequest(request_body, ResponseMinSaludDTO.class);
					this.logService.save(writeLogSATARL(reclasificacionCentroTrabajo.getEmpleid(), reclasificacionCentroTrabajo.getId(), reclasificacionCentroTrabajo.getId(), EstadosEnum.EXITOSO.getName(), "OK", authorization));
				} catch (NoSuchMethodException e) {
					log.error("Configuracion @ServiceConfig invalida: ERROR: ".concat(e.getMessage()));
					this.logService.save(writeLogSATARL(reclasificacionCentroTrabajo.getEmpleid(), reclasificacionCentroTrabajo.getId(), reclasificacionCentroTrabajo.getId(), EstadosEnum.FALLIDO.getName(), ((ErrorDTO) response).getError_description(), authorization));
				} catch (IllegalAccessException | NoSuchFieldException e) {
					log.error("Response es invalido para el objeto ResponseMinSaludDTO: ERROR: ".concat(e.getMessage()));
					this.logService.save(writeLogSATARL(reclasificacionCentroTrabajo.getEmpleid(), reclasificacionCentroTrabajo.getId(), reclasificacionCentroTrabajo.getId(), EstadosEnum.FALLIDO.getName(), ((ErrorDTO) response).getError_description(), authorization));
				} catch (IOException e) {
					log.error("Error de conexion con el servicio: ERROR: ".concat(e.getMessage()));
					this.logService.save(writeLogSATARL(reclasificacionCentroTrabajo.getEmpleid(), reclasificacionCentroTrabajo.getId(), reclasificacionCentroTrabajo.getId(), EstadosEnum.FALLIDO.getName(), ((ErrorDTO) response).getError_description(), authorization));
				}

			}

		return response;
	}

    @ApiOperation(value = "Novedades transitorias",  response = ResponseContentExitFailDTO.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Header con la autenticacion", paramType = "header", dataType = "string")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = ResponseContentExitFailDTO.class),
            @ApiResponse(code = 201, message = "Created", response = void.class),
            @ApiResponse(code = 400, message = "Bad Request", response = String.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = String.class),
            @ApiResponse(code = 401, message = "Forbidden", response = String.class),
            @ApiResponse(code = 404, message = "Not found", response = ErrorDTO.class),
            @ApiResponse(code = 500, message = "Failure", response = InternalServerErrorDTO.class),
    })
	@PostMapping(path = "/NovedadesTransitorias", consumes = "application/json", produces = "application/json")
	@ServiceConfig(protocol = "https", domain = "sisafitra.sispropreprod.gov.co", port = "8062",
			name = "NovedadesTransitorias", clientId = "6ff4b98c8c22497b9c1d7d7eb5c94644",
			uri = "/NovedadesTransitorias", headers = {"Content-Type=application/json"},
			method = RequestMethod.POST)
	public Object novedadesTransitorias(String authorization, String entity_body)
	{
		Object response = null;
		//ParametroGeneral parametro = this.parametroGeneralService.getParametroGeneralParametroDocumento(SisafitraConstant.ParameroGeneralConstant.EMPRESA);
		try
		{
			Method method = new Object() {}.getClass().getEnclosingMethod();
			RequestBodyDTO request_body = PropertiesBuilder.getAnnotationFeatures(entity_body, method.getName(), this.getClass(), method.getParameterTypes());
			request_body.getHeaders().put(SisafitraConstant.AUTHORIZATION, authorization);
			response = super.responseFromPostRequest(request_body, ResponseMinSaludDTO.class);

		} catch (NoSuchMethodException e)
		{
			log.error("Configuracion @ServiceConfig invalida: ERROR: ".concat(e.getMessage()));
		}catch (IllegalAccessException | NoSuchFieldException e)
		{
			log.error("Response es invalido para el objeto ResponseMinSaludDTO: ERROR: ".concat(e.getMessage()));
		} catch (IOException e)
		{
			log.error("Error de conexion con el servicio: ERROR: ".concat(e.getMessage()));
		}


		return response;
	}

    @ApiOperation(value = "Modificacion IBC",  response = ResponseContentExitFailDTO.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Header con la autenticacion", paramType = "header", dataType = "string")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = ResponseContentExitFailDTO.class),
            @ApiResponse(code = 201, message = "Created", response = void.class),
            @ApiResponse(code = 400, message = "Bad Request", response = String.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = String.class),
            @ApiResponse(code = 401, message = "Forbidden", response = String.class),
            @ApiResponse(code = 404, message = "Not found", response = ErrorDTO.class),
            @ApiResponse(code = 500, message = "Failure", response = InternalServerErrorDTO.class),
    })
	@PostMapping(path = "/ModificacionIBC", consumes = "application/json", produces = "application/json")
	@ServiceConfig(protocol = "https", domain = "sisafitra.sispropreprod.gov.co", port = "8062",
			name = "ModificacionIBC", clientId = "83d16bb59dc548cb8a75bc43c8da68c6",
			uri = "/ModificacionIBC", headers = {"Content-Type=application/json"},
			method = RequestMethod.POST)
	public Object modificacionIBC(String authorization, String entity_body)
	{
		Object response = null;
		//ParametroGeneral parametro = this.parametroGeneralService.getParametroGeneralParametroDocumento(SisafitraConstant.ParameroGeneralConstant.EMPRESA);
		try
		{
			Method method = new Object() {}.getClass().getEnclosingMethod();
			RequestBodyDTO request_body = PropertiesBuilder.getAnnotationFeatures(entity_body, method.getName(), this.getClass(), method.getParameterTypes());
			request_body.getHeaders().put(SisafitraConstant.AUTHORIZATION, authorization);
			response = super.responseFromPostRequest(request_body, ResponseMinSaludDTO.class);

		} catch (NoSuchMethodException e)
		{
			log.error("Configuracion @ServiceConfig invalida: ERROR: ".concat(e.getMessage()));
		}catch (IllegalAccessException | NoSuchFieldException e)
		{
			log.error("Response es invalido para el objeto ResponseMinSaludDTO: ERROR: ".concat(e.getMessage()));
		} catch (IOException e)
		{
			log.error("Error de conexion con el servicio: ERROR: ".concat(e.getMessage()));
		}

		return response;
	}
	
}
