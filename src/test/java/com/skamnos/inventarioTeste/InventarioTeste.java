package com.skamnos.inventarioTeste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.skamnos.modelo.inventario.*;


public class InventarioTeste {
	private Inventario inventario;

    @BeforeEach
    public void setUp() {
    inventario = new Inventario(30);
    }
    
    @Test
    // Teste para saber se um item é adicionado corretamente
    public void deveAdicionaritem(){

    }
}