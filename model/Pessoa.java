package com.casapoular.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Pessoa {
    private String nome;
    private Integer idade;
    private BigDecimal renda;
}
