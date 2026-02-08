package com.skamnos.ItensTeste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skamnos.itens.listaItens.*;

public class BencaoLuminarTeste {
    private BencaoLuminar bencaoLuminar;
    
    @BeforeEach
    public void setUp() {
        bencaoLuminar = new BencaoLuminar();
    }

    @Test
    public void deveTerNomeCorreto() {
        assertEquals("Bênção Luminar", bencaoLuminar.getNome());
    }

    @Test
    public void deveTerPrecoCorreto() {
        assertEquals(200, bencaoLuminar.getPreco());
    }

    @Test
    public void deveTerDescricaoCorreta() {
        String descricaoEsperada = """
            Efeito: ---???---
            Muitos acreditam ser apenas um mito inventado por desesperados, mas para a Cúpula dos Absolutos, é uma ameaça real o suficiente para justificar massacres.
            Não é apenas um item; é uma âncora para aqueles que têm uma tarefa inacabada com a vida.
            A Igreja do Sol Poente protege estas poucas raridades com o próprio sangue, esperando pelo momento em que a 'pessoa certa' precisará recusar o fim.
            """;
        assertEquals(descricaoEsperada, bencaoLuminar.getDescricao());
    }
}
