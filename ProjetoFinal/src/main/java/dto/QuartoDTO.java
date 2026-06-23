package dto;

import enums.StatusQuarto;
import enums.TipoQuarto;

public class QuartoDTO {

	private Integer codigo;
	private Integer numero;
	private TipoQuarto tipo;
	private Integer capacidadeMaxima;
	private Double valorDiaria;
	private StatusQuarto status;

	public QuartoDTO() {
	}

	public QuartoDTO(Integer codigo, Integer numero, TipoQuarto tipo, Integer capacidadeMaxima, Double valorDiaria,
			StatusQuarto status) {
		this.codigo = codigo;
		this.numero = numero;
		this.tipo = tipo;
		this.capacidadeMaxima = capacidadeMaxima;
		this.valorDiaria = valorDiaria;
		this.status = status;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public TipoQuarto getTipo() {
		return tipo;
	}

	public void setTipo(TipoQuarto tipo) {
		this.tipo = tipo;
	}

	public Integer getCapacidadeMaxima() {
		return capacidadeMaxima;
	}

	public void setCapacidadeMaxima(Integer capacidadeMaxima) {
		this.capacidadeMaxima = capacidadeMaxima;
	}

	public Double getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(Double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public StatusQuarto getStatus() {
		return status;
	}

	public void setStatus(StatusQuarto status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Quarto " + numero + " (" + tipo + ")";
	}
}
