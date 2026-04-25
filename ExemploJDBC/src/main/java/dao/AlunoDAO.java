package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.AlunoDTO;

public class AlunoDAO implements DAO<AlunoDTO, Integer> {
	
	private Connection conn;
	
	public AlunoDAO(Connection conn) {
		
		this.conn = conn;		
	}

	@Override
	public int cadastrar(AlunoDTO alunoDTO) throws SQLException {
		
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
			
			st.setInt(1, alunoDTO.getRegistroAcademico());
			st.setString(2, alunoDTO.getNome());
			st.setString(3, alunoDTO.getSexo());
			st.setInt(4, alunoDTO.getCursoDTO().getCodigo());
			st.setDate(5, alunoDTO.getDataIngresso());
			st.setInt(6, alunoDTO.getPeriodo());
			st.setDouble(7, alunoDTO.getCoeficiente());
			
			return st.executeUpdate();
			
		} finally {
			
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}

	@Override
	public List<AlunoDTO> buscarTodos() throws SQLException {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			
			st = conn.prepareStatement("select * from aluno");
			rs = st.executeQuery();
			
			List<AlunoDTO> listaAlunos = new ArrayList<>();
			
			while (rs.next()) {
								
				AlunoDTO alunoDTO = new AlunoDTO();
				alunoDTO.setRegistroAcademico(rs.getInt("registroAcademico"));
				alunoDTO.setNome(rs.getString("nome"));
				alunoDTO.setSexo(rs.getString("sexo"));
				alunoDTO.setDataIngresso(rs.getDate("dataIngresso"));
				alunoDTO.setPeriodo(rs.getInt("periodo"));
				alunoDTO.setCoeficiente(rs.getDouble("coeficiente"));
				
				listaAlunos.add(alunoDTO);
			}
			
			return listaAlunos;
			
		} finally {
			
			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}

	@Override
	public AlunoDTO buscarPorChave(Integer chavePrimaria) throws SQLException {
		
		PreparedStatement st = null;
		ResultSet rs = null;
				
		st = conn.prepareStatement("select * from aluno where registroAcademico = ?");
		st.setInt(1, chavePrimaria);
		rs = st.executeQuery();
			
		try {
		
			if (rs.next()) {
				
				AlunoDTO alunoDTO = new AlunoDTO();
				alunoDTO.setRegistroAcademico(rs.getInt("registroAcademico"));
				alunoDTO.setNome(rs.getString("nome"));
				alunoDTO.setSexo(rs.getString("sexo"));
				alunoDTO.setDataIngresso(rs.getDate("dataIngresso"));
				alunoDTO.setPeriodo(rs.getInt("periodo"));
				alunoDTO.setCoeficiente(rs.getDouble("coeficiente"));
				
				return alunoDTO;
			}
				
			return null;
			
		} finally {
			
			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}

	@Override
	public int atualizar(AlunoDTO alunoDTO) throws SQLException {

		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement("update aluno set periodo = ?, coeficiente = ? where registroAcademico = ?");
			st.setInt(1, alunoDTO.getPeriodo());
			st.setDouble(2, alunoDTO.getCoeficiente());
			st.setInt(3, alunoDTO.getRegistroAcademico());
			
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
			
			st = conn.prepareStatement("delete from aluno where registroAcademico = ?");
			st.setInt(1, chavePrimaria);
			
			return st.executeUpdate();
			
		} finally {
			
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}
}
