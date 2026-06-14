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
	public int cadastrar(CursoDTO cursoDTO) throws SQLException {
		
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement("insert into curso (nome, periodo, duracao) values (?, ?, ?)");
			st.setString(1, cursoDTO.getNome());
			st.setString(2, cursoDTO.getPeriodo());
			st.setInt(3, cursoDTO.getDuracao());
			
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
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			
			st = conn.prepareStatement("select * from curso where codigo = ?");
			st.setInt(1, chavePrimaria);
			rs = st.executeQuery();
			
			if (rs.next()) {
				
				CursoDTO cursoDTO = new CursoDTO();
				cursoDTO.setCodigo(rs.getInt("codigo"));
				cursoDTO.setNome(rs.getString("nome"));
				cursoDTO.setPeriodo(rs.getString("periodo"));
				cursoDTO.setDuracao(rs.getInt("duracao"));
				
				return cursoDTO;
			}
			
			return null;
			
		} finally {
			
			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}

	@Override
	public int atualizar(CursoDTO cursoDTO) throws SQLException {
		
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement("update curso set periodo = ?, duracao = ? where codigo = ?");
			st.setString(1, cursoDTO.getPeriodo());
			st.setInt(2, cursoDTO.getDuracao());
			st.setInt(3, cursoDTO.getCodigo());
			
			return st.executeUpdate();
			
		} finally {
			
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}

	@Override
	public int excluir(Integer chavePrimaria) throws SQLException {
		
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement("delete from curso where codigo = ?");
			st.setInt(1, chavePrimaria);
			
			return st.executeUpdate();
			
		} finally {
			
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}	
}
