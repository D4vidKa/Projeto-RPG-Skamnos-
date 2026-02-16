package com.skamnos.ItensTeste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import com.skamnos.modelo.jogador.Jogador;
import com.skamnos.modelo.elemento.Elemento;

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

    @Test
    // Item deve funcionar corretamente ao ser usado por um jogador
    public void deveRestaurarVidaCorretamente() {
        // Configura o jogador com vida reduzida
        Jogador jogador = new Jogador("Teste", 50, 10, 5, 5, 1, Elemento.VITAS, 0, 1, "Início do Jogo", null, null,
                null, new ArrayList<>());
        // Configura o jogador com vida reduzida
        jogador.setVida(10);
        // Usa a lágrima de hydrax
        lagrimaDeHydrax.usar(jogador);
        // Verifica se a vida foi restaurada corretamente (10 + 40 = 50, mas não pode
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
        // Usa a lágrima de hydrax
        lagrimaDeHydrax.usar(jogador);
        // Verifica se a vida foi restaurada corretamente (45 + 40 = 85, mas deve ser
        // limitada a 50)
        assertEquals(50, jogador.getVida());
    }

    @Test
    // Item não deve ser usado se o jogador já estiver com a vida cheia
    public void naoDeveUsarComVidaCheia() {
        // Configura o jogador com vida cheia
        Jogador jogador = new Jogador("Teste", 50, 10, 5, 5, 1, Elemento.VITAS, 0, 1, "Início do Jogo", null, null,
                null, new ArrayList<>());
        // Usa a lágrima de hydrax
        lagrimaDeHydrax.usar(jogador);
        // Verifica se a vida permanece a mesma (50)
        assertEquals(50, jogador.getVida());
    }
}
