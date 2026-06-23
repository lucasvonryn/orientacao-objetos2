package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.QuartoDTO;
import enums.StatusQuarto;
import enums.TipoQuarto;

public class QuartoDAO implements DAO<QuartoDTO, Integer> {

	private Connection conn;

	public QuartoDAO(Connection conn) {
		this.conn = conn;
	}

	@Override
	public int cadastrar(QuartoDTO quartoDTO) throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement(
					"insert into quarto (numero, tipo, capacidade_maxima, valor_diaria, status) values (?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);

			st.setInt(1, quartoDTO.getNumero());
			st.setString(2, quartoDTO.getTipo().name());
			st.setInt(3, quartoDTO.getCapacidadeMaxima());
			st.setDouble(4, quartoDTO.getValorDiaria());
			st.setString(5, quartoDTO.getStatus().name());

			int resultado = st.executeUpdate();

			rs = st.getGeneratedKeys();
			if (rs.next()) {
				quartoDTO.setCodigo(rs.getInt(1));
			}

			return resultado;

		} finally {

			BancoDados.finalizarResultSet(rs);
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar(conn);
		}
	}

	@Override
	public List<QuartoDTO> buscarTodos() throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("select * from quarto order by numero");
			rs = st.executeQuery();

			List<QuartoDTO> lista = new ArrayList<>();

			while (rs.next()) {
				lista.add(mapearQuarto(rs));
			}

			return lista;

		} finally {

			BancoDados.finalizarResultSet(rs);
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar(conn);
		}
	}

	@Override
	public QuartoDTO buscarPorChave(Integer codigo) throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("select * from quarto where codigo = ?");
			st.setInt(1, codigo);
			rs = st.executeQuery();

			if (rs.next()) {
				return mapearQuarto(rs);
			}

			return null;

		} finally {

			BancoDados.finalizarResultSet(rs);
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar(conn);
		}
	}

	public QuartoDTO buscarPorNumero(Integer numero) throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("select * from quarto where numero = ?");
			st.setInt(1, numero);
			rs = st.executeQuery();

			if (rs.next()) {
				return mapearQuarto(rs);
			}

			return null;

		} finally {

			BancoDados.finalizarResultSet(rs);
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar(conn);
		}
	}

	public List<QuartoDTO> buscarPorTipo(TipoQuarto tipo) throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("select * from quarto where tipo = ? order by numero");
			st.setString(1, tipo.name());
			rs = st.executeQuery();

			List<QuartoDTO> lista = new ArrayList<>();

			while (rs.next()) {
				lista.add(mapearQuarto(rs));
			}

			return lista;

		} finally {

			BancoDados.finalizarResultSet(rs);
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar(conn);
		}
	}

	public List<QuartoDTO> buscarPorStatus(StatusQuarto status) throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("select * from quarto where status = ? order by numero");
			st.setString(1, status.name());
			rs = st.executeQuery();

			List<QuartoDTO> lista = new ArrayList<>();

			while (rs.next()) {
				lista.add(mapearQuarto(rs));
			}

			return lista;

		} finally {

			BancoDados.finalizarResultSet(rs);
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar(conn);
		}
	}

	@Override
	public int atualizar(QuartoDTO quartoDTO) throws SQLException {

		PreparedStatement st = null;

		try {

			st = conn.prepareStatement(
					"update quarto set numero = ?, tipo = ?, capacidade_maxima = ?, valor_diaria = ?, status = ? where codigo = ?");

			st.setInt(1, quartoDTO.getNumero());
			st.setString(2, quartoDTO.getTipo().name());
			st.setInt(3, quartoDTO.getCapacidadeMaxima());
			st.setDouble(4, quartoDTO.getValorDiaria());
			st.setString(5, quartoDTO.getStatus().name());
			st.setInt(6, quartoDTO.getCodigo());

			return st.executeUpdate();

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.desconectar(conn);
		}
	}

	public int atualizarStatus(Integer codigo, StatusQuarto status) throws SQLException {

		PreparedStatement st = null;

		try {

			st = conn.prepareStatement("update quarto set status = ? where codigo = ?");
			st.setString(1, status.name());
			st.setInt(2, codigo);

			return st.executeUpdate();

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.desconectar(conn);
		}
	}

	@Override
	public int excluir(Integer codigo) throws SQLException {

		PreparedStatement st = null;

		try {

			st = conn.prepareStatement("delete from quarto where codigo = ?");
			st.setInt(1, codigo);

			return st.executeUpdate();

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.desconectar(conn);
		}
	}

	public boolean possuiVinculos(Integer codigo) throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("select count(*) as total from reserva where codigo_quarto = ?");
			st.setInt(1, codigo);
			rs = st.executeQuery();

			if (rs.next() && rs.getInt("total") > 0) {
				return true;
			}

			BancoDados.finalizarResultSet(rs);
			BancoDados.finalizarStatement(st);

			st = conn.prepareStatement(
					"select count(*) as total from hospedagem h "
							+ "inner join reserva r on h.codigo_reserva = r.codigo "
							+ "where r.codigo_quarto = ?");
			st.setInt(1, codigo);
			rs = st.executeQuery();

			return rs.next() && rs.getInt("total") > 0;

		} finally {

			BancoDados.finalizarResultSet(rs);
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar(conn);
		}
	}

	private QuartoDTO mapearQuarto(ResultSet rs) throws SQLException {

		QuartoDTO quartoDTO = new QuartoDTO();
		quartoDTO.setCodigo(rs.getInt("codigo"));
		quartoDTO.setNumero(rs.getInt("numero"));
		quartoDTO.setTipo(TipoQuarto.valueOf(rs.getString("tipo")));
		quartoDTO.setCapacidadeMaxima(rs.getInt("capacidade_maxima"));
		quartoDTO.setValorDiaria(rs.getDouble("valor_diaria"));
		quartoDTO.setStatus(StatusQuarto.valueOf(rs.getString("status")));

		return quartoDTO;
	}
}
