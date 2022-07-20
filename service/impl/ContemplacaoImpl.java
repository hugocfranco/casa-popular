package com.casapoular.service.impl;

import com.casapoular.model.Familia;
import com.casapoular.model.PontuacaoFamilia;
import com.casapoular.service.Contemplacao;
import com.casapoular.service.PontuacaoStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContemplacaoImpl implements Contemplacao {

    private final PontuacaoStrategy pontuacaoStrategy;

    @Override
    public List<PontuacaoFamilia> ordenarFamilias(List<Familia> listaDeFamilias) {
        List<PontuacaoFamilia> pontuacaoFamilias = criarListaPontuacaoFamilias(listaDeFamilias);
        pontuacaoStrategy.realizarPontuacao(pontuacaoFamilias);
        //todo ordernar pontuacao
        return null;
    }

    private List<PontuacaoFamilia> criarListaPontuacaoFamilias(List<Familia> listaDeFamilias) {
        return listaDeFamilias.stream()
                .map(PontuacaoFamilia::new)
                .collect(Collectors.toList());
    }
}
