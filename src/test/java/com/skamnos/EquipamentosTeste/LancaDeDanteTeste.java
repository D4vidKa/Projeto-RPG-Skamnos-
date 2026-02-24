package com.skamnos.EquipamentosTeste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import com.skamnos.modelo.jogador.Jogador;
import com.skamnos.modelo.elemento.Elemento;
import com.skamnos.itens.listaEquipamentos.*;

public class LancaDeDanteTeste {
    private LancaDeDante lancaDeDante;

    @BeforeEach
    public void setUp() {
        lancaDeDante = new LancaDeDante();
    }

    @Test
    public void deveTerNomeCorreto() {
        assertEquals("Lança de Dante", lancaDeDante.getNome());
    }

    @Test
    public void deveTerPrecoCorreto() {
        assertEquals(50, lancaDeDante.getPreco());
    }

    @Test
    public void deveTerDescricaoCorreta() {
        String descricaoEsperada = """
                Esculpida em Vidro de Dragão — um minério translúcido e indestrutível das profundezas — 
                esta lança foi um presente diplomático do Barão Ferrum para a Mestra-Oráculo Lyra há quatro séculos. 
                Para a Oráculo, a arma era uma 'joia delicada demais para a guerra', sendo então confiada ao seu prodígio, Dante de Nereza. 
                Após a queda de Dante em uma emboscada esquecida, a lança repousou no leito oceânico, absorvendo o silêncio das marés até ser recuperada pelos espiões do Conclave.
                """;
        assertEquals(descricaoEsperada, lancaDeDante.getDescricao());
    }

    @Test
    public void deveTerTipoArmaCorreto() {
        assertEquals("Arma", lancaDeDante.getTipoArma());
    }

    @Test
    // Testa os bônus de ataque, vida, defesa e mana
    public void deveTerBonusCorretos() {
        assertEquals(15, lancaDeDante.getBonusAtaque());
        assertEquals(0, lancaDeDante.getBonusVida());
        assertEquals(0, lancaDeDante.getBonusDefesa());
        assertEquals(15, lancaDeDante.getBonusMana());
    }

    @Test
    public void deveTerElementoCorreto() {
        assertEquals(Elemento.AEQUOR, lancaDeDante.getElementoItem());
    }

    @Test
    public void deveUsarEquipamentoCorretamente() {
        // Configura o jogador
        Jogador jogador = new Jogador("Teste", 100, 10, 5, 20, 1, Elemento.VITAS, 0, 1, "Início do Jogo", null, null,
                null, new ArrayList<>());
        // adiciona o equipamento ao inventário do jogador
        jogador.getInventario().add(lancaDeDante);
        // Simula o uso do equipamento
        jogador.equiparItem(lancaDeDante);
        // Verifica os bônus aplicados
        assertEquals(25, jogador.getAtaque()); // 10 base + 15 do equipamento
        assertEquals(100, jogador.getVida()); // Sem bônus de vida
        assertEquals(5, jogador.getDefesa()); // Sem bônus de defesa
        assertEquals(35, jogador.getMana()); // 20 base + 15 do equipamento
    }

    @Test
    public void deveDesequiparEquipamentoCorretamente() {
        // Configura o jogador
        Jogador jogador = new Jogador("Teste", 100, 10, 5, 20, 1, Elemento.VITAS, 0, 1, "Início do Jogo", null, null,
                null, new ArrayList<>());
        // adiciona o equipamento ao inventário do jogador
        jogador.getInventario().add(lancaDeDante);
        // Simula o uso do equipamento
        jogador.equiparItem(lancaDeDante);
        // Simula a desequipagem do equipamento
        jogador.desequiparItem(lancaDeDante);
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
        jogador.equiparItem(lancaDeDante);
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
        boolean resultado = jogador.desequiparItem(lancaDeDante);
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
        boolean resultado = jogador.comprarItem(lancaDeDante);
        // Verifica que o equipamento foi comprado e adicionado ao inventário
        assertEquals(true, resultado);
        assertEquals(1, jogador.getInventario().size());
        assertEquals(lancaDeDante, jogador.getInventario().get(0));
        // Verifica que o dinheiro foi descontado
        assertEquals(50, jogador.getOuro()); // 100 - 50 do equipamento
    }
}
