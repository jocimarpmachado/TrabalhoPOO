/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopoo;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Jocimar Machado
 */
public class Menu {
    
    public static void main(String[] args) {  
        menu();
    }
    
    public static void menu() {        
        String opcao = null;
        String nome, ANO, TEMPO, tela="", ID, NOTA;
        int ano, id = 0, nota;
        float tempo;
        ResultSet res;
        
        do {
            opcao = JOptionPane.showInputDialog(
                    " 1 - Cadastrar Genero\n" +
                    " 2 - Cadastrar Artista\n" +
                    " 3 - Cadastrar Album\n" +
                    " 4 - Cadastrar Musica\n" +
                    " 5 - Pesquisar Album\n" +
                    " 6 - Pesquisar Artista\n" +
                    " 7 - Pesquisar Genero\n" +
                    " 8 - Pesquisar Musica\n"+
                    " 9 - Relatório\n" +
                    " 10 - Sair\n\n");
            
           switch ( opcao) {  
               case "1":
                   nome = JOptionPane.showInputDialog("Nome do Genero: ");
                   Genero ge = new Genero(nome);
                   Conexao.inserirGenero(ge);
               break;  
                   
               case "2":
                   nome = JOptionPane.showInputDialog("Nome do Artista: ");
                   ANO = JOptionPane.showInputDialog("Tempo de carreira: ");
                   ano = Integer.parseInt(ANO);
                   
                   res = Conexao.relatorioGenero();
                   if(res!=null) {
                       try {
                            while(res.next()){
                                tela = tela
                                +"\n id: "+res.getString("id")
                                +"\n Nome: "+res.getString("nome")
                                +".";
                            }
                            ID = JOptionPane.showInputDialog(null, "Digite o ID Do Genero que Faz Referencia ao Artista"+tela);
                            id = Integer.parseInt(ID);
			} catch (SQLException e) {
                            System.out.println("Problema para exibir registros de Artista!");
			}
                    } else {
			System.out.println("A pesquisa não retornou nenhum registro!");
                    }
                   Artista ar = new Artista(nome, ano);
                   Conexao.inserirArtista(ar,id);
                   tela = "";
               break;  
                   
               case "3":
                   nome = JOptionPane.showInputDialog("Nome do Album: ");
                   ANO = JOptionPane.showInputDialog("Ano de Lançamento: ");
                   ano = Integer.parseInt(ANO); // String Para int
                   
                   res = Conexao.relatorioArtista();
                   if(res!=null) {
                       try {
                            while(res.next()){
                                tela = tela
                                +"\n id: "+res.getString("id")
                                +"\n Nome: "+res.getString("nome")
                                +"\n Tempo de Carreira: "+res.getInt("tempo_de_carreira")
                                +".";
                            }
                            ID = JOptionPane.showInputDialog(null, "Digite o ID Artista que Faz Referencia ao album"+tela);
                            id = Integer.parseInt(ID);
			} catch (SQLException e) {
                            System.out.println("Problema para exibir registros de Artista!");
			}
                    } else {
			System.out.println("A pesquisa não retornou nenhum registro!");
                    }
                   Album al = new Album(nome, ano);
                   Conexao.inserirAlbum(al, id);
                   tela = "";
               break;  
                   
               case "4":
                   nome = JOptionPane.showInputDialog("Nome da Musica: ");
                   TEMPO = JOptionPane.showInputDialog("Tempo: ");
                   NOTA = JOptionPane.showInputDialog("Nota: ");
                   tempo = Float.parseFloat(TEMPO); // String Para float
                   nota = Integer.parseInt(NOTA);
                   
                   res = Conexao.relatorioAlbum();
                   if(res!=null) {
                       try {
                            while(res.next()){
                                tela = tela
                                +"\n id: "+res.getString("id")
                                +"\n Nome: "+res.getString("nome")
                                +"\n Ano: "+res.getInt("ano")
                                +".";
                            }
                            ID = JOptionPane.showInputDialog(null, "Digite o ID Do Album que Faz Referencia a Musica"+tela);
                            id = Integer.parseInt(ID);
			} catch (SQLException e) {
                            System.out.println("Problema para exibir registros de Artista!");
			}
                    } else {
			System.out.println("A pesquisa não retornou nenhum registro!");
                    }
                   Musica mu = new Musica(nome, tempo, nota);
                   Conexao.inserirMusica(mu, id);
                   tela = "";
               break;  
                   
               case "5":
                   nome = JOptionPane.showInputDialog("Pesquisar no Album: ");
                   res = Conexao.pesquisarAlbum(nome);
                   if(res!=null) {
                       try {
                            while(res.next()){
                                tela = tela
                                +"\n id: "+res.getString("id")
                                +"\n Nome: "+res.getString("nome")
                                +"\n Ano: "+res.getInt("ano")
                                +"\n Artista: "+res.getInt("artista")
                                +".";
                            }
                            JOptionPane.showMessageDialog(null, tela);
			} catch (SQLException e) {
                            System.out.println("Problema para exibir registros de album!");
			}
                    } else {
			System.out.println("A pesquisa não retornou nenhum registro!");
                    }
                   tela = "";
               break;
                   
               case "6":  
                   nome = JOptionPane.showInputDialog("Pesquisar por Artista: ");
                   res = Conexao.pesquisarArtista(nome);
                   if(res!=null) {
                       try {
                            while(res.next()){
                                tela = tela
                                +"\n id: "+res.getString("id")
                                +"\n Nome: "+res.getString("nome")
                                +"\n Tempo de carreira: "+res.getInt("tempo_de_carreira")
                                +"\n genero: "+res.getInt("artista")
                                +".";
                            }
                            JOptionPane.showMessageDialog(null, tela);
			} catch (SQLException e) {
                            System.out.println("Problema para exibir registros de artista!");
			}
                    } else {
			System.out.println("A pesquisa não retornou nenhum registro!");
                    }
                   tela = "";
               break;  
                   
               case "7":  
                   nome = JOptionPane.showInputDialog("Pesquisar por Genero: ");
                   res = Conexao.pesquisarGenero(nome);
                   if(res!=null) {
                       try {
                            while(res.next()){
                                tela = tela
                                +"\n id: "+res.getString("id")
                                +"\n Nome: "+res.getString("nome")
                                +".";
                            }
                            JOptionPane.showMessageDialog(null, tela);
			} catch (SQLException e) {
                            System.out.println("Problema para exibir registros de genero!");
			}
                    } else {
			System.out.println("A pesquisa não retornou nenhum registro!");
                    }
                   tela = "";
               break;
               
               case "8": 
                   nome = JOptionPane.showInputDialog("Pesquisar por Musica: ");
                   res = Conexao.pesquisarMusica(nome);
                   if(res!=null) {
                       try {
                            while(res.next()){
                                tela = tela
                                +"\n id: "+res.getString("id")
                                +"\n Nome: "+res.getString("nome")
                                +"\n Tempo: "+res.getInt("tempo")
                                +"\n Album: "+res.getInt("album")
                                +".";
                            }
                            JOptionPane.showMessageDialog(null, tela);
			} catch (SQLException e) {
                            System.out.println("Problema para exibir registros de musica!");
			}
                    } else {
			System.out.println("A pesquisa não retornou nenhum registro!");
                    }
                   tela = "";
               break;
               
               case "9":
                  JOptionPane.showMessageDialog(null, "Relatorio Completo");
                   res = Conexao.relatorio();
                   if(res!=null) {
                       try {
                            while(res.next()){
                                tela = tela
                                +"\n Musica: "+res.getString("Musica")
                                +"\n Album: "+res.getString("Album")
                                +"\n Artista: "+res.getString("Artista")
                                +"\n Genero: "+res.getString("Genero")
                                +"\n Nota: "+res.getString("Nota")
                                +".";
                            }
                            JOptionPane.showMessageDialog(null, tela);
			} catch (SQLException e) {
                            System.out.println("Problema para exibir registros!");
			}
                    } else {
			System.out.println("A pesquisa não retornou nenhum registro!");
                    }
                   tela = "";
               break;
                   
               case "10":
                   JOptionPane.showMessageDialog(null, "Saindo" );
               break;
                   
               default:
                   JOptionPane.showMessageDialog(null, "Error" );
           }
       } while ( !"10".equals(opcao) );  
   }
}
