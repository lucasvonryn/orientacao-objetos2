package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.ClienteDTO;

public class ClienteDAO implements DAO<ClienteDTO, Integer> {

	private Connection conn;

	public ClienteDAO(Connection conn) {
		this.conn = conn;
	}

	@Override
	public int cadastrar(ClienteDTO clienteDTO) throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement(
					"insert into cliente (nome, cpf, telefone, email, data_nascimento) values (?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);

			st.setString(1, clienteDTO.getNome());
			st.setString(2, clienteDTO.getCpf());
			st.setString(3, clienteDTO.getTelefone());
			st.setString(4, clienteDTO.getEmail());
			st.setDate(5, clienteDTO.getDataNascimento());

			int resultado = st.executeUpdate();

			rs = st.getGeneratedKeys();
			if (rs.next()) {
				clienteDTO.setCodigo(rs.getInt(1));
			}

			return resultado;

		} finally {

			BancoDados.finalizarResultSet(rs);
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar(conn);
		}
	}

	@Override
	public List<ClienteDTO> buscarTodos() throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("select * from cliente order by nome");
			rs = st.executeQuery();

			List<ClienteDTO> lista = new ArrayList<>();

			while (rs.next()) {
				lista.add(mapearCliente(rs));
			}

			return lista;

		} finally {

			BancoDados.finalizarResultSet(rs);
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar(conn);
		}
	}

	@Override
	public ClienteDTO buscarPorChave(Integer codigo) throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("select * from cliente where codigo = ?");
			st.setInt(1, codigo);
			rs = st.executeQuery();

			if (rs.next()) {
				return mapearCliente(rs);
			}

			return null;

		} finally {

			BancoDados.finalizarResultSet(rs);
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar(conn);
		}
	}

	public ClienteDTO buscarPorCpf(String cpf) throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("select * from cliente where cpf = ?");
			st.setString(1, cpf);
			rs = st.executeQuery();

			if (rs.next()) {
				return mapearCliente(rs);
			}

			return null;

		} finally {

			BancoDados.finalizarResultSet(rs);
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar(conn);
		}
	}

	@Override
	public int atualizar(ClienteDTO clienteDTO) throws SQLException {

		PreparedStatement st = null;

		try {

			st = conn.prepareStatement(
					"update cliente set nome = ?, cpf = ?, telefone = ?, email = ?, data_nascimento = ? where codigo = ?");

			st.setString(1, clienteDTO.getNome());
			st.setString(2, clienteDTO.getCpf());
			st.setString(3, clienteDTO.getTelefone());
			st.setString(4, clienteDTO.getEmail());
			st.setDate(5, clienteDTO.getDataNascimento());
			st.setInt(6, clienteDTO.getCodigo());

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

			st = conn.prepareStatement("delete from cliente where codigo = ?");
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

			st = conn.prepareStatement(
					"select count(*) as total from reserva where codigo_cliente = ?");
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
							+ "where r.codigo_cliente = ?");
			st.setInt(1, codigo);
			rs = st.executeQuery();

			return rs.next() && rs.getInt("total") > 0;

		} finally {

			BancoDados.finalizarResultSet(rs);
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar(conn);
		}
	}

	private ClienteDTO mapearCliente(ResultSet rs) throws SQLException {

		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setCodigo(rs.getInt("codigo"));
		clienteDTO.setNome(rs.getString("nome"));
		clienteDTO.setCpf(rs.getString("cpf"));
		clienteDTO.setTelefone(rs.getString("telefone"));
		clienteDTO.setEmail(rs.getString("email"));
		clienteDTO.setDataNascimento(rs.getDate("data_nascimento"));

		return clienteDTO;
	}
}
