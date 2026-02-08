package com.skamnos.ItensTeste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skamnos.itens.listaItens.*;

public class BrasaProibidaTeste {
    private BrasaProibida brasaProibida;
    
    @BeforeEach
    public void setUp() {
        brasaProibida = new BrasaProibida();
    }

    @Test
    public void deveTerNomeCorreto() {
        assertEquals("Brasa Proibida", brasaProibida.getNome());
    }

    @Test
    public void deveTerPrecoCorreto() {
        assertEquals(70, brasaProibida.getPreco());
    }

    @Test
    public void deveTerDescricaoCorreta() {
        String descricaoEsperada = """
            Efeito: ---Recupera 25 Pontos de Mana---
            O ápice da loucura de Korthos. Após se perder em suas próprias fórmulas, ele criou esta versão extremamente agressiva que recupera muita mana instantaneamente.
            Mesmo após a Legião banir suas pesquisas, Korthos continuou a refiná-la em segredo.
            Dizem que ele se tornou viciado na própria criação antes de desaparecer sem deixar rastros.
            """;
        assertEquals(descricaoEsperada, brasaProibida.getDescricao());
    }

    @Test
    public void deveUsarItemCorretamente() {
        // Este teste seria mais complexo, pois envolve a interação com a classe Jogador.
        // Para um teste completo, seria necessário criar um mock ou uma instância de Jogador e verificar se a vida foi restaurada corretamente.
    }
}
