package app;

import java.io.IOException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import annotation.ServiceConfig;
import builder.PropertiesBuilder;
import com.google.gson.Gson;
import controller.BaseController;
import dto.*;
import entities.AfiliacionEmpresa;
import enums.EstadosEnum;
import exception.MinSaludBusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.AfiliacionService;
import singleton.ConfiguracionSingleton;
import utils.SisafitraConstant;

@RestController
@RequestMapping("/")
public class Controller extends BaseController
{
	private AfiliacionService afiliacionService;
	public Controller()
	{
		ConfiguracionSingleton.getInstance();
		this.afiliacionService = new AfiliacionService();
	}

	Logger log = LoggerFactory.getLogger(this.getClass().getName());

	@PostMapping(path = "/token", consumes = "application/x-www-form-urlencoded", produces = "application/json")
	@ServiceConfig(protocol = "https", domain = "sisafitra.sispropreprod.gov.co", port = "8062",
			name = "Token", clientId = "9160f6412fad4b7fbc5f86d37a8dd680",
			uri = "/token", headers = {"Content-Type=application/x-www-form-urlencoded"},
			params = {"username=830008686", "password=830008686", "grant_type=password",
					"client_id=9160f6412fad4b7fbc5f86d37a8dd680"},
			method = RequestMethod.POST)
	public TokenDTO token()
	{
		TokenDTO response = null;
		log.info("Token init");
		try
		{
			Method method = new Object() {}.getClass().getEnclosingMethod();
			RequestFormPostDTO request_body = PropertiesBuilder.getAnnotationFeatures(method.getName(), this.getClass());
			log.info("Token request: ".concat(request_body.toString()));
			response = (TokenDTO) super.responseFromPostFormRequest(request_body, TokenDTO.class);
			log.info("Token response: ".concat(response.toString()));
			ConfiguracionSingleton.getInstance().setToken(response);
			ConfiguracionSingleton.getInstance().setAuthorization(SisafitraConstant.BEARER.concat(response.getAccess_token()));
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

	@PostMapping(path = "/AfiliacionARL", consumes = "application/json", produces = "application/json")
	@ServiceConfig(protocol = "https", domain = "sisafitra.sispropreprod.gov.co", port = "8062",
			name = "AfiliacionARL", clientId = "f45d4049f9a44f839e692f2ca331ec77",
			uri = "/AfiliacionARL", headers = {"Content-Type=application/json"},
			method = RequestMethod.POST)
	public Object afiliacionARL(String authorization)
	{
		try
		{
			Method method = new Object() {}.getClass().getEnclosingMethod();
			int correctos = 0, incorrectos= 0;
			List<AfiliacionEmpresa> afiliaciones = this.afiliacionService.afiliacionPorEstado(EstadosEnum.FALLIDO.name(), EstadosEnum.EN_TRAMITE.name());
			for(AfiliacionEmpresa afiliacion: afiliaciones)
			{
				Gson gson = new Gson();
				RequestBodyDTO request_body = PropertiesBuilder.getAnnotationFeatures(gson.toJson(afiliacion), method.getName(), this.getClass(), method.getParameterTypes());
				request_body.getHeaders().put(SisafitraConstant.AUTHORIZATION, authorization == null ? ConfiguracionSingleton.getInstance().getAuthorization() : authorization);
                ResponseMinSaludDTO response = (ResponseMinSaludDTO) super.responseFromPostRequest(request_body, ResponseMinSaludDTO.class);
				afiliacion.setEstadoMin(new BigDecimal(2));
				this.afiliacionService.add(afiliacion);
			}

            AfiliacionResponseDTO response = new AfiliacionResponseDTO();
			response.setCorrectos(correctos);
			response.setIncorrecto(incorrectos);
			response.setTotal(afiliaciones.size());

			return response;

		}catch (NoSuchMethodException e)
		{
			log.error("Configuracion @ServiceConfig invalida: ERROR: ".concat(e.getMessage()));
		}catch (IllegalAccessException | NoSuchFieldException e)
		{
			log.error("Response es invalido para el objeto ResponseMinSaludDTO: ERROR: ".concat(e.getMessage()));
		} catch (IOException e)
		{
			log.error("Error de conexion con el servicio: ERROR: ".concat(e.getMessage()));
		} catch (MinSaludBusinessException e)
		{
			log.error("Error de negocio. ERROR: ".concat(e.getMessage()));
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}

        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@PostMapping(path = "/InicioRelacionLaboralARL", consumes = "application/json", produces = "application/json")
	@ServiceConfig(protocol = "https", domain = "sisafitra.sispropreprod.gov.co", port = "8062",
			name = "InicioRelacionLaboralARL", clientId = "37cf0135c6c5408eb474a8ac0cdd11f2",
			uri = "/InicioRelacionLaboralARL", headers = {"Content-Type=application/json"},
			method = RequestMethod.POST)
	public ResponseMinSaludDTO inicioRelacionLaboralARL(String authorization, String entity_body)
	{
		ResponseMinSaludDTO response = null;
		try
		{
			Method method = new Object() {}.getClass().getEnclosingMethod();
			RequestBodyDTO request_body = PropertiesBuilder.getAnnotationFeatures(entity_body, method.getName(), this.getClass(), method.getParameterTypes());
			request_body.getHeaders().put(SisafitraConstant.AUTHORIZATION, authorization == null ? ConfiguracionSingleton.getInstance().getAuthorization() : authorization);
			response = (ResponseMinSaludDTO) super.responseFromPostRequest(request_body, ResponseMinSaludDTO.class);

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

	@PostMapping(path = "/TerminacionRelacionLaboralARL", consumes = "application/json", produces = "application/json")
	@ServiceConfig(protocol = "https", domain = "sisafitra.sispropreprod.gov.co", port = "8062",
			name = "TerminacionRelacionLaboralARL", clientId = "b09ba3fd1e1e4f05a05daf36bab5a552",
			uri = "/TerminacionRelacionLaboralARL", headers = {"Content-Type=application/json"},
			method = RequestMethod.POST)
	public ResponseMinSaludDTO terminacionRelacionLaboralARL(String authorization, String entity_body)
	{
		ResponseMinSaludDTO response = null;
		try
		{
			Method method = new Object() {}.getClass().getEnclosingMethod();
			RequestBodyDTO request_body = PropertiesBuilder.getAnnotationFeatures(entity_body, method.getName(), this.getClass(), method.getParameterTypes());
			request_body.getHeaders().put(SisafitraConstant.AUTHORIZATION, authorization == null ? ConfiguracionSingleton.getInstance().getAuthorization() : authorization);
			response = (ResponseMinSaludDTO) super.responseFromPostRequest(request_body, ResponseMinSaludDTO.class);

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

	@GetMapping(path = "/ConsultaEmpresaTrasladada", consumes = "application/json", produces = "application/json")
	@ServiceConfig(protocol = "https", domain = "sisafitra.sispropreprod.gov.co", port = "8062",
			name = "ConsultaEmpresaTrasladada", clientId = "147171ef46c44b41b77b2aaac10ae39b",
			uri = "/ConsultaEmpresaTrasladada", headers = {"Content-Type=application/json"},
			method = RequestMethod.GET)
	public ResponseMinSaludDTO consultaEmpresa(String authorization, String entity_body)
	{
		ResponseMinSaludDTO response = null;
		try
		{
			Method method = new Object() {}.getClass().getEnclosingMethod();
			RequestBodyDTO request_body = PropertiesBuilder.getAnnotationFeatures(entity_body, method.getName(), this.getClass(), method.getParameterTypes());
			request_body.getHeaders().put(SisafitraConstant.AUTHORIZATION, authorization == null ? ConfiguracionSingleton.getInstance().getAuthorization() : authorization);
			response = (ResponseMinSaludDTO) super.responseFromPostRequest(request_body, ResponseMinSaludDTO.class);

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

	@GetMapping(path = "/ConsultaEstructuraEmpresa", consumes = "application/json", produces = "application/json")
	@ServiceConfig(protocol = "https", domain = "sisafitra.sispropreprod.gov.co", port = "8062",
			name = "ConsultaEstructuraEmpresa", clientId = "d99d20985fde4150b924c8d0177691b6",
			uri = "/ConsultaEstructuraEmpresa", headers = {"Content-Type=application/json"},
			method = RequestMethod.GET)
	public ResponseMinSaludDTO consultaEstructuraEmpresa(String authorization, String entity_body)
	{
		ResponseMinSaludDTO response = null;
		try
		{
			Method method = new Object() {}.getClass().getEnclosingMethod();
			RequestBodyDTO request_body = PropertiesBuilder.getAnnotationFeatures(entity_body, method.getName(), this.getClass(), method.getParameterTypes());
			request_body.getHeaders().put(SisafitraConstant.AUTHORIZATION, authorization == null ? ConfiguracionSingleton.getInstance().getAuthorization() : authorization);
			response = (ResponseMinSaludDTO) super.responseFromPostRequest(request_body, ResponseMinSaludDTO.class);

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

	@PostMapping(path = "/TrasladoEmpleador", consumes = "application/json", produces = "application/json")
	@ServiceConfig(protocol = "https", domain = "sisafitra.sispropreprod.gov.co", port = "8062",
			name = "TrasladoEmpleador", clientId = "ecf9cfbadbe046f8b33f372dbbca31cd",
			uri = "/TrasladoEmpleador", headers = {"Content-Type=application/json"},
			method = RequestMethod.POST)
	public ResponseMinSaludDTO trasladoEmpleador(String authorization, String entity_body)
	{
		ResponseMinSaludDTO response = null;
		try
		{
			Method method = new Object() {}.getClass().getEnclosingMethod();
			RequestBodyDTO request_body = PropertiesBuilder.getAnnotationFeatures(entity_body, method.getName(), this.getClass(), method.getParameterTypes());
			request_body.getHeaders().put(SisafitraConstant.AUTHORIZATION, authorization == null ? ConfiguracionSingleton.getInstance().getAuthorization() : authorization);
			response = (ResponseMinSaludDTO) super.responseFromPostRequest(request_body, ResponseMinSaludDTO.class);

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

	@PostMapping(path = "/RetractoTrasladoEmpleador", consumes = "application/json", produces = "application/json")
	@ServiceConfig(protocol = "https", domain = "sisafitra.sispropreprod.gov.co", port = "8062",
			name = "RetractoTrasladoEmpleador", clientId = "13d29ae635514990810dd2c6ec54e6ea",
			uri = "/RetractoTrasladoEmpleador", headers = {"Content-Type=application/json"},
			method = RequestMethod.POST)
	public ResponseMinSaludDTO retractoTrasladoEmpleador(String authorization, String entity_body)
	{
		ResponseMinSaludDTO response = null;
		try
		{
			Method method = new Object() {}.getClass().getEnclosingMethod();
			RequestBodyDTO request_body = PropertiesBuilder.getAnnotationFeatures(entity_body, method.getName(), this.getClass(), method.getParameterTypes());
			request_body.getHeaders().put(SisafitraConstant.AUTHORIZATION, authorization == null ? ConfiguracionSingleton.getInstance().getAuthorization() : authorization);
			response = (ResponseMinSaludDTO) super.responseFromPostRequest(request_body, ResponseMinSaludDTO.class);

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

	@PostMapping(path = "/RetiroDefinitivoEmpresaSGRL", consumes = "application/json", produces = "application/json")
	@ServiceConfig(protocol = "https", domain = "sisafitra.sispropreprod.gov.co", port = "8062",
			name = "RetiroDefinitivoEmpresaSGRL", clientId = "697a4eff67b24efb8714e512bda5c818",
			uri = "/RetiroDefinitivoEmpresaSGRL", headers = {"Content-Type=application/json"},
			method = RequestMethod.POST)
	public ResponseMinSaludDTO retiroDefinitivoEmpresaSGRL(String authorization, String entity_body)
	{
		ResponseMinSaludDTO response = null;
		try
		{
			Method method = new Object() {}.getClass().getEnclosingMethod();
			RequestBodyDTO request_body = PropertiesBuilder.getAnnotationFeatures(entity_body, method.getName(), this.getClass(), method.getParameterTypes());
			request_body.getHeaders().put(SisafitraConstant.AUTHORIZATION, authorization == null ? ConfiguracionSingleton.getInstance().getAuthorization() : authorization);
			response = (ResponseMinSaludDTO) super.responseFromPostRequest(request_body, ResponseMinSaludDTO.class);

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

	@PostMapping(path = "/NovedadesSedes", consumes = "application/json", produces = "application/json")
	@ServiceConfig(protocol = "https", domain = "sisafitra.sispropreprod.gov.co", port = "8062",
			name = "NovedadesSedes", clientId = "f45d4049f9a44f839e692f2ca331ec77",
			uri = "/NovedadesSedes", headers = {"Content-Type=application/json"},
			method = RequestMethod.POST)
	public ResponseMinSaludDTO novedadesSedes(String authorization, String entity_body)
	{
		ResponseMinSaludDTO response = null;
		try
		{
			Method method = new Object() {}.getClass().getEnclosingMethod();
			RequestBodyDTO request_body = PropertiesBuilder.getAnnotationFeatures(entity_body, method.getName(), this.getClass(), method.getParameterTypes());
			request_body.getHeaders().put(SisafitraConstant.AUTHORIZATION, authorization == null ? ConfiguracionSingleton.getInstance().getAuthorization() : authorization);
			response = (ResponseMinSaludDTO) super.responseFromPostRequest(request_body, ResponseMinSaludDTO.class);

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

	@PostMapping(path = "/NovedadesCentroTrabajo", consumes = "application/json", produces = "application/json")
	@ServiceConfig(protocol = "https", domain = "sisafitra.sispropreprod.gov.co", port = "8062",
			name = "NovedadesCentroTrabajo", clientId = "f0dccc17a4b84772848fd5f3efe20f4b",
			uri = "/NovedadesCentroTrabajo", headers = {"Content-Type=application/json"},
			method = RequestMethod.POST)
	public ResponseMinSaludDTO novedadesCentroTrabajo(String authorization, String entity_body)
	{
		ResponseMinSaludDTO response = null;
		try
		{
			Method method = new Object() {}.getClass().getEnclosingMethod();
			RequestBodyDTO request_body = PropertiesBuilder.getAnnotationFeatures(entity_body, method.getName(), this.getClass(), method.getParameterTypes());
			request_body.getHeaders().put(SisafitraConstant.AUTHORIZATION, authorization == null ? ConfiguracionSingleton.getInstance().getAuthorization() : authorization);
			response = (ResponseMinSaludDTO) super.responseFromPostRequest(request_body, ResponseMinSaludDTO.class);

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

	@PostMapping(path = "/ReclasificacionCentroTrabajo", consumes = "application/json", produces = "application/json")
	@ServiceConfig(protocol = "https", domain = "sisafitra.sispropreprod.gov.co", port = "8062",
			name = "ReclasificacionCentroTrabajo", clientId = "a1829924eb1642a2adbe48799a905e55",
			uri = "/ReclasificacionCentroTrabajo", headers = {"Content-Type=application/json"},
			method = RequestMethod.POST)
	public ResponseMinSaludDTO reclasificacionCentroTrabajo(String authorization, String entity_body)
	{
		ResponseMinSaludDTO response = null;
		try
		{
			Method method = new Object() {}.getClass().getEnclosingMethod();
			RequestBodyDTO request_body = PropertiesBuilder.getAnnotationFeatures(entity_body, method.getName(), this.getClass(), method.getParameterTypes());
			request_body.getHeaders().put(SisafitraConstant.AUTHORIZATION, authorization == null ? ConfiguracionSingleton.getInstance().getAuthorization() : authorization);
			response = (ResponseMinSaludDTO) super.responseFromPostRequest(request_body, ResponseMinSaludDTO.class);

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

	@PostMapping(path = "/NovedadesTransitorias", consumes = "application/json", produces = "application/json")
	@ServiceConfig(protocol = "https", domain = "sisafitra.sispropreprod.gov.co", port = "8062",
			name = "NovedadesTransitorias", clientId = "6ff4b98c8c22497b9c1d7d7eb5c94644",
			uri = "/NovedadesTransitorias", headers = {"Content-Type=application/json"},
			method = RequestMethod.POST)
	public ResponseMinSaludDTO novedadesTransitorias(String authorization, String entity_body)
	{
		ResponseMinSaludDTO response = null;
		try
		{
			Method method = new Object() {}.getClass().getEnclosingMethod();
			RequestBodyDTO request_body = PropertiesBuilder.getAnnotationFeatures(entity_body, method.getName(), this.getClass(), method.getParameterTypes());
			request_body.getHeaders().put(SisafitraConstant.AUTHORIZATION, authorization == null ? ConfiguracionSingleton.getInstance().getAuthorization() : authorization);
			response = (ResponseMinSaludDTO) super.responseFromPostRequest(request_body, ResponseMinSaludDTO.class);

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

	@PostMapping(path = "/ModificacionIBC", consumes = "application/json", produces = "application/json")
	@ServiceConfig(protocol = "https", domain = "sisafitra.sispropreprod.gov.co", port = "8062",
			name = "ModificacionIBC", clientId = "83d16bb59dc548cb8a75bc43c8da68c6",
			uri = "/ModificacionIBC", headers = {"Content-Type=application/json"},
			method = RequestMethod.POST)
	public ResponseMinSaludDTO modificacionIBC(String authorization, String entity_body)
	{
		ResponseMinSaludDTO response = null;
		try
		{
			Method method = new Object() {}.getClass().getEnclosingMethod();
			RequestBodyDTO request_body = PropertiesBuilder.getAnnotationFeatures(entity_body, method.getName(), this.getClass(), method.getParameterTypes());
			request_body.getHeaders().put(SisafitraConstant.AUTHORIZATION, authorization == null ? ConfiguracionSingleton.getInstance().getAuthorization() : authorization);
			response = (ResponseMinSaludDTO) super.responseFromPostRequest(request_body, ResponseMinSaludDTO.class);

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
