package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.HospedagemDTO;
import dto.PagamentoDTO;
import enums.FormaPagamento;

public class PagamentoDAO implements DAO<PagamentoDTO, Integer> {

	private Connection conn;

	public PagamentoDAO(Connection conn) {
		this.conn = conn;
	}

	@Override
	public int cadastrar(PagamentoDTO pagamentoDTO) throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement(
					"insert into pagamento (codigo_hospedagem, valor, data, forma_pagamento) values (?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);

			st.setInt(1, pagamentoDTO.getHospedagemDTO().getCodigo());
			st.setDouble(2, pagamentoDTO.getValor());
			st.setDate(3, pagamentoDTO.getData());
			st.setString(4, pagamentoDTO.getFormaPagamento().name());

			int resultado = st.executeUpdate();

			rs = st.getGeneratedKeys();
			if (rs.next()) {
				pagamentoDTO.setCodigo(rs.getInt(1));
			}

			return resultado;

		} finally {

			BancoDados.finalizarResultSet(rs);
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar(conn);
		}
	}

	@Override
	public List<PagamentoDTO> buscarTodos() throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("select * from pagamento order by data desc");
			rs = st.executeQuery();

			List<PagamentoDTO> lista = new ArrayList<>();

			while (rs.next()) {
				lista.add(mapearPagamento(rs));
			}

			return lista;

		} finally {

			BancoDados.finalizarResultSet(rs);
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar(conn);
		}
	}

	@Override
	public PagamentoDTO buscarPorChave(Integer codigo) throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("select * from pagamento where codigo = ?");
			st.setInt(1, codigo);
			rs = st.executeQuery();

			if (rs.next()) {
				return mapearPagamento(rs);
			}

			return null;

		} finally {

			BancoDados.finalizarResultSet(rs);
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar(conn);
		}
	}

	public List<PagamentoDTO> buscarPorHospedagem(Integer codigoHospedagem) throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("select * from pagamento where codigo_hospedagem = ? order by data");
			st.setInt(1, codigoHospedagem);
			rs = st.executeQuery();

			List<PagamentoDTO> lista = new ArrayList<>();

			while (rs.next()) {
				lista.add(mapearPagamento(rs));
			}

			return lista;

		} finally {

			BancoDados.finalizarResultSet(rs);
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar(conn);
		}
	}

	@Override
	public int atualizar(PagamentoDTO pagamentoDTO) throws SQLException {

		PreparedStatement st = null;

		try {

			st = conn.prepareStatement(
					"update pagamento set codigo_hospedagem = ?, valor = ?, data = ?, forma_pagamento = ? where codigo = ?");

			st.setInt(1, pagamentoDTO.getHospedagemDTO().getCodigo());
			st.setDouble(2, pagamentoDTO.getValor());
			st.setDate(3, pagamentoDTO.getData());
			st.setString(4, pagamentoDTO.getFormaPagamento().name());
			st.setInt(5, pagamentoDTO.getCodigo());

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

			st = conn.prepareStatement("delete from pagamento where codigo = ?");
			st.setInt(1, codigo);

			return st.executeUpdate();

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.desconectar(conn);
		}
	}

	public double buscarTotalArrecadado() throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("select coalesce(sum(valor), 0) as total from pagamento");
			rs = st.executeQuery();

			if (rs.next()) {
				return rs.getDouble("total");
			}

			return 0;

		} finally {

			BancoDados.finalizarResultSet(rs);
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar(conn);
		}
	}

	private PagamentoDTO mapearPagamento(ResultSet rs) throws SQLException {

		PagamentoDTO pagamentoDTO = new PagamentoDTO();
		pagamentoDTO.setCodigo(rs.getInt("codigo"));
		pagamentoDTO.setValor(rs.getDouble("valor"));
		pagamentoDTO.setData(rs.getDate("data"));
		pagamentoDTO.setFormaPagamento(FormaPagamento.valueOf(rs.getString("forma_pagamento")));

		HospedagemDTO hospedagemDTO = new HospedagemDTO();
		hospedagemDTO.setCodigo(rs.getInt("codigo_hospedagem"));
		pagamentoDTO.setHospedagemDTO(hospedagemDTO);

		return pagamentoDTO;
	}
}
