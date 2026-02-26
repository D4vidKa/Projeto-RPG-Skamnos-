package com.skamnos.itens.listaItens;

import com.skamnos.itens.consumiveis.Consumiveis;
import com.skamnos.modelo.jogador.Jogador;

/*
 * Classe que representa a Escama de Hydrax, um item consumível que restaura vida.
 */
public class EscamaDeHydrax implements Consumiveis {
    /*
     * Métodos implementados da interface Consumiveis
     */
    @Override
    public String getNome() {
        return "Escama de Hydrax";
    }

    @Override
    public int getPreco() {
        return 40;
    }

    @Override
    public String getDescricao() {
        return """
                Uma poção capaz de recuperar uma pequena parte da vida do usuário.
                Foi criada por Silas um Discipulus do Conclave das Correntes há 200 anos.
                """;
    }

    @Override
    public String getEfeitoDescrição() {
        return "Recupera 20 Pontos de Vida";
    }

    @Override
    // Método para usar o item, restaurando a vida do jogador
    public void usar(Jogador alvo) {
        int valorCura = 20;
        if (alvo.getVida() >= alvo.getVidaMaxima()) {
            System.out.println(alvo.getNome() + " já está com a vida cheia., não é necessário usar " + this.getNome() + ".");
            return;
        } else {
            alvo.receberCura(valorCura);
            System.out.println(alvo.getNome() + " restaurou " + valorCura + " pontos de vida usando " + this.getNome() + ".");
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
