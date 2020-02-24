package com.co.singleton;

import com.co.dto.TokenDTO;
import com.co.entities.ParametroGeneral;
import com.co.exception.MinSaludBusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.List;

@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
@Configuration
public class ConfiguracionSingleton
{
    private static ConfiguracionSingleton configuracion;

    public TokenDTO token;
    public String authorization;
    public List<ParametroGeneral> parametros;


    Logger log = LoggerFactory.getLogger(ConfiguracionSingleton.class);

    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        throw new CloneNotSupportedException("Can't clone a singleton class");
    }

    public TokenDTO getToken() {
        return token;
    }

    public void setToken(TokenDTO token) {
        if (this.token == null) {
            this.token = token;
        }
    }

    public String getAuthorization() {
        return authorization;
    }

    public void setAuthorization(String authorization) {
        if (this.authorization == null) {
            this.authorization = authorization;
        }
    }

    public List<ParametroGeneral> getParametros() {
        return parametros;
    }

    public void setParametros(List<ParametroGeneral> parametros) {
        if(this.parametros == null) {
            log.info("Seteamos: ".concat(parametros.size() + " ").concat("parametros"));
            this.parametros = parametros;
        }
    }
    public ParametroGeneral getParametroPorDocumento(String parameroGeneralConstant) throws MinSaludBusinessException {
        log.info("Parametros: ".concat(this.parametros.size() + " "));
        return this.parametros.stream().filter(p -> p.getDocumento().trim().equalsIgnoreCase(parameroGeneralConstant)).findFirst().orElseThrow(() -> new MinSaludBusinessException("No existe parametro con ese documento: ".concat(parameroGeneralConstant)));
    }
}
