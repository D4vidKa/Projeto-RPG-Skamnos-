package com.skamnos.itens.listaItens;
import com.skamnos.itens.consumiveis.Consumiveis;
import com.skamnos.modelo.jogador.Jogador;

/*
    Classe que representa a Bênção Luminar, um item consumível.
 */
public class BencaoLuminar implements Consumiveis{
    // Atributos do item
    private String nome = "Bênção Luminar";
    private int preco = 200;
    private String descricao = """
            Efeito: ---???---
            Muitos acreditam ser apenas um mito inventado por desesperados, mas para a Cúpula dos Absolutos, é uma ameaça real o suficiente para justificar massacres.
            Não é apenas um item; é uma âncora para aqueles que têm uma tarefa inacabada com a vida.
            A Igreja do Sol Poente protege estas poucas raridades com o próprio sangue, esperando pelo momento em que a 'pessoa certa' precisará recusar o fim.
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
        
    }
}
