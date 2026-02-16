package com.skamnos.itens.listaItens;

import com.skamnos.itens.consumiveis.Consumiveis;
import com.skamnos.modelo.jogador.Jogador;

/*
 * Classe que representa a Escama de Hydrax, um item consumível que restaura vida.
 */
public class EscamaDeHydrax implements Consumiveis {
    // Atributos do item
    private String nome = "Escama de Hydrax";
    private int preco = 40;
    private String descricao = """
            Efeito: ---Recupera 20 Pontos de Vida---
            Uma poção capaz de recuperar uma pequena parte da vida do usuário.
            Foi criada por Silas um Discipulus do Conclave das Correntes há 200 anos.
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
    // Método para usar o item, restaurando a vida do jogador
    public void usar(Jogador alvo) {
        int valorCura = 20;
        if (alvo.getVida() >= alvo.getVidaMaxima()) {
            System.out.println(alvo.getNome() + " já está com a vida cheia., não é necessário usar " + nome + ".");
            return;
        } else {
            alvo.receberCura(valorCura);
            System.out.println(alvo.getNome() + " restaurou " + valorCura + " pontos de vida usando " + nome + ".");
        }
    }

    @Override
    public String toString() {
        return nome + " - Preço: " + preco + " moedas de ouro\n" + descricao;
    }
}
