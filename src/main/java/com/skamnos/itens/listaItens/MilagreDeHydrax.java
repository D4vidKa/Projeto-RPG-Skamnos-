package com.skamnos.itens.listaItens;

import com.skamnos.itens.consumiveis.Consumiveis;
import com.skamnos.modelo.jogador.Jogador;

/*
 * Classe que representa o Milagre de Hydrax, um item consumível que restaura toda a vida.
 */
public class MilagreDeHydrax implements Consumiveis {
    /*
     * Métodos implementados da interface Consumiveis
     */
    @Override
    public String getNome() {
        return "Milagre de Hydrax";
    }

    @Override
    public int getPreco() {
        return 100;
    }

    @Override
    public String getDescricao() {
        return """
                A obra-prima de Silas que o fez virar um dos grandes Magister do Conclave, criada em colaboração com outros discípulos após anos de desenvolvimento.
                Esta poção foi desenvolvida a pedido da Mestra-Oráculo Lyra para fortalecer seus espiões em missões de extremo risco, sendo capaz de recuperar toda a vitalidade de uma pessoa.
                """;
    }

    @Override
    public String getEfeitoDescrição() {
        return "Recupera toda a vida";
    }

    @Override
    // Método para usar o item, restaurando toda a vida do jogador
    public void usar(Jogador alvo) {
        if (alvo.getVida() >= alvo.getVidaMaxima()) {
            System.out.println(
                    alvo.getNome() + " já está com a vida cheia., não é necessário usar " + this.getNome() + ".");
            return;
        } else {
            alvo.restaurarVidaMaxima();
            System.out.println(alvo.getNome() + " restaurou toda a vida usando " + this.getNome() + ".");
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
