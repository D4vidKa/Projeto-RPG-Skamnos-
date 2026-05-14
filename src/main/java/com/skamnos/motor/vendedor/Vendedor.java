package com.skamnos.motor.vendedor;

import java.util.ArrayList;
import java.util.List;

import com.skamnos.itens.item.Item;
import com.skamnos.itens.listaItens.*;
import com.skamnos.itens.listaEquipamentos.*;
import com.skamnos.motor.itemVenda.*;
import com.skamnos.modelo.jogador.*;

/**
 * Classe que representa um Vendedor no jogo.
 * O Vendedor é um NPC que oferece itens, armas, armaduras e outros equipamentos para
 * os jogadores em troca de ouro. Ele pode ter um estoque fixo de itens e pode ser encontrado em diferentes locais do jogo.
 */
public class Vendedor {
    private String nome;
    private ArrayList<ItemVenda> estoque;

    public Vendedor(String nome, ArrayList<ItemVenda> estoque) {
        this.nome = "Vendedor";
        this.estoque = new ArrayList<>();
        inicializarEstoque();
    }
    // Getters e Setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public List<ItemVenda> getEstoque() {
        return estoque;
    }
    public void setEstoque(ArrayList<ItemVenda> estoque) {
        this.estoque = estoque;
    }

    public void inicializarEstoque(){
        EscamaDeHydrax escamaDeHydrax = new EscamaDeHydrax();
        ItemVenda vendaEscamaDeHydrax = new ItemVenda();
        vendaEscamaDeHydrax.setItem(escamaDeHydrax);
        vendaEscamaDeHydrax.setQuantidade(10);
        estoque.add(vendaEscamaDeHydrax);

        LagrimaDeHydrax lagrimaDeHydrax = new LagrimaDeHydrax();
        ItemVenda vendaLagrimaDeHydrax = new ItemVenda();
        vendaLagrimaDeHydrax.setItem(lagrimaDeHydrax);
        vendaLagrimaDeHydrax.setQuantidade(10);
        estoque.add(vendaLagrimaDeHydrax);

        MilagreDeHydrax milagreDeHydrax = new MilagreDeHydrax();
        ItemVenda vendaMilagreDeHydrax = new ItemVenda();
        vendaMilagreDeHydrax.setItem(milagreDeHydrax);
        vendaMilagreDeHydrax.setQuantidade(10);
        estoque.add(vendaMilagreDeHydrax);

        BrasaProibida brasaProibida = new BrasaProibida();
        ItemVenda vendaBrasaProibida = new ItemVenda();
        vendaBrasaProibida.setItem(brasaProibida);
        vendaBrasaProibida.setQuantidade(10);
        estoque.add(vendaBrasaProibida);

        CinzaRubra cinzaRubra = new CinzaRubra();
        ItemVenda vendaCinzaRubra = new ItemVenda();
        vendaCinzaRubra.setItem(cinzaRubra);
        vendaCinzaRubra.setQuantidade(10);
        estoque.add(vendaCinzaRubra);

        BencaoLuminar bencaoLuminar = new BencaoLuminar();
        ItemVenda vendaBencaoLuminar = new ItemVenda();
        vendaBencaoLuminar.setItem(bencaoLuminar);
        vendaBencaoLuminar.setQuantidade(5);
        estoque.add(vendaBencaoLuminar);

        ElmoDeKira elmoDeKira = new ElmoDeKira();
        ItemVenda vendaElmoDeKira = new ItemVenda();
        vendaElmoDeKira.setItem(elmoDeKira);
        vendaElmoDeKira.setQuantidade(1);
        estoque.add(vendaElmoDeKira);

        FenixEncarnada fenixEncarnada = new FenixEncarnada();
        ItemVenda vendaFenixEncarnada = new ItemVenda();
        vendaFenixEncarnada.setItem(fenixEncarnada);
        vendaFenixEncarnada.setQuantidade(1);
        estoque.add(vendaFenixEncarnada);

        LancaDeDante lancaDeDante = new LancaDeDante();
        ItemVenda vendaLancaDeDante = new ItemVenda();
        vendaLancaDeDante.setItem(lancaDeDante);
        vendaLancaDeDante.setQuantidade(1);
        estoque.add(vendaLancaDeDante);

        MascaraEterna mascaraEterna = new MascaraEterna();
        ItemVenda vendaMascaraEterna = new ItemVenda();
        vendaMascaraEterna.setItem(mascaraEterna);
        vendaMascaraEterna.setQuantidade(1);
        estoque.add(vendaMascaraEterna);

        OVeredito oVeredito = new OVeredito();
        ItemVenda vendaOVeredito = new ItemVenda();
        vendaOVeredito.setItem(oVeredito);
        vendaOVeredito.setQuantidade(1);
        estoque.add(vendaOVeredito);
    }

    // Método para mostrar os itens disponíveis para venda de forma organizada por nome, descrição, preço e quantidade
    public void mostrarItens(){
        System.out.println("Itens disponíveis para venda:");
        for (ItemVenda etiqueta : estoque) {
            Item item = etiqueta.getItem();
            int quantidade = etiqueta.getQuantidade();
            System.out.println("Nome: " + item.getNome());
            System.out.println("Descrição: " + item.getDescricao());
            System.out.println("Preço: " + item.getPreco() + " ouro");
            System.out.println("Quantidade: " + quantidade);
            System.out.println("-----------------------------");
        }
    }

    // Método para realizar a venda de um item para um jogador
    public boolean realizarVenda(Jogador jogador, ItemVenda itemVenda) {
        int preco = itemVenda.getItem().getPreco();
        if (estoque.contains(itemVenda)) {
            jogador.comprarItem(itemVenda);
            if (preco > jogador.getOuro()) {
                return false; // Ouro insuficiente para realizar a compra
                
            }
            // Atualiza a quantidade do item no estoque
            int novaQuantidade = itemVenda.getQuantidade() - 1;
            itemVenda.setQuantidade(novaQuantidade);
            if (itemVenda.getQuantidade() <= 0) {
                estoque.remove(itemVenda); // Remove o item do estoque se a quantidade chegar a zero
            }
            return true; // Venda realizada com sucesso
            
        } else {
            System.out.println("Este item não está disponível para venda.");
            return false;
        }
    }

    // Método para resetar a area anterior permitindo lutar contra os inimigos novamente
    public void resetarArea(){
        // Lógica para resetar a área, permitindo que os inimigos reapareçam
    }
}
