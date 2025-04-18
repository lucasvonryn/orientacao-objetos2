package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import entities.Curso;

public class CursoDAOTeste {

	public static void cadastrarCursoTeste() throws SQLException, IOException {
		
		Curso curso = new Curso();
		curso.setNome("Tecnologia em Automação Industrial");
		curso.setPeriodo("Diurno");
		curso.setDuracao(6);
		
		Connection conn = BancoDados.conectar();
		new CursoDAO(conn).cadastrar(curso);
		
		System.out.println("Cadastro efetuado com sucesso.");
	}
	
	public static void main(String[] args) {
		
		try {
			
			CursoDAOTeste.cadastrarCursoTeste();
			
		} catch (SQLException | IOException e) {
			
			System.out.println(e.getMessage());
		}
	}
}
