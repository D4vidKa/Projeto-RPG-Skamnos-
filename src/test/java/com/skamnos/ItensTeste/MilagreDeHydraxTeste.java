package com.skamnos.itensTeste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import com.skamnos.modelo.jogador.Jogador;
import com.skamnos.modelo.elemento.Elemento;

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
                A obra-prima de Silas que o fez virar um dos grandes Magister do Conclave, criada em colaboração com outros discípulos após anos de desenvolvimento.
                Esta poção foi desenvolvida a pedido da Mestra-Oráculo Lyra para fortalecer seus espiões em missões de extremo risco, sendo capaz de recuperar toda a vitalidade de uma pessoa.
                """;
        assertEquals(descricaoEsperada, milagreDeHydrax.getDescricao());
    }

    @Test
    public void deveTerEfeitoDescricaoCorreta() {
        String efeitoDescricaoEsperada = "Recupera toda a vida";
        assertEquals(efeitoDescricaoEsperada, milagreDeHydrax.getEfeitoDescrição());
    }

    @Test
    // Item deve funcionar corretamente ao ser usado por um jogador
    public void deveRestaurarVidaCorretamente() {
        // Configura o jogador com vida reduzida
        Jogador jogador = new Jogador("Teste", 50, 10, 5, 5, 1, Elemento.VITAS, 0, 1, "Início do Jogo", null, null,
                null, new ArrayList<>());
        // Configura o jogador com vida reduzida
        jogador.setVida(1);
        // Usa a lágrima de hydrax
        milagreDeHydrax.usar(jogador);
        assertEquals(50, jogador.getVida());
    }

    @Test
    // Teste para garantir que o item não seja usado quando a vida do jogador já
    // estiver cheia
    public void naoDeveUsarQuandoVidaCheia() {
        // Criar um jogador com vida cheia
        Jogador jogador = new Jogador("Teste", 50, 10, 5, 5, 1, Elemento.VITAS, 0, 1, "Início do Jogo", null, null,
                null, new ArrayList<>());
        jogador.setVida(50);

        // Usar o Milagre de Hydrax
        milagreDeHydrax.usar(jogador);

        // Verificar se a vida permanece inalterada
        assertEquals(50, jogador.getVida());
    }

    @Test
    public void deveTerToStringCorreto() {
        String toStringEsperado = String.format(
                "\n[ ITEM CONSUMÍVEL ]\n" +
                        "Nome: %-15s | Preço: %d g\n" +
                        "Descrição: %s\n" +
                        "Efeito: %s\n" +
                        "--------------------------",
                milagreDeHydrax.getNome(), milagreDeHydrax.getPreco(), milagreDeHydrax.getDescricao(),
                milagreDeHydrax.getEfeitoDescrição());
        assertEquals(toStringEsperado, milagreDeHydrax.toString());
    }
}
