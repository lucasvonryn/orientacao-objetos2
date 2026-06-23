package service;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dto.HospedagemDTO;
import dto.PagamentoDTO;
import enums.StatusHospedagem;
import util.ExportadorXls;

public class RelatorioService {

	private final HospedagemService hospedagemService = new HospedagemService();
	private final PagamentoService pagamentoService = new PagamentoService();
	private final ExportadorXls exportadorXls = new ExportadorXls();

	public List<HospedagemDTO> buscarHospedagens() throws SQLException, IOException {
		return hospedagemService.buscarParaRelatorio();
	}

	public List<PagamentoDTO> buscarPagamentos() throws SQLException, IOException {
		return pagamentoService.buscarTodos();
	}

	public double buscarTotalArrecadado() throws SQLException, IOException {
		return pagamentoService.buscarTotalArrecadado();
	}

	public int contarQuartosOcupados(List<HospedagemDTO> hospedagens) {

		int total = 0;
		for (HospedagemDTO hospedagem : hospedagens) {
			if (hospedagem.getStatus() == StatusHospedagem.EM_ANDAMENTO) {
				total++;
			}
		}
		return total;
	}

	public Map<Integer, Double> agruparFaturamentoPorQuarto(List<HospedagemDTO> hospedagens) {

		Map<Integer, Double> faturamento = new HashMap<>();

		for (HospedagemDTO hospedagem : hospedagens) {
			Integer numeroQuarto = hospedagem.getReservaDTO().getQuartoDTO().getNumero();
			Double atual = faturamento.getOrDefault(numeroQuarto, 0.0);
			faturamento.put(numeroQuarto, atual + hospedagem.getValorTotal());
		}

		return faturamento;
	}

	public void exportarRelatorio(File arquivo) throws SQLException, IOException {

		List<HospedagemDTO> hospedagens = buscarHospedagens();
		List<PagamentoDTO> pagamentos = buscarPagamentos();
		double total = buscarTotalArrecadado();

		exportadorXls.exportarRelatorioHospedagens(arquivo, hospedagens, pagamentos, total);
	}
}
