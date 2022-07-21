package com.casapoular.model.enums;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public enum RendaFamiliarPnt {

    RENDA_BAIXA(BigDecimal.ZERO, BigDecimal.valueOf(900), 5),
    RENDA_MEDIA(BigDecimal.valueOf(901), BigDecimal.valueOf(1500), 3);

    private final BigDecimal menorValor;
    private final BigDecimal maiorValor;
    private final Integer pontos;

    RendaFamiliarPnt(BigDecimal menorValor, BigDecimal maiorValor, Integer pontos) {
        this.menorValor = menorValor;
        this.maiorValor = maiorValor;
        this.pontos = pontos;
    }
}
