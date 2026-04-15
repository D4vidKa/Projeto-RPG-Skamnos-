package com.skamnos.equipamentosTeste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.skamnos.modelo.jogador.Jogador;
import com.skamnos.modelo.elemento.Elemento;
import com.skamnos.modelo.inventario.Inventario;
import com.skamnos.itens.listaEquipamentos.*;

public class OVereditoTeste {
    private OVeredito oVeredito;

    @BeforeEach
    public void setUp() {
        oVeredito = new OVeredito();
    }

    @Test
    public void deveTerNomeCorreto() {
        assertEquals("O Veredito", oVeredito.getNome());
    }

    @Test
    public void deveTerPrecoCorreto() {
        assertEquals(80, oVeredito.getPreco());
    }

    @Test
    public void deveTerDescricaoCorreta() {
        String descricaoEsperada = """
                Forjados em Aço Sombral pelos Mestres de Engenharia a mando do Sindicato, estes machados são a extensão da vontade do Conselho de Ouro.
                Nas mãos de um Executor, a lâmina não apenas corta; ela encerra disputas com uma finalidade absoluta.
                Dizem que o peso do metal é proporcional à dívida de quem o enfrenta, separando carne e osso com a precisão de um contrato sendo selado.
                """;
        assertEquals(descricaoEsperada, oVeredito.getDescricao());
    }

    @Test
    public void deveTerTipoArmaCorreto() {
        assertEquals("Arma", oVeredito.getTipoArma());
    }

    @Test
    // Testa os bônus de ataque, vida, defesa e mana
    public void deveTerBonusCorretos() {
        assertEquals(20, oVeredito.getBonusAtaque());
        assertEquals(0, oVeredito.getBonusVida());
        assertEquals(0, oVeredito.getBonusDefesa());
        assertEquals(10, oVeredito.getBonusMana());
    }

    @Test
    public void deveTerElementoCorreto() {
        assertEquals(Elemento.TELLUS, oVeredito.getElementoItem());
    }

    @Test
    public void deveUsarEquipamentoCorretamente() {
        Inventario inventario = new Inventario(30);
        // Configura o jogador
        Jogador jogador = new Jogador("Teste", 100, 10, 5, 20, 1, Elemento.VITAS, 0, 1, "Início do Jogo", null, null,
                null, inventario);
        // adiciona o equipamento ao inventário do jogador
        jogador.getInventario().adicionarItem(oVeredito);
        // Simula o uso do equipamento
        jogador.equiparItem(oVeredito);
        // Verifica os bônus aplicados
        assertEquals(30, jogador.getAtaque()); // 10 base + 20 do equipamento
        assertEquals(100, jogador.getVida()); // Sem bônus de vida
        assertEquals(5, jogador.getDefesa()); // Sem bônus de defesa
        assertEquals(30, jogador.getMana()); // 20 base + 10 do equipamento
    }

    @Test
    public void deveDesequiparEquipamentoCorretamente() {
        Inventario inventario = new Inventario(30);
        // Configura o jogador
        Jogador jogador = new Jogador("Teste", 100, 10, 5, 20, 1, Elemento.VITAS, 0, 1, "Início do Jogo", null, null,
                null, inventario);
        // adiciona o equipamento ao inventário do jogador
        jogador.getInventario().adicionarItem(oVeredito);
        // Simula o uso do equipamento
        jogador.equiparItem(oVeredito);
        // Simula a desequipagem do equipamento
        jogador.desequiparItem(oVeredito);
        // Verifica os bônus removidos
        assertEquals(10, jogador.getAtaque()); // Volta ao valor base
        assertEquals(100, jogador.getVida()); // Sem bônus de vida
        assertEquals(5, jogador.getDefesa()); // Sem bônus de defesa
        assertEquals(20, jogador.getMana()); // Volta ao valor base
    }

    @Test
    public void naoPodeEquiparSeNaoTiverNoInventario() {
        Inventario inventario = new Inventario(30);
        // Configura o jogador
        Jogador jogador = new Jogador("Teste", 100, 10, 5, 20, 1, Elemento.VITAS, 0, 1, "Início do Jogo", null, null,
                null, inventario);
        // Tenta equipar o item sem tê-lo no inventário
        boolean resultado = jogador.equiparItem(oVeredito);
        // Verifica que o equipamento não foi equipado
        assertEquals(false, resultado);
    }

    @Test
    public void naoPodeDesequiparSeNaoEstiverEquipado() {
        Inventario inventario = new Inventario(30);
        // Configura o jogador
        Jogador jogador = new Jogador("Teste", 100, 10, 5, 20, 1, Elemento.VITAS, 0, 1, "Início do Jogo", null, null,
                null, inventario);
        // Tenta desequipar o item sem tê-lo equipado
        boolean resultado = jogador.desequiparItem(oVeredito);
        // Verifica que o equipamento não foi desequipado
        assertEquals(false, resultado);
    }

    @Test
    // teste para verificar a compra
    public void deveComprarEquipamentoCorretamente() {
        Inventario inventario = new Inventario(30);
        // Configura o jogador com dinheiro suficiente
        Jogador jogador = new Jogador("Teste", 100, 10, 5, 20, 1, Elemento.VITAS, 100, 1, "Início do Jogo", null, null,
                null, inventario);
        // Simula a compra do equipamento
        boolean resultado = jogador.comprarItem(oVeredito);
        // Verifica que o equipamento foi comprado e adicionado ao inventário
        assertEquals(true, resultado);
        assertEquals(1, jogador.getInventario().getQuantidadeDeItens());
        assertEquals(oVeredito, jogador.getInventario().obterItem(0));
        // Verifica que o dinheiro foi descontado
        assertEquals(20, jogador.getOuro()); // 100 - 80 do equipamento
    }
}
