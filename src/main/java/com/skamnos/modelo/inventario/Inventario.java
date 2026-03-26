package com.skamnos.modelo.inventario;
import java.util.ArrayList;
import java.util.List;
import com.skamnos.itens.item.Item;


public class Inventario {
    // Atributos do inventário
    private List<Item> itens;
    private int capacidadeMaxima = 30;

    // Construtor do inventário
    public Inventario(int capacidadeMaxima) {
        this.itens = new ArrayList<>();
        this.capacidadeMaxima = capacidadeMaxima;
    }

    // Getters e Setters
    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public void setCapacidadeMaxima(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }
    
    // Método para adicionar um item ao inventário
    public boolean adicionarItem(Item item) {
        if (itens.size() < capacidadeMaxima) {
            itens.add(item);
            System.out.println("Item adicionado: " + item.getNome());
            return true;
        } else {
            System.out.println("Inventário cheio! Não é possível adicionar mais itens.");
            return false;
        }
    }

    // Método para remover um item do inventário
    public boolean removerItem(Item item) {
        if (itens.remove(item)) {
            System.out.println("Item removido: " + item.getNome());
            return true;
        } else {
            System.out.println("Item não encontrado no inventário.");
            return false;
        }
    }

    // Método para listar os itens no inventário
    public void listarItens() {
        if (itens.isEmpty()) {
            System.out.println("O inventário está vazio.");
        } else {
            System.out.println("Itens no inventário:");
            for (Item item : itens) {
                System.out.println("- " + item.getNome());
            }
        }
    }
}
