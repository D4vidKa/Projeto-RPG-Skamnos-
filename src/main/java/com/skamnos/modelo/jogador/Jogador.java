package com.skamnos.modelo.jogador;

import com.skamnos.modelo.elemento.Elemento;
import com.skamnos.modelo.entidade.Entidade;
import com.skamnos.itens.item.Item;
import java.util.List;
import java.util.ArrayList;

public class Jogador extends Entidade{
    // Atributos específicos do jogador
    protected int ouro;
    protected int experiencia;
    protected String ultimoCheckpoint;
    protected Item armaEquipada;
    protected Item cabecaEquipada;
    protected Item corpoEquipada;
    protected List<Item> inventario;

    // Construtor
    public Jogador(String nome, int vidaMaxima, int ataque, int defesa, int manaMaxima, int nivel, Elemento elemento, int ouro, int experiencia, String ultimoCheckpoint, Item armaEquipada, Item cabecaEquipada, Item corpoEquipada, List<Item> inventario) {
        super(nome, vidaMaxima, ataque, defesa, manaMaxima, nivel, elemento);
        // Inicialização dos atributos específicos do jogador
        this.nome = "Jogador";
        this.vidaMaxima = 50;
        this.vida = 50;
        this.ataque = 10;
        this.defesa = 5;
        this.manaMaxima = 5;
        this.mana = 5;
        this.nivel = 1;
        this.elemento = Elemento.VITAS;
        this.ouro = 0;
        this.experiencia = 1;
        this.ultimoCheckpoint = "Início do Jogo";
        this.armaEquipada = null;
        this.cabecaEquipada = null;
        this.corpoEquipada = null;
        this.inventario = new ArrayList<>();
    }

    // Getters e Setters
    public int getOuro() {
        return ouro;
    }

    public void setOuro(int ouro) {
        this.ouro = ouro;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public String getUltimoCheckpoint() {
        return ultimoCheckpoint;
    }

    public void setUltimoCheckpoint(String ultimoCheckpoint) {
        this.ultimoCheckpoint = ultimoCheckpoint;
    }

    public Item getArmaEquipada() {
        return armaEquipada;
    }

    public void setArmaEquipada(Item armaEquipada) {
        this.armaEquipada = armaEquipada;
    }

    public Item getCabecaEquipada() {
        return cabecaEquipada;
    }

    public void setCabecaEquipada(Item cabecaEquipada) {
        this.cabecaEquipada = cabecaEquipada;
    }

    public Item getCorpoEquipada() {
        return corpoEquipada;
    }

    public void setCorpoEquipada(Item corpoEquipada) {
        this.corpoEquipada = corpoEquipada;
    }

    public List<Item> getInventario() {
        return inventario;
    }

    public void setInventario(List<Item> inventario) {
        this.inventario = inventario;
    }

    /*
    Métodos específicos do jogador, como ganhar ouro, subir de nível, equipar itens, etc.
     */

    // Método para ganhar ouro
    public void ganharOuro(int quantidade) {
        this.ouro += quantidade;
        if (quantidade < 0) {
            this.ouro -= quantidade; // Impede que o ouro seja negativo
        }
        
    }

    // Método para ganhar experiência
    public void ganharExperiencia(int quantidade) {
        this.experiencia += quantidade;
        if (quantidade < 0) {
            this.experiencia -= quantidade; // Impede que a experiência seja negativa
        }
        
        if(this.experiencia >= 50) {
            this.experiencia = 1; // Reseta a experiência ao subir de nível
            subirNivel();
        }

        if (this.nivel == 50){
            this.experiencia = 0; // Impede que a experiência seja acumulada após atingir o nível máximo
        }

        if (this.nivel > 50){
            this.nivel = 50; // Impede que o nível ultrapasse o máximo
        }
    }

    // Método para aplicar bônus de atributos ao subir de nível
    public void aplicarBonusAtributos(int valor){
        this.vidaMaxima += 7;
        this.ataque += 3;
        this.defesa += 2;
        this.manaMaxima += 1;
        // Aplica bônus adicionais a cada 5 níveis
        if (this.nivel % 5 == 0){
            this.vidaMaxima += 10;
            this.ataque += 5;
            this.defesa += 3;
            this.manaMaxima += 2;
        }
    }

    // Método para exibir mensagem de parabéns ao subir de nível
    public String mensagemParabens(){
        return """
        Parabéns! Você subiu para o nível """ + this.nivel + """
        Vida máxima aumentada para """ + this.vidaMaxima + """
        Ataque aumentado para """ + this.ataque + """
        Defesa aumentada para """ + this.defesa + """
        Mana máxima aumentada para """ + this.manaMaxima + """
                """;
    }

    // Método para subir de nível
    public void subirNivel(){
        this.nivel++;
        aplicarBonusAtributos(this.nivel);
        this.vida = this.vidaMaxima; // Restaurar vida ao subir de nível
        this.mana = this.manaMaxima; // Restaurar mana ao subir de nível
        // Mensagem de parabéns ao jogador
        System.out.println(mensagemParabens());
    }

    // Método para comprar um item, verificando o custo e atualizando o ouro do jogador
    public boolean comprarItem(Item item) {
        if (this.ouro >= item.getPreco()) {
            this.ouro -= item.getPreco();
            this.inventario.add(item);
            System.out.println("Item " + item.getNome() + " comprado com sucesso! ");
            return true; // Compra bem-sucedida
        } else {
            System.out.println("Ouro insuficiente para comprar " + item.getNome());
            return false; // Ouro insuficiente para comprar o item
        }
    }

    // Método para salvar o estado do jogador
    // JogoSalvo ainda não implementado, mas a ideia é criar um objeto JogoSalvo que armazene todas as informações relevantes do jogador, como nível, etc.
    /*public JogoSalvo salvarJogo() {
        
    }*/

    // Método para carregar o estado do jogador a partir de um jogo salvo
    /*public void carregarJogo(JogoSalvo save) {
        
    }*/

    // Método para descansar e recuperar vida e mana
    public void descansar() {
        this.vida = this.vidaMaxima;
        this.mana = this.manaMaxima;
        System.out.println("Você descansa e sente-se completamente restaurado!");
    }
}
