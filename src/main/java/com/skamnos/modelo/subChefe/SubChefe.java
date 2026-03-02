package com.skamnos.modelo.subChefe;
import com.skamnos.modelo.elemento.Elemento;
import com.skamnos.modelo.inimigo.Inimigo;

public abstract class SubChefe extends Inimigo {
    public SubChefe(String nome, int vidaMaxima, int ataque, int defesa, int manaMaxima, int nivel, Elemento elemento, int recompensaOuro, int recompensaExp, int nivelArea, String descricao) {
        super(nome, vidaMaxima, ataque, defesa, manaMaxima, nivel, elemento, recompensaOuro, recompensaExp, nivelArea, descricao);
    }

}
