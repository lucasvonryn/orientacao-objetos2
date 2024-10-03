package aula02.ex02;

import java.util.List;
import java.util.ArrayList;

public class Agenda {

	private List<Contato> contatos;
	
	public Agenda() {
		
		this.contatos = new ArrayList<Contato>();
	}

	public void adicionarContato(Contato contato) {
		
		contatos.add(contato);
		System.out.println("Contato adicionado à agenda.");
	}
	
	public void excluirContato() {
		
	}
	
	public void exibirContatos() {
		
		if (contatos.isEmpty()) {
			
			System.out.println("Agenda vazia.");
			return;
		}
		
		for (Contato contato : contatos) {
			
			System.out.println(contato);
		}
	}
	
	public void pesquisarContato(String busca) {
		
	}
}
