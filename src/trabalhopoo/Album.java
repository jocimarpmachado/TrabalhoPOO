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
public class Album {
    private String nome;
    private int ano;

    public Album(String nome, int ano) {
        this.nome = nome;
        this.ano = ano;
    }

    public String getNome() {
        return nome;
    }

    public int getAno() {
        return ano;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
    
    public void ListaAlbum(){
        System.out.println("Nome "+nome);
        System.out.println("Ano "+ano);
    }
}
