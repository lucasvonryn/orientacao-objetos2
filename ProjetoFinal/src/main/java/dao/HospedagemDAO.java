package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.ClienteDTO;
import dto.HospedagemDTO;
import dto.QuartoDTO;
import dto.ReservaDTO;
import enums.StatusHospedagem;
import enums.StatusReserva;

public class HospedagemDAO implements DAO<HospedagemDTO, Integer> {

	private Connection conn;

	public HospedagemDAO(Connection conn) {
		this.conn = conn;
	}

	@Override
	public int cadastrar(HospedagemDTO hospedagemDTO) throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement(
					"insert into hospedagem (codigo_reserva, data_hora_checkin, data_hora_checkout, qtd_diarias, valor_total, status) "
							+ "values (?, ?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);

			st.setInt(1, hospedagemDTO.getReservaDTO().getCodigo());
			st.setTimestamp(2, hospedagemDTO.getDataHoraCheckin());
			st.setTimestamp(3, hospedagemDTO.getDataHoraCheckout());
			st.setInt(4, hospedagemDTO.getQtdDiarias());
			st.setDouble(5, hospedagemDTO.getValorTotal());
			st.setString(6, hospedagemDTO.getStatus().name());

			int resultado = st.executeUpdate();

			rs = st.getGeneratedKeys();
			if (rs.next()) {
				hospedagemDTO.setCodigo(rs.getInt(1));
			}

			return resultado;

		} finally {

			BancoDados.finalizarResultSet(rs);
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar(conn);
		}
	}

	@Override
	public List<HospedagemDTO> buscarTodos() throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("select * from hospedagem order by data_hora_checkin desc");
			rs = st.executeQuery();

			List<HospedagemDTO> lista = new ArrayList<>();

			while (rs.next()) {
				lista.add(mapearHospedagem(rs));
			}

			return lista;

		} finally {

			BancoDados.finalizarResultSet(rs);
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar(conn);
		}
	}

	@Override
	public HospedagemDTO buscarPorChave(Integer codigo) throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("select * from hospedagem where codigo = ?");
			st.setInt(1, codigo);
			rs = st.executeQuery();

			if (rs.next()) {
				return mapearHospedagem(rs);
			}

			return null;

		} finally {

			BancoDados.finalizarResultSet(rs);
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar(conn);
		}
	}

	public HospedagemDTO buscarPorReserva(Integer codigoReserva) throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("select * from hospedagem where codigo_reserva = ?");
			st.setInt(1, codigoReserva);
			rs = st.executeQuery();

			if (rs.next()) {
				return mapearHospedagem(rs);
			}

			return null;

		} finally {

			BancoDados.finalizarResultSet(rs);
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar(conn);
		}
	}

	public List<HospedagemDTO> buscarEmAndamento() throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("select * from hospedagem where status = ? order by data_hora_checkin");
			st.setString(1, StatusHospedagem.EM_ANDAMENTO.name());
			rs = st.executeQuery();

			List<HospedagemDTO> lista = new ArrayList<>();

			while (rs.next()) {
				lista.add(mapearHospedagem(rs));
			}

			return lista;

		} finally {

			BancoDados.finalizarResultSet(rs);
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar(conn);
		}
	}

	@Override
	public int atualizar(HospedagemDTO hospedagemDTO) throws SQLException {

		PreparedStatement st = null;

		try {

			st = conn.prepareStatement(
					"update hospedagem set codigo_reserva = ?, data_hora_checkin = ?, data_hora_checkout = ?, "
							+ "qtd_diarias = ?, valor_total = ?, status = ? where codigo = ?");

			st.setInt(1, hospedagemDTO.getReservaDTO().getCodigo());
			st.setTimestamp(2, hospedagemDTO.getDataHoraCheckin());
			st.setTimestamp(3, hospedagemDTO.getDataHoraCheckout());
			st.setInt(4, hospedagemDTO.getQtdDiarias());
			st.setDouble(5, hospedagemDTO.getValorTotal());
			st.setString(6, hospedagemDTO.getStatus().name());
			st.setInt(7, hospedagemDTO.getCodigo());

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

			st = conn.prepareStatement("delete from hospedagem where codigo = ?");
			st.setInt(1, codigo);

			return st.executeUpdate();

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.desconectar(conn);
		}
	}

	public List<HospedagemDTO> buscarParaRelatorio() throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement(
					"select h.*, r.codigo_cliente, r.codigo_quarto, r.data_checkin, r.data_checkout, r.status as status_reserva "
							+ "from hospedagem h "
							+ "inner join reserva r on h.codigo_reserva = r.codigo "
							+ "order by h.data_hora_checkin desc");
			rs = st.executeQuery();

			List<HospedagemDTO> lista = new ArrayList<>();

			while (rs.next()) {
				HospedagemDTO hospedagemDTO = mapearHospedagem(rs);

				ReservaDTO reservaDTO = hospedagemDTO.getReservaDTO();
				reservaDTO.setDataCheckin(rs.getDate("data_checkin"));
				reservaDTO.setDataCheckout(rs.getDate("data_checkout"));
				reservaDTO.setStatus(StatusReserva.valueOf(rs.getString("status_reserva")));

				ClienteDTO clienteDTO = new ClienteDTO();
				clienteDTO.setCodigo(rs.getInt("codigo_cliente"));
				reservaDTO.setClienteDTO(clienteDTO);

				QuartoDTO quartoDTO = new QuartoDTO();
				quartoDTO.setCodigo(rs.getInt("codigo_quarto"));
				reservaDTO.setQuartoDTO(quartoDTO);

				lista.add(hospedagemDTO);
			}

			return lista;

		} finally {

			BancoDados.finalizarResultSet(rs);
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar(conn);
		}
	}

	private HospedagemDTO mapearHospedagem(ResultSet rs) throws SQLException {

		HospedagemDTO hospedagemDTO = new HospedagemDTO();
		hospedagemDTO.setCodigo(rs.getInt("codigo"));
		hospedagemDTO.setDataHoraCheckin(rs.getTimestamp("data_hora_checkin"));
		hospedagemDTO.setDataHoraCheckout(rs.getTimestamp("data_hora_checkout"));
		hospedagemDTO.setQtdDiarias(rs.getInt("qtd_diarias"));
		hospedagemDTO.setValorTotal(rs.getDouble("valor_total"));
		hospedagemDTO.setStatus(StatusHospedagem.valueOf(rs.getString("status")));

		ReservaDTO reservaDTO = new ReservaDTO();
		reservaDTO.setCodigo(rs.getInt("codigo_reserva"));
		hospedagemDTO.setReservaDTO(reservaDTO);

		return hospedagemDTO;
	}
}
