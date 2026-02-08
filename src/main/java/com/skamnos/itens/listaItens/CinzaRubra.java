package com.skamnos.itens.listaItens;
import com.skamnos.itens.consumiveis.Consumiveis;
import com.skamnos.modelo.jogador.Jogador;

/*
    Classe que representa a Cinza Rubra, um item consumível que restaura mana.
 */
public class CinzaRubra implements Consumiveis {
    // Atributos do item
    private String nome = "Cinza Rubra";
    private int preco = 40;
    private String descricao = """
            Efeito: ---Recupera 10 Pontos de Mana---
            Uma pílula cáustica que incendeia os canais de mana do usuário, recuperando parte de sua energia.
            Desenvolvida por Korthos, o Alquimista de Ferro, a mando da Legião de Escamas para manter seus soldados em combate contínuo,
            sua fórmula é cercada de rumores sombrios: dizem que foi criada ilegalmente nos laboratórios militares usando cinzas de dissidentes e combustíveis instáveis que 'fritam' o corpo por dentro.
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
        int valorMana = 10;
        alvo.receberMana(valorMana);
        System.out.println(alvo.getNome() + " restaurou " + valorMana + " pontos de mana usando " + nome + ".");
    }

    @Override
    public String toString() {
        return nome + " - Preço: " + preco + " moedas de ouro\n" + descricao;
    }
}
