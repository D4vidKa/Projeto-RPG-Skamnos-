package com.skamnos.ItensTeste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import com.skamnos.modelo.jogador.Jogador;
import com.skamnos.modelo.elemento.Elemento;

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
         // Configura o jogador com vida reduzida
        Jogador jogador = new Jogador("Teste", 50, 10, 7, 30, 1, Elemento.VITAS, 0, 1, "Início do Jogo", null, null,
                null, new ArrayList<>());
        // Configura o jogador com mana reduzida
        jogador.setMana(1);
        cinzaRubra.usar(jogador);
        assertEquals(11, jogador.getMana());
    }

    @Test
    public void naoDeveExcederManaMaxima() {
        // Configura o jogador com vida reduzida
        Jogador jogador = new Jogador("Teste", 50, 10, 7, 30, 1, Elemento.VITAS, 0, 1, "Início do Jogo", null, null,
                null, new ArrayList<>());
        // Configura o jogador com mana quase cheia
        jogador.setMana(29);
        cinzaRubra.usar(jogador);
        assertEquals(30, jogador.getMana());
    }

    @Test
    public void naoDeveRestaurarManaSeJaEstiverCheia() {
        // Configura o jogador com vida reduzida
        Jogador jogador = new Jogador("Teste", 50, 10, 7, 30, 1, Elemento.VITAS, 0, 1, "Início do Jogo", null, null,
                null, new ArrayList<>());
        // Configura o jogador com mana cheia
        jogador.setMana(30);
        cinzaRubra.usar(jogador);
        assertEquals(30, jogador.getMana());
    }
}
