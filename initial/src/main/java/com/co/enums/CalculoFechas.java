package com.co.enums;

public enum CalculoFechas
{
    AF("AF", 1), TR("TR", 2L);

    private long dias;

    private String estado;

    CalculoFechas(String estado, long dias)
    {
        this.estado = estado;
        this.dias = dias;
    }

    public long getDias() {
        return dias;
    }

    public String getEstado() {
        return estado;
    }
}
