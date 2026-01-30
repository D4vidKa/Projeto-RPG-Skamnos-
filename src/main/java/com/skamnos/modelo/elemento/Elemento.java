package com.skamnos.modelo.elemento;

public enum Elemento {
    IGNIS,  // Fogo
    AEQUOR, // Água
    TELLUS, // Terra
    VITAS,  // Vida
    OBITUS  // Morte
    ;

    /**
     * Obtém o multiplicador de dano baseado nos elementos do atacante e do defensor.
     *
     * @param atacante O elemento do atacante.
     * @param defensor O elemento do defensor.
     * @return O multiplicador de dano.
     */
    public static double obterMultiplicador(Elemento atacante, Elemento defensor) {
        return switch (atacante) {
            case IGNIS -> (defensor == TELLUS) ? 1.5 : 1.0;
            case AEQUOR -> (defensor == IGNIS) ? 1.5 : 1.0;
            case TELLUS -> (defensor == AEQUOR) ? 1.5 : 1.0;
            case VITAS -> (defensor == OBITUS) ? 1.5 : 1.0;
            case OBITUS -> switch (defensor) {
                case IGNIS, AEQUOR, TELLUS -> 1.5;
                default -> 1.0;
            };
        };
    }
}
