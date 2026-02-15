package com.skamnos.itens.corpo;

import com.skamnos.itens.equipamento.Equipamento;

/*
 * Interface que representa um item de corpo, que é um tipo de Equipamento.
 */
public interface Corpo extends Equipamento {
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
}
