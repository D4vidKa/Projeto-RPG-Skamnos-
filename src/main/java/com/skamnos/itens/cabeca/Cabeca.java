package com.skamnos.itens.cabeca;

import com.skamnos.itens.equipamento.Equipamento;

/*
 * Classe que representa um item de cabeça, que é um tipo de Equipamento.
 */
public class Cabeca extends Equipamento{
    @Override
    public String getNome() {
        return "Cabeça";
    }
    @Override
    public int getPreco() {
        return 0;
    }
    @Override
    public String getDescricao() {
        return "Equipamento para a cabeça do jogador.";
    }
}
