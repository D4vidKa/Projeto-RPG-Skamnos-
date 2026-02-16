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
    private String descricao = """
            Efeito: ---Recupera toda a Vida---
            A obra-prima de Silas que o fez virar um dos grandes Magister do Conclave, criada em colaboração com outros discípulos após anos de desenvolvimento.
            Esta poção foi desenvolvida a pedido da Mestra-Oráculo Lyra para fortalecer seus espiões em missões de extremo risco, sendo capaz de recuperar toda a vitalidade de uma pessoa.
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
    // Método para usar o item, restaurando toda a vida do jogador
    public void usar(Jogador alvo) {
        if (alvo.getVida() >= alvo.getVidaMaxima()) {
            System.out.println(alvo.getNome() + " já está com a vida cheia., não é necessário usar " + nome + ".");
            return;
        } else {
            alvo.restaurarVidaMaxima();
            System.out.println(alvo.getNome() + " restaurou toda a vida usando " + nome + ".");
        }
    }   

    @Override
    public String toString() {
        return nome + " - Preço: " + preco + " moedas de ouro\n" + descricao;
    }
}
