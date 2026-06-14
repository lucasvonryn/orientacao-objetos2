package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dto.AlunoDTO;
import dto.CursoDTO;

public class AlunoDAOTeste {

	public static void cadastrarAlunoTeste() throws SQLException, IOException {
		
		CursoDTO curso = new CursoDTO();
		curso.setCodigo(1);
		
		AlunoDTO aluno = new AlunoDTO();
		aluno.setRegistroAcademico(2613573);
		aluno.setNome("Lucas Gabriel Von Ryn");
		aluno.setSexo("Masculino");
		aluno.setCursoDTO(curso);
		aluno.setDataIngresso(java.sql.Date.valueOf("2026-04-24"));
		aluno.setPeriodo(1);
		aluno.setCoeficiente(10.0);
		
		Connection conn = BancoDados.conectar();
		Integer resultado = new AlunoDAO(conn).cadastrar(aluno);
		
		if (resultado > 0) {
			System.out.println("Cadastro realizado com sucesso.");
		} else {
			System.out.println("Erro ao cadastrar novo aluno.");
		}
	}
	
	public static void buscarTodosAlunosTeste() throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		List<AlunoDTO> listaAlunos = new AlunoDAO(conn).buscarTodos();
		
		for (AlunoDTO alunoDTO : listaAlunos) {
			System.out.println(alunoDTO);
		}
	}
	
	public static void buscarPorChaveTeste() throws SQLException, IOException { 
		
		Connection conn = BancoDados.conectar();
		AlunoDTO alunoDTO = new AlunoDAO(conn).buscarPorChave(2613573);
		
		System.out.println(alunoDTO);
	}
	
	public static void atualizarAlunoTeste() throws SQLException, IOException {
		
		AlunoDTO alunoDTO = new AlunoDTO();
		alunoDTO.setRegistroAcademico(2613573);
		alunoDTO.setPeriodo(6);
		alunoDTO.setCoeficiente(6.52);
		
		Connection conn = BancoDados.conectar();
		int resultado = new AlunoDAO(conn).atualizar(alunoDTO);
		
		if (resultado > 0) {
			System.out.println("Aluno atualizado com sucesso.");
		} else {
			System.out.println("Erro ao atualizar um aluno.");
		}
	}
	
	public static void excluirAlunoTeste() throws SQLException, IOException {
		
		int registroAcademico = 2613573;
		
		Connection conn = BancoDados.conectar();
		int resultado = new AlunoDAO(conn).excluir(registroAcademico);
		
		if (resultado > 0) {
			System.out.println("Aluno excluído com sucesso.");
		} else {
			System.out.println("Erro ao excluir um aluno.");
		}
	}
	
	public static void main(String[] args) {
		
		try {
			
//			AlunoDAOTeste.cadastrarAlunoTeste();
//			AlunoDAOTeste.buscarTodosAlunosTeste();
//			AlunoDAOTeste.buscarPorChaveTeste();
//			AlunoDAOTeste.atualizarAlunoTeste();
			AlunoDAOTeste.excluirAlunoTeste();
			
		} catch (SQLException | IOException e) {
			
			System.out.println(e.getMessage());
		}
	}
}
