package com.skamnos.itens.equipamento;

import com.skamnos.itens.item.Item;

/*
* Interface que representa um Equipamento, que é um tipo de Item.
 */
public interface Equipamento extends Item {
    // Métodos que todo equipamento deve implementar
    @Override
    String getNome();

    @Override
    int getPreco();

    @Override
    String getDescricao();
    
    @Override
    String toString();

    public abstract int getBonusVida();

    public abstract int getBonusAtaque();

    public abstract int getBonusDefesa();

    public abstract int getBonusMana();

    // Método para saber o tipo do equipamento (arma, armadura, etc.)
    public abstract String getTipoArma();
}
