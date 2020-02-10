package com.co.singleton;

import com.co.dto.TokenDTO;
import com.co.entities.ParametroGeneral;
import com.co.exception.MinSaludBusinessException;
import com.co.utils.SisafitraConstant;

import java.util.List;

public class ConfiguracionSingleton
{
    private static ConfiguracionSingleton configuracion;

    private TokenDTO token;
    private String authorization;
    private List<ParametroGeneral> parametros;

    public static ConfiguracionSingleton getInstance()
    {
        if (configuracion == null)
            configuracion = new ConfiguracionSingleton();

        return configuracion;
    }

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
            this.parametros = parametros;
        }
    }

    public ParametroGeneral getParametroPorDocumento(String parameroGeneralConstant) throws MinSaludBusinessException {
        return this.parametros.stream().filter(p -> p.getDocumento().equalsIgnoreCase(parameroGeneralConstant)).findFirst().orElseThrow(() -> new MinSaludBusinessException("No existe parametro con ese documento: ".concat(parameroGeneralConstant)));
    }
}
