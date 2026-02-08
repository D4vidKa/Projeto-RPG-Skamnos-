package com.skamnos.ItensTeste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skamnos.itens.listaItens.*;

public class LagrimaDeHydraxTeste {
    private LagrimaDeHydrax lagrimaDeHydrax;
    
    @BeforeEach
    public void setUp() {
        lagrimaDeHydrax = new LagrimaDeHydrax();
    }

    @Test
    public void deveTerNomeCorreto() {
        assertEquals("Lágrima de Hydrax", lagrimaDeHydrax.getNome());
    }

    @Test
    public void deveTerPrecoCorreto() {
        assertEquals(65, lagrimaDeHydrax.getPreco());
    }

    @Test
    public void deveTerDescricaoCorreta() {
        String descricaoEsperada = """
            Efeito: ---Recupera 40 Pontos de Vida---
            Uma versão aprimorada da escama comum, também criada por Silas.
            Após uma revolta no Arquipélago de Nereza onde várias pessoas morreram, Silas viu a necessidade de aprimorar sua criação.
            """;
        assertEquals(descricaoEsperada, lagrimaDeHydrax.getDescricao());
    }
}
