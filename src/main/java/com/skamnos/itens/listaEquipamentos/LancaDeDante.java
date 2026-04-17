package com.skamnos.itens.listaEquipamentos;

import com.skamnos.itens.arma.Arma;
import com.skamnos.modelo.elemento.Elemento;

public class LancaDeDante implements Arma {
    public LancaDeDante() {
    }

    @Override
    public String getNome() {
        return "Lança de Dante";
    }

    @Override
    public String getDescricao() {
        return """
                Esculpida em Vidro de Dragão — um minério translúcido e indestrutível das profundezas —
                esta lança foi um presente diplomático do Barão Ferrum para a Mestra-Oráculo Lyra há quatro séculos.
                Para a Oráculo, a arma era uma 'joia delicada demais para a guerra', sendo então confiada ao seu prodígio, Dante de Nereza.
                Após a queda de Dante em uma emboscada esquecida, a lança repousou no leito oceânico, absorvendo o silêncio das marés até ser recuperada pelos espiões do Conclave.
                """;
    }

    @Override
    public int getPreco() {
        return 50;
    }

    @Override
    public String getTipoArma() {
        return "Arma";
    }

    @Override
    public int getBonusAtaque() {
        return 15;
    }

    @Override
    public int getBonusVida() {
        return 0;
    }

    @Override
    public int getBonusDefesa() {
        return 0;
    }

    @Override
    public int getBonusMana() {
        return 15;
    }

    @Override
    public Elemento getElementoItem() {
        return Elemento.AEQUOR;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n==========================================\n");
        sb.append(String.format(" %-15s | TIPO: %s\n", getNome().toUpperCase(), getTipoArma()));
        sb.append("==========================================\n");
        sb.append(" Descrição: ").append(getDescricao()).append("\n");
        sb.append("------------------------------------------\n");
        sb.append(" ELEMENTO: ").append(getElementoItem()).append("\n");
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
