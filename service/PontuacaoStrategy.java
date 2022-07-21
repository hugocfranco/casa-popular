package com.casapoular.service;

import com.casapoular.model.FamiliaPontuacao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PontuacaoStrategy {

    private final List<PontuacaoInterface> pontuacaoInterfaceList;

    public void realizarPontuacao(List<FamiliaPontuacao> listaDeFamilias) {
        pontuacaoInterfaceList.forEach(pontuacaoInterface ->
                pontuacaoInterface.pontuar(listaDeFamilias)
        );
    }
}
