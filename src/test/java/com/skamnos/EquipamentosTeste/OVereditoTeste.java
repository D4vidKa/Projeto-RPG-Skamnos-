package com.skamnos.EquipamentosTeste;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import com.skamnos.modelo.jogador.Jogador;
import com.skamnos.modelo.elemento.Elemento;
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
        // Configura o jogador
        Jogador jogador = new Jogador("Teste", 100, 10, 5, 20, 1, Elemento.VITAS, 0, 1, "Início do Jogo", null, null,
                null, new ArrayList<>());
        // adiciona o equipamento ao inventário do jogador
        jogador.getInventario().add(oVeredito);
        // Simula o uso do equipamento
        jogador.equiparItem(oVeredito);
        // Verifica os bônus aplicados
        assertEquals(30, jogador.getAtaque()); // 10 base + 20 do equipamento
        assertEquals(100, jogador.getVida()); // Sem bônus de vida
        assertEquals(5, jogador.getDefesa()); // Sem bônus de defesa
        assertEquals(30, jogador.getMana()); // 20 base + 10 do equipamento

    }
}
