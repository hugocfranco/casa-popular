package com.casapoular.service;

import com.casapoular.model.PontuacaoFamilia;

import java.util.List;

public interface PontuacaoInterface {
    void pontuar(List<PontuacaoFamilia> pontuacaoFamilias);
}
