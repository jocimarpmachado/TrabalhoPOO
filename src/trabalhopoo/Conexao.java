package trabalhopoo;

import java.sql.*;

public class Conexao {
	
	//M�todo para Conectar ao Banco de Dados Local chamado 'cadastro', usuário 'root' e senha em branco!
	public static Connection conectar() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost/cadastro_de_musicas", "root", "");
			return(c);
		} catch (ClassNotFoundException e) {
			System.out.println("Problema na configura��o do Driver do MySQL!");
		} catch (SQLException e) {
			System.out.println("Problema na conex�o com o banco de dados!");
		}
		return(null);
	}
	
	//Retorna o relatório contendo todas as Pessoa do Banco
          public static ResultSet relatorio() {
            Connection con = conectar();
            Statement st;
            try {
            	st = con.createStatement();
              //return(st.executeQuery("SELECT mu.nome as Musica, al.nome as Album, ar.nome as Artista, ge.nome as Genero, mu.Nota as Nota FROM musica mu, album al, artista ar, genero ge WHERE(mu.album = al.id AND al.artista = ar.id AND ar.genero = ge.id) ;"));
                return(st.executeQuery("SELECT ge.nome as Genero, ar.nome as Artista, al.nome as Album, mu.nome as Musica, mu.Nota as Nota FROM genero ge, artista ar, album al, musica mu WHERE (mu.album = al.id AND al.artista = ar.id AND ar.genero = ge.id );"));
            } catch (SQLException e) {
		System.out.println("Problema na consulta na tabela album!");
            }
            return(null);
	}
          
        public static ResultSet relatorioAlbum() {
            Connection con = conectar();
            Statement st;
            try {
            	st = con.createStatement();
            	return(st.executeQuery("SELECT * FROM album;"));
            } catch (SQLException e) {
		System.out.println("Problema na consulta na tabela album!");
            }
            return(null);
	}
        
        public static ResultSet relatorioArtista() {
            Connection con = conectar();
            Statement st;
            try {
            	st = con.createStatement();
            	return(st.executeQuery("SELECT * FROM artista;"));
            } catch (SQLException e) {
		System.out.println("Problema na consulta na tabela Artista!");
            }
            return(null);
	}
        
        public static ResultSet relatorioGenero() {
            Connection con = conectar();
            Statement st;
            try {
            	st = con.createStatement();
            	return(st.executeQuery("SELECT * FROM genero;"));
            } catch (SQLException e) {
		System.out.println("Problema na consulta na tabela genero!");
            }
            return(null);
	}
        
	public static ResultSet relatorioMusica() {
            Connection con = conectar();
            Statement st;
            try {
            	st = con.createStatement();
            	return(st.executeQuery("SELECT * FROM musica;"));
            } catch (SQLException e) {
		System.out.println("Problema na consulta na tabela musica!");
            }
            return(null);
	}
	
	// inserir Album
	public static int inserirAlbum(Album al, int id) {
            String insercao = "INSERT INTO album (nome, ano, artista) VALUES ('"+al.getNome()+"',"+al.getAno()+", "+id+");";
            Connection con = conectar();
            Statement st;
            try {
            	st = con.createStatement();
            	return(st.executeUpdate(insercao));
            } catch (SQLException e) {
            	System.out.println("Problema na inserção da Album!");
            }
            return(0);
	}
        // inserir Artista
        public static int inserirArtista(Artista ar, int id) {
            String insercao = "INSERT INTO artista (nome, tempo_de_carreira, genero) VALUES ('"+ar.getNome()+"',"+ar.getTempoDeCarteira()+", "+id+");";
            Connection con = conectar();
            Statement st;
            try {
            	st = con.createStatement();
            	return(st.executeUpdate(insercao));
            } catch (SQLException e) {
            	System.out.println("Problema na inserção da Artista!");
            }
            return(0);
	}
        // inserir Genero
        public static int inserirGenero(Genero ge) {
            String insercao = "INSERT INTO genero (nome) VALUES ('"+ge.getNome()+"');";
            Connection con = conectar();
            Statement st;
            try {
            	st = con.createStatement();
            	return(st.executeUpdate(insercao));
            } catch (SQLException e) {
            	System.out.println("Problema na inserção da Genero!");
            }
            return(0);
	}
        public static int inserirMusica(Musica mu, int id) {
            String insercao = "INSERT INTO musica (nome, tempo, nota, album) VALUES ('"+mu.getNome()+"',"+mu.getTempo()+","+mu.getNota()+","+id+");";
            Connection con = conectar();
            Statement st;
            try {
            	st = con.createStatement();
            	return(st.executeUpdate(insercao));
            } catch (SQLException e) {
            	System.out.println("Problema na inserção da Musica!");
            }
            return(0);
	}
        
        public static ResultSet pesquisarAlbum(String nome){
            Connection con = conectar();
            Statement st;
            try {
            	st = con.createStatement();
            	return(st.executeQuery("SELECT * FROM album where(nome like '"+nome+"%');"));
            } catch (SQLException e) {
		System.out.println("Problema na pesquisar na tabela album!");
            }
            return(null);
	}
        
        public static ResultSet pesquisarArtista(String nome){
            Connection con = conectar();
            Statement st;
            try {
            	st = con.createStatement();
            	return(st.executeQuery("SELECT * FROM artista where(nome like '"+nome+"%');"));
            } catch (SQLException e) {
		System.out.println("Problema na pesquisar na tabela artista!");
            }
            return(null);
	}
        
        public static ResultSet pesquisarGenero(String nome){
            Connection con = conectar();
            Statement st;
            try {
            	st = con.createStatement();
            	return(st.executeQuery("SELECT * FROM genero where(nome like '"+nome+"%');"));
            } catch (SQLException e) {
		System.out.println("Problema na pesquisar na tabela genero!");
            }
            return(null);
	}
        
        public static ResultSet pesquisarMusica(String nome){
            Connection con = conectar();
            Statement st;
            try {
            	st = con.createStatement();
            	return(st.executeQuery("SELECT * FROM musica where(nome like '"+nome+"%');"));
            } catch (SQLException e) {
		System.out.println("Problema na pesquisar na tabela muica!");
            }
            return(null);
	}
}
