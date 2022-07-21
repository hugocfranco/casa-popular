package com.casapoular.service.pontuacoes;

import com.casapoular.model.Familia;
import com.casapoular.model.Pessoa;
import com.casapoular.model.FamiliaPontuacao;
import com.casapoular.model.enums.RendaFamiliarPnt;
import com.casapoular.service.PontuacaoInterface;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PontuacaoRenda implements PontuacaoInterface {
    @Override
    public void pontuar(List<FamiliaPontuacao> familiasPontuacao) {
        familiasPontuacao.forEach(pontuacaoFamilia -> {
            BigDecimal rendaFamiliar = recuperarRendaFamiliar(pontuacaoFamilia.getFamilia());
            pontuacaoFamilia.addPontos(pontuacaoPorRenda(rendaFamiliar));
        });
    }

    private BigDecimal recuperarRendaFamiliar(Familia familia) {
        BigDecimal rendaResponsaveis = familia.getPretendente().getRenda().add(familia.getConjuge().getRenda());
        BigDecimal rendaFilhos = familia.getFilhos().stream().map(Pessoa::getRenda).reduce(BigDecimal.ZERO, BigDecimal::add);
        return rendaResponsaveis.add(rendaFilhos);
    }

    private Integer pontuacaoPorRenda(BigDecimal rendaFamiliar) {
        for (RendaFamiliarPnt rendaFamiliarPnt : RendaFamiliarPnt.values())
            if (rendaFamiliar.compareTo(rendaFamiliarPnt.getMenorValor()) >= 0 &&
                    rendaFamiliar.compareTo(rendaFamiliarPnt.getMaiorValor()) <= 0)
                return rendaFamiliarPnt.getPontos();
        return 0;
    }
}
