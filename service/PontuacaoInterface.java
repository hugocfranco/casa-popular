package com.casapoular.service;

import com.casapoular.model.FamiliaPontuacao;

import java.util.List;

public interface PontuacaoInterface {
    void pontuar(List<FamiliaPontuacao> familiasPontuacao);
}
