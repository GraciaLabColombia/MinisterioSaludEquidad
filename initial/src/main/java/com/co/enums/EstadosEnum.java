package com.co.enums;

import java.math.BigDecimal;

public enum EstadosEnum {

    EN_TRAMITE(new BigDecimal(1)), EXITOSO(new BigDecimal(2)), ERROR(new BigDecimal(2)), FALLIDO(new BigDecimal(3));

    private BigDecimal name;

    EstadosEnum(BigDecimal name) {
        this.name = name;
    }

    public BigDecimal getName() {
        return name;
    }

    public void setName(BigDecimal name) {
        this.name = name;
    }
}
