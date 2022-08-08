package com.casapoular.service.impl;

import com.casapoular.model.Familia;
import com.casapoular.model.FamiliaPontuacao;
import com.casapoular.model.Pessoa;
import com.casapoular.service.PontuacaoStrategy;
import com.casapoular.service.pontuacoes.PontuacaoDependente;
import com.casapoular.service.pontuacoes.PontuacaoRenda;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContemplacaoImplTest {
    PontuacaoRenda pontuacaoRenda = new PontuacaoRenda();
    PontuacaoDependente pontuacaoDependente = new PontuacaoDependente();
    @Spy
    PontuacaoStrategy pontuacaoStrategy = new PontuacaoStrategy(Arrays.asList(pontuacaoRenda, pontuacaoDependente));
    @InjectMocks
    ContemplacaoImpl contemplacaoImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testOrdenarFamilias() {
        List<FamiliaPontuacao> result = contemplacaoImpl.ordenarFamilias(buildFamilias());
        FamiliaPontuacao familiaEscolhida = FamiliaPontuacao.builder()
                .familia(buildFamilias().get(3))
                .pontos(8)
                .build();
        Assert.assertEquals(familiaEscolhida, result.get(0));
    }

    private List<Familia> buildFamilias() {
        List<Familia> familias = new ArrayList<>();
        Familia familiaUM = Familia.builder() // 3 Pontos de Renda + 0 Pontos de Dependentes = 3 Pontos no Total
                .pretendente(Pessoa.builder()
                        .nome("Pessoa Pretendente")
                        .idade(41)
                        .renda(BigDecimal.valueOf(300))
                        .build())
                .conjuge(Pessoa.builder()
                        .nome("Pessoa Conjuge")
                        .idade(41)
                        .renda(BigDecimal.valueOf(450))
                        .build())
                .filhos(Arrays.asList(
                        Pessoa.builder()
                                .nome("Pessoa Filho")
                                .idade(21)
                                .renda(BigDecimal.valueOf(200))
                                .build(),
                        Pessoa.builder()
                                .nome("Pessoa Filha")
                                .idade(19)
                                .renda(BigDecimal.ZERO)
                                .build()
                )).build();
        familias.add(familiaUM);
        Familia familiaDois = Familia.builder() // 5 Pontos de Renda + 2 Pontos de Dependentes = 7 Pontos no Total
                .pretendente(Pessoa.builder()
                        .nome("Pessoa Pretendente")
                        .idade(42)
                        .renda(BigDecimal.valueOf(700))
                        .build())
                .conjuge(Pessoa.builder()
                        .nome("Pessoa Conjuge")
                        .idade(42)
                        .renda(BigDecimal.ZERO)
                        .build())
                .filhos(Arrays.asList(
                        Pessoa.builder()
                                .nome("Pessoa Filho")
                                .idade(19)
                                .renda(BigDecimal.ZERO)
                                .build(),
                        Pessoa.builder()
                                .nome("Pessoa Filha")
                                .idade(15)
                                .renda(BigDecimal.ZERO)
                                .build()
                )).build();
        familias.add(familiaDois);
        Familia familiaTres = Familia.builder() // 0 Pontos de Renda + 2 Pontos de Dependentes = 2 Pontos no Total
                .pretendente(Pessoa.builder()
                        .nome("Pessoa Pretendente")
                        .idade(43)
                        .renda(BigDecimal.valueOf(1000))
                        .build())
                .conjuge(Pessoa.builder()
                        .nome("Pessoa Conjuge")
                        .idade(43)
                        .renda(BigDecimal.valueOf(450))
                        .build())
                .filhos(Arrays.asList(
                        Pessoa.builder()
                                .nome("Pessoa Filho")
                                .idade(22)
                                .renda(BigDecimal.valueOf(400))
                                .build(),
                        Pessoa.builder()
                                .nome("Pessoa Filha")
                                .idade(15)
                                .renda(BigDecimal.ZERO)
                                .build()
                )).build();
        familias.add(familiaTres);
        Familia familiaQuadro = Familia.builder() // 5 Pontos de Renda + 3 Pontos de Dependentes = 8 Pontos no Total
                .pretendente(Pessoa.builder()
                        .nome("Pessoa Pretendente")
                        .idade(44)
                        .renda(BigDecimal.valueOf(700))
                        .build())
                .conjuge(Pessoa.builder()
                        .nome("Pessoa Conjuge")
                        .idade(44)
                        .renda(BigDecimal.ZERO)
                        .build())
                .filhos(Arrays.asList(
                        Pessoa.builder()
                                .nome("Pessoa Filho")
                                .idade(19)
                                .renda(BigDecimal.valueOf(200))
                                .build(),
                        Pessoa.builder()
                                .nome("Pessoa Filha")
                                .idade(15)
                                .renda(BigDecimal.ZERO)
                                .build(),
                        Pessoa.builder()
                                .nome("Pessoa Filha Dois")
                                .idade(15)
                                .renda(BigDecimal.ZERO)
                                .build(),
                        Pessoa.builder()
                                .nome("Pessoa Filho Dois")
                                .idade(9)
                                .renda(BigDecimal.ZERO)
                                .build()
                )).build();
        familias.add(familiaQuadro);
        return familias;
    }
}