package dto;

import java.sql.Timestamp;

import enums.StatusHospedagem;

public class HospedagemDTO {

	private Integer codigo;
	private ReservaDTO reservaDTO;
	private Timestamp dataHoraCheckin;
	private Timestamp dataHoraCheckout;
	private Integer qtdDiarias;
	private Double valorTotal;
	private StatusHospedagem status;

	public HospedagemDTO() {
		this.reservaDTO = new ReservaDTO();
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public ReservaDTO getReservaDTO() {
		return reservaDTO;
	}

	public void setReservaDTO(ReservaDTO reservaDTO) {
		this.reservaDTO = reservaDTO;
	}

	public Timestamp getDataHoraCheckin() {
		return dataHoraCheckin;
	}

	public void setDataHoraCheckin(Timestamp dataHoraCheckin) {
		this.dataHoraCheckin = dataHoraCheckin;
	}

	public Timestamp getDataHoraCheckout() {
		return dataHoraCheckout;
	}

	public void setDataHoraCheckout(Timestamp dataHoraCheckout) {
		this.dataHoraCheckout = dataHoraCheckout;
	}

	public Integer getQtdDiarias() {
		return qtdDiarias;
	}

	public void setQtdDiarias(Integer qtdDiarias) {
		this.qtdDiarias = qtdDiarias;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public StatusHospedagem getStatus() {
		return status;
	}

	public void setStatus(StatusHospedagem status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Hospedagem " + codigo + " - Reserva "
				+ (reservaDTO != null ? reservaDTO.getCodigo() : "");
	}
}
