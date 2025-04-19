package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Aluno;

public class AlunoDAO {

	private Connection conn;
	
	public AlunoDAO(Connection conn) {
		
		this.conn = conn;
	}
	
	public void cadastrar(Aluno aluno) throws SQLException {
		
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement("insert into aluno "
					+ "(nome, sexo, codigo_curso, data_ingresso, periodo, coeficiente) values"
					+ "(?, ?, ?, ?, ?, ?)");
			
			st.setString(1, aluno.getNome());
			st.setString(2, aluno.getSexo());
			st.setInt(3, aluno.getCodigoCurso());
			st.setString(4, aluno.getDataIngresso());
			st.setInt(5, aluno.getPeriodo());
			st.setDouble(6, aluno.getCoeficiente());
			
			st.executeUpdate();
			
		} finally {
			
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}
	
	public List<Aluno> buscarTodos() throws SQLException {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			
			st = conn.prepareStatement("select * from aluno order by nome");
			
			rs = st.executeQuery();
			
			List<Aluno> listaAlunos = new ArrayList<>();
			
			while (rs.next()) {
				
				Aluno aluno = new Aluno();
				
				aluno.setNome(rs.getString("nome"));
				aluno.setSexo(rs.getString("sexo"));
				aluno.setCodigoCurso(rs.getInt("codigo_curso"));
				aluno.setDataIngresso(rs.getString("data_ingresso"));
				aluno.setPeriodo(rs.getInt("periodo"));
				aluno.setCoeficiente(rs.getDouble("coeficiente"));
				
				listaAlunos.add(aluno);
			}
			
			return listaAlunos;
			
		} finally {
			
			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
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
