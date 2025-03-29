package listas.lista01.ex04;

public class Disciplina {
	private int codigo;
	private String nome;
	private String ementa;
	private int cargaHoraria;
	
	public Disciplina(int codigo, String nome, String ementa, int cargaHoraria) {
		this.codigo = codigo;
		this.nome = nome;
		this.ementa = ementa;
		this.cargaHoraria = cargaHoraria;
	}
	
	@Override
	public String toString() {
        return "Código: " + codigo + ", Nome: " + nome + ", Ementa: " + ementa + ", Carga Horária: " + cargaHoraria + "h";
    }
}
