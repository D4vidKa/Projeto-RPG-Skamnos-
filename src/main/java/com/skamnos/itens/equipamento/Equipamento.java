package com.skamnos.itens.equipamento;
import com.skamnos.modelo.elemento.Elemento;
import com.skamnos.itens.item.Item;
/*
 * Classe abstrata que representa um Equipamento no jogo.
 * Equipamentos podem ser armas, armaduras ou outros itens que
 * fornecem bônus ao personagem.
 */
public abstract class Equipamento implements Item {
    private String nome;
    private int preco;
    private int bonusVida;
    private int bonusAtaque;
    private int bonusDefesa;
    private int bonusMana;
    private Elemento elementoItem;
    
}
