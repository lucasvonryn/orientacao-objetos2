package listas.lista01.ex03;

public class Processo {

	private Integer numero;
	private String dataCriacao;
	private String descricao;
	
	public Processo(Integer numero, String dataCriacao, String descricao) {
		this.numero = numero;
		this.dataCriacao = dataCriacao;
		this.descricao = descricao;
	}
	
	public String toString() {
		return (
			"Número: " + numero + "\n" +
			"Data Criação: " + dataCriacao + "\n" +
			"Descrição: " + descricao
		);
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(String dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
