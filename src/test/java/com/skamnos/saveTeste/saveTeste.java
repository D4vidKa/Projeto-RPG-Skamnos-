package com.skamnos.saveTeste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.skamnos.motor.saveManager.*;
import com.skamnos.motor.jogoSalvo.*;
import com.skamnos.modelo.inventario.*;

// Classe de teste para o SaveManager e o processo de salvamento do jogo
public class saveTeste {
    private SaveManager saveManager;
    private JogoSalvo jogoSalvo;

    @BeforeEach
    public void setUp() {
        saveManager = new SaveManager();
        Inventario inventario = new Inventario(20);
        jogoSalvo = new JogoSalvo("Teste", 100, 80, 20, 10, 50, 30, 5, null, 200, 1500, "Checkpoint 1", null, null, null, inventario);
    }

    // Teste para verificar se o jogo é salvo corretamente
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
}
