package com.skamnos.motor.vendedor;

import java.util.ArrayList;
import java.util.List;

import com.skamnos.itens.item.Item;
import com.skamnos.itens.listaItens.*;
import com.skamnos.itens.listaEquipamentos.*;
import com.skamnos.motor.itemVenda.*;

/**
 * Classe que representa um Vendedor no jogo.
 * O Vendedor é um NPC que oferece itens, armas, armaduras e outros equipamentos para
 * os jogadores em troca de ouro. Ele pode ter um estoque fixo de itens e pode ser encontrado em diferentes locais do jogo.
 */
public class Vendedor {
    private String nome;
    private ArrayList<Item> estoque;

    public Vendedor(String nome, ArrayList<Item> estoque) {
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
    public List<Item> getEstoque() {
        return estoque;
    }
    public void setEstoque(ArrayList<Item> estoque) {
        this.estoque = estoque;
    }

    public void inicializarEstoque(){
        EscamaDeHydrax escamaDeHydrax = new EscamaDeHydrax();
        ItemVenda vendaEscamaDeHydrax = new ItemVenda();
        vendaEscamaDeHydrax.setItem(escamaDeHydrax);
        vendaEscamaDeHydrax.setQuantidade(10);
        estoque.add(vendaEscamaDeHydrax.getItem());

        LagrimaDeHydrax lagrimaDeHydrax = new LagrimaDeHydrax();
        ItemVenda vendaLagrimaDeHydrax = new ItemVenda();
        vendaLagrimaDeHydrax.setItem(lagrimaDeHydrax);
        vendaLagrimaDeHydrax.setQuantidade(10);
        estoque.add(vendaLagrimaDeHydrax.getItem());

        MilagreDeHydrax milagreDeHydrax = new MilagreDeHydrax();
        ItemVenda vendaMilagreDeHydrax = new ItemVenda();
        vendaMilagreDeHydrax.setItem(milagreDeHydrax);
        vendaMilagreDeHydrax.setQuantidade(10);
        estoque.add(vendaMilagreDeHydrax.getItem());

        BrasaProibida brasaProibida = new BrasaProibida();
        ItemVenda vendaBrasaProibida = new ItemVenda();
        vendaBrasaProibida.setItem(brasaProibida);
        vendaBrasaProibida.setQuantidade(10);
        estoque.add(vendaBrasaProibida.getItem());

        CinzaRubra cinzaRubra = new CinzaRubra();
        ItemVenda vendaCinzaRubra = new ItemVenda();
        vendaCinzaRubra.setItem(cinzaRubra);
        vendaCinzaRubra.setQuantidade(10);
        estoque.add(vendaCinzaRubra.getItem());

        BencaoLuminar bencaoLuminar = new BencaoLuminar();
        ItemVenda vendaBencaoLuminar = new ItemVenda();
        vendaBencaoLuminar.setItem(bencaoLuminar);
        vendaBencaoLuminar.setQuantidade(5);
        estoque.add(vendaBencaoLuminar.getItem());

        ElmoDeKira elmoDeKira = new ElmoDeKira();
        ItemVenda vendaElmoDeKira = new ItemVenda();
        vendaElmoDeKira.setItem(elmoDeKira);
        vendaElmoDeKira.setQuantidade(1);
        estoque.add(vendaElmoDeKira.getItem());

        FenixEncarnada fenixEncarnada = new FenixEncarnada();
        ItemVenda vendaFenixEncarnada = new ItemVenda();
        vendaFenixEncarnada.setItem(fenixEncarnada);
        vendaFenixEncarnada.setQuantidade(1);
        estoque.add(vendaFenixEncarnada.getItem());

        LancaDeDante lancaDeDante = new LancaDeDante();
        ItemVenda vendaLancaDeDante = new ItemVenda();
        vendaLancaDeDante.setItem(lancaDeDante);
        vendaLancaDeDante.setQuantidade(1);
        estoque.add(vendaLancaDeDante.getItem());

        MascaraEterna mascaraEterna = new MascaraEterna();
        ItemVenda vendaMascaraEterna = new ItemVenda();
        vendaMascaraEterna.setItem(mascaraEterna);
        vendaMascaraEterna.setQuantidade(1);
        estoque.add(vendaMascaraEterna.getItem());

        OVeredito oVeredito = new OVeredito();
        ItemVenda vendaOVeredito = new ItemVenda();
        vendaOVeredito.setItem(oVeredito);
        vendaOVeredito.setQuantidade(1);
        estoque.add(vendaOVeredito.getItem());
    }

    public void mostrarItens(){
        System.out.println("Itens disponíveis para venda:");
        for (Item item : estoque) {
            System.out.println("- " + item.getNome() + ": " + item.getDescricao());
        }
    }
}
