package com.skamnos.itens.corpo;
import com.skamnos.itens.equipamento.Equipamento;

/*
 * Classe que representa um item de corpo, que é um tipo de Equipamento.
 */
public class Corpo extends Equipamento{
    @Override
    public String getNome() {
        return "Corpo";
    }

    @Override
    public int getPreco() {
        return 0;
    }

    @Override
    public String getDescricao() {
        return "Equipamento para o corpo do jogador.";
    }
}
