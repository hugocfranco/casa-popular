package com.casapoular.service.pontuacoes;

import com.casapoular.model.Familia;
import com.casapoular.model.PontuacaoFamilia;
import com.casapoular.model.enums.DependentePnt;
import com.casapoular.service.PontuacaoInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PontuacaoDependente implements PontuacaoInterface {

    private static final Integer IDADE_MAXIMA = 18;

    @Override
    public void pontuar(List<PontuacaoFamilia> pontuacaoFamilias) {
        pontuacaoFamilias.forEach(pontuacaoFamilia -> {
            Integer quantidadeDependente = recuperarQuantidadeDependente(pontuacaoFamilia.getFamilia());
            pontuacaoFamilia.addPontos(pontuacaoPorDependente(quantidadeDependente));
        });
    }

    private Integer recuperarQuantidadeDependente(Familia familia) {
        return (int) familia.getFilhos().stream()
                .filter(pessoa -> pessoa.getIdade().compareTo(IDADE_MAXIMA) < 0)
                .count();
    }

    private Integer pontuacaoPorDependente(Integer quantidadeDependente) {
        for (DependentePnt dependentePnt : DependentePnt.values())
            if (quantidadeDependente.compareTo(dependentePnt.getMenorQuantidade()) > 0 &&
                    quantidadeDependente.compareTo(dependentePnt.getMaiorQuantidade()) <= 0)
                return dependentePnt.getPontos();
        return 0;
    }
}
