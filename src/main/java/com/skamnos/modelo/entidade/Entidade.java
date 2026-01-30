package com.skamnos.modelo.entidade;

public abstract class Entidade {
    protected String nome;
    protected int vidaMaxima;
    protected int vida;
    protected int ataque;
    protected int defesa;
    protected int mana;
    protected int nivel;
    protected Elemento elemento;

    // Construtor
    public Entidade(String nome, int vidaMaxima, int ataque, int defesa, int mana, int nivel, Elemento elemento) {
        this.nome = nome;
        this.vidaMaxima = vidaMaxima;
        this.vida = vidaMaxima; // Vida inicial é igual à vida máxima
        this.ataque = ataque;
        this.defesa = defesa;
        this.mana = mana;
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
        return setVida(dano);;
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
    public abstract void atacar(Entidade alvo){
        // Lógica de ataque será implementada nas subclasses
    };
    
    // Método para receber dano
    public abstract void receberDano(int dano){
        this.setVida(this.getVida() - dano);
        if (receberDano(dano) >= this.getVida()){
            estaVivo() = false;
        }
    };

    // Método para verificar se a entidade está viva
    public abstract boolean estaVivo(){
        if (this.getVida() > 0){
            return true;
        } else {
            return false;
        }
    };

    // Método para receber cura
    public abstract void receberCura(int cura){
        this.setVida(this.getVida() + cura);
        if receberCura() < 0 {
            receberCura(0);
        }
        if (this.getVida() > this.getVidaMaxima()){
            this.setVida(this.getVidaMaxima());
        }
    };

    // Método para obter o elemento de ataque da entidade
    public abstract Elemento getElementoAtaque(){
        return this.elemento;
    };
}
