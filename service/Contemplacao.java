package com.casapoular.service;

import com.casapoular.model.Familia;
import com.casapoular.model.FamiliaPontuacao;

import java.util.List;

public interface Contemplacao {

    List<FamiliaPontuacao> ordenarFamilias(List<Familia> listaDeFamilias);

}
