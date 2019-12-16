package app;

import builder.PropertiesBuilder;
import controller.BaseController;
import controllerentity.ServicioAfiliacionControllerEntity;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.springframework.web.bind.annotation.*;
import utils.PropertiesSingleton;
import utils.Contants;

import java.io.IOException;
import java.util.Map;


@RestController
public class Controller extends BaseController
{
	public Controller()
	{
		PropertiesSingleton.getInstance().readUrlProperties();
		PropertiesSingleton.getInstance().readClientIdProperties();
	}
	
	@RequestMapping(value = "/token", method = RequestMethod.POST)
	public String index(@RequestHeader(name = "username", required = true) String username,  @RequestHeader(name = "password", required = true) String password, 
	                    @RequestHeader(name = "grant_type", required = true) String grant_type, @RequestHeader(name = "client_id", required = true) String client_id) {
		return "Greetings from Spring Boot!";
	}

	@RequestMapping(value = "/ServicioAfiliacion", headers = "Content-Type=application/json", method = RequestMethod.POST)
	public HttpEntity servicioAfiliacion(@RequestHeader(name = "Authorization", required = true) String authorization, @RequestBody ServicioAfiliacionControllerEntity entity_body)
	{
		CloseableHttpResponse response = null;
		try
		{
			String url = PropertiesBuilder.buildUrl(PropertiesSingleton.getInstance().getUrlProperties(), Contants.SERVICIO_AFILIACION).toString();
			Map headers = PropertiesBuilder.getMapFromStringHeaders("servicioAfiliacion", Controller.class);
			headers.put(Contants.CLIENT_ID_HEADER, PropertiesSingleton.getInstance().getClientIdProperties().getProperty(Contants.SERVICIO_AFILIACION_ID));
			response = super.responseFromPostRequest(url, headers, entity_body);

		} catch (NoSuchMethodException e)
		{
			e.printStackTrace();
		}catch(IOException e)
		{
			e.printStackTrace();
		}

		return response.getEntity();
	}
	
}
