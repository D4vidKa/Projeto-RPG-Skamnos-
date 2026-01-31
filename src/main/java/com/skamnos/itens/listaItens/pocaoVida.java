package com.skamnos.itens.listaItens;

import com.skamnos.itens.consumiveis.Consumiveis;
import com.skamnos.modelo.jogador.Jogador;

public class pocaoVida implements Consumiveis {
    private int valorCura = 20;

    @Override
    public String getNome() {
        return "Poção de Vida";
    }

    @Override
    public int getPreco() {
        return 40;
    }

    @Override
    public void usar(Jogador alvo) {
        alvo.receberCura(valorCura);
        System.out.println(alvo.getNome() + " recuperou " + valorCura + " pontos de vida!");
    }

}
