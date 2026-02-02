package com.skamnos.itens.listaItens;

import com.skamnos.itens.consumiveis.Consumiveis;
import com.skamnos.modelo.jogador.Jogador;

/*
 * Classe que representa o Milagre de Hydrax, um item consumível que restaura toda a vida.
 */
public class MilagreDeHydrax implements Consumiveis {
    // Atributos do item
    private String nome = "Milagre de Hydrax";
    private int preco = 100;
    private String descricao = "A obra-prima de Silas que o fez virar um dos grandes Magister do Conclave, criada em colaboração com outros discípulos após anos de desenvolvimento. Esta poção foi desenvolvida a pedido da Mestra-Oráculo Lyra para fortalecer seus espiões em missões de extremo risco, sendo capaz de recuperar toda a vitalidade de uma pessoa.";

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
        int valorCura = alvo.getVidaMaxima();
        alvo.receberCura(valorCura);
        System.out.println(alvo.getNome() + " restaurou " + valorCura + " pontos de vida usando " + nome + ".");
    }

}
