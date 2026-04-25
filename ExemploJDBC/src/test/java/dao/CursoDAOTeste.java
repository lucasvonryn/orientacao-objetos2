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
	
	public static void buscarPorChaveCursoTeste() throws SQLException, IOException {
		
		int codigo = 1;
		
		Connection conn = BancoDados.conectar();
		CursoDTO cursoDTO = new CursoDAO(conn).buscarPorChave(codigo);
		
		System.out.println(cursoDTO);
	}
	
	public static void atualizarCursoTeste() throws SQLException, IOException {
		
		CursoDTO cursoDTO = new CursoDTO();
		cursoDTO.setCodigo(19);
		cursoDTO.setPeriodo("Noturno");
		cursoDTO.setDuracao(10);
		
		Connection conn = BancoDados.conectar();
		int resultado = new CursoDAO(conn).atualizar(cursoDTO);
		
		if (resultado > 0) {
			System.out.println("Curso atualizado com sucesso.");
		} else {
			System.out.println("Erro ao atualizar um curso.");
		}
	}
	
	public static void excluirCursoTeste() throws SQLException, IOException {
		
		int codigo = 19;
		
		Connection conn = BancoDados.conectar();
		int resultado = new CursoDAO(conn).excluir(codigo);
		
		if (resultado > 0) {
			System.out.println("Curso excluído com sucesso.");
		} else {
			System.out.println("Erro ao excluir um curso.");
		}
	}
	
	public static void main(String[] args) {
		
		try {
			
//			CursoDAOTeste.cadastrarCursoTeste();
//			CursoDAOTeste.buscarTodosCursosTeste();
//			CursoDAOTeste.buscarPorChaveCursoTeste();
//			CursoDAOTeste.atualizarCursoTeste();
			CursoDAOTeste.excluirCursoTeste();
			
		} catch (SQLException | IOException e) {
			
			System.out.println(e.getMessage());
		}
	}
}
