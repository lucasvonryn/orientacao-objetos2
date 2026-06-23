package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import dao.BancoDados;
import dao.ReservaDAO;
import dto.ClienteDTO;
import dto.QuartoDTO;
import dto.ReservaDTO;
import enums.StatusQuarto;
import enums.StatusReserva;
import enums.TipoLog;

public class ReservaService {

	private final LogService logService = new LogService();
	private final QuartoService quartoService = new QuartoService();
	private final ClienteService clienteService = new ClienteService();

	public List<ReservaDTO> buscarTodos() throws SQLException, IOException {
		List<ReservaDTO> lista = buscarTodosSemHidratacao();
		for (ReservaDTO reserva : lista) {
			hidratarReserva(reserva);
		}
		return lista;
	}

	private List<ReservaDTO> buscarTodosSemHidratacao() throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		return new ReservaDAO(conn).buscarTodos();
	}

	public ReservaDTO buscarPorChave(Integer codigo) throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		ReservaDTO reserva = new ReservaDAO(conn).buscarPorChave(codigo);
		if (reserva != null) {
			hidratarReserva(reserva);
		}
		return reserva;
	}

	public boolean possuiHospedagem(Integer codigoReserva) throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		return new ReservaDAO(conn).possuiHospedagem(codigoReserva);
	}

	public String cadastrar(ReservaDTO reservaDTO) throws SQLException, IOException {

		String validacao = validarReserva(reservaDTO);
		if (validacao != null) {
			return validacao;
		}

		QuartoDTO quarto = quartoService.buscarPorChave(reservaDTO.getQuartoDTO().getCodigo());
		if (quarto == null) {
			return "Quarto nao encontrado.";
		}

		if (quarto.getStatus() != StatusQuarto.DISPONIVEL) {
			return "Quarto nao esta disponivel para reserva.";
		}

		if (reservaDTO.getQtdHospedes() > quarto.getCapacidadeMaxima()) {
			return "Quantidade de hospedes excede a capacidade do quarto.";
		}

		Connection conn = BancoDados.conectar();
		if (new ReservaDAO(conn).existeConflitoDatas(quarto.getCodigo(), reservaDTO.getDataCheckin(),
				reservaDTO.getDataCheckout(), null)) {
			return "Quarto indisponivel no periodo informado.";
		}

		reservaDTO.setStatus(StatusReserva.ATIVA);
		conn = BancoDados.conectar();
		int resultado = new ReservaDAO(conn).cadastrar(reservaDTO);

		if (resultado > 0) {
			quartoService.atualizarStatus(quarto.getCodigo(), StatusQuarto.RESERVADO);
			logService.registrar(TipoLog.RESERVA, "SUCESSO",
					"Reserva " + reservaDTO.getCodigo() + " criada para quarto " + quarto.getNumero());
			return null;
		}

		return "Nao foi possivel registrar a reserva.";
	}

	public String cancelar(Integer codigo) throws SQLException, IOException {

		ReservaDTO reserva = buscarPorChave(codigo);
		if (reserva == null) {
			return "Reserva nao encontrada.";
		}

		if (reserva.getStatus() != StatusReserva.ATIVA) {
			return "Somente reservas ativas podem ser canceladas.";
		}

		if (possuiHospedagem(codigo)) {
			return "Reserva com check-in realizado nao pode ser cancelada.";
		}

		Connection conn = BancoDados.conectar();
		new ReservaDAO(conn).atualizarStatus(codigo, StatusReserva.CANCELADA);
		quartoService.atualizarStatus(reserva.getQuartoDTO().getCodigo(), StatusQuarto.DISPONIVEL);

		logService.registrar(TipoLog.CANCELAMENTO, "SUCESSO", "Reserva " + codigo + " cancelada");

		return null;
	}

	public int processarReservasExpiradas() throws SQLException, IOException {

		Date hoje = Date.valueOf(java.time.LocalDate.now());

		Connection conn = BancoDados.conectar();
		List<ReservaDTO> expiradas = new ReservaDAO(conn).buscarExpiradas(hoje);
		int total = 0;

		for (ReservaDTO reserva : expiradas) {
			if (!possuiHospedagem(reserva.getCodigo())) {
				conn = BancoDados.conectar();
				new ReservaDAO(conn).atualizarStatus(reserva.getCodigo(), StatusReserva.EXPIRADA);
				quartoService.atualizarStatus(reserva.getQuartoDTO().getCodigo(), StatusQuarto.DISPONIVEL);
				logService.registrar(TipoLog.CANCELAMENTO, "SUCESSO",
						"Reserva " + reserva.getCodigo() + " expirada automaticamente");
				total++;
			}
		}

		return total;
	}

	private void hidratarReserva(ReservaDTO reserva) throws SQLException, IOException {

		ClienteDTO cliente = clienteService.buscarPorChave(reserva.getClienteDTO().getCodigo());
		QuartoDTO quarto = quartoService.buscarPorChave(reserva.getQuartoDTO().getCodigo());

		if (cliente != null) {
			reserva.setClienteDTO(cliente);
		}
		if (quarto != null) {
			reserva.setQuartoDTO(quarto);
		}
	}

	private String validarReserva(ReservaDTO reservaDTO) {

		if (reservaDTO.getClienteDTO() == null || reservaDTO.getClienteDTO().getCodigo() == null) {
			return "Cliente e obrigatorio.";
		}
		if (reservaDTO.getQuartoDTO() == null || reservaDTO.getQuartoDTO().getCodigo() == null) {
			return "Quarto e obrigatorio.";
		}
		if (reservaDTO.getDataCheckin() == null || reservaDTO.getDataCheckout() == null) {
			return "Datas de check-in e check-out sao obrigatorias.";
		}
		if (!reservaDTO.getDataCheckout().after(reservaDTO.getDataCheckin())) {
			return "Data de check-out deve ser posterior ao check-in.";
		}
		if (reservaDTO.getQtdHospedes() == null || reservaDTO.getQtdHospedes() <= 0) {
			return "Quantidade de hospedes e obrigatoria.";
		}

		return null;
	}
}
