package com.skamnos.itens.arma;
import com.skamnos.itens.equipamento.Equipamento;

/*
 * Classe que representa uma Arma, que é um tipo de Equipamento.
 */
public class Arma extends Equipamento{
    @Override
    public String getNome() {
        return "Arma";
    }
    @Override
    public int getPreco() {
        return 0;
    }
    @Override
    public String getDescricao() {
        return "Equipamento para a arma do jogador.";
    }
}
