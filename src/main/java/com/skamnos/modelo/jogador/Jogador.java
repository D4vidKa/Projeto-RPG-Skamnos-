package com.skamnos.modelo.jogador;

import com.skamnos.modelo.elemento.Elemento;
import com.skamnos.modelo.entidade.Entidade;
import com.skamnos.itens.equipamento.Equipamento;
import com.skamnos.itens.item.Item;
import com.skamnos.itens.arma.Arma;
import com.skamnos.itens.cabeca.Cabeca;
import com.skamnos.itens.corpo.Corpo;

import java.util.List;
import java.util.ArrayList;

public class Jogador extends Entidade {
    // Atributos específicos do jogador
    protected int ouro;
    protected int experiencia;
    protected String ultimoCheckpoint;
    protected Arma armaEquipada;
    protected Cabeca cabecaEquipada;
    protected Corpo corpoEquipada;
    protected List<Item> inventario;

    // Construtor
    public Jogador(String nome, int vidaMaxima, int ataque, int defesa, int manaMaxima, int nivel, Elemento elemento,
            int ouro, int experiencia, String ultimoCheckpoint, Item armaEquipada, Item cabecaEquipada,
            Item corpoEquipada, List<Item> inventario) {
        super(nome, vidaMaxima, ataque, defesa, manaMaxima, nivel, elemento);
        // Inicialização dos atributos específicos do jogador
        this.nome = nome;
        this.vidaMaxima = vidaMaxima;
        this.vida = vidaMaxima;
        this.ataque = ataque;
        this.defesa = defesa;
        this.manaMaxima = manaMaxima;
        this.mana = manaMaxima;
        this.nivel = nivel;
        this.elemento = elemento;
        this.ouro = ouro;
        this.experiencia = experiencia;
        this.ultimoCheckpoint = ultimoCheckpoint;
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

    public void setArmaEquipada(Arma armaEquipada) {
        this.armaEquipada = armaEquipada;
    }

    public Item getCabecaEquipada() {
        return cabecaEquipada;
    }

    public void setCabecaEquipada(Cabeca cabecaEquipada) {
        this.cabecaEquipada = cabecaEquipada;
    }

    public Item getCorpoEquipada() {
        return corpoEquipada;
    }

    public void setCorpoEquipada(Corpo corpoEquipada) {
        this.corpoEquipada = corpoEquipada;
    }

    public List<Item> getInventario() {
        return inventario;
    }

    public void setInventario(List<Item> inventario) {
        this.inventario = inventario;
    }

    /*
     * Métodos específicos do jogador, como ganhar ouro, subir de nível, equipar
     * itens, etc.
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

        if (this.experiencia >= 50) {
            this.experiencia = 1; // Reseta a experiência ao subir de nível
            subirNivel();
        }

        if (this.nivel == 50) {
            this.experiencia = 0; // Impede que a experiência seja acumulada após atingir o nível máximo
        }

        if (this.nivel > 50) {
            this.nivel = 50; // Impede que o nível ultrapasse o máximo
        }
    }

    // Método para aplicar bônus de atributos ao subir de nível
    public void aplicarBonusAtributos(int valor) {
        this.vidaMaxima += 5;
        this.ataque += 3;
        this.defesa += 2;
        this.manaMaxima += 1;
        // Aplica bônus adicionais a cada 5 níveis
        if (this.nivel % 5 == 0) {
            this.vidaMaxima += 7;
            this.ataque += 5;
            this.defesa += 3;
            this.manaMaxima += 2;
        }
    }

    // Método para exibir mensagem de parabéns ao subir de nível
    public String mensagemParabens() {
        return """
                Parabéns! Você subiu para o nível """ + this.nivel + """
                Vida máxima aumentada para """ + this.vidaMaxima + """
                Ataque aumentado para """ + this.ataque + """
                Defesa aumentada para """ + this.defesa + """
                Mana máxima aumentada para """ + this.manaMaxima + """
                """;
    }

    // Método para subir de nível
    public void subirNivel() {
        this.nivel++;
        aplicarBonusAtributos(this.nivel);
        this.vida = this.vidaMaxima; // Restaurar vida ao subir de nível
        this.mana = this.manaMaxima; // Restaurar mana ao subir de nível
        // Mensagem de parabéns ao jogador
        System.out.println(mensagemParabens());
    }

    // Método para comprar um item, verificando o custo e atualizando o ouro do
    // jogador
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
    // JogoSalvo ainda não implementado, mas a ideia é criar um objeto JogoSalvo que
    // armazene todas as informações relevantes do jogador, como nível, etc.
    /*
     * public JogoSalvo salvarJogo() {
     * 
     * }
     */

    // Método para carregar o estado do jogador a partir de um jogo salvo
    /*
     * public void carregarJogo(JogoSalvo save) {
     * 
     * }
     */

    // Método para descansar e recuperar vida e mana
    public void descansar() {
        this.vida = this.vidaMaxima;
        this.mana = this.manaMaxima;
        System.out.println("Você descansa e sente-se completamente restaurado!");
    }

    // Método para equipar um item, verificando se o item está no inventário e atualizando os atributos do jogador
    public boolean equiparItem(Equipamento item) {
        if (this.inventario.contains(item)) {
            switch (item.getTipoArma()) {
                case "Arma":
                    // Equipar a arma e atualizar os atributos do jogador
                    if (this.armaEquipada != null) {
                        // Se já houver uma arma equipada, desequipá-la antes de equipar a nova
                        desequiparItem(this.armaEquipada);
                    }
                    this.armaEquipada = Arma.class.cast(item);
                    this.vidaMaxima += item.getBonusVida(); // Aplica o bônus de vida da arma equipada
                    this.ataque += item.getBonusAtaque(); // Aplica o bônus de ataque da arma equipada
                    this.defesa += item.getBonusDefesa(); // Aplica o bônus de defesa da arma equipada
                    this.mana += item.getBonusMana(); // Aplica o bônus de mana da arma equipada
                    break;
                case "Cabeça":
                    if (this.cabecaEquipada != null) {
                        // Se já houver um equipamento de cabeça equipado, desequipá-lo antes de equipar o novo
                        desequiparItem(this.cabecaEquipada);
                    }
                    this.cabecaEquipada = Cabeca.class.cast(item);
                    // atualizando os atributos do jogador
                    this.vidaMaxima += item.getBonusVida(); // Aplica o bônus de vida da arma equipada
                    this.ataque += item.getBonusAtaque(); // Aplica o bônus de ataque da arma equipada
                    this.defesa += item.getBonusDefesa(); // Aplica o bônus de defesa da arma equipada
                    this.mana += item.getBonusMana(); // Aplica o bônus de mana da arma equipada
                    break;
                case "Corpo":
                    if (this.corpoEquipada != null) {
                        // Se já houver um equipamento de corpo equipado, desequipá-lo antes de equipar o novo
                        desequiparItem(this.corpoEquipada);
                    }
                    this.corpoEquipada = Corpo.class.cast(item);
                    // atualizando os atributos do jogador
                    this.vidaMaxima += item.getBonusVida(); // Aplica o bônus de vida da arma equipada
                    this.ataque += item.getBonusAtaque(); // Aplica o bônus de ataque da arma equipada
                    this.defesa += item.getBonusDefesa(); // Aplica o bônus de defesa da arma equipada
                    this.mana += item.getBonusMana(); // Aplica o bônus de mana da arma equipada
                    break;
                default:
                    System.out.println("Tipo de item desconhecido: " + item.getTipoArma());
                    return false; // Tipo de item desconhecido
            }
            System.out.println("Item " + item.getNome() + " equipado com sucesso! ");
            return true; // Item equipado com sucesso
        } else {
            System.out.println("Item " + item.getNome() + " não encontrado no inventário.");
            return false; // Item não encontrado no inventário
        }
    }

    // Método para desequipar um item, verificando se o item está equipado e
    // atualizando os atributos do jogador
    public boolean desequiparItem(Equipamento item) {
        if (item.equals(this.armaEquipada)) {
            this.vidaMaxima -= item.getBonusVida(); // Remove o bônus de vida da arma desequipada
            this.ataque -= item.getBonusAtaque(); // Remove o bônus de ataque da arma desequipada
            this.defesa -= item.getBonusDefesa(); // Remove o bônus de defesa da arma desequipada
            this.mana -= item.getBonusMana(); // Remove o bônus de mana da arma desequipada
            this.armaEquipada = null;
            System.out.println("Item " + item.getNome() + " desequipado com sucesso! ");
            return true; // Item desequipado com sucesso
        } else if (item.equals(this.cabecaEquipada)) {
            this.vidaMaxima -= item.getBonusVida(); // Remove o bônus de vida do equipamento de cabeça desequipado
            this.ataque -= item.getBonusAtaque(); // Remove o bônus de ataque do equipamento de cabeça desequipado
            this.defesa -= item.getBonusDefesa(); // Remove o bônus de defesa do equipamento de cabeça desequipado
            this.mana -= item.getBonusMana(); // Remove o bônus de mana do equipamento de cabeça desequipado
            this.cabecaEquipada = null;
            System.out.println("Item " + item.getNome() + " desequipado com sucesso! ");
            return true; // Item desequipado com sucesso
        } else if (item.equals(this.corpoEquipada)) {
            this.vidaMaxima -= item.getBonusVida(); // Remove o bônus de vida do equipamento de corpo desequipado
            this.ataque -= item.getBonusAtaque(); // Remove o bônus de ataque do equipamento de corpo desequipado
            this.defesa -= item.getBonusDefesa(); // Remove o bônus de defesa do equipamento de corpo desequipado
            this.mana -= item.getBonusMana(); // Remove o bônus de mana do equipamento de corpo desequipado
            this.corpoEquipada = null;
            System.out.println("Item " + item.getNome() + " desequipado com sucesso! ");
            return true; // Item desequipado com sucesso
        } else {
            System.out.println("Item " + item.getNome() + " não está equipado.");
            return false; // Item não está equipado
        }
    }

    // Método para exibir o status do jogador
    public void exibirStatus() {
        // Exibe o status do jogador, como nome, experiencia, nivel e ouro
        System.out.println("\n--- STATUS DO JOGADOR ---");
        System.out.println("Nome: " + this.nome + " | Nível: " + this.nivel);
        System.out.println("Experiência: " + this.experiencia + "/50");
        System.out.println("Ouro: " + this.ouro);
        // Exibe os atributos do jogador, como vida, mana, ataque, defesa e elemento
        System.out.println("\n[ Atributos ]");
        System.out.println("Vida: " + this.vida + "/" + this.vidaMaxima);
        System.out.println("Mana: " + this.mana + "/" + this.manaMaxima);
        System.out.println("Ataque: " + this.ataque + " | Defesa: " + this.defesa);
        System.out.println("Elemento: " + this.elemento);
        // Exibe os equipamentos do jogador, como arma, cabeça e corpo
        System.out.println("\n[ Equipamentos ]");
        System.out.println("Arma: " + (armaEquipada != null ? armaEquipada.getNome() : "Nenhuma"));
        System.out.println("Cabeça: " + (cabecaEquipada != null ? cabecaEquipada.getNome() : "Nenhuma"));
        System.out.println("Corpo: " + (corpoEquipada != null ? corpoEquipada.getNome() : "Nenhuma"));
        System.out.println("-------------------------\n");
    }
    
}
