package com.skamnos.modelo.inimigoComum;

import com.skamnos.modelo.inimigo.Inimigo;
import com.skamnos.modelo.jogador.Jogador;
import com.skamnos.modelo.elemento.Elemento;

public class InimigoComum extends Inimigo{
    public InimigoComum(String nome, int vidaMaxima, int ataque, int defesa, int manaMaxima, int nivel, Elemento elemento, int recompensaOuro, int recompensaExp, int nivelArea, String descricao) {
        super(nome, vidaMaxima, ataque, defesa, manaMaxima, nivel, elemento, recompensaOuro, recompensaExp, nivelArea, descricao);
    }

    @Override
    public void executarTurno(Jogador jogador) {
        if (this.vida > 0) {
            // Lógica para o inimigo comum executar seu turno
            // Por exemplo, pode atacar o jogador ou usar uma habilidade
            System.out.println(nome + " te ataca!");
            int danoCausado = this.atacar(jogador); // Substitua pelo objeto do jogador
            System.out.println(this.getNome() + " causou " + danoCausado + " de dano!");
        } else {
            this.morrer(jogador); // Chama o método morrer para conceder recompensas ao jogador
            System.out.println(nome + " foi derrotado! Você ganhou " + recompensaOuro + " de ouro e " + recompensaExp + " de experiência!");
        }
    }
}
