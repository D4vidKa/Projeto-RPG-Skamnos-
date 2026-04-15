package com.skamnos.itensTeste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.skamnos.modelo.jogador.Jogador;
import com.skamnos.modelo.elemento.Elemento;
import com.skamnos.modelo.inventario.Inventario;
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
                O ápice da loucura de Korthos. Após se perder em suas próprias fórmulas, ele criou esta versão extremamente agressiva que recupera muita mana instantaneamente.
                Mesmo após a Legião banir suas pesquisas, Korthos continuou a refiná-la em segredo.
                Dizem que ele se tornou viciado na própria criação antes de desaparecer sem deixar rastros.
                """;
        assertEquals(descricaoEsperada, brasaProibida.getDescricao());
    }

    @Test
    public void deveTerEfeitoDescricaoCorreta() {
        String efeitoDescricaoEsperada = "Recupera 20 Pontos de Mana";
        assertEquals(efeitoDescricaoEsperada, brasaProibida.getEfeitoDescrição());
    }

    @Test
    public void deveUsarItemCorretamente() {
        Inventario inventario = new Inventario(30);
        // Configura o jogador com vida reduzida
        Jogador jogador = new Jogador("Teste", 50, 10, 7, 30, 1, Elemento.VITAS, 0, 1, "Início do Jogo", null, null,
                null, inventario);
        // Configura o jogador com mana reduzida
        jogador.setMana(5);
        brasaProibida.usar(jogador);
        assertEquals(25, jogador.getMana());
    }

    @Test
    public void naoDeveExcederManaMaxima() {
        Inventario inventario = new Inventario(30);
        // Configura o jogador com vida reduzida
        Jogador jogador = new Jogador("Teste", 50, 10, 7, 30, 1, Elemento.VITAS, 0, 1, "Início do Jogo", null, null,
                null, inventario);
        // Configura o jogador com mana quase cheia
        jogador.setMana(29);
        brasaProibida.usar(jogador);
        assertEquals(30, jogador.getMana());
    }

    @Test
    public void naoDeveRestaurarManaSeCheia() {
        Inventario inventario = new Inventario(30);
        // Configura o jogador com vida reduzida
        Jogador jogador = new Jogador("Teste", 50, 10, 7, 30, 1, Elemento.VITAS, 0, 1, "Início do Jogo", null, null,
                null, inventario);
        // Configura o jogador com mana cheia
        jogador.setMana(30);
        brasaProibida.usar(jogador);
        assertEquals(30, jogador.getMana());
    }

    @Test
    public void deveTerToStringCorreto() {
        String toStringEsperado = String.format(
                "\n[ ITEM CONSUMÍVEL ]\n" +
                        "Nome: %-15s | Preço: %d g\n" +
                        "Descrição: %s\n" +
                        "Efeito: %s\n" +
                        "--------------------------",
                brasaProibida.getNome(), brasaProibida.getPreco(), brasaProibida.getDescricao(),
                brasaProibida.getEfeitoDescrição());
        assertEquals(toStringEsperado, brasaProibida.toString());
    }
}
