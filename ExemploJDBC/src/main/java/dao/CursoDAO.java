package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.CursoDTO;

public class CursoDAO implements DAO<CursoDTO, Integer> {
	
	private Connection conn;
	
	public CursoDAO(Connection conn) {
		
		this.conn = conn;
	}

	@Override
	public int cadastrar(CursoDTO entidade) throws SQLException {
		
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement("insert into curso (nome, periodo, duracao) values (?, ?, ?)");
			
			st.setString(1, entidade.getNome());
			st.setString(2, entidade.getPeriodo());
			st.setInt(3, entidade.getDuracao());
			
			return st.executeUpdate();
			
		} finally {
			
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}

	@Override
	public List<CursoDTO> buscarTodos() throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			
			st = conn.prepareStatement("select * from curso order by nome");
			
			rs = st.executeQuery();
			
			List<CursoDTO> listaCursos = new ArrayList<>();
			
			while (rs.next()) {
				
				CursoDTO cursoDTO = new CursoDTO();
				
				cursoDTO.setCodigo(rs.getInt("codigo"));
				cursoDTO.setNome(rs.getString("nome"));
				cursoDTO.setPeriodo(rs.getString("periodo"));
				cursoDTO.setDuracao(rs.getInt("duracao"));
				
				listaCursos.add(cursoDTO);
			}
			
			return listaCursos;
			
		} finally {
			
			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}

	@Override
	public CursoDTO buscarPorChave(Integer chavePrimaria) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int atualizar(CursoDTO entidade) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int excluir(Integer chavePrimaria) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}	
}
