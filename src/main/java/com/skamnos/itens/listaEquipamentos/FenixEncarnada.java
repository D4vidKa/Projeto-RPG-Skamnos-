package com.skamnos.itens.listaEquipamentos;

import com.skamnos.itens.arma.Arma;
import com.skamnos.modelo.elemento.Elemento;

public class FenixEncarnada implements Arma{
    @Override
    public String getNome() {
        return "Fênix Encarnada";
    }

    @Override
    public String getDescricao() {
        return """
                Empunhar esta lâmina é um teste de vontade; o calor que emana do punho faz os braços do usuário parecerem derreter em magma vivo. 
                Forjada com Aço Sombral imbuído com Ignis nas entranhas do vulcão no Pico da Ascensão, a Fênix Encarnada é uma arma senciente que não tolera a hesitação. 
                Ela exige um tributo de dor: aqueles que tentam usurpar seu poder sem a devida força são instantaneamente consumidos, transformados em cinzas pela fúria de Pyrothos.
                """;
    }

    @Override
    public int getPreco() {
        return 100;
    }

    @Override
    public String getTipoArma() {
        return "Arma";
    }

    @Override
    public int getBonusAtaque() {
        return 30;
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
        return 5;
    }

    @Override
    public Elemento getElementoItem() {
        return Elemento.IGNIS;
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
