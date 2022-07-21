package com.casapoular.model.enums;

import lombok.Getter;

@Getter
public enum DependentePnt {

    POUCOS_DEPENDENTES(1, 2, 2),
    MUITOS_DEPENDENTES(3, Integer.MAX_VALUE, 3);

    private final Integer menorQuantidade;
    private final Integer maiorQuantidade;
    private final Integer pontos;

    DependentePnt(Integer menorQuantidade, Integer maiorQuantidade, Integer pontos) {
        this.menorQuantidade = menorQuantidade;
        this.maiorQuantidade = maiorQuantidade;
        this.pontos = pontos;
    }
}
