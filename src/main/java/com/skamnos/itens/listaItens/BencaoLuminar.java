package com.skamnos.itens.listaItens;

import com.skamnos.itens.consumiveis.Consumiveis;
import com.skamnos.modelo.jogador.Jogador;
import com.skamnos.modelo.inventario.Inventario;

/*
    Classe que representa a Bênção Luminar, um item consumível.
 */
public class BencaoLuminar implements Consumiveis {
    /*
     * Métodos implementados da interface Consumiveis
     */
    @Override
    public String getNome() {
        return "Bênção Luminar";
    }

    @Override
    public int getPreco() {
        return 200;
    }

    @Override
    public String getDescricao() {
        return """
                Muitos acreditam ser apenas um mito inventado por desesperados, mas para a Cúpula dos Absolutos, é uma ameaça real o suficiente para justificar massacres.
                Não é apenas um item; é uma âncora para aqueles que têm uma tarefa inacabada com a vida.
                A Igreja do Sol Poente protege estas poucas raridades com o próprio sangue, esperando pelo momento em que a 'pessoa certa' precisará recusar o fim.
                """;
    }

    @Override
    public String getEfeitoDescrição() {
        return "???";
    }

    @Override
    public void removerDoInventario(Jogador jogador) {
        Inventario inventario = jogador.getInventario();
        inventario.removerItem(this);
    }

    @Override
    // O efeito deve ser reviver o jogador com 100% da vida máxima.
    public void usar(Jogador alvo) {
        if (alvo.estaVivo()) {
            System.out.println("""
                    A Benção Luminar permanece fria em suas mãos.
                    A luz se recusa a brilhar para aqueles que ainda caminham sob o sol.
                    """);
        } else {
            System.out.println(
                    """
                            O frio do abismo começa a envolver sua consciência e o mundo desbota em cinzas...
                            De repente, uma centelha dourada explode no centro do seu ser.
                            Você sente o sangue ferver como metal líquido e o ar voltando aos pulmões como um rugido de tempestade.
                            A Benção Luminar se desfaz em cinzas estelares enquanto sua alma é puxada de volta ao corpo.
                            ---Você vive novamente!---
                            """);
            alvo.restaurarVidaMaxima();
            removerDoInventario(alvo);
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
