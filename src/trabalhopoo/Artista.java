/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopoo;

/**
 *
 * @author Jocimar Machado
 */
public class Artista {
    private String nome;
    private int tempo_de_carreira;

    public Artista(String nome, int tempoDeCarteira) {
        this.nome = nome;
        this.tempo_de_carreira = tempoDeCarteira;
    }

    public String getNome() {
        return nome;
    }

    public int getTempoDeCarteira() {
        return tempo_de_carreira;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTempoDeCarteira(int tempoDeCarteira) {
        this.tempo_de_carreira = tempoDeCarteira;
    }
    
    public void ListaArtista(){
        System.out.println("Nome "+nome);
        System.out.println("Tempo De Carreira "+tempo_de_carreira);
    }
}
