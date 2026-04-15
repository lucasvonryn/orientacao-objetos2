package aulas.aula08.genericslist;

import java.util.ArrayList;
import java.util.List;

public class Caixa<T> {

	private List<T> itens;
	
	public Caixa() {
		
		this.itens = new ArrayList<>();
	}
	
	public void guardar(T item) {
		
		this.itens.add(item);
		System.out.println("Item guardado com sucesso.");
	}
	
	public void verificarConteudo() {
		
		System.out.println("Conteúdo da caixa:");
		for (T item : this.itens) {
			System.out.println(item);
		}
	}
}
