package com.skamnos.itens.listaItens;
import com.skamnos.itens.consumiveis.Consumiveis;
import com.skamnos.modelo.jogador.Jogador;

/*
    Classe que representa a Brasa Proibida, um item consumível que restaura mana.
 */
public class BrasaProibida implements Consumiveis{
    // Atributos do item
    private String nome = "Brasa Proibida";
    private int preco = 70;
    private String descricao = """
            Efeito: ---Recupera 20 Pontos de Mana---
            O ápice da loucura de Korthos. Após se perder em suas próprias fórmulas, ele criou esta versão extremamente agressiva que recupera muita mana instantaneamente.
            Mesmo após a Legião banir suas pesquisas, Korthos continuou a refiná-la em segredo.
            Dizem que ele se tornou viciado na própria criação antes de desaparecer sem deixar rastros.
            """;

    /*
    Métodos implementados da interface Consumiveis
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
        if (alvo.getMana() >= alvo.getManaMaxima()) {
            System.out.println("Sua mana já está cheia. A Brasa Proibida não teve efeito.");
        } else {
            int manaRestaurada = 20;
            alvo.setMana(Math.min(alvo.getMana() + manaRestaurada, alvo.getManaMaxima()));
            System.out.println("Você usou a Brasa Proibida e recuperou " + manaRestaurada + " pontos de mana!");
        }
    }

    @Override
    public String toString() {
        return nome + " - Preço: " + preco + " moedas de ouro\n" + descricao;
    }
}
