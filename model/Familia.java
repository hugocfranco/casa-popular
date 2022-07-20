package com.casapoular.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Familia {
    private Pessoa pretendente;
    private Pessoa conjuge;
    private List<Pessoa> filhos;
}
