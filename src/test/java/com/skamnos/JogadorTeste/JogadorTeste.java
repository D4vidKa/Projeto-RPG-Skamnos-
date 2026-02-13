package com.skamnos.JogadorTeste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skamnos.itens.listaItens.BencaoLuminar;
import com.skamnos.modelo.elemento.Elemento;
import com.skamnos.modelo.jogador.Jogador;

public class JogadorTeste {
    private Jogador jogador;
    
    @BeforeEach
    public void setUp() {
        jogador = new Jogador("Teste", 50, 10, 5, 5, 1, Elemento.VITAS, 0, 1, "Início do Jogo", null, null, null, null);
    }

    @Test
    // Teste para verificar se o jogador ganha ouro corretamente
    public void deveGanharOuro(){
        jogador.ganharOuro(100);
        assertEquals(100, jogador.getOuro()); // Ouro deve ser 100 após ganhar
    }
    
    @Test
    // Teste para verificar que o jogador não pode ganhar ouro negativo
    public void ganharOuroNaoPodeSerNegativo(){
        jogador.ganharOuro(-50); // Tenta ganhar ouro negativo
        assertEquals(0, jogador.getOuro()); // Ouro não deve ser alterado
    }

    @Test
    // Teste para verificar se o jogador ganha experiência corretamente
    public void deveGanharExperiencia(){
        jogador.ganharExperiencia(10);
        assertEquals(11, jogador.getExperiencia()); // Experiência deve ser 11 após ganhar
    }

    @Test
    // Teste para verificar que o jogador não pode ganhar experiência negativa
    public void ganharExperienciaNaoPodeSerNegativo(){
        jogador.ganharExperiencia(-5); // Tenta ganhar experiência negativa
        assertEquals(1, jogador.getExperiencia()); // Experiência não deve ser alterada
    }

    @Test
    // Teste para verificar se o exp reseta ao subir de nível
    public void expDeveResetarAoSubirDeNivel(){
        jogador.ganharExperiencia(50); // Ganha experiência suficiente para subir de nível
        assertEquals(1, jogador.getExperiencia()); // Experiência deve resetar para 1 após subir de nível
    }

    @Test
    // Teste para verificar se o jogador sobe de nível corretamente
    public void deveSubirNivel(){
        jogador.ganharExperiencia(50); // Ganha experiência suficiente para subir de nível
        assertEquals(2, jogador.getNivel()); // Nível deve ser 2 após subir de nível
    }

    @Test
    // Teste para verificar que o jogador não pode acumular experiência após atingir o nível máximo
    public void experienciaNaoAcumulaAposNivelMaximo(){
        jogador.setNivel(50); // Define o nível do jogador para o máximo
        jogador.ganharExperiencia(10); // Tenta ganhar experiência
        assertEquals(0, jogador.getExperiencia()); // Experiência não deve ser acumulada
    }

    @Test
    // Teste para verificar que o jogador não pode ultrapassar o nível máximo
    public void nivelNaoUltrapassaMaximo(){
        jogador.setNivel(50); // Define o nível do jogador para o máximo
        jogador.ganharExperiencia(50); // Tenta ganhar experiência
        assertEquals(50, jogador.getNivel()); // Nível não deve ultrapassar 50
    }

    @Test
    // Teste para verificar se os atributos aumentam corretamente ao subir de nível
    public void atributosDevemAumentarAoSubirNivel(){
        jogador.ganharExperiencia(50); // Ganha experiência suficiente para subir de nível
        assertEquals(57, jogador.getVidaMaxima()); // Vida máxima deve aumentar para 57
        assertEquals(13, jogador.getAtaque()); // Ataque deve aumentar para 13
        assertEquals(7, jogador.getDefesa()); // Defesa deve aumentar para 7
        assertEquals(6, jogador.getManaMaxima()); // Mana máxima deve aumentar para 6
    }

    @Test
    public void atributosDevemAumentarBonusAoSubirNivel(){
        jogador.setNivel(4); // Define o nível do jogador para 4
        jogador.ganharExperiencia(50); // Ganha experiência suficiente para subir de nível
        assertEquals(67, jogador.getVidaMaxima()); // Vida máxima deve aumentar para 67 (57 + 10)
        assertEquals(18, jogador.getAtaque()); // Ataque deve aumentar para 18 (13 + 5)
        assertEquals(10, jogador.getDefesa()); // Defesa deve aumentar para 10 (7 + 3)
        assertEquals(8, jogador.getManaMaxima()); // Mana máxima deve aumentar para 8 (6 + 2)
    }

    @Test
    // Teste para saber se o item é comprado corretamente
    public void deveComprarItem(){
        BencaoLuminar BencaoLuminar = new BencaoLuminar(); // Cria uma instância do item Bênção Luminar
        jogador.ganharOuro(200); // Dá ao jogador ouro suficiente para comprar o
        boolean comprado = jogador.comprarItem(BencaoLuminar); // Tenta comprar o item Bênção Luminar
        assertEquals(true, comprado); // O item deve ser comprado com sucesso
        assertEquals(0, jogador.getOuro()); // O ouro do jogador deve ser reduzido para 0 após a compra
    }

    @Test
    // Teste para verificar que o jogador não pode comprar um item se não tiver ouro suficiente
    public void naoDeveComprarItemSemOuroSuficiente(){
        BencaoLuminar BencaoLuminar = new BencaoLuminar(); // Cria uma instância do item Bênção Luminar
        boolean comprado = jogador.comprarItem(BencaoLuminar); // Tenta comprar o item Bênção Luminar sem ouro suficiente
        assertEquals(false, comprado); // O item não deve ser comprado
        assertEquals(0, jogador.getOuro()); // O ouro do jogador deve permanecer 0
    }

    @Test
    // Teste para verificar se o jogador descansou corretamente
    public void deveDescansar(){
        jogador.setVida(30); // Define a vida do jogador para 30
        jogador.setMana(3); // Define a mana do jogador para 3
        jogador.descansar(); // O jogador descansa para recuperar vida e mana
        assertEquals(jogador.getVidaMaxima(), jogador.getVida()); // A vida do jogador deve ser restaurada para o máximo
        assertEquals(jogador.getManaMaxima(), jogador.getMana()); // A mana do jogador deve ser restaurada para o máximo
    }
}
