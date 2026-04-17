package com.skamnos.itens.listaEquipamentos;

import com.skamnos.itens.arma.Arma;
import com.skamnos.modelo.elemento.Elemento;

public class OVeredito implements Arma {
    public OVeredito() {
    }

    @Override
    public String getNome() {
        return "O Veredito";
    }

    @Override
    public String getDescricao() {
        return """
                Forjados em Aço Sombral pelos Mestres de Engenharia a mando do Sindicato, estes machados são a extensão da vontade do Conselho de Ouro.
                Nas mãos de um Executor, a lâmina não apenas corta; ela encerra disputas com uma finalidade absoluta.
                Dizem que o peso do metal é proporcional à dívida de quem o enfrenta, separando carne e osso com a precisão de um contrato sendo selado.
                """;
    }

    @Override
    public int getPreco() {
        return 80;
    }

    @Override
    public String getTipoArma() {
        return "Arma";
    }

    @Override
    public int getBonusAtaque() {
        return 20;
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
        return 10;
    }

    @Override
    public Elemento getElementoItem() {
        return Elemento.TELLUS;
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