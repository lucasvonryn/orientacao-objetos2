package util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import dto.HospedagemDTO;
import dto.PagamentoDTO;

public class ExportadorXls {

	public void exportarRelatorioHospedagens(File arquivo, List<HospedagemDTO> hospedagens,
			List<PagamentoDTO> pagamentos, double totalArrecadado) throws IOException {

		try (HSSFWorkbook workbook = new HSSFWorkbook()) {

			HSSFSheet sheetHospedagens = workbook.createSheet("Hospedagens");
			criarCabecalhoHospedagens(sheetHospedagens);

			int linha = 1;
			for (HospedagemDTO hospedagem : hospedagens) {
				HSSFRow row = sheetHospedagens.createRow(linha++);
				row.createCell(0).setCellValue(hospedagem.getCodigo());
				row.createCell(1).setCellValue(hospedagem.getReservaDTO().getClienteDTO().getNome());
				row.createCell(2).setCellValue(hospedagem.getReservaDTO().getQuartoDTO().getNumero());
				row.createCell(3).setCellValue(hospedagem.getDataHoraCheckin() != null
						? hospedagem.getDataHoraCheckin().toString()
						: "");
				row.createCell(4).setCellValue(hospedagem.getDataHoraCheckout() != null
						? hospedagem.getDataHoraCheckout().toString()
						: "");
				row.createCell(5).setCellValue(hospedagem.getQtdDiarias());
				row.createCell(6).setCellValue(hospedagem.getValorTotal());
				row.createCell(7).setCellValue(hospedagem.getStatus().name());
			}

			HSSFSheet sheetPagamentos = workbook.createSheet("Pagamentos");
			criarCabecalhoPagamentos(sheetPagamentos);

			linha = 1;
			for (PagamentoDTO pagamento : pagamentos) {
				HSSFRow row = sheetPagamentos.createRow(linha++);
				row.createCell(0).setCellValue(pagamento.getCodigo());
				row.createCell(1).setCellValue(pagamento.getHospedagemDTO().getCodigo());
				row.createCell(2).setCellValue(pagamento.getValor());
				row.createCell(3).setCellValue(pagamento.getData() != null ? pagamento.getData().toString() : "");
				row.createCell(4).setCellValue(pagamento.getFormaPagamento().name());
			}

			HSSFSheet sheetResumo = workbook.createSheet("Resumo");
			HSSFRow resumoRow = sheetResumo.createRow(0);
			resumoRow.createCell(0).setCellValue("Total arrecadado");
			resumoRow.createCell(1).setCellValue(totalArrecadado);
			resumoRow = sheetResumo.createRow(1);
			resumoRow.createCell(0).setCellValue("Quartos em hospedagem");
			resumoRow.createCell(1).setCellValue(contarHospedagensEmAndamento(hospedagens));

			for (int i = 0; i < 8; i++) {
				sheetHospedagens.autoSizeColumn(i);
			}
			for (int i = 0; i < 5; i++) {
				sheetPagamentos.autoSizeColumn(i);
			}

			try (FileOutputStream outputStream = new FileOutputStream(arquivo)) {
				workbook.write(outputStream);
			}
		}
	}

	private void criarCabecalhoHospedagens(HSSFSheet sheet) {

		HSSFRow header = sheet.createRow(0);
		header.createCell(0).setCellValue("Codigo");
		header.createCell(1).setCellValue("Hospede");
		header.createCell(2).setCellValue("Quarto");
		header.createCell(3).setCellValue("Check-in");
		header.createCell(4).setCellValue("Check-out");
		header.createCell(5).setCellValue("Diarias");
		header.createCell(6).setCellValue("Valor Total");
		header.createCell(7).setCellValue("Status");
	}

	private void criarCabecalhoPagamentos(HSSFSheet sheet) {

		HSSFRow header = sheet.createRow(0);
		header.createCell(0).setCellValue("Codigo");
		header.createCell(1).setCellValue("Hospedagem");
		header.createCell(2).setCellValue("Valor");
		header.createCell(3).setCellValue("Data");
		header.createCell(4).setCellValue("Forma Pagamento");
	}

	private int contarHospedagensEmAndamento(List<HospedagemDTO> hospedagens) {

		int total = 0;
		for (HospedagemDTO hospedagem : hospedagens) {
			if (hospedagem.getStatus() == enums.StatusHospedagem.EM_ANDAMENTO) {
				total++;
			}
		}
		return total;
	}
}
