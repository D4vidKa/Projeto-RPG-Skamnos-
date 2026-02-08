package com.skamnos.ItensTeste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skamnos.itens.listaItens.*;

public class CinzaRubraTeste {
    private CinzaRubra cinzaRubra;
    
    @BeforeEach
    public void setUp() {
        cinzaRubra = new CinzaRubra();
    }

    @Test
    public void deveTerNomeCorreto() {
        assertEquals("Cinza Rubra", cinzaRubra.getNome());
    }

    @Test
    public void deveTerPrecoCorreto() {
        assertEquals(40, cinzaRubra.getPreco());
    }

    @Test
    public void deveTerDescricaoCorreta() {
        String descricaoEsperada = """
            Efeito: ---Recupera 10 Pontos de Mana---
            Uma pílula cáustica que incendeia os canais de mana do usuário, recuperando parte de sua energia.
            Desenvolvida por Korthos, o Alquimista de Ferro, a mando da Legião de Escamas para manter seus soldados em combate contínuo,
            sua fórmula é cercada de rumores sombrios: dizem que foi criada ilegalmente nos laboratórios militares usando cinzas de dissidentes e combustíveis instáveis que 'fritam' o corpo por dentro.
            """;
        assertEquals(descricaoEsperada, cinzaRubra.getDescricao());
    }

    @Test
    public void deveUsarItemCorretamente() {
        // Este teste seria mais complexo, pois envolve a interação com a classe Jogador.
        // Para um teste completo, seria necessário criar um mock ou uma instância de Jogador e verificar se a mana foi restaurada corretamente.
    }
}
