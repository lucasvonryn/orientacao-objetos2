package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.BancoDados;
import dao.ClienteDAO;
import dto.ClienteDTO;

public class ClienteService {

	public List<ClienteDTO> buscarTodos() throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		return new ClienteDAO(conn).buscarTodos();
	}

	public ClienteDTO buscarPorChave(Integer codigo) throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		return new ClienteDAO(conn).buscarPorChave(codigo);
	}

	public ClienteDTO buscarPorCpf(String cpf) throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		return new ClienteDAO(conn).buscarPorCpf(cpf);
	}

	public String cadastrar(ClienteDTO clienteDTO) throws SQLException, IOException {

		String validacao = validarCamposObrigatorios(clienteDTO);
		if (validacao != null) {
			return validacao;
		}

		ClienteDTO existente = buscarPorCpf(clienteDTO.getCpf());
		if (existente != null) {
			return "CPF ja cadastrado no sistema.";
		}

		Connection conn = BancoDados.conectar();
		int resultado = new ClienteDAO(conn).cadastrar(clienteDTO);
		if (resultado > 0) {
			return null;
		}

		return "Nao foi possivel cadastrar o cliente.";
	}

	public String atualizar(ClienteDTO clienteDTO) throws SQLException, IOException {

		String validacao = validarCamposObrigatorios(clienteDTO);
		if (validacao != null) {
			return validacao;
		}

		if (clienteDTO.getCodigo() == null) {
			return "Informe o codigo do cliente para atualizacao.";
		}

		ClienteDTO atual = buscarPorChave(clienteDTO.getCodigo());
		if (atual == null) {
			return "Cliente nao encontrado.";
		}

		ClienteDTO porCpf = buscarPorCpf(clienteDTO.getCpf());
		if (porCpf != null && !porCpf.getCodigo().equals(clienteDTO.getCodigo())) {
			return "CPF ja cadastrado para outro cliente.";
		}

		Connection conn = BancoDados.conectar();
		int resultado = new ClienteDAO(conn).atualizar(clienteDTO);
		if (resultado > 0) {
			return null;
		}

		return "Nao foi possivel atualizar o cliente.";
	}

	public String excluir(Integer codigo) throws SQLException, IOException {

		ClienteDTO cliente = buscarPorChave(codigo);
		if (cliente == null) {
			return "Cliente nao encontrado.";
		}

		Connection conn = BancoDados.conectar();
		if (new ClienteDAO(conn).possuiVinculos(codigo)) {
			return "Cliente vinculado a reservas ou hospedagens. Exclusao nao permitida.";
		}

		conn = BancoDados.conectar();
		int resultado = new ClienteDAO(conn).excluir(codigo);
		if (resultado > 0) {
			return null;
		}

		return "Nao foi possivel excluir o cliente.";
	}

	private String validarCamposObrigatorios(ClienteDTO clienteDTO) {

		if (clienteDTO.getNome() == null || clienteDTO.getNome().trim().isEmpty()) {
			return "Nome completo e obrigatorio.";
		}
		if (clienteDTO.getCpf() == null || clienteDTO.getCpf().trim().isEmpty()) {
			return "CPF e obrigatorio.";
		}
		if (clienteDTO.getTelefone() == null || clienteDTO.getTelefone().trim().isEmpty()) {
			return "Telefone e obrigatorio.";
		}
		if (clienteDTO.getEmail() == null || clienteDTO.getEmail().trim().isEmpty()) {
			return "E-mail e obrigatorio.";
		}
		if (clienteDTO.getDataNascimento() == null) {
			return "Data de nascimento e obrigatoria.";
		}

		return null;
	}
}
