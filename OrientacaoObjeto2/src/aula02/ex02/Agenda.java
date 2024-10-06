package aula02.ex02;

import java.util.List;
import java.util.ArrayList;

public class Agenda {

	private List<Contato> contatos;
	private Integer n;
	
	public Agenda() {
		
		this.contatos = new ArrayList<Contato>();
		this.n = 0;
	}

	public void adicionarContato(Contato contato) {
		
		contatos.add(contato);
		System.out.println("Contato adicionado à agenda.");
	}
	
	public void excluirContato(Contato contatoExclusao) {
		
		for (Contato contato : contatos) {
			
			if (contato == contatoExclusao) {

				contatos.remove(contato);
				System.out.println("Contato excluído da agenda.");
				return;
			}
		}
		System.out.println("Contato não encontrado.");
	}
	
	public void exibirContatos() {
		
		if (contatos.isEmpty()) {
			
			System.out.println("Agenda vazia.");
			return;
		}
		
		System.out.println("------ CONTATOS ------");

		for (Contato contato : contatos) {

			n++;
			System.out.println("\nContato " + n + "\n");
			contato.imprimirDados();
		}
	}
	
	public void pesquisarContato(String pesquisa) {
		
		System.out.println("\nPesquisa de contatos:");
		for (Contato contato : contatos) {
			
			if (contato.getNome().toLowerCase().contains(pesquisa.toLowerCase())) {

				contato.imprimirDados();
				System.out.println("\n");
				return;
			}
		}
		System.out.println("\nNenhum contato encontrado.");
	}
}
