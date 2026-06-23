package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BancoDados;
import dao.QuartoDAO;
import dto.QuartoDTO;
import enums.StatusQuarto;
import enums.TipoQuarto;

public class QuartoService {

	public List<QuartoDTO> buscarTodos() throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		return new QuartoDAO(conn).buscarTodos();
	}

	public QuartoDTO buscarPorChave(Integer codigo) throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		return new QuartoDAO(conn).buscarPorChave(codigo);
	}

	public QuartoDTO buscarPorNumero(Integer numero) throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		return new QuartoDAO(conn).buscarPorNumero(numero);
	}

	public List<QuartoDTO> buscarPorTipo(TipoQuarto tipo) throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		return new QuartoDAO(conn).buscarPorTipo(tipo);
	}

	public List<QuartoDTO> buscarPorStatus(StatusQuarto status) throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		return new QuartoDAO(conn).buscarPorStatus(status);
	}

	public List<QuartoDTO> buscar(String numeroTexto, TipoQuarto tipo, StatusQuarto status)
			throws SQLException, IOException {

		if (numeroTexto != null && !numeroTexto.trim().isEmpty()) {
			QuartoDTO quarto = buscarPorNumero(Integer.parseInt(numeroTexto.trim()));
			List<QuartoDTO> lista = new ArrayList<>();
			if (quarto != null) {
				lista.add(quarto);
			}
			return lista;
		}

		if (tipo != null) {
			return buscarPorTipo(tipo);
		}

		if (status != null) {
			return buscarPorStatus(status);
		}

		return buscarTodos();
	}

	public String cadastrar(QuartoDTO quartoDTO) throws SQLException, IOException {

		String validacao = validarCamposObrigatorios(quartoDTO);
		if (validacao != null) {
			return validacao;
		}

		QuartoDTO existente = buscarPorNumero(quartoDTO.getNumero());
		if (existente != null) {
			return "Numero de quarto ja cadastrado.";
		}

		if (quartoDTO.getStatus() == null) {
			quartoDTO.setStatus(StatusQuarto.DISPONIVEL);
		}

		Connection conn = BancoDados.conectar();
		int resultado = new QuartoDAO(conn).cadastrar(quartoDTO);
		if (resultado > 0) {
			return null;
		}

		return "Nao foi possivel cadastrar o quarto.";
	}

	public String atualizar(QuartoDTO quartoDTO) throws SQLException, IOException {

		String validacao = validarCamposObrigatorios(quartoDTO);
		if (validacao != null) {
			return validacao;
		}

		if (quartoDTO.getCodigo() == null) {
			return "Informe o codigo do quarto para atualizacao.";
		}

		QuartoDTO atual = buscarPorChave(quartoDTO.getCodigo());
		if (atual == null) {
			return "Quarto nao encontrado.";
		}

		QuartoDTO porNumero = buscarPorNumero(quartoDTO.getNumero());
		if (porNumero != null && !porNumero.getCodigo().equals(quartoDTO.getCodigo())) {
			return "Numero de quarto ja cadastrado para outro registro.";
		}

		Connection conn = BancoDados.conectar();
		int resultado = new QuartoDAO(conn).atualizar(quartoDTO);
		if (resultado > 0) {
			return null;
		}

		return "Nao foi possivel atualizar o quarto.";
	}

	public String excluir(Integer codigo) throws SQLException, IOException {

		QuartoDTO quarto = buscarPorChave(codigo);
		if (quarto == null) {
			return "Quarto nao encontrado.";
		}

		Connection conn = BancoDados.conectar();
		if (new QuartoDAO(conn).possuiVinculos(codigo)) {
			return "Quarto vinculado a reservas ou hospedagens. Exclusao nao permitida.";
		}

		conn = BancoDados.conectar();
		int resultado = new QuartoDAO(conn).excluir(codigo);
		if (resultado > 0) {
			return null;
		}

		return "Nao foi possivel excluir o quarto.";
	}

	public void atualizarStatus(Integer codigo, StatusQuarto status) throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		new QuartoDAO(conn).atualizarStatus(codigo, status);
	}

	private String validarCamposObrigatorios(QuartoDTO quartoDTO) {

		if (quartoDTO.getNumero() == null) {
			return "Numero do quarto e obrigatorio.";
		}
		if (quartoDTO.getTipo() == null) {
			return "Tipo do quarto e obrigatorio.";
		}
		if (quartoDTO.getCapacidadeMaxima() == null || quartoDTO.getCapacidadeMaxima() <= 0) {
			return "Capacidade maxima e obrigatoria.";
		}
		if (quartoDTO.getValorDiaria() == null || quartoDTO.getValorDiaria() <= 0) {
			return "Valor da diaria e obrigatorio.";
		}
		if (quartoDTO.getStatus() == null) {
			return "Status do quarto e obrigatorio.";
		}

		return null;
	}
}
