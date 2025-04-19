package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import entities.Aluno;

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
	
	public static void main(String[] args) {
		
		try {
			
//			AlunoDAOTeste.cadastrarCursoTeste();
			AlunoDAOTeste.buscarTodosAlunosTeste();
			
		} catch (SQLException | IOException e) {
			
			System.out.println(e.getMessage());
		}
	}
}
