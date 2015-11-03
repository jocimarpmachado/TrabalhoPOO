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
public class Musica {
    private String nome;
    private float tempo;
    private int nota;

    public Musica(String nome, float tempo, int nota) {
        this.nome = nome;
        this.tempo = tempo;
        this.nota = nota;
    }

    public int getNota() {
        return nota;
    }
    
    public String getNome() {
        return nome;
    }
    
    public float getTempo() {
        return tempo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setNota(int nota) {
        this.nota = nota;
    }
    
    public void setTempo(float tempo) {
        this.tempo = tempo;
    }
    
    public void ListaMusica(){
        System.out.println("Nome "+nome);
        System.out.println("Tempo "+tempo);
    }
}
