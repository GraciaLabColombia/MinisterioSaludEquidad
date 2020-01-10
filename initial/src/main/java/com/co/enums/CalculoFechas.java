package com.co.enums;

public enum CalculoFechas
{
    AF("AF", 1);

    private int dias;

    private String estado;

    CalculoFechas(String estado, int dias)
    {
        this.estado = estado;
        this.dias = dias;
    }

    public int getDias() {
        return dias;
    }

    public String getEstado() {
        return estado;
    }
}
