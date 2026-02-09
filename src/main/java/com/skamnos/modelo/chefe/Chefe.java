package com.skamnos.modelo.chefe;

import com.skamnos.modelo.inimigo.Inimigo;
import com.skamnos.modelo.elemento.Elemento;

public class Chefe extends Inimigo {
    public Chefe(String nome, int vidaMaxima, int ataque, int defesa, int manaMaxima, int nivel, Elemento elemento, int recompensaOuro, int recompensaExp, int nivelArea, String descricao) {
        super(nome, vidaMaxima, ataque, defesa, manaMaxima, nivel, elemento, recompensaOuro, recompensaExp, nivelArea, descricao);
    }

    @Override
    // Lógica para o turno do chefe, como atacar o jogador ou usar uma habilidade especial
    public void executarTurno() {
        
    }
}
