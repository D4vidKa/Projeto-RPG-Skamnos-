package com.skamnos.itens.listaItens;

import com.skamnos.itens.consumiveis.Consumiveis;
import com.skamnos.modelo.jogador.Jogador;

/*
 * Classe que representa a Lágrima de Hydrax, um item consumível que restaura vida.
 */
public class LagrimaDeHydrax implements Consumiveis {
    /*
     * Métodos implementados da interface Consumiveis
     */
    @Override
    public String getNome() {
        return "Lágrima de Hydrax";
    }

    @Override
    public int getPreco() {
        return 65;
    }

    @Override
    public String getDescricao() {
        return """
                Uma versão aprimorada da escama comum, também criada por Silas.
                Após uma revolta no Arquipélago de Nereza onde várias pessoas morreram, Silas viu a necessidade de aprimorar sua criação.
                """;
    }

    @Override
    public String getEfeitoDescrição() {
        return "Recupera 40 Pontos de Vida";
    }

    @Override
    // Método para usar o item, restaurando a vida do jogador
    public void usar(Jogador alvo) {
        int valorCura = 40;
        if (alvo.getVida() >= alvo.getVidaMaxima()) {
            System.out.println(
                    alvo.getNome() + " já está com a vida cheia., não é necessário usar " + this.getNome() + ".");
            return;
        } else {
            alvo.receberCura(valorCura);
            System.out.println(
                    alvo.getNome() + " restaurou " + valorCura + " pontos de vida usando " + this.getNome() + ".");
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
