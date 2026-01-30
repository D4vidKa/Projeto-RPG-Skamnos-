package com.skamnos.itens.item;

import com.skamnos.modelo.elemento.Elemento;

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
