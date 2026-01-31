package com.skamnos.modelo.jogador;

import com.skamnos.modelo.elemento.Elemento;
import com.skamnos.modelo.entidade.Entidade;

public class Jogador extends Entidade{

    public Jogador(String nome, int vidaMaxima, int ataque, int defesa, int manaMaxima, int nivel, Elemento elemento) {
        super(nome, vidaMaxima, ataque, defesa, manaMaxima, nivel, elemento);
        
    }
    
}
