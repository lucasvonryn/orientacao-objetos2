package listas.lista01.ex03;

public class Disciplina {

	private Integer codigo;
	private String nome;
	private String ementa;
	private Integer cargaHoraria;
	
	public Disciplina(Integer codigo, String nome, String ementa, Integer cargaHoraria) {
		this.codigo = codigo;
		this.nome = nome;
		this.ementa = ementa;
		this.cargaHoraria = cargaHoraria;
	}
	
	public String toString() {
		return (
			"Codigo: " + codigo + "\n" +
			"Nome: " + nome + "\n" +
			"Ementa: " + ementa + "\n" +
			"Carga Horária: " + cargaHoraria
		);
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmenta() {
		return ementa;
	}

	public void setEmenta(String ementa) {
		this.ementa = ementa;
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
}
