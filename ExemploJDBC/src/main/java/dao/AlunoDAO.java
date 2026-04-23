package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import dto.AlunoDTO;

public class AlunoDAO implements DAO<AlunoDTO, Integer> {
	
	private Connection conn;
	
	public AlunoDAO(Connection conn) {
		
		this.conn = conn;		
	}

	@Override
	public int cadastrar(AlunoDTO entidade) throws SQLException {
		
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement(
					"insert into aluno ("
					+ "registroAcademico,"
					+ " nome,"
					+ " sexo,"
					+ " codigoCurso,"
					+ " dataIngresso,"
					+ " periodo,"
					+ " coeficiente"
					+ ") values (?, ?, ?, ?, ?, ?, ?)"
					);
			
			st.setInt(1, entidade.getRegistroAcademico());
			st.setString(2, entidade.getNome());
			st.setString(3, entidade.getSexo());
			st.setInt(4, entidade.getCursoDTO().getCodigo());
			st.setDate(5, entidade.getDataIngresso());
			st.setInt(6, entidade.getPeriodo());
			st.setDouble(7, entidade.getCoeficiente());
			
			return st.executeUpdate();
			
		} finally {
			
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}

	@Override
	public List<AlunoDTO> buscarTodos() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AlunoDTO buscarPorChave(Integer chavePrimaria) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int atualizar(AlunoDTO entidade) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int excluir(Integer chavePrimaria) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
