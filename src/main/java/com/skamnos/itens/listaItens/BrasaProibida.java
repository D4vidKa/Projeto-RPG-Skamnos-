package com.skamnos.itens.listaItens;

import com.skamnos.itens.consumiveis.Consumiveis;
import com.skamnos.modelo.jogador.Jogador;

/*
    Classe que representa a Brasa Proibida, um item consumível que restaura mana.
 */
public class BrasaProibida implements Consumiveis {
    /*
     * Métodos implementados da interface Consumiveis
     */
    @Override
    public String getNome() {
        return "Brasa Proibida";
    }

    @Override
    public int getPreco() {
        return 70;
    }

    @Override
    public String getDescricao() {
        return """
                O ápice da loucura de Korthos. Após se perder em suas próprias fórmulas, ele criou esta versão extremamente agressiva que recupera muita mana instantaneamente.
                Mesmo após a Legião banir suas pesquisas, Korthos continuou a refiná-la em segredo.
                Dizem que ele se tornou viciado na própria criação antes de desaparecer sem deixar rastros.
                """;
    }

    @Override
    public String getEfeitoDescrição() {
        return "Recupera 20 Pontos de Mana";
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
        return String.format(
                "\n[ ITEM CONSUMÍVEL ]\n" +
                        "Nome: %-15s | Preço: %d g\n" +
                        "Descrição: %s\n" +
                        "Efeito: %s\n" +
                        "--------------------------",
                this.getNome(), this.getPreco(), this.getDescricao(), this.getEfeitoDescrição());
    }
}
