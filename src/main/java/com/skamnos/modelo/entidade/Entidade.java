package com.skamnos.modelo.entidade;
import com.skamnos.modelo.elemento.Elemento;

public abstract class Entidade {
    protected String nome;
    protected int vidaMaxima;
    protected int vida;
    protected int ataque;
    protected int defesa;
    protected int manaMaxima;
    protected int mana;
    protected int nivel;
    protected Elemento elemento;

    // Construtor
    public Entidade(String nome, int vidaMaxima, int ataque, int defesa, int manaMaxima, int nivel, Elemento elemento) {
        this.nome = nome;
        this.vidaMaxima = vidaMaxima;
        this.vida = vidaMaxima; // Vida inicial é igual à vida máxima
        this.ataque = ataque;
        this.defesa = defesa;
        this.manaMaxima = manaMaxima;
        this.mana = manaMaxima; // Mana inicial é igual à mana máxima
        this.nivel = nivel;
        this.elemento = elemento;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public void setVidaMaxima(int vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getManaMaxima() {
        return manaMaxima;
    }

    public void setManaMaxima(int manaMaxima) {
        this.manaMaxima = manaMaxima;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Elemento getElemento() {
        return elemento;
    }

    public void setElemento(Elemento elemento) {
        this.elemento = elemento;
    }
    
    // Metodos abstratos para ações específicas das entidades

    // Método para atacar outra entidade
    public void atacar(Entidade alvo){
        // Lógica de ataque será implementada nas subclasses
    };
    
    // Método para receber dano
    public void receberDano(int dano){
        if (dano >= 0){
            this.setVida(this.getVida() - dano);
            if (this.getVida() < 0){
                this.setVida(0);
            }
        } else {
            dano = 0; // Evita que o dano seja negativo
        }
    };

    // Método para verificar se a entidade está viva
    public boolean estaVivo(){
        if (this.getVida() > 0){
            return true;
        } else {
            return false;
        }
    };

    // Método para receber cura
    public void receberCura(int valorCura){
        if (valorCura >= 0){
            this.setVida(this.getVida() + valorCura);
            if (this.getVida() > this.getVidaMaxima()){
                this.setVida(this.getVidaMaxima());
            }
        } else {
            valorCura = 0; // Evita que a cura seja negativa
        }
    };

    public void receberMana(int valorMana){
        if (valorMana >= 0){
            this.setMana(this.getMana() + valorMana);
            if (this.getMana() > this.getManaMaxima()){
                this.setMana(this.getManaMaxima());
            }
        } else {
            valorMana = 0; // Evita que a mana seja negativa
        }
    };
    
    // Método para obter o elemento de ataque da entidade
    public Elemento getElementoAtaque(){
        return this.elemento;
    };
}
