package aulas.aula02.ex01;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
	
	public List<Contato> contatos;

	public Agenda() {

		this.contatos = new ArrayList<Contato>();
	}
	
	public void adicionarContato(Contato contato) {
		contatos.add(contato);
	}
	
	public void exibirContatos() {
		
		if (contatos.isEmpty()) {
			System.out.println("A agenda está vazia.");
		} else {
			for (Contato contato : contatos) {
				System.out.println(contato);
			}
		}
	}
	
	public void pesquisarContatos(String pesquisa) {
		
		boolean encontrado = false;
		for (Contato contato : contatos) {
			if (contato.getNomeCompleto().toLowerCase().contains(pesquisa.toLowerCase())) {
				System.out.println(contato);
				encontrado = true;
			}
		}
		
		if (!encontrado) {
			System.out.println("Nenhum contato encontrado para: " + pesquisa);
		}
	}
}
