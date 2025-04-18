package dao;

import java.sql.Connection;
import java.util.List;

import entities.Aluno;

public class AlunoDAO {

	private Connection conn;
	
	public AlunoDAO(Connection conn) {
		
		this.conn = conn;
	}
	
	public void cadastrar(Aluno aluno) {
		
	}
	
	public List<Aluno> buscarTodos() {
		
		return null;
	}
	
	public Aluno buscarPorRA(int ra) {
		
		return null;
	}
	
	public void atualizar(Aluno aluno) {
		
	}
	
	public int excluir(int ra) {
		
		return 0;
	}
}
