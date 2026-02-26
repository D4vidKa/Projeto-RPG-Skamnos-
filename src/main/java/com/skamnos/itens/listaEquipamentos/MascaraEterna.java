package com.skamnos.itens.listaEquipamentos;

import com.skamnos.itens.cabeca.Cabeca;

public class MascaraEterna implements Cabeca{

    @Override
    public String getNome() {
        return "Máscara Eterna";
    }

    @Override
    public String getDescricao() {
        return """
                Uma relíquia de um tempo cujas crônicas foram perdidas.
                Forjada em um metal translúcido que desafia a metalurgia moderna, esta máscara reflete a luz e o calor com a intensidade do próprio sol. 
                Desenterrada das camadas mais profundas do Pico da Ascensão, ela emana uma aura de autoridade primordial. 
                Os Magisters do Conclave estimam que o artefato date de mais de 2500 anos.
                """;
    }

    @Override
    public int getPreco() {
        return 75;
    }

    @Override
    public String getTipoArma() {
        return "Cabeça";
    }

    @Override
    public int getBonusAtaque() {
        return 0;
    }

    @Override
    public int getBonusVida() {
        return 20;
    }

    @Override
    public int getBonusDefesa() {
        return 30;
    }

    @Override
    public int getBonusMana() {
        return 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n==========================================\n");
        sb.append(String.format(" %-15s | TIPO: %s\n", getNome().toUpperCase(), getTipoArma()));
        sb.append("==========================================\n");
        sb.append(" Descrição: ").append(getDescricao()).append("\n");
        sb.append("------------------------------------------\n");
        sb.append(" BÔNUS DO EQUIPAMENTO:\n");

        // Mostra apenas bônus maiores que zero para limpeza visual
        if (getBonusAtaque() > 0)
            sb.append(String.format("  > Ataque: +%d\n", getBonusAtaque()));
        if (getBonusDefesa() > 0)
            sb.append(String.format("  > Defesa: +%d\n", getBonusDefesa()));
        if (getBonusVida() > 0)
            sb.append(String.format("  > Vida:   +%d\n", getBonusVida()));
        if (getBonusMana() > 0)
            sb.append(String.format("  > Mana:   +%d\n", getBonusMana()));

        sb.append("------------------------------------------\n");
        sb.append(" Preço de Venda: ").append(getPreco()).append(" moedas de ouro\n");
        sb.append("==========================================");

        return sb.toString();
    }
}
