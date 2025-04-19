package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import entities.Curso;

public class CursoDAOTeste {

	public static void cadastrarCursoTeste() throws SQLException, IOException {
		
		Curso curso = new Curso();
		curso.setNome("Tecnologia em Análise de Sistemas");
		curso.setPeriodo("Noturno");
		curso.setDuracao(6);
		
		Connection conn = BancoDados.conectar();
		new CursoDAO(conn).cadastrar(curso);
		
		System.out.println("Cadastro efetuado com sucesso.");
	}
	
	public static void buscarTodosCursosTeste() throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		List<Curso> listaCursos = new CursoDAO(conn).buscarTodos();
		
		for (Curso curso : listaCursos) {
			
			System.out.println(curso.getCodigo() + " - " + curso.getNome() + " - " +
							   curso.getPeriodo() + " - " + curso.getDuracao());
		}
		
	}
	
	public static void buscarPorCodigoTeste() throws SQLException, IOException {
		
		int codigoCurso = 3;
		
		Connection conn = BancoDados.conectar();
		Curso curso = new CursoDAO(conn).buscarPorCodigo(codigoCurso);
		
		if (curso != null) {
			
			System.out.println(curso.getCodigo() + " - " + curso.getNome() + " - " +
					   curso.getPeriodo() + " - " + curso.getDuracao());
			
		} else {
			
			System.out.println("Código não encontrado.");
		}
	}
	
	public static void atualizarCursoTeste() throws SQLException, IOException {
		
		Curso curso = new Curso();
		curso.setCodigo(1);
		curso.setDuracao(5);
		curso.setPeriodo("Noturno");
		
		Connection conn = BancoDados.conectar();
		new CursoDAO(conn).atualizar(curso);
		
		System.out.println("Dados do curso atualizados com sucesso.");
	}
	
	public static void excluirCursoTeste() throws SQLException, IOException { 
		
		int codigoCurso = 3;
		
		Connection conn = BancoDados.conectar();
		int linhasManipuladas = new CursoDAO(conn).excluir(codigoCurso);
		
		if (linhasManipuladas > 0) {
			
			System.out.println("Curso excluído com sucesso.");
			
		} else {
			
			System.out.println("Nenhum registro foi alterado.");
		}
	}
	
	public static void main(String[] args) {
		
		try {
			
//			CursoDAOTeste.cadastrarCursoTeste();
//			CursoDAOTeste.buscarTodosCursosTeste();
//			CursoDAOTeste.buscarPorCodigoTeste();
//			CursoDAOTeste.atualizarCursoTeste();
			CursoDAOTeste.excluirCursoTeste();
			
		} catch (SQLException | IOException e) {
			
			System.out.println(e.getMessage());
		}
	}
}
