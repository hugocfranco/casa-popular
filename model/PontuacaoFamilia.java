package com.casapoular.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PontuacaoFamilia {

    public PontuacaoFamilia(Familia familia) {
        this.familia = familia;
        pontos = 0;
    }

    private Familia familia;
    private Integer pontos;

    public void addPontos(Integer pontuacao) {
        this.pontos += pontuacao;
    }
}
