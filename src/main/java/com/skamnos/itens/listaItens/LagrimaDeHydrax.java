package com.skamnos.itens.listaItens;

import com.skamnos.itens.consumiveis.Consumiveis;
import com.skamnos.modelo.jogador.Jogador;

/*
 * Classe que representa a Lágrima de Hydrax, um item consumível que restaura vida.
 */
public class LagrimaDeHydrax implements Consumiveis {
    // Atributos do item
    private String nome = "Lágrima de Hydrax";
    private int preco = 65;
    private String descricao = """
            Efeito: ---Recupera 40 Pontos de Vida---
            Uma versão aprimorada da escama comum, também criada por Silas.
            Após uma revolta no Arquipélago de Nereza onde várias pessoas morreram, Silas viu a necessidade de aprimorar sua criação.
            """;

    /*
     * Métodos implementados da interface Consumiveis
     */
    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public int getPreco() {
        return preco;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    @Override
    public void usar(Jogador alvo) {
        int valorCura = 40;
        alvo.receberCura(valorCura);
        System.out.println(alvo.getNome() + " restaurou " + valorCura + " pontos de vida usando " + nome + ".");
    }

    @Override
    public String toString() {
        return nome + " - Preço: " + preco + " moedas de ouro\n" + descricao;
    }
}
