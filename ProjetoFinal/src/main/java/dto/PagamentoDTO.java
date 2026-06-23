package dto;

import java.sql.Date;

import enums.FormaPagamento;

public class PagamentoDTO {

	private Integer codigo;
	private HospedagemDTO hospedagemDTO;
	private Double valor;
	private Date data;
	private FormaPagamento formaPagamento;

	public PagamentoDTO() {
		this.hospedagemDTO = new HospedagemDTO();
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public HospedagemDTO getHospedagemDTO() {
		return hospedagemDTO;
	}

	public void setHospedagemDTO(HospedagemDTO hospedagemDTO) {
		this.hospedagemDTO = hospedagemDTO;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
}
