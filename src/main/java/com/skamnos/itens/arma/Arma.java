package com.skamnos.itens.arma;

import com.skamnos.itens.equipamento.Equipamento;
import com.skamnos.modelo.elemento.Elemento;

/*
 * Interface que representa um item de arma, que é um tipo de Equipamento.
 */
public interface Arma extends Equipamento {
    // Métodos específicos para armas
    @Override
    String getNome();

    @Override
    int getPreco();

    @Override
    String getDescricao();

    @Override
    int getBonusVida();

    @Override
    int getBonusAtaque();

    @Override
    int getBonusDefesa();

    @Override
    int getBonusMana();

    @Override
    String getTipoArma();

    // Método para obter o elemento da arma, se aplicável
    public Elemento getElementoItem();
}
