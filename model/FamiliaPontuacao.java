package com.casapoular.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class FamiliaPontuacao implements Comparable<FamiliaPontuacao> {

    private Integer pontos;
    private Familia familia;

    public FamiliaPontuacao(Familia familia) {
        this.familia = familia;
        pontos = 0;
    }

    public void addPontos(Integer pontuacao) {
        this.pontos += pontuacao;
    }

    @Override
    public int compareTo(FamiliaPontuacao familiaPontuacao) {
        return familiaPontuacao.getPontos().compareTo(this.pontos);
    }
}
