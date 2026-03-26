package com.skamnos.equipamentosTeste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import com.skamnos.modelo.jogador.Jogador;
import com.skamnos.modelo.elemento.Elemento;
import com.skamnos.itens.listaEquipamentos.*;

public class FenixEncarnadaTeste {
    private FenixEncarnada fenixEncarnada;

    @BeforeEach
    public void setUp() {
        fenixEncarnada = new FenixEncarnada();
    }

    @Test
    public void deveTerNomeCorreto() {
        assertEquals("Fênix Encarnada", fenixEncarnada.getNome());
    }

    @Test
    public void deveTerPrecoCorreto() {
        assertEquals(100, fenixEncarnada.getPreco());
    }

    @Test
    public void deveTerDescricaoCorreta() {
        String descricaoEsperada = """
                Empunhar esta lâmina é um teste de vontade; o calor que emana do punho faz os braços do usuário parecerem derreter em magma vivo. 
                Forjada com Aço Sombral imbuído com Ignis nas entranhas do vulcão no Pico da Ascensão, a Fênix Encarnada é uma arma senciente que não tolera a hesitação. 
                Ela exige um tributo de dor: aqueles que tentam usurpar seu poder sem a devida força são instantaneamente consumidos, transformados em cinzas pela fúria de Pyrothos.
                """;
        assertEquals(descricaoEsperada, fenixEncarnada.getDescricao());
    }

    @Test
    public void deveTerTipoArmaCorreto() {
        assertEquals("Arma", fenixEncarnada.getTipoArma());
    }

    @Test
    // Testa os bônus de ataque, vida, defesa e mana
    public void deveTerBonusCorretos() {
        assertEquals(30, fenixEncarnada.getBonusAtaque());
        assertEquals(0, fenixEncarnada.getBonusVida());
        assertEquals(0, fenixEncarnada.getBonusDefesa());
        assertEquals(5, fenixEncarnada.getBonusMana());
    }

    @Test
    public void deveTerElementoCorreto() {
        assertEquals(Elemento.IGNIS, fenixEncarnada.getElementoItem());
    }

    @Test
    public void deveUsarEquipamentoCorretamente() {
        // Configura o jogador
        Jogador jogador = new Jogador("Teste", 100, 10, 5, 20, 1, Elemento.VITAS, 0, 1, "Início do Jogo", null, null,
                null, new ArrayList<>());
        // adiciona o equipamento ao inventário do jogador
        jogador.getInventario().add(fenixEncarnada);
        // Simula o uso do equipamento
        jogador.equiparItem(fenixEncarnada);
        // Verifica os bônus aplicados
        assertEquals(40, jogador.getAtaque()); // 10 base + 30 do equipamento
        assertEquals(100, jogador.getVida()); // Sem bônus de vida
        assertEquals(5, jogador.getDefesa()); // Sem bônus de defesa
        assertEquals(25, jogador.getMana()); // 20 base + 5 do equipamento
    }

    @Test
    public void deveDesequiparEquipamentoCorretamente() {
        // Configura o jogador
        Jogador jogador = new Jogador("Teste", 100, 10, 5, 20, 1, Elemento.VITAS, 0, 1, "Início do Jogo", null, null,
                null, new ArrayList<>());
        // adiciona o equipamento ao inventário do jogador
        jogador.getInventario().add(fenixEncarnada);
        // Simula o uso do equipamento
        jogador.equiparItem(fenixEncarnada);
        // Simula a desequipagem do equipamento
        jogador.desequiparItem(fenixEncarnada);
        // Verifica os bônus removidos
        assertEquals(10, jogador.getAtaque()); // Volta ao valor base
        assertEquals(100, jogador.getVida()); // Sem bônus de vida
        assertEquals(5, jogador.getDefesa()); // Sem bônus de defesa
        assertEquals(20, jogador.getMana()); // Volta ao valor base
    }

    @Test
    public void naoPodeEquiparSeNaoTiverNoInventario() {
        // Configura o jogador
        Jogador jogador = new Jogador("Teste", 100, 10, 5, 20, 1, Elemento.VITAS, 0, 1, "Início do Jogo", null, null,
                null, new ArrayList<>());
        // Tenta equipar o item sem adicioná-lo ao inventário
        jogador.equiparItem(fenixEncarnada);
        // Verifica que os bônus não foram aplicados
        assertEquals(10, jogador.getAtaque()); // Valor base
        assertEquals(100, jogador.getVida()); // Sem bônus de vida
        assertEquals(5, jogador.getDefesa()); // Sem bônus de defesa
        assertEquals(20, jogador.getMana()); // Valor base
    }

    @Test
    public void naoPodeDesequiparSeNaoEstiverEquipado() {
        // Configura o jogador
        Jogador jogador = new Jogador("Teste", 100, 10, 5, 20, 1, Elemento.VITAS, 0, 1, "Início do Jogo", null, null,
                null, new ArrayList<>());
        // Tenta desequipar o item sem tê-lo equipado
        boolean resultado = jogador.desequiparItem(fenixEncarnada);
        // Verifica que o equipamento não foi desequipado
        assertEquals(false, resultado);
    }

    @Test
    // teste para verificar a compra
    public void deveComprarEquipamentoCorretamente() {
        // Configura o jogador com dinheiro suficiente
        Jogador jogador = new Jogador("Teste", 100, 10, 5, 20, 1, Elemento.VITAS, 100, 1, "Início do Jogo", null, null,
                null, new ArrayList<>());
        // Simula a compra do equipamento
        boolean resultado = jogador.comprarItem(fenixEncarnada);
        // Verifica que o equipamento foi comprado e adicionado ao inventário
        assertEquals(true, resultado);
        assertEquals(1, jogador.getInventario().size());
        assertEquals(fenixEncarnada, jogador.getInventario().get(0));
        // Verifica que o dinheiro foi descontado
        assertEquals(0, jogador.getOuro()); // 100 - 100 do equipamento
    }
}
