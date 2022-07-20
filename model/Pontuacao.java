package com.casapoular.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Pontuacao {
    private Familia familia;
    private Integer pontos;
}
