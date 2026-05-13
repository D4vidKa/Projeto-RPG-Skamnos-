package com.skamnos.motor.itemVenda;

import com.skamnos.itens.item.Item;

/**
 * Classe que representa um item à venda em um vendedor.
 * Ela contém o item em si e a quantidade disponível para venda.
 */
public class ItemVenda {

    private Item item;
    private int quantidade;
    
    public ItemVenda() {
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
}
