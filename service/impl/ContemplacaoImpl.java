package com.casapoular.service.impl;

import com.casapoular.model.Familia;
import com.casapoular.model.FamiliaPontuacao;
import com.casapoular.service.Contemplacao;
import com.casapoular.service.PontuacaoStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContemplacaoImpl implements Contemplacao {

    private final PontuacaoStrategy pontuacaoStrategy;

    @Override
    public List<FamiliaPontuacao> ordenarFamilias(List<Familia> listaDeFamilias) {
        List<FamiliaPontuacao> familiasPontuacao = criarListaPontuacaoFamilias(listaDeFamilias);
        pontuacaoStrategy.realizarPontuacao(familiasPontuacao);
        Collections.sort(familiasPontuacao);
        return familiasPontuacao;
    }

    private List<FamiliaPontuacao> criarListaPontuacaoFamilias(List<Familia> listaDeFamilias) {
        return listaDeFamilias.stream()
                .map(FamiliaPontuacao::new)
                .collect(Collectors.toList());
    }
}
