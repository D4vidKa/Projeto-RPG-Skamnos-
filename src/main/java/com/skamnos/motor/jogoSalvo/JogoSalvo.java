package com.skamnos.motor.jogoSalvo;

import com.skamnos.itens.arma.Arma;
import com.skamnos.itens.cabeca.Cabeca;
import com.skamnos.itens.corpo.Corpo;
import com.skamnos.modelo.elemento.Elemento;
import com.skamnos.modelo.inventario.Inventario;

/**
 * Classe que representa um jogo salvo, contendo as informações necessárias para
 * restaurar o estado do jogo em um momento específico.
 */
public class JogoSalvo {
    /*
     * Atributos que armazenam as informações do jogo salvo.
     */
    private String nomeSalvo;
    private int vidaMaximaSalva;
    private int vidaSalva;
    private int ataqueSalvo;
    private int defesaSalva;
    private int manaMaximaSalva;
    private int manaSalva;
    private int nivelSalvo;
    private Elemento elementoSalvo;
    private int ouroSalvo;
    private int experienciaSalva;
    private String checkpointSalvo;
    private Arma armaSalva;
    private Cabeca cabecaSalva;
    private Corpo corpoSalvo;
    private Inventario inventarioSalvo;

    // Construtor vazio
    public JogoSalvo() {
    }

    // Construtor
    public JogoSalvo(String nomeSalvo, int vidaMaximaSalva, int vidaSalva, int ataqueSalvo, int defesaSalva, int manaMaximaSalva, int manaSalva, int nivelSalvo,
            Elemento elementoSalvo, int ouroSalvo, int experienciaSalva, String checkpointSalvo, Arma armaSalva,
            Cabeca cabecaSalva, Corpo corpoSalvo, Inventario inventarioSalvo) {
        // Atributos do Personagem
        this.nomeSalvo = nomeSalvo;
        this.vidaMaximaSalva = vidaMaximaSalva;
        this.vidaSalva = vidaSalva;
        this.ataqueSalvo = ataqueSalvo;
        this.defesaSalva = defesaSalva;
        this.manaMaximaSalva = manaMaximaSalva;
        this.manaSalva = manaSalva;
        this.nivelSalvo = nivelSalvo;
        this.elementoSalvo = elementoSalvo;
        this.ouroSalvo = ouroSalvo;
        this.experienciaSalva = experienciaSalva;
        this.checkpointSalvo = checkpointSalvo;
        // Equipamentos e Inventário
        this.armaSalva = armaSalva;
        this.cabecaSalva = cabecaSalva;
        this.corpoSalvo = corpoSalvo;
        this.inventarioSalvo = inventarioSalvo;
    }

    // Getters e Setters para os atributos do jogo salvo
    public String getNomeSalvo() {
        return nomeSalvo;
    }

    public void setNomeSalvo(String nomeSalvo) {
        this.nomeSalvo = nomeSalvo;
    }

    public int getVidaMaximaSalva() {
        return vidaMaximaSalva;
    }

    public void setVidaMaximaSalva(int vidaMaximaSalva) {
        this.vidaMaximaSalva = vidaMaximaSalva;
    }

    public int getVidaSalva() {
        return vidaSalva;
    }

    public void setVidaSalva(int vidaSalva) {
        this.vidaSalva = vidaSalva;
    }

    public int getAtaqueSalvo() {
        return ataqueSalvo;
    }

    public void setAtaqueSalvo(int ataqueSalvo) {
        this.ataqueSalvo = ataqueSalvo;
    }

    public int getDefesaSalva() {
        return defesaSalva;
    }

    public void setDefesaSalva(int defesaSalva) {
        this.defesaSalva = defesaSalva;
    }

    public int getManaMaximaSalva() {
        return manaMaximaSalva;
    }

    public void setManaMaximaSalva(int manaMaximaSalva) {
        this.manaMaximaSalva = manaMaximaSalva;
    }   

    public int getManaSalva() {
        return manaSalva;
    }

    public void setManaSalva(int manaSalva) {
        this.manaSalva = manaSalva;
    }

    public int getNivelSalvo() {
        return nivelSalvo;
    }

    public void setNivelSalvo(int nivelSalvo) {
        this.nivelSalvo = nivelSalvo;
    }

    public Elemento getElementoSalvo() {
        return elementoSalvo;
    }

    public void setElementoSalvo(Elemento elementoSalvo) {
        this.elementoSalvo = elementoSalvo;
    }

    public int getOuroSalvo() {
        return ouroSalvo;
    }

    public void setOuroSalvo(int ouroSalvo) {
        this.ouroSalvo = ouroSalvo;
    }

    public int getExperienciaSalva() {
        return experienciaSalva;
    }

    public void setExperienciaSalva(int experienciaSalva) {
        this.experienciaSalva = experienciaSalva;
    }

    public String getCheckpointSalvo() {
        return checkpointSalvo;
    }

    public void setCheckpointSalvo(String checkpointSalvo) {
        this.checkpointSalvo = checkpointSalvo;
    }

    public Arma getArmaSalva() {
        return armaSalva;
    }

    public void setArmaSalva(Arma armaSalva) {
        this.armaSalva = armaSalva;
    }

    public Cabeca getCabecaSalva() {
        return cabecaSalva;
    }

    public void setCabecaSalva(Cabeca cabecaSalva) {
        this.cabecaSalva = cabecaSalva;
    }

    public Corpo getCorpoSalvo() {
        return corpoSalvo;
    }

    public void setCorpoSalvo(Corpo corpoSalvo) {
        this.corpoSalvo = corpoSalvo;
    }

    public Inventario getInventarioSalvo() {
        return inventarioSalvo;
    }

    public void setInventarioSalvo(Inventario inventarioSalvo) {
        this.inventarioSalvo = inventarioSalvo;
    }


}
