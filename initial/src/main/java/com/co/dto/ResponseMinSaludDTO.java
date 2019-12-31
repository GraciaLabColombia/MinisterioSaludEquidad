package com.co.dto;

public class ResponseMinSaludDTO extends ResponseDTO
{
    private int resultado;

    private String mensaje;

    private String codigo;

    public int getResultado() {
        return resultado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getCodigo() {
        return codigo;
    }
}
