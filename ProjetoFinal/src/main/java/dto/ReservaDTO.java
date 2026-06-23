package dto;

import java.sql.Date;

import enums.StatusReserva;

public class ReservaDTO {

	private Integer codigo;
	private ClienteDTO clienteDTO;
	private QuartoDTO quartoDTO;
	private Date dataCheckin;
	private Date dataCheckout;
	private Integer qtdHospedes;
	private StatusReserva status;

	public ReservaDTO() {
		this.clienteDTO = new ClienteDTO();
		this.quartoDTO = new QuartoDTO();
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public ClienteDTO getClienteDTO() {
		return clienteDTO;
	}

	public void setClienteDTO(ClienteDTO clienteDTO) {
		this.clienteDTO = clienteDTO;
	}

	public QuartoDTO getQuartoDTO() {
		return quartoDTO;
	}

	public void setQuartoDTO(QuartoDTO quartoDTO) {
		this.quartoDTO = quartoDTO;
	}

	public Date getDataCheckin() {
		return dataCheckin;
	}

	public void setDataCheckin(Date dataCheckin) {
		this.dataCheckin = dataCheckin;
	}

	public Date getDataCheckout() {
		return dataCheckout;
	}

	public void setDataCheckout(Date dataCheckout) {
		this.dataCheckout = dataCheckout;
	}

	public Integer getQtdHospedes() {
		return qtdHospedes;
	}

	public void setQtdHospedes(Integer qtdHospedes) {
		this.qtdHospedes = qtdHospedes;
	}

	public StatusReserva getStatus() {
		return status;
	}

	public void setStatus(StatusReserva status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Reserva " + codigo + " - " + (clienteDTO != null ? clienteDTO.getNome() : "")
				+ " - Quarto " + (quartoDTO != null ? quartoDTO.getNumero() : "");
	}
}
