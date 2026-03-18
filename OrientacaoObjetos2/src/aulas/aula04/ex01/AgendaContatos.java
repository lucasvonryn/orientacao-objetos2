package aulas.aula04.ex01;

import java.util.ArrayList;
import java.util.List;

public class AgendaContatos {

	private List<Contato> contatos;

	public AgendaContatos() {

		this.contatos = new ArrayList<>();
	}
	
	// Adiciona contato passado por parâmetro à lista de contatos
	public void adicionarContato(Contato contato) {
		
		this.contatos.add(contato);
	}
	
	// Exclui contato passado por parâmetro à lista de contatos
	public void excluirContato(Contato contato) {
		
		this.contatos.remove(contato);
	}
	
	// Exibe todos os contatos da lista
	public void exibirContatos() {
		
		if (this.contatos.isEmpty()) {
			
			System.out.println("Lista de contatos vazia.\n");
			
		} else {
			
			System.out.println("Lista de contatos:");
			
			for (Contato contato : this.contatos) {
				
				System.out.println(contato);
			}
		}
	}
	
	// Busca por contatos com "pedaço" da string passada por parâmetro
	public void buscarContatos(String busca) {
		
		if (this.contatos.isEmpty()) {
			
			System.out.println("Lista de contatos vazia.");
			
		} else {
			
			boolean encontrou = false;
			
			for (Contato contato : this.contatos) {
				
				if (contato.getNomeCompleto().toLowerCase().contains(busca.toLowerCase())) {
					
					System.out.println(contato);
					encontrou = true;
				}
			}
			
			if (!encontrou) {
				
				System.out.println("Nenhum contato encontrado com esse nome.");
			}
		}	
	}
}
