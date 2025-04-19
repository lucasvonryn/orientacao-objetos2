package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import entities.Aluno;
import entities.Curso;

public class AlunoDAOTeste {

	public static void cadastrarCursoTeste() throws SQLException, IOException {
	
		Aluno aluno = new Aluno();
		aluno.setNome("Fernando de Lima");
		aluno.setSexo("Masculino");
		aluno.setCodigoCurso(1);
		aluno.setDataIngresso("29/07/2021");
		aluno.setPeriodo(4);
		aluno.setCoeficiente(9.0);
		
		Connection conn = BancoDados.conectar();
		new AlunoDAO(conn).cadastrar(aluno);
		
		System.out.println("Cadastro efetuado com sucesso.");
	}
	
	public static void buscarTodosAlunosTeste() throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		List<Aluno> listaAlunos = new AlunoDAO(conn).buscarTodos();
		
		for (Aluno aluno : listaAlunos) {
			
			System.out.println(aluno.getNome() + " - " + aluno.getSexo() + " - " + aluno.getCodigoCurso() + 
					" - " + aluno.getDataIngresso() + " - " + aluno.getPeriodo() + " - " +
					aluno.getCoeficiente());
		}
	}
	
	public static void buscarPorRATeste() throws SQLException, IOException {
		
		int registro_academico = 4;
		
		Connection conn = BancoDados.conectar();
		Aluno aluno = new AlunoDAO(conn).buscarPorRA(registro_academico);
		
		if (aluno != null) {
			
			System.out.println(aluno.getNome() + " - " + aluno.getSexo() + " - " + aluno.getCodigoCurso() + 
					" - " + aluno.getDataIngresso() + " - " + aluno.getPeriodo() + " - " +
					aluno.getCoeficiente());
			
		} else {
			
			System.out.println("RA não encontrado.");
		}
	}
	
	public static void atualizarAlunoTeste() throws SQLException, IOException {
		
		Aluno aluno = new Aluno();
		aluno.setRegistroAcademico(3);
		aluno.setNome("Lucas Gabriel Von Ryn");
		aluno.setSexo("Masculino");
		aluno.setCodigoCurso(1);
		aluno.setDataIngresso("01/04/2025");
		aluno.setPeriodo(5);
		aluno.setCoeficiente(9.89);
		
		Connection conn = BancoDados.conectar();
		new AlunoDAO(conn).atualizar(aluno);
		
		System.out.println("Dados do aluno atualizados com sucesso.");
	}
	
	public static void excluirAlunoTeste() throws SQLException, IOException {
		
		int ra = 4;
		
		Connection conn = BancoDados.conectar();
		int linhasManipuladas = new AlunoDAO(conn).excluir(ra);
		
		if (linhasManipuladas > 0) {
			
			System.out.println("Aluno excluído com sucesso.");
			
		} else {
		
			System.out.println("Nenhum registro foi alterado.");
		}
	}
	
	public static void main(String[] args) {
		
		try {
			
//			AlunoDAOTeste.cadastrarCursoTeste();
//			AlunoDAOTeste.buscarTodosAlunosTeste();
//			AlunoDAOTeste.buscarPorRATeste();
//			AlunoDAOTeste.atualizarAlunoTeste();
			AlunoDAOTeste.excluirAlunoTeste();
			
		} catch (SQLException | IOException e) {
			
			System.out.println(e.getMessage());
		}
	}
}
