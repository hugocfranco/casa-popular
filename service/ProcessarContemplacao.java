package com.casapoular.service;

import com.casapoular.model.Familia;
import com.casapoular.model.Pontuacao;

import java.util.List;

public interface ProcessarContemplacao {

    List<Pontuacao> ordenarFamilias(List<Familia> listaDeFamilias);

}
