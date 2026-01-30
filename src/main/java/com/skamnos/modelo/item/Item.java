package com.skamnos.modelo.item;

import com.skamnos.modelo.elemento.Elemento;
import com.skamnos.modelo.jogador.Jogador;

public interface Item {
    
    /*
    Métodos que todo item deve implementar
     */
    public abstract String getNome();
    public abstract int getPreco();
    public abstract int getBonusVida();
    public abstract int getBonusAtaque();
    public abstract int getBonusDefesa();
    public abstract int getBonusMana();
    public abstract Elemento getElemento();
    public abstract void usar(Jogador alvo);
}
