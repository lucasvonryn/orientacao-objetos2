package aulas.aula08.ex01;

import java.util.LinkedList;
import java.util.Queue;

public class Impressora<T> {

	private Queue<T> filaImpressao;
	
	public Impressora() {
		
		this.filaImpressao = new LinkedList<>();
	}
	
	public void adicionarDocumento(T documento) {
		
		this.filaImpressao.add(documento);
		System.out.println("Documento adicionado.");
	}
	
	public void imprimir() {
		
		for (T documento : this.filaImpressao) {
			
			System.out.println(documento);
		}
	}
}
