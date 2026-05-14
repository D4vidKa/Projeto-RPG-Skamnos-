package com.skamnos.vendedorTeste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.skamnos.motor.vendedor.Vendedor;
import java.util.ArrayList;
import java.util.List;
import com.skamnos.motor.itemVenda.*;
import com.skamnos.modelo.elemento.Elemento;
import com.skamnos.modelo.inventario.Inventario;
import com.skamnos.modelo.jogador.*;

public class VendedorTeste {
    private Vendedor vendedor;
    private Jogador jogador;

    @BeforeEach
    public void setUp() {
        Vendedor vendedor = new Vendedor("Teste", new ArrayList<ItemVenda>());
        this.vendedor = vendedor;
    }

    @BeforeEach
    public void setUpJogador() {
        Inventario inventario = new Inventario(30);
        jogador = new Jogador("Teste", 50, 10, 7, 8, 1, Elemento.VITAS, 100, 1, "Início do Jogo", null, null, null, inventario);
    }

    @Test
    public void testeInicializacaoVendedor() {
        // Teste para verificar se o vendedor é inicializado corretamente com o nome e estoque
        assertEquals("Vendedor", vendedor.getNome()); // O nome do vendedor deve ser "Vendedor"
        assertEquals(11, vendedor.getEstoque().size()); // O estoque deve conter 11 itens
    }

    @Test
    public void testeExibirItensDisponiveis() {
        // Teste para verificar se os itens disponíveis para venda são exibidos corretamente
        List<ItemVenda> estoque = vendedor.getEstoque();
        assertEquals(11, estoque.size()); // O estoque deve conter 11 itens

        // Verificar se os itens no estoque correspondem aos itens esperados
        assertEquals("Escama de Hydrax", estoque.get(0).getItem().getNome());
        assertEquals("Lágrima de Hydrax", estoque.get(1).getItem().getNome());
        assertEquals("Milagre de Hydrax", estoque.get(2).getItem().getNome());
        assertEquals("Brasa Proibida", estoque.get(3).getItem().getNome());
        assertEquals("Cinza Rubra", estoque.get(4).getItem().getNome());
        assertEquals("Bênção Luminar", estoque.get(5).getItem().getNome());
        assertEquals("Elmo de Kira", estoque.get(6).getItem().getNome());
        assertEquals("Fênix Encarnada", estoque.get(7).getItem().getNome());
        assertEquals("Lança de Dante", estoque.get(8).getItem().getNome());
        assertEquals("Máscara Eterna", estoque.get(9).getItem().getNome());
        assertEquals("O Veredito", estoque.get(10).getItem().getNome());
    }

    @Test
    public void metodoMostrarItensFunciona(){
        // teste para verificar se o metodo mostrarItens funciona corretamente
        vendedor.mostrarItens();
    }

    @Test
    public void testeComprarItem() {
        // Teste para verificar se o método comprarItem funciona corretamente
        // Este teste pode serve para simular a compra de um item e verificar se o estoque é atualizado corretamente
        vendedor.realizarVenda(jogador, vendedor.getEstoque().get(0)); // Simula a compra de 1 Escama de Hydrax
        assertEquals(9, vendedor.getEstoque().get(0).getQuantidade()); // A quantidade do item no estoque deve ser reduzida para 9
        assertEquals(1, jogador.getInventario().getItens().size()); // O jogador deve ter 1 item no inventário após a compra
    }
}
