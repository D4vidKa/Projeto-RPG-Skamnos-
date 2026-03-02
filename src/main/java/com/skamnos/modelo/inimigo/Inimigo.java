package com.skamnos.modelo.inimigo;

import com.skamnos.modelo.elemento.Elemento;
import com.skamnos.modelo.entidade.Entidade;
import com.skamnos.modelo.jogador.Jogador;

/*
* Classe Inimigo que herda de Entidade e representa os inimigos do jogo.
* Contém atributos específicos como recompensa de ouro, experiência, nível da área e descrição.
 */
public abstract class Inimigo extends Entidade{
    // Atributos específicos de Inimigo
    protected int recompensaOuro;
    protected int recompensaExp;
    protected int nivelArea;
    protected String descricao;
    
    // Construtor
    public Inimigo(String nome, int vidaMaxima, int ataque, int defesa, int manaMaxima, int nivel, Elemento elemento, int recompensaOuro, int recompensaExp, int nivelArea, String descricao) {
        super(nome, vidaMaxima, ataque, defesa, manaMaxima, nivel, elemento);
        this.recompensaOuro = recompensaOuro;
        this.recompensaExp = recompensaExp;
        this.descricao = descricao;
        this.nivelArea = nivelArea;
    }

    // Getters e Setters
    public int getRecompensaOuro() {
        return recompensaOuro;
    }


    public void setRecompensaOuro(int recompensaOuro) {
        this.recompensaOuro = recompensaOuro;
    }


    public int getRecompensaExp() {
        return recompensaExp;
    }


    public void setRecompensaExp(int recompensaExp) {
        this.recompensaExp = recompensaExp;
    }


    public int getNivelArea() {
        return nivelArea;
    }


    public void setNivelArea(int nivelArea) {
        this.nivelArea = nivelArea;
    }


    public String getDescricao() {
        return descricao;
    }


    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // Método abstrato para executar o turno do inimigo, a ser implementado por cada tipo específico de inimigo
    public abstract void executarTurno(Jogador jogador);

    // Metodo para receber o ouro ao morrer
    public int getOuroDropado(int numeroArea) {
        return this.recompensaOuro;
    }

    // Metodo para receber a experiencia ao morrer
    public int getExpDropada(int numeroArea) {
        return this.recompensaExp;
    }

    // Método para verificar se o inimigo morreu e conceder recompensas ao jogador
    // Deve ser implementado depois da classe Jogador ser implementada
    public void morrer(Jogador jogador) {
        if (jogador != null) {
            jogador.ganharOuro(this.getOuroDropado(this.nivelArea));
            jogador.ganharExperiencia(this.getExpDropada(this.nivelArea));
        }
    }

    @Override
    public int atacar(Entidade alvo) {
        return super.atacar(alvo);
    }
}