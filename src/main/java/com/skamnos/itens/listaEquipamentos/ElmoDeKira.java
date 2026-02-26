package com.skamnos.itens.listaEquipamentos;

import com.skamnos.itens.cabeca.Cabeca;

public class ElmoDeKira implements Cabeca {
    @Override
    public String getNome() {
        return "Elmo de Kira";
    }

    @Override
    public String getDescricao() {
        return """
                Um elmo de aço fosco, marcado por cicatrizes de um combate antigo.
                Ele pertenceu a Kira, uma Inceptora que tombou durante a sangrenta Guerra Civil da Grande Forja.
                Enquanto os nomes dos generais foram gravados em ouro pelo Sindicato, o de Kira foi levado pelo vento.
                Este elmo é o único fragmento que impede que sua existência seja totalmente devorada pelo tempo — um peso silencioso sobre a cabeça de quem o usa.
                """;
    }

    @Override
    public int getPreco() {
        return 50;
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
        return 20;
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
