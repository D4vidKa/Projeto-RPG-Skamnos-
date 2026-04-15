package com.skamnos.itensTeste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.skamnos.modelo.jogador.Jogador;
import com.skamnos.modelo.elemento.Elemento;
import com.skamnos.modelo.inventario.*;

import com.skamnos.itens.listaItens.*;

public class BencaoLuminarTeste {
    private BencaoLuminar bencaoLuminar;

    @BeforeEach
    public void setUp() {
        bencaoLuminar = new BencaoLuminar();
    }

    @Test
    public void deveTerNomeCorreto() {
        assertEquals("Bênção Luminar", bencaoLuminar.getNome());
    }

    @Test
    public void deveTerPrecoCorreto() {
        assertEquals(200, bencaoLuminar.getPreco());
    }

    @Test
    public void deveTerDescricaoCorreta() {
        String descricaoEsperada = """
                Muitos acreditam ser apenas um mito inventado por desesperados, mas para a Cúpula dos Absolutos, é uma ameaça real o suficiente para justificar massacres.
                Não é apenas um item; é uma âncora para aqueles que têm uma tarefa inacabada com a vida.
                A Igreja do Sol Poente protege estas poucas raridades com o próprio sangue, esperando pelo momento em que a 'pessoa certa' precisará recusar o fim.
                """;
        assertEquals(descricaoEsperada, bencaoLuminar.getDescricao());
    }

    @Test
    public void deveTerEfeitoDescricaoCorreta() {
        String efeitoDescricaoEsperada = "???";
        assertEquals(efeitoDescricaoEsperada, bencaoLuminar.getEfeitoDescrição());
    }

    @Test
    public void deveUsarItemCorretamente() {
        Inventario inventario = new Inventario(30);
        // Configura o jogador com vida reduzida
        Jogador jogador = new Jogador("Teste", 50, 10, 7, 30, 1, Elemento.VITAS, 0, 1, "Início do Jogo", null, null,
                null, inventario);
        // Configura o jogador como morto
        jogador.setVida(0);
        bencaoLuminar.usar(jogador);
        assertEquals(50, jogador.getVida());
    }

    @Test
    public void naoDeveReviverJogadorVivo() {
        // Configura o jogador com vida reduzida
        Inventario inventario = new Inventario(30);
        Jogador jogador = new Jogador("Teste", 50, 10, 7, 30, 1, Elemento.VITAS, 0, 1, "Início do Jogo", null, null,
                null, inventario);
        // Configura o jogador como vivo
        jogador.setVida(25);
        bencaoLuminar.usar(jogador);
        assertEquals(25, jogador.getVida());
    }

    @Test
    public void deveTerToStringCorreto() {
        String toStringEsperado = String.format(
                "\n[ ITEM CONSUMÍVEL ]\n" +
                        "Nome: %-15s | Preço: %d g\n" +
                        "Descrição: %s\n" +
                        "Efeito: %s\n" +
                        "--------------------------",
                bencaoLuminar.getNome(), bencaoLuminar.getPreco(), bencaoLuminar.getDescricao(),
                bencaoLuminar.getEfeitoDescrição());
        assertEquals(toStringEsperado, bencaoLuminar.toString());
    }
}
