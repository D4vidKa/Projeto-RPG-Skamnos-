package com.skamnos.ElementoTeste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.skamnos.modelo.elemento.Elemento;

public class ElementoTeste {
    @Test
    // Testa o multiplicador de dano entre os elementos IGNIS e TELLUS
    public void testIgnisVsTellus() {
        double multiplicador = Elemento.obterMultiplicador(Elemento.IGNIS, Elemento.TELLUS);
        assertEquals(1.5, multiplicador);
    }

    @Test
    // Testa o multiplicador de dano entre os elementos IGNIS e AEQUOR
    public void testIgnisVsAequor() {
        double multiplicador = Elemento.obterMultiplicador(Elemento.IGNIS, Elemento.AEQUOR);
        assertEquals(1.0, multiplicador);
    }

    @Test
    // Testa o multiplicador de dano entre os elementos IGNIS e IGNIS
    public void testIgnisVsIgnis() {
        double multiplicador = Elemento.obterMultiplicador(Elemento.IGNIS, Elemento.IGNIS);
        assertEquals(1.0, multiplicador);
    }

    @Test
    // Testa o multiplicador de dano entre os elementos AEQUOR e IGNIS
    public void testAequorVsIgnis() {
        double multiplicador = Elemento.obterMultiplicador(Elemento.AEQUOR, Elemento.IGNIS);
        assertEquals(1.5, multiplicador);
    }

    @Test
    // Testa o multiplicador de dano entre os elementos AEQUOR e TELLUS
    public void testAequorVsTellus() {
        double multiplicador = Elemento.obterMultiplicador(Elemento.AEQUOR, Elemento.TELLUS);
        assertEquals(1.0, multiplicador);
    }

    @Test
    // Testa o multiplicador de dano entre os elementos AEQUOR e AEQUOR
    public void testAequorVsAequor() {
        double multiplicador = Elemento.obterMultiplicador(Elemento.AEQUOR, Elemento.AEQUOR);
        assertEquals(1.0, multiplicador);
    }

    @Test
    // Testa o multiplicador de dano entre os elementos TELLUS e AEQUOR
    public void testTellusVsAequor() {
        double multiplicador = Elemento.obterMultiplicador(Elemento.TELLUS, Elemento.AEQUOR);
        assertEquals(1.5, multiplicador);
    }

    @Test
    // Testa o multiplicador de dano entre os elementos TELLUS e IGNIS
    public void testTellusVsIgnis() {
        double multiplicador = Elemento.obterMultiplicador(Elemento.TELLUS, Elemento.IGNIS);
        assertEquals(1.0, multiplicador);
    }

    @Test
    // Testa o multiplicador de dano entre os elementos TELLUS e TELLUS
    public void testTellusVsTellus() {
        double multiplicador = Elemento.obterMultiplicador(Elemento.TELLUS, Elemento.TELLUS);
        assertEquals(1.0, multiplicador);
    }

    @Test
    // Testa o multiplicador de dano entre os elementos VITAS e OBITUS
    public void testVitasVsObitus() {
        double multiplicador = Elemento.obterMultiplicador(Elemento.VITAS, Elemento.OBITUS);
        assertEquals(1.5, multiplicador);
    }

    @Test
    // Testa o multiplicador de dano entre os elementos VITAS e IGNIS
    public void testVitasVsIgnis() {
        double multiplicador = Elemento.obterMultiplicador(Elemento.VITAS, Elemento.IGNIS);
        assertEquals(1.0, multiplicador);
    }

    @Test
    // Testa o multiplicador de dano entre os elementos VITAS e AEQUOR
    public void testVitasVsAequor() {
        double multiplicador = Elemento.obterMultiplicador(Elemento.VITAS, Elemento.AEQUOR);
        assertEquals(1.0, multiplicador);
    }

    @Test
    // Testa o multiplicador de dano entre os elementos VITAS e TELLUS
    public void testVitasVsTellus() {
        double multiplicador = Elemento.obterMultiplicador(Elemento.VITAS, Elemento.TELLUS);
        assertEquals(1.0, multiplicador);
    }

    @Test
    // Testa o multiplicador de dano entre os elementos VITAS e VITAS
    public void testVitasVsVitas() {
        double multiplicador = Elemento.obterMultiplicador(Elemento.VITAS, Elemento.VITAS);
        assertEquals(1.0, multiplicador);
    }

    @Test
    // Testa o multiplicador de dano entre os elementos OBITUS e VITAS
    void testObitusVsVitas() {
        double multiplicador = Elemento.obterMultiplicador(Elemento.OBITUS, Elemento.VITAS);
        assertEquals(1.0, multiplicador);
    }

    @Test
    // Testa o multiplicador de dano entre os elementos OBITUS e IGNIS
    void testObitusVsIgnis() {
        double multiplicador = Elemento.obterMultiplicador(Elemento.OBITUS, Elemento.IGNIS);
        assertEquals(1.5, multiplicador);
    }

    @Test
    // Testa o multiplicador de dano entre os elementos OBITUS e AEQUOR
    void testObitusVsAequor() {
        double multiplicador = Elemento.obterMultiplicador(Elemento.OBITUS, Elemento.AEQUOR);
        assertEquals(1.5, multiplicador);
    }

    @Test
    // Testa o multiplicador de dano entre os elementos OBITUS e TELLUS
    void testObitusVsTellus() {
        double multiplicador = Elemento.obterMultiplicador(Elemento.OBITUS, Elemento.TELLUS);
        assertEquals(1.5, multiplicador);
    }

    @Test
    // Testa o multiplicador de dano entre os elementos OBITUS e OBITUS
    void testObitusVsObitus() {
        double multiplicador = Elemento.obterMultiplicador(Elemento.OBITUS, Elemento.OBITUS);
        assertEquals(1.0, multiplicador);
    }
}