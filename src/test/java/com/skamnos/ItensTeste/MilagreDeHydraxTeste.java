package com.skamnos.ItensTeste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skamnos.itens.listaItens.*;

public class MilagreDeHydraxTeste {
    private MilagreDeHydrax milagreDeHydrax;
    
    @BeforeEach
    public void setUp() {
        milagreDeHydrax = new MilagreDeHydrax();
    }

    @Test
    public void deveTerNomeCorreto() {
        assertEquals("Milagre de Hydrax", milagreDeHydrax.getNome());
    }

    @Test
    public void deveTerPrecoCorreto() {
        assertEquals(100, milagreDeHydrax.getPreco());
    }

    @Test
    public void deveTerDescricaoCorreta() {
        String descricaoEsperada = """
            Efeito: ---Recupera toda a Vida---
            A obra-prima de Silas que o fez virar um dos grandes Magister do Conclave, criada em colaboração com outros discípulos após anos de desenvolvimento.
            Esta poção foi desenvolvida a pedido da Mestra-Oráculo Lyra para fortalecer seus espiões em missões de extremo risco, sendo capaz de recuperar toda a vitalidade de uma pessoa.
            """;
        assertEquals(descricaoEsperada, milagreDeHydrax.getDescricao());
    }
}
