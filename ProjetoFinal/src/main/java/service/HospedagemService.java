package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import dao.BancoDados;
import dao.HospedagemDAO;
import dto.HospedagemDTO;
import dto.QuartoDTO;
import dto.ReservaDTO;
import enums.StatusHospedagem;
import enums.StatusQuarto;
import enums.StatusReserva;
import enums.TipoLog;

public class HospedagemService {

	private final LogService logService = new LogService();
	private final ReservaService reservaService = new ReservaService();
	private final QuartoService quartoService = new QuartoService();

	public List<HospedagemDTO> buscarTodos() throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		List<HospedagemDTO> lista = new HospedagemDAO(conn).buscarTodos();
		for (HospedagemDTO hospedagem : lista) {
			hidratarHospedagem(hospedagem);
		}
		return lista;
	}

	public List<HospedagemDTO> buscarEmAndamento() throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		List<HospedagemDTO> lista = new HospedagemDAO(conn).buscarEmAndamento();
		for (HospedagemDTO hospedagem : lista) {
			hidratarHospedagem(hospedagem);
		}
		return lista;
	}

	public HospedagemDTO buscarPorChave(Integer codigo) throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		HospedagemDTO hospedagem = new HospedagemDAO(conn).buscarPorChave(codigo);
		if (hospedagem != null) {
			hidratarHospedagem(hospedagem);
		}
		return hospedagem;
	}

	public HospedagemDTO buscarPorReserva(Integer codigoReserva) throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		HospedagemDTO hospedagem = new HospedagemDAO(conn).buscarPorReserva(codigoReserva);
		if (hospedagem != null) {
			hidratarHospedagem(hospedagem);
		}
		return hospedagem;
	}

	public String realizarCheckin(Integer codigoReserva) throws SQLException, IOException {

		ReservaDTO reserva = reservaService.buscarPorChave(codigoReserva);
		if (reserva == null) {
			return "Reserva nao encontrada.";
		}

		if (reserva.getStatus() != StatusReserva.ATIVA) {
			return "Somente reservas ativas podem gerar check-in.";
		}

		if (buscarPorReserva(codigoReserva) != null) {
			return "Check-in ja realizado para esta reserva.";
		}

		HospedagemDTO hospedagemDTO = new HospedagemDTO();
		hospedagemDTO.setReservaDTO(reserva);
		hospedagemDTO.setDataHoraCheckin(new Timestamp(System.currentTimeMillis()));
		hospedagemDTO.setQtdDiarias(0);
		hospedagemDTO.setValorTotal(0.0);
		hospedagemDTO.setStatus(StatusHospedagem.EM_ANDAMENTO);

		Connection conn = BancoDados.conectar();
		int resultado = new HospedagemDAO(conn).cadastrar(hospedagemDTO);
		if (resultado > 0) {
			quartoService.atualizarStatus(reserva.getQuartoDTO().getCodigo(), StatusQuarto.OCUPADO);
			logService.registrar(TipoLog.CHECKIN, "SUCESSO",
					"Check-in da reserva " + codigoReserva + " em " + hospedagemDTO.getDataHoraCheckin());
			return null;
		}

		return "Nao foi possivel realizar o check-in.";
	}

	public String realizarCheckout(Integer codigoHospedagem) throws SQLException, IOException {

		Connection conn = BancoDados.conectar();
		HospedagemDTO hospedagem = new HospedagemDAO(conn).buscarPorChave(codigoHospedagem);
		if (hospedagem == null) {
			return "Hospedagem nao encontrada.";
		}

		if (hospedagem.getStatus() != StatusHospedagem.EM_ANDAMENTO) {
			return "Hospedagem ja finalizada.";
		}

		ReservaDTO reserva = reservaService.buscarPorChave(hospedagem.getReservaDTO().getCodigo());
		QuartoDTO quarto = quartoService.buscarPorChave(reserva.getQuartoDTO().getCodigo());

		Timestamp checkout = new Timestamp(System.currentTimeMillis());
		hospedagem.setDataHoraCheckout(checkout);
		hospedagem.setStatus(StatusHospedagem.FINALIZADA);

		LocalDate inicio = hospedagem.getDataHoraCheckin().toLocalDateTime().toLocalDate();
		LocalDate fim = checkout.toLocalDateTime().toLocalDate();
		long diarias = ChronoUnit.DAYS.between(inicio, fim);
		if (diarias < 1) {
			diarias = 1;
		}

		hospedagem.setQtdDiarias((int) diarias);
		hospedagem.setValorTotal(diarias * quarto.getValorDiaria());
		hospedagem.setReservaDTO(reserva);

		conn = BancoDados.conectar();
		int resultado = new HospedagemDAO(conn).atualizar(hospedagem);
		if (resultado > 0) {
			quartoService.atualizarStatus(quarto.getCodigo(), StatusQuarto.DISPONIVEL);
			logService.registrar(TipoLog.CHECKOUT, "SUCESSO",
					"Check-out da hospedagem " + codigoHospedagem + " - " + diarias + " diarias - R$ "
							+ hospedagem.getValorTotal());
			return null;
		}

		return "Nao foi possivel realizar o check-out.";
	}

	public List<HospedagemDTO> buscarParaRelatorio() throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		List<HospedagemDTO> lista = new HospedagemDAO(conn).buscarParaRelatorio();
		for (HospedagemDTO hospedagem : lista) {
			hidratarHospedagem(hospedagem);
		}
		return lista;
	}

	private void hidratarHospedagem(HospedagemDTO hospedagem) throws SQLException, IOException {
		ReservaDTO reserva = reservaService.buscarPorChave(hospedagem.getReservaDTO().getCodigo());
		if (reserva != null) {
			hospedagem.setReservaDTO(reserva);
		}
	}
}
