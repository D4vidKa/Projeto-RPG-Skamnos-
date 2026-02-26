package com.skamnos.itens.consumiveis;
import com.skamnos.itens.item.Item;
import com.skamnos.modelo.jogador.Jogador;

/**
 * Interface para itens consumíveis.
 */
public interface Consumiveis extends Item {
    String getEfeitoDescrição();
    // Método para usar um item consumível em um jogador
    void usar(Jogador alvo);
}
