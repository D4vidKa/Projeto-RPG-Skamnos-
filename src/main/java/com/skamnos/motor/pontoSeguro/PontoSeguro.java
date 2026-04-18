package com.skamnos.motor.pontoSeguro;

import com.skamnos.motor.jogoSalvo.JogoSalvo;
import com.skamnos.modelo.jogador.*;
import com.skamnos.motor.saveManager.SaveManager;

/**
 * Classe que representa um Ponto Seguro no jogo.
 * Um Ponto Seguro é um local onde os jogadores podem descansar, recuperar saúde e salvar o progresso do jogo. 
 * Ele pode conter NPCs, lojas, e outras facilidades para os jogadores.
 */
public class PontoSeguro {
    private String nomeLocal;
    private JogoSalvo ultimoSave;

    // Construtor
    public PontoSeguro(String nomeLocal, JogoSalvo ultimoSave) {
        this.nomeLocal = nomeLocal;
        this.ultimoSave = ultimoSave;
    }

    public String getNomeLocal() {
        return nomeLocal;
    }

    public void setNomeLocal(String nomeLocal) {
        this.nomeLocal = nomeLocal;
    }

    public JogoSalvo getUltimoSave() {
        return ultimoSave;
    }

    public void setUltimoSave(JogoSalvo ultimoSave) {
        this.ultimoSave = ultimoSave;
    }
    
    // Métoto para gerenciar o descanço do jogador
    public void gerenciarDescanso(Jogador jogador) {
        jogador.descansar();
    }

    // Método para executar o salvamento do jogo
    public void executarSave(Jogador jogador) {
        JogoSalvo dadosParaSalvar = new JogoSalvo();

        jogador.salvarJogo(dadosParaSalvar);

        SaveManager saveManager = new SaveManager();
        saveManager.salvarJogo(dadosParaSalvar);
    }
}
