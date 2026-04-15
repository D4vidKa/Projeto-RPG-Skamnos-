package com.skamnos.inventarioTeste;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skamnos.modelo.elemento.Elemento;
import com.skamnos.modelo.inventario.*;
import com.skamnos.itens.listaEquipamentos.*;
import com.skamnos.itens.listaItens.*;
import com.skamnos.modelo.jogador.Jogador;


public class InventarioTeste {
	private Inventario inventario;
    private ElmoDeKira elmoDeKira;
    private BencaoLuminar bencaoLuminar;

    @BeforeEach
    public void setUp() {
    inventario = new Inventario(30);
    }

    @BeforeEach
    public void setUpItens() {
        elmoDeKira = new ElmoDeKira();
    }

    @BeforeEach
    public void setUpItens2() {
        bencaoLuminar = new BencaoLuminar();
    }
    
    

    @Test
    // Teste para saber se um item é adicionado corretamente
    public void deveAdicionaritem(){
        inventario.adicionarItem(elmoDeKira);
        assertEquals(1, inventario.getItens().size());
        assertEquals(elmoDeKira, inventario.getItens().get(0));
    }

    @Test
    // Teste para listar itens do inventário
    public void deveListarItens(){
        inventario.adicionarItem(elmoDeKira);
        inventario.listarItens();
        assertEquals(1, inventario.getItens().size());
    }

    @Test
    // Teste para remover um item do inventário
    public void deveRemoverItem(){
        inventario.adicionarItem(elmoDeKira);
        boolean removido = inventario.removerItem(elmoDeKira);
        assertEquals(true, removido);
        assertEquals(0, inventario.getItens().size());
    }

    @Test
    // Teste para saber se um item é excluido do inventário apos uso
    public void deveExcluirItemAposUso(){
        Jogador jogador = new Jogador("Teste", 50, 10, 7, 30, 1, Elemento.VITAS, 0, 1, "Início do Jogo", null, null,
                null, inventario);
        jogador.setVida(0);
        inventario.adicionarItem(bencaoLuminar);
        bencaoLuminar.usar(jogador); // Simula o uso do item
        assertEquals(0, inventario.getItens().size());
    }
    
    @Test
    // Teste para verificar o tamanho maximo do inventário
    public void deveVerificarTamanhoMaximo(){
        Inventario pequenoInventario = new Inventario(1);
        boolean adicionado1 = pequenoInventario.adicionarItem(elmoDeKira);
        boolean adicionado2 = pequenoInventario.adicionarItem(bencaoLuminar);
        assertEquals(true, adicionado1);
        assertEquals(false, adicionado2); // O segundo item não deve ser adicionado
        assertEquals(1, pequenoInventario.getItens().size());
    }
}