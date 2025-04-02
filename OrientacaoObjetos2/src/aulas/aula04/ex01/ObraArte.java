package aulas.aula04.ex01;

import java.util.ArrayList;
import java.util.List;

public class ObraArte {
	private String autor;
	private List<Quadrilatero> quadrilateros;
	
	public ObraArte(String autor) {
		this.autor = autor;
		this.quadrilateros = new ArrayList<>();
	}
	
	public void desenhar(Quadrilatero quadrilatero) {
		quadrilateros.add(quadrilatero);
		System.out.println("Quadrilátero desenhado com sucesso.");
	}
	
	public void exibirObra() {
		System.out.println("Obras do autor: " + autor);
		for (Quadrilatero quadrilatero : quadrilateros) {
			System.out.println(quadrilatero);
		}
	}
}
