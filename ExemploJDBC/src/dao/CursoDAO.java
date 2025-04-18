package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import entities.Curso;

public class CursoDAO {

	private Connection conn;
	
	public CursoDAO(Connection conn) {
		
		this.conn = conn;
	}
	
	public void cadastrar(Curso curso) throws SQLException {
		
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement("insert into curso (nome, periodo, duracao) values (?, ?, ?)");
			
			st.setString(1, curso.getNome());
			st.setString(2, curso.getPeriodo());
			st.setInt(3, curso.getDuracao());
			
			st.executeUpdate();
			
		} finally {
			
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}
	
	public List<Curso> buscarTodos() {
		
		return null;
	}
	
	public Curso buscarPorCodigo(int codigoCurso) {
		
		return null;
	}
	
	public void atualizar(Curso curso) {
		
	}
	
	public int excluir(int codigo) {
		
		return 0;
	}
}
