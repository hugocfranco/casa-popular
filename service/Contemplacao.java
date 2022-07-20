package com.casapoular.service;

import com.casapoular.model.Familia;
import com.casapoular.model.PontuacaoFamilia;

import java.util.List;

public interface Contemplacao {

    List<PontuacaoFamilia> ordenarFamilias(List<Familia> listaDeFamilias);

}
