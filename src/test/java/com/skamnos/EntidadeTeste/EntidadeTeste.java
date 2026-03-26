package com.skamnos.entidadeTeste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skamnos.modelo.elemento.Elemento;
import com.skamnos.modelo.entidade.Entidade;


public class EntidadeTeste {
    private Entidade entidade;
    
    @BeforeEach
    public void setUp() {
        entidade = new Entidade("Teste", 100, 10, 5, 50, 1, Elemento.IGNIS) {
            // Implementação abstrata para permitir a criação de uma instância de Entidade
        };
    }

    @Test
    public void danoReduzVida(){
        entidade.receberDano(30); // Causa 30 de dano
        assertEquals(70, entidade.getVida()); // Vida deve ser reduzida para 70
    }
   
    @Test
    public void danoNaoPodeSerNegativo(){
        entidade.receberDano(-20); // Tenta causar dano negativo
        assertEquals(100, entidade.getVida()); // Vida não deve ser alterada
    }

    @Test
    public void vidaNaoPodeSerNegativa(){
        entidade.receberDano(150); // Tenta causar mais dano do que a vida máxima
        assertEquals(0, entidade.getVida()); // Vida não pode ser negativa
    }
    
    @Test
    public void deveEstarVivo(){
        assertEquals(true, entidade.estaVivo()); // Entidade deve estar viva com vida > 0
    }

    @Test
    public void deveEstarMorto(){
        entidade.receberDano(100); // Causa dano suficiente para matar a entidade
        assertEquals(false, entidade.estaVivo()); // Entidade deve estar morta com vida = 0
    }

    @Test
    public void curaAumentaVida(){
        entidade.receberDano(50); // Causa 50 de dano
        entidade.receberCura(30); // Cura 30 de vida
        assertEquals(80, entidade.getVida()); // Vida deve ser 80 após a cura
    }

    @Test
    public void curaNaoPodeSerNegativa(){
        entidade.receberDano(50); // Causa 50 de dano
        entidade.receberCura(-20); // Tenta curar com valor negativo
        assertEquals(50, entidade.getVida()); // Vida não deve ser alterada pela cura negativa
    }

    @Test
    public void vidaNaoPodeExcederMaxima(){
        entidade.receberDano(50); // Causa 50 de dano
        entidade.receberCura(100); // Tenta curar além da vida máxima
        assertEquals(100, entidade.getVida()); // Vida não deve exceder a vida máxima
    }

    @Test
    public void manaNaoPodeExcederMaxima(){
        entidade.receberMana(20); // Aumenta mana em 20
        assertEquals(50, entidade.getMana()); // Mana não deve exceder o máximo
    }

    @Test
    public void manaNaoPodeSerNegativa(){
        entidade.receberMana(-10); // Tenta aumentar mana com valor negativo
        assertEquals(50, entidade.getMana()); // Mana não deve ser alterada pela mana negativa
    }
    
    @Test
    public void obterElementoAtaque(){
        assertEquals(Elemento.IGNIS, entidade.getElementoAtaque()); // O elemento de ataque deve ser IGNIS
    }
    
    @Test
    public void atacarReduzVidaDoAlvo(){
        Entidade alvo = new Entidade("Alvo", 100, 5, 5, 50, 1, Elemento.AEQUOR) {
            // Implementação abstrata para permitir a criação de uma instância de Entidade
        };
        entidade.atacar(alvo); // Ataca o alvo
        assertEquals(95, alvo.getVida()); // Vida do alvo deve ser reduzida em 5 (dano base)
    }

    @Test
    public void defesaMaiorQueAtaque(){
        Entidade alvo = new Entidade("Alvo", 100, 5, 15, 50, 1, Elemento.AEQUOR) {
            // Implementação abstrata para permitir a criação de uma instância de Entidade
        };
        entidade.atacar(alvo); // Ataca o alvo
        assertEquals(99, alvo.getVida()); // Vida do alvo deve ser reduzida em 1 (dano mínimo) devido à defesa maior que o ataque
    }

    @Test
    public void atacarDeveMatarAlvo(){
        Entidade alvo = new Entidade("Alvo", 5, 5, 5, 50, 1, Elemento.AEQUOR) {
            // Implementação abstrata para permitir a criação de uma instância de Entidade
        };
        entidade.atacar(alvo); // Ataca o alvo
        assertEquals(0, alvo.getVida()); // Vida do alvo deve ser reduzida a 0 (morto)
        assertEquals(false, alvo.estaVivo()); // Alvo deve estar morto
    }
}