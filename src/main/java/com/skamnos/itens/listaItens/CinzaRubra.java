package com.skamnos.itens.listaItens;

import com.skamnos.itens.consumiveis.Consumiveis;
import com.skamnos.modelo.inventario.Inventario;
import com.skamnos.modelo.jogador.Jogador;

/*
    Classe que representa a Cinza Rubra, um item consumível que restaura mana.
 */
public class CinzaRubra implements Consumiveis {
    public CinzaRubra() {
    }

    /*
     * Métodos implementados da interface Consumiveis
     */
    @Override
    public String getNome() {
        return "Cinza Rubra";
    }

    @Override
    public int getPreco() {
        return 40;
    }

    @Override
    public String getDescricao() {
        return """
                Uma pílula cáustica que incendeia os canais de mana do usuário, recuperando parte de sua energia.
                Desenvolvida por Korthos, o Alquimista de Ferro, a mando da Legião de Escamas para manter seus soldados em combate contínuo,
                sua fórmula é cercada de rumores sombrios: dizem que foi criada ilegalmente nos laboratórios militares usando cinzas de dissidentes e combustíveis instáveis que 'fritam' o corpo por dentro.
                """;
    }

    @Override
    public String getEfeitoDescrição() {
        return "Recupera 10 Pontos de Mana";
    }

    @Override
    public void removerDoInventario(Jogador jogador) {
        Inventario inventario = jogador.getInventario();
        inventario.removerItem(this);
    }

    @Override
    public void usar(Jogador alvo) {
        if (alvo.getMana() >= alvo.getManaMaxima()) {
            System.out.println("Sua mana já está cheia. A Cinza Rubra não teve efeito.");
        } else {
            int manaRestaurada = 10;
            alvo.setMana(Math.min(alvo.getMana() + manaRestaurada, alvo.getManaMaxima()));
            System.out.println("Você usou a Cinza Rubra e recuperou " + manaRestaurada + " pontos de mana!");
            this.removerDoInventario(alvo);
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
