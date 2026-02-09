package com.skamnos.modelo.inimigoComum;

import com.skamnos.modelo.inimigo.Inimigo;
import com.skamnos.modelo.elemento.Elemento;


public class InimigoComum extends Inimigo{
    public InimigoComum(String nome, int vidaMaxima, int ataque, int defesa, int manaMaxima, int nivel, Elemento elemento, int recompensaOuro, int recompensaExp, int nivelArea, String descricao) {
        super(nome, vidaMaxima, ataque, defesa, manaMaxima, nivel, elemento, recompensaOuro, recompensaExp, nivelArea, descricao);
    }

    @Override
    public void executarTurno() {
        // Lógica para o turno do inimigo comum, como atacar o jogador ou usar uma habilidade
        if (this.estaVivo()) {
            this.atacar(null); // Substitua 'null' pela referência ao jogador quando disponível
        } else {
            this.morrer(null); // Substitua 'null' pela referência ao jogador quando disponível
        }
    }
}
