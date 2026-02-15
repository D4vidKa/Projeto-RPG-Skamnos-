package com.skamnos.itens.cabeca;

import com.skamnos.itens.equipamento.Equipamento;

/*
 * Interface que representa um item de cabeça, que é um tipo de Equipamento.
 */
public interface Cabeca extends Equipamento {
    // Métodos específicos para itens de cabeça
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
