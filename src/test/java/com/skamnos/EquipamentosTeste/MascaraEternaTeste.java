package com.skamnos.equipamentosTeste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.skamnos.modelo.elemento.Elemento;
import com.skamnos.modelo.inventario.Inventario;
import com.skamnos.modelo.jogador.Jogador;
import com.skamnos.itens.listaEquipamentos.*;

public class MascaraEternaTeste {
    private MascaraEterna mascaraEterna;

    @BeforeEach
    public void setUp() {
        mascaraEterna = new MascaraEterna();
    }

    @Test
    public void deveTerNomeCorreto() {
        assertEquals("Máscara Eterna", mascaraEterna.getNome());
    }

    @Test
    public void deveTerPrecoCorreto() {
        assertEquals(75, mascaraEterna.getPreco());
    }

    @Test
    public void deveTerDescricaoCorreta() {
        String descricaoEsperada = """
                Uma relíquia de um tempo cujas crônicas foram perdidas.
                Forjada em um metal translúcido que desafia a metalurgia moderna, esta máscara reflete a luz e o calor com a intensidade do próprio sol. 
                Desenterrada das camadas mais profundas do Pico da Ascensão, ela emana uma aura de autoridade primordial. 
                Os Magisters do Conclave estimam que o artefato date de mais de 2500 anos.
                """;
        assertEquals(descricaoEsperada, mascaraEterna.getDescricao());
    }

    @Test
    public void deveTerTipoArmaCorreto() {
        assertEquals("Cabeça", mascaraEterna.getTipoArma());
    }

    @Test
    // Testa os bônus de ataque, vida, defesa e mana
    public void deveTerBonusCorretos() {
        assertEquals(0, mascaraEterna.getBonusAtaque());
        assertEquals(20, mascaraEterna.getBonusVida());
        assertEquals(30, mascaraEterna.getBonusDefesa());
        assertEquals(0, mascaraEterna.getBonusMana());
    }

    @Test
    public void deveUsarEquipamentoCorretamente() {
        Inventario inventario = new Inventario(30);
        // Configura o jogador
        Jogador jogador = new Jogador("Teste", 100, 10, 5, 20, 1, Elemento.VITAS, 0, 1, "Início do Jogo", null, null,
                null, inventario);
        // adiciona o equipamento ao inventário do jogador
        jogador.getInventario().adicionarItem(mascaraEterna);
        // Simula o uso do equipamento
        jogador.equiparItem(mascaraEterna);
        // Verifica os bônus aplicados
        assertEquals(10, jogador.getAtaque()); // Sem bônus de ataque
        assertEquals(120, jogador.getVidaMaxima()); // 100 base + 20 do equipamento
        assertEquals(35, jogador.getDefesa()); // 5 base + 30 do equipamento
        assertEquals(20, jogador.getMana()); // Sem bônus de mana
    }

    @Test
    public void deveDesequiparEquipamentoCorretamente() {
        Inventario inventario = new Inventario(30);
        // Configura o jogador
        Jogador jogador = new Jogador("Teste", 100, 10, 5, 20, 1, Elemento.VITAS, 0, 1, "Início do Jogo", null, null,
                null, inventario);
        // adiciona o equipamento ao inventário do jogador
        jogador.getInventario().adicionarItem(mascaraEterna);
        // Simula o uso do equipamento
        jogador.equiparItem(mascaraEterna);
        // Simula a desequipagem do equipamento
        jogador.desequiparItem(mascaraEterna);
        // Verifica os bônus removidos
        assertEquals(10, jogador.getAtaque()); // Volta ao valor base
        assertEquals(100, jogador.getVidaMaxima()); // Sem bônus de vida
        assertEquals(5, jogador.getDefesa()); // Sem bônus de defesa
        assertEquals(20, jogador.getMana()); // Volta ao valor base
    }

    @Test
    public void naoPodeEquiparSeNaoTiverNoInventario() {
        Inventario inventario = new Inventario(30);
        // Configura o jogador
        Jogador jogador = new Jogador("Teste", 100, 10, 5, 20, 1, Elemento.VITAS, 0, 1, "Início do Jogo", null, null,
                null, inventario);
        // Tenta equipar o item sem adicioná-lo ao inventário
        jogador.equiparItem(mascaraEterna);
        // Verifica que os bônus não foram aplicados
        assertEquals(10, jogador.getAtaque()); // Valor base
        assertEquals(100, jogador.getVidaMaxima()); // Sem bônus de vida
        assertEquals(5, jogador.getDefesa()); // Sem bônus de defesa
        assertEquals(20, jogador.getMana()); // Valor base
    }

    @Test
    public void naoPodeDesequiparSeNaoEstiverEquipado() {
        Inventario inventario = new Inventario(30);
        // Configura o jogador
        Jogador jogador = new Jogador("Teste", 100, 10, 5, 20, 1, Elemento.VITAS, 0, 1, "Início do Jogo", null, null,
                null, inventario);
        // Tenta desequipar o item sem tê-lo equipado
        boolean resultado = jogador.desequiparItem(mascaraEterna);
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
        boolean resultado = jogador.comprarItem(mascaraEterna);
        // Verifica que o equipamento foi comprado e adicionado ao inventário
        assertEquals(true, resultado);
        assertEquals(1, jogador.getInventario().getQuantidadeDeItens());
        assertEquals(mascaraEterna, jogador.getInventario().obterItem(0));
        // Verifica que o dinheiro foi descontado
        assertEquals(25, jogador.getOuro()); // 100 - 75 do equipamento
    }
}
