package com.casapoular.service;

import com.casapoular.model.PontuacaoFamilia;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PontuacaoStrategy {

    private final List<PontuacaoInterface> pontuacaoInterfaceList;

    public void realizarPontuacao(List<PontuacaoFamilia> listaDeFamilias) {
        pontuacaoInterfaceList.forEach(pontuacaoInterface ->
                pontuacaoInterface.pontuar(listaDeFamilias)
        );
    }
}
