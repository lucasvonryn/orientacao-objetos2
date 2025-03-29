package listas.lista01.ex01;

public class Filme {

	private String titulo;
	private int duracaoMinutos;
	
	public Filme(String titulo, int duracaoMinutos) {

		this.titulo = titulo;
		this.duracaoMinutos = duracaoMinutos;
	}

	public String getTitulo() {
		return titulo;
	}

	public int getDuracaoMinutos() {
		return duracaoMinutos;
	}
}
