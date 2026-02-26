package com.skamnos.EquipamentosTeste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import com.skamnos.modelo.elemento.Elemento;
import com.skamnos.modelo.jogador.Jogador;
import com.skamnos.itens.listaEquipamentos.*;

public class ElmoDeKiraTeste {
    private ElmoDeKira elmoDeKira;

    @BeforeEach
    public void setUp() {
        elmoDeKira = new ElmoDeKira();
    }

    @Test
    public void deveTerNomeCorreto() {
        assertEquals("Elmo de Kira", elmoDeKira.getNome());
    }

    @Test
    public void deveTerPrecoCorreto() {
        assertEquals(50, elmoDeKira.getPreco());
    }

    @Test
    public void deveTerDescricaoCorreta() {
        String descricaoEsperada = """
                Um elmo de aço fosco, marcado por cicatrizes de um combate antigo. 
                Ele pertenceu a Kira, uma Inceptora que tombou durante a sangrenta Guerra Civil da Grande Forja. 
                Enquanto os nomes dos generais foram gravados em ouro pelo Sindicato, o de Kira foi levado pelo vento. 
                Este elmo é o único fragmento que impede que sua existência seja totalmente devorada pelo tempo — um peso silencioso sobre a cabeça de quem o usa.
                """;
        assertEquals(descricaoEsperada, elmoDeKira.getDescricao());
    }

    @Test
    public void deveTerTipoArmaCorreto() {
        assertEquals("Cabeça", elmoDeKira.getTipoArma());
    }

    @Test
    // Testa os bônus de ataque, vida, defesa e mana
    public void deveTerBonusCorretos() {
        assertEquals(0, elmoDeKira.getBonusAtaque());
        assertEquals(20, elmoDeKira.getBonusVida());
        assertEquals(20, elmoDeKira.getBonusDefesa());
        assertEquals(0, elmoDeKira.getBonusMana());
    }

    @Test
    public void deveUsarEquipamentoCorretamente() {
        // Configura o jogador
        Jogador jogador = new Jogador("Teste", 100, 10, 5, 20, 1, Elemento.VITAS, 0, 1, "Início do Jogo", null, null,
                null, new ArrayList<>());
        // adiciona o equipamento ao inventário do jogador
        jogador.getInventario().add(elmoDeKira);
        // Simula o uso do equipamento
        jogador.equiparItem(elmoDeKira);
        // Verifica os bônus aplicados
        assertEquals(10, jogador.getAtaque()); // Sem bônus de ataque
        assertEquals(120, jogador.getVidaMaxima()); // 100 base + 20 do equipamento
        assertEquals(25, jogador.getDefesa()); // 5 base + 20 do equipamento
        assertEquals(20, jogador.getMana()); // Sem bônus de mana
    }

    @Test
    public void deveDesequiparEquipamentoCorretamente() {
        // Configura o jogador
        Jogador jogador = new Jogador("Teste", 100, 10, 5, 20, 1, Elemento.VITAS, 0, 1, "Início do Jogo", null, null,
                null, new ArrayList<>());
        // adiciona o equipamento ao inventário do jogador
        jogador.getInventario().add(elmoDeKira);
        // Simula o uso do equipamento
        jogador.equiparItem(elmoDeKira);
        // Simula a desequipagem do equipamento
        jogador.desequiparItem(elmoDeKira);
        // Verifica os bônus removidos
        assertEquals(10, jogador.getAtaque()); // Volta ao valor base
        assertEquals(100, jogador.getVidaMaxima()); // Sem bônus de vida
        assertEquals(5, jogador.getDefesa()); // Sem bônus de defesa
        assertEquals(20, jogador.getMana()); // Volta ao valor base
    }

    @Test
    public void naoPodeEquiparSeNaoTiverNoInventario() {
        // Configura o jogador
        Jogador jogador = new Jogador("Teste", 100, 10, 5, 20, 1, Elemento.VITAS, 0, 1, "Início do Jogo", null, null,
                null, new ArrayList<>());
        // Tenta equipar o item sem adicioná-lo ao inventário
        jogador.equiparItem(elmoDeKira);
        // Verifica que os bônus não foram aplicados
        assertEquals(10, jogador.getAtaque()); // Valor base
        assertEquals(100, jogador.getVidaMaxima()); // Sem bônus de vida
        assertEquals(5, jogador.getDefesa()); // Sem bônus de defesa
        assertEquals(20, jogador.getMana()); // Valor base
    }

    @Test
    public void naoPodeDesequiparSeNaoEstiverEquipado() {
        // Configura o jogador
        Jogador jogador = new Jogador("Teste", 100, 10, 5, 20, 1, Elemento.VITAS, 0, 1, "Início do Jogo", null, null,
                null, new ArrayList<>());
        // Tenta desequipar o item sem tê-lo equipado
        boolean resultado = jogador.desequiparItem(elmoDeKira);
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
        boolean resultado = jogador.comprarItem(elmoDeKira);
        // Verifica que o equipamento foi comprado e adicionado ao inventário
        assertEquals(true, resultado);
        assertEquals(1, jogador.getInventario().size());
        assertEquals(elmoDeKira, jogador.getInventario().get(0));
        // Verifica que o dinheiro foi descontado
        assertEquals(50, jogador.getOuro()); // 100 - 50 do equipamento
    }
}
