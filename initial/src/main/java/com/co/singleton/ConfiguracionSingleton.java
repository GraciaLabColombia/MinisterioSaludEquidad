package com.co.singleton;

import com.co.dto.TokenDTO;

public class ConfiguracionSingleton
{
    private static ConfiguracionSingleton configuracion;

    private TokenDTO token;
    private String authorization;

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
}
