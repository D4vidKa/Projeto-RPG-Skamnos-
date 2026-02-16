package com.skamnos.ItensTeste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import com.skamnos.modelo.jogador.Jogador;
import com.skamnos.modelo.elemento.Elemento;
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

    @Test
    // Item deve funcionar corretamente ao ser usado por um jogador
    public void deveRestaurarVidaCorretamente() {
        // Configura o jogador com vida reduzida
        Jogador jogador = new Jogador("Teste", 50, 10, 5, 5, 1, Elemento.VITAS, 0, 1, "Início do Jogo", null, null,
                null, new ArrayList<>());
        // Configura o jogador com vida reduzida
        jogador.setVida(30);
        // Usa a escama de hydrax
        escamaDeHydrax.usar(jogador);
        // Verifica se a vida foi restaurada corretamente (30 + 20 = 50, mas não pode
        // exceder o máximo)
        assertEquals(50, jogador.getVida());
    }

    @Test
    // Item não deve exceder a vida máxima do jogador
    public void naoDeveExcederVidaMaxima() {
        // Configura o jogador com vida reduzida
        Jogador jogador = new Jogador("Teste", 50, 10, 5, 5, 1, Elemento.VITAS, 0, 1, "Início do Jogo", null, null,
                null, new ArrayList<>());
        // Configura o jogador com vida reduzida
        jogador.setVida(45);
        // Usa a escama de hydrax
        escamaDeHydrax.usar(jogador);
        // Verifica se a vida foi restaurada corretamente (45 + 20 = 65, mas deve ser
        // limitada a 50)
        assertEquals(50, jogador.getVida());
    }

    @Test
    // Item não deve ser usado se o jogador já estiver com a vida cheia
    public void naoDeveUsarComVidaCheia() {
        // Configura o jogador com vida cheia
        Jogador jogador = new Jogador("Teste", 50, 10, 5, 5, 1, Elemento.VITAS, 0, 1, "Início do Jogo", null, null,
                null, new ArrayList<>());
        // Usa a escama de hydrax
        escamaDeHydrax.usar(jogador);
        // Verifica se a vida permanece inalterada
        assertEquals(50, jogador.getVida());
    }
}
