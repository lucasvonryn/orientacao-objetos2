package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dto.CursoDTO;

public class CursoDAOTeste {

	public static void cadastrarCursoTeste() throws SQLException, IOException {
		
		CursoDTO curso = new CursoDTO();
		curso.setNome("Bacharelado em Ciência da Computação");
		curso.setPeriodo("Integral");
		curso.setDuracao(8);
		
		Connection conn = BancoDados.conectar();
		int resultado = new CursoDAO(conn).cadastrar(curso);
		
		if (resultado > 0) {
			System.out.println("Cadastro realizado com sucesso.");
		} else {
			System.out.println("Erro ao cadastrar um novo curso.");
		}
	}
	
	public static void buscarTodosCursosTeste() throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		List<CursoDTO> listaCursos = new CursoDAO(conn).buscarTodos();
		
		for (CursoDTO cursoDTO : listaCursos) {
			System.out.println(cursoDTO);
		}
	}
	
	public static void main(String[] args) {
		
		try {
			
//			CursoDAOTeste.cadastrarCursoTeste();
			CursoDAOTeste.buscarTodosCursosTeste();
			
		} catch (SQLException | IOException e) {
			
			System.out.println(e.getMessage());
		}
	}
}
