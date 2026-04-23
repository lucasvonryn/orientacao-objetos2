package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import dto.AlunoDTO;

public class AlunoDAOTeste {

	public static void cadastrarAlunoTeste() throws SQLException, IOException {
		
		AlunoDTO aluno = new AlunoDTO();
		aluno.setRegistroAcademico(2613573);
		aluno.setNome("Lucas Gabriel Von Ryn");
		aluno.setSexo("Masculino");
		aluno.setDataIngresso(java.sql.Date.valueOf("2024-03-15"));
		
		Connection conn = BancoDados.conectar();
		new AlunoDAO(conn).cadastrar(null);
	}
}
