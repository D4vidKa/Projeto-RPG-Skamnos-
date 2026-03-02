package com.skamnos.InimigosTeste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.skamnos.modelo.elemento.Elemento;
import com.skamnos.modelo.inimigoComum.InimigoComum;
import com.skamnos.modelo.jogador.Jogador;

public class InimigoComumTeste {
    private InimigoComum inimigo;
    private Jogador jogador; // Adicione um jogador para testar a interação

    @BeforeEach
    public void setUp() {
        inimigo = new InimigoComum("Goblin", 100, 15, 5, 30, 1, Elemento.TELLUS, 50, 20, 1, "Um goblin comum.");
        jogador = new Jogador("Teste", 50, 10, 7, 8, 1, Elemento.VITAS, 0, 1, "Início do Jogo", null, null, null, null); // Exemplo de jogador
    }

    @Test
    // Teste para verificar se o inimigo comum executa seu turno corretamente
    public void testeExecutarTurno() {
        int vidaInicialJogador = jogador.getVida();
        inimigo.executarTurno(jogador);
        int danoCausado = vidaInicialJogador - jogador.getVida();
        assertEquals(8, danoCausado); // Verifica se o dano causado é o esperado (15 de ataque - 7 de defesa)
    }

    @Test
    // Teste para verificar se o inimigo comum morre corretamente e concede recompensas ao jogador
    public void testeMorrer() {
        inimigo.setVida(0); // Define a vida do inimigo como 0 para simular a morte
        inimigo.executarTurno(jogador); // Executa o turno para que o método morrer seja chamado
        assertEquals(50, jogador.getOuro()); // Verifica se o jogador recebeu o ouro corretamente
        assertEquals(21, jogador.getExperiencia()); // Verifica se o jogador recebeu a experiência corretamente
    }  
}
