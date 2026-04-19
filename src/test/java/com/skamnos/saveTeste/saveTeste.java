package com.skamnos.saveTeste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.skamnos.motor.saveManager.*;
import com.skamnos.motor.jogoSalvo.*;
import com.skamnos.modelo.inventario.*;
import com.skamnos.itens.listaEquipamentos.*;
import com.skamnos.itens.listaItens.*;

// Classe de teste para o SaveManager e o processo de salvamento do jogo
public class saveTeste {
    private SaveManager saveManager;
    private JogoSalvo jogoSalvo;
    private BencaoLuminar bencaoLuminar;
    private ElmoDeKira elmoDeKira;

    @BeforeEach
    public void setUp() {
        saveManager = new SaveManager();
        Inventario inventario = new Inventario(20);
        jogoSalvo = new JogoSalvo("Teste", 100, 80, 20, 10, 50, 30, 5, null, 200, 1500, "Checkpoint 1", null, null, null, inventario);
    }

    // Teste para verificar se o jogo é salvo e carregado corretamente
    @Test
    public void deveSalvarJogoCorretamente() {
        saveManager.salvarJogo(jogoSalvo);
        JogoSalvo jogoCarregado = saveManager.carregarJogo();
        assertEquals(jogoSalvo.getNomeSalvo(), jogoCarregado.getNomeSalvo());
        assertEquals(jogoSalvo.getVidaMaximaSalva(), jogoCarregado.getVidaMaximaSalva());
        assertEquals(jogoSalvo.getVidaSalva(), jogoCarregado.getVidaSalva());
        assertEquals(jogoSalvo.getAtaqueSalvo(), jogoCarregado.getAtaqueSalvo());
        assertEquals(jogoSalvo.getDefesaSalva(), jogoCarregado.getDefesaSalva());
        assertEquals(jogoSalvo.getManaMaximaSalva(), jogoCarregado.getManaMaximaSalva());
        assertEquals(jogoSalvo.getManaSalva(), jogoCarregado.getManaSalva());
        assertEquals(jogoSalvo.getNivelSalvo(), jogoCarregado.getNivelSalvo());
        assertEquals(jogoSalvo.getOuroSalvo(), jogoCarregado.getOuroSalvo());
        assertEquals(jogoSalvo.getExperienciaSalva(), jogoCarregado.getExperienciaSalva());
        assertEquals(jogoSalvo.getCheckpointSalvo(), jogoCarregado.getCheckpointSalvo());
    }

    // Teste para verificar se os itens do inventário são salvos e carregados corretamente
    @Test
    public void deveSalvarInventarioCorretamente() {
        bencaoLuminar = new BencaoLuminar();
        elmoDeKira = new ElmoDeKira();
        jogoSalvo.getInventarioSalvo().adicionarItem(bencaoLuminar);
        jogoSalvo.getInventarioSalvo().adicionarItem(elmoDeKira);
        saveManager.salvarJogo(jogoSalvo);
        JogoSalvo jogoCarregado = saveManager.carregarJogo();
        assertEquals(jogoSalvo.getNomeSalvo(), jogoCarregado.getNomeSalvo());
        assertEquals(jogoSalvo.getVidaMaximaSalva(), jogoCarregado.getVidaMaximaSalva());
        assertEquals(jogoSalvo.getVidaSalva(), jogoCarregado.getVidaSalva());
        assertEquals(jogoSalvo.getAtaqueSalvo(), jogoCarregado.getAtaqueSalvo());
        assertEquals(jogoSalvo.getDefesaSalva(), jogoCarregado.getDefesaSalva());
        assertEquals(jogoSalvo.getManaMaximaSalva(), jogoCarregado.getManaMaximaSalva());
        assertEquals(jogoSalvo.getManaSalva(), jogoCarregado.getManaSalva());
        assertEquals(jogoSalvo.getNivelSalvo(), jogoCarregado.getNivelSalvo());
        assertEquals(jogoSalvo.getOuroSalvo(), jogoCarregado.getOuroSalvo());
        assertEquals(jogoSalvo.getExperienciaSalva(), jogoCarregado.getExperienciaSalva());
        assertEquals(jogoSalvo.getCheckpointSalvo(), jogoCarregado.getCheckpointSalvo());
    }

    // Teste para saber se o jogo é carregado corretamente quando não há um arquivo de salvamento
    @Test
    public void deveRetornarNullQuandoNaoHouverJogoSalvo() {
        JogoSalvo jogoCarregado = saveManager.carregarJogo();
        assertEquals(null, jogoCarregado);
    }

    // Teste para saver se o save é atualizado corretamente
    @Test
    public void deveAtualizarSaveCorretamente() {
        jogoSalvo.setVidaSalva(50);
        jogoSalvo.setCheckpointSalvo("Checkpoint 2");
        saveManager.salvarJogo(jogoSalvo);
        JogoSalvo jogoCarregado = saveManager.carregarJogo();
        assertEquals(50, jogoCarregado.getVidaSalva());
        assertEquals("Checkpoint 2", jogoCarregado.getCheckpointSalvo());
    }

    // Teste para verificar como o save é carregado quando o arquivo de salvamento está corrompido ou com dados inválidos
    @Test
    public void deveRetornarNullQuandoArquivoCorrompido() {
        // Simular um arquivo de salvamento corrompido
        saveManager.salvarJogo(null);
        JogoSalvo jogoCarregado = saveManager.carregarJogo();
        assertEquals(null, jogoCarregado);
    }
}
