package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.ClienteDTO;
import dto.QuartoDTO;
import dto.ReservaDTO;
import enums.StatusReserva;

public class ReservaDAO implements DAO<ReservaDTO, Integer> {

	private Connection conn;

	public ReservaDAO(Connection conn) {
		this.conn = conn;
	}

	@Override
	public int cadastrar(ReservaDTO reservaDTO) throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement(
					"insert into reserva (codigo_cliente, codigo_quarto, data_checkin, data_checkout, qtd_hospedes, status) "
							+ "values (?, ?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);

			st.setInt(1, reservaDTO.getClienteDTO().getCodigo());
			st.setInt(2, reservaDTO.getQuartoDTO().getCodigo());
			st.setDate(3, reservaDTO.getDataCheckin());
			st.setDate(4, reservaDTO.getDataCheckout());
			st.setInt(5, reservaDTO.getQtdHospedes());
			st.setString(6, reservaDTO.getStatus().name());

			int resultado = st.executeUpdate();

			rs = st.getGeneratedKeys();
			if (rs.next()) {
				reservaDTO.setCodigo(rs.getInt(1));
			}

			return resultado;

		} finally {

			BancoDados.finalizarResultSet(rs);
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar(conn);
		}
	}

	@Override
	public List<ReservaDTO> buscarTodos() throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("select * from reserva order by data_checkin desc");
			rs = st.executeQuery();

			List<ReservaDTO> lista = new ArrayList<>();

			while (rs.next()) {
				lista.add(mapearReserva(rs));
			}

			return lista;

		} finally {

			BancoDados.finalizarResultSet(rs);
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar(conn);
		}
	}

	@Override
	public ReservaDTO buscarPorChave(Integer codigo) throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("select * from reserva where codigo = ?");
			st.setInt(1, codigo);
			rs = st.executeQuery();

			if (rs.next()) {
				return mapearReserva(rs);
			}

			return null;

		} finally {

			BancoDados.finalizarResultSet(rs);
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar(conn);
		}
	}

	@Override
	public int atualizar(ReservaDTO reservaDTO) throws SQLException {

		PreparedStatement st = null;

		try {

			st = conn.prepareStatement(
					"update reserva set codigo_cliente = ?, codigo_quarto = ?, data_checkin = ?, "
							+ "data_checkout = ?, qtd_hospedes = ?, status = ? where codigo = ?");

			st.setInt(1, reservaDTO.getClienteDTO().getCodigo());
			st.setInt(2, reservaDTO.getQuartoDTO().getCodigo());
			st.setDate(3, reservaDTO.getDataCheckin());
			st.setDate(4, reservaDTO.getDataCheckout());
			st.setInt(5, reservaDTO.getQtdHospedes());
			st.setString(6, reservaDTO.getStatus().name());
			st.setInt(7, reservaDTO.getCodigo());

			return st.executeUpdate();

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.desconectar(conn);
		}
	}

	public int atualizarStatus(Integer codigo, StatusReserva status) throws SQLException {

		PreparedStatement st = null;

		try {

			st = conn.prepareStatement("update reserva set status = ? where codigo = ?");
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

			st = conn.prepareStatement("delete from reserva where codigo = ?");
			st.setInt(1, codigo);

			return st.executeUpdate();

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.desconectar(conn);
		}
	}

	public List<ReservaDTO> buscarAtivas() throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("select * from reserva where status = ? order by data_checkin");
			st.setString(1, StatusReserva.ATIVA.name());
			rs = st.executeQuery();

			List<ReservaDTO> lista = new ArrayList<>();

			while (rs.next()) {
				lista.add(mapearReserva(rs));
			}

			return lista;

		} finally {

			BancoDados.finalizarResultSet(rs);
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar(conn);
		}
	}

	public List<ReservaDTO> buscarExpiradas(Date dataReferencia) throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement(
					"select * from reserva where status = ? and data_checkout < ? order by data_checkout");
			st.setString(1, StatusReserva.ATIVA.name());
			st.setDate(2, dataReferencia);
			rs = st.executeQuery();

			List<ReservaDTO> lista = new ArrayList<>();

			while (rs.next()) {
				lista.add(mapearReserva(rs));
			}

			return lista;

		} finally {

			BancoDados.finalizarResultSet(rs);
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar(conn);
		}
	}

	public boolean existeConflitoDatas(Integer codigoQuarto, Date checkin, Date checkout, Integer excetoReservaId)
			throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			String sql = "select count(*) as total from reserva "
					+ "where codigo_quarto = ? and status = ? "
					+ "and data_checkin < ? and data_checkout > ?";

			if (excetoReservaId != null) {
				sql += " and codigo <> ?";
			}

			st = conn.prepareStatement(sql);
			st.setInt(1, codigoQuarto);
			st.setString(2, StatusReserva.ATIVA.name());
			st.setDate(3, checkout);
			st.setDate(4, checkin);

			if (excetoReservaId != null) {
				st.setInt(5, excetoReservaId);
			}

			rs = st.executeQuery();

			return rs.next() && rs.getInt("total") > 0;

		} finally {

			BancoDados.finalizarResultSet(rs);
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar(conn);
		}
	}

	public boolean possuiHospedagem(Integer codigoReserva) throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("select count(*) as total from hospedagem where codigo_reserva = ?");
			st.setInt(1, codigoReserva);
			rs = st.executeQuery();

			return rs.next() && rs.getInt("total") > 0;

		} finally {

			BancoDados.finalizarResultSet(rs);
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar(conn);
		}
	}

	private ReservaDTO mapearReserva(ResultSet rs) throws SQLException {

		ReservaDTO reservaDTO = new ReservaDTO();
		reservaDTO.setCodigo(rs.getInt("codigo"));
		reservaDTO.setDataCheckin(rs.getDate("data_checkin"));
		reservaDTO.setDataCheckout(rs.getDate("data_checkout"));
		reservaDTO.setQtdHospedes(rs.getInt("qtd_hospedes"));
		reservaDTO.setStatus(StatusReserva.valueOf(rs.getString("status")));

		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setCodigo(rs.getInt("codigo_cliente"));
		reservaDTO.setClienteDTO(clienteDTO);

		QuartoDTO quartoDTO = new QuartoDTO();
		quartoDTO.setCodigo(rs.getInt("codigo_quarto"));
		reservaDTO.setQuartoDTO(quartoDTO);

		return reservaDTO;
	}
}
