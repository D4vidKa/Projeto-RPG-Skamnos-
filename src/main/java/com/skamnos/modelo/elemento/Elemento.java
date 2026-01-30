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
        switch (atacante) {
            case IGNIS:
                switch (defensor) {
                    case TELLUS:
                        return 1.5;
                    default:
                        return 1.0;
                }
            case AEQUOR:
                switch (defensor) {
                    case IGNIS:
                        return 1.5;
                    default:
                        return 1.0;
                }
            case TELLUS:
                switch (defensor) {
                    case AEQUOR:
                        return 1.5;
                    default:
                        return 1.0;
                }
            case VITAS:
                switch (defensor) {
                    case OBITUS:
                        return 1.5;
                    default:
                        return 1.0;
                }
            case OBITUS:
                switch (defensor) {
                    case IGNIS:
                        return 1.5;
                    case AEQUOR:
                        return 1.5;
                    case TELLUS:
                        return 1.5;
                    case VITAS:
                        return 0.5;
                    default:
                        return 1.0;
                }
            default:
                return 1.0;
        }
    }
}
