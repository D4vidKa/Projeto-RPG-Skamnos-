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
            Efeito: ---Recupera 25 Pontos de Mana---
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
        int valorMana = 25;
        alvo.receberMana(valorMana);
        System.out.println(alvo.getNome() + " restaurou " + valorMana + " pontos de mana usando " + nome + ".");
    }

    @Override
    public String toString() {
        return nome + " - Preço: " + preco + " moedas de ouro\n" + descricao;
    }
}
