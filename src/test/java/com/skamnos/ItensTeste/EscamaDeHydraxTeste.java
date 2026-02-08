package com.skamnos.ItensTeste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skamnos.itens.listaItens.*;

public class EscamaDeHydraxTeste {
    private EscamaDeHydrax escamaDeHydrax;
    
    @BeforeEach
    public void setUp() {
        escamaDeHydrax = new EscamaDeHydrax();
    }

    @Test
    public void deveTerNomeCorreto() {
        assertEquals("Escama de Hydrax", escamaDeHydrax.getNome());
    }

    @Test
    public void deveTerPrecoCorreto() {
        assertEquals(40, escamaDeHydrax.getPreco());
    }

    @Test
    public void deveTerDescricaoCorreta() {
        String descricaoEsperada = """
            Efeito: ---Recupera 20 Pontos de Vida---
            Uma poção capaz de recuperar uma pequena parte da vida do usuário.
            Foi criada por Silas um Discipulus do Conclave das Correntes há 200 anos.
            """;
        assertEquals(descricaoEsperada, escamaDeHydrax.getDescricao());
    }
}
