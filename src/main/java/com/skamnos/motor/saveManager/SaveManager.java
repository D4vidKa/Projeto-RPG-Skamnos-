package com.skamnos.motor.saveManager;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;
import com.skamnos.motor.jogoSalvo.JogoSalvo;

public class SaveManager {
    // Implementação do SaveManager para gerenciar os jogos salvos
    private final ObjectMapper objectMapper;
    private final String PASTA_SALVOS = "saves/";
    private final String CAMINHO_ARQUIVO = PASTA_SALVOS + "jogo_salvo.json";

    public SaveManager() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        // Criar a pasta de salvamento se não existir
        File pastaSalvos = new File(PASTA_SALVOS);
        if (!pastaSalvos.exists()) {
            pastaSalvos.mkdirs();
        }
    }

    // Método para salvar o jogo
    public void salvarJogo(JogoSalvo jogoSalvo) {
        try {
            objectMapper.writeValue(new File(CAMINHO_ARQUIVO), jogoSalvo);
            System.out.println("Jogo salvo com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao salvar o jogo: " + e.getMessage());
        }
    }

    // Método para carregar o jogo
    public JogoSalvo carregarJogo() {
        try {
            return objectMapper.readValue(new File(CAMINHO_ARQUIVO), JogoSalvo.class);
        } catch (IOException e) {
            System.err.println("Erro ao carregar o jogo: " + e.getMessage());
            return null;
        }
    }
}
