package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.BancoDados;
import dao.PagamentoDAO;
import dto.HospedagemDTO;
import dto.PagamentoDTO;
import enums.FormaPagamento;

public class PagamentoService {

	public List<PagamentoDTO> buscarTodos() throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		return new PagamentoDAO(conn).buscarTodos();
	}

	public List<PagamentoDTO> buscarPorHospedagem(Integer codigoHospedagem) throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		return new PagamentoDAO(conn).buscarPorHospedagem(codigoHospedagem);
	}

	public String cadastrar(PagamentoDTO pagamentoDTO) throws SQLException, IOException {

		if (pagamentoDTO.getHospedagemDTO() == null || pagamentoDTO.getHospedagemDTO().getCodigo() == null) {
			return "Hospedagem e obrigatoria.";
		}
		if (pagamentoDTO.getValor() == null || pagamentoDTO.getValor() <= 0) {
			return "Valor do pagamento e obrigatorio.";
		}
		if (pagamentoDTO.getData() == null) {
			return "Data do pagamento e obrigatoria.";
		}
		if (pagamentoDTO.getFormaPagamento() == null) {
			return "Forma de pagamento e obrigatoria.";
		}

		HospedagemDTO hospedagem = new HospedagemService().buscarPorChave(pagamentoDTO.getHospedagemDTO().getCodigo());
		if (hospedagem == null) {
			return "Hospedagem nao encontrada.";
		}

		Connection conn = BancoDados.conectar();
		int resultado = new PagamentoDAO(conn).cadastrar(pagamentoDTO);

		if (resultado > 0) {
			return null;
		}

		return "Nao foi possivel registrar o pagamento.";
	}

	public double buscarTotalArrecadado() throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		return new PagamentoDAO(conn).buscarTotalArrecadado();
	}

	public FormaPagamento[] listarFormasPagamento() {
		return FormaPagamento.values();
	}
}
