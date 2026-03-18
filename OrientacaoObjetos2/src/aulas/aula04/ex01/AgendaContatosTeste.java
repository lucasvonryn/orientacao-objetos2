package aulas.aula04.ex01;

public class AgendaContatosTeste {

	public static void main(String[] args) {
		
		Contato contato1 = new Contato("Marcelo", "Oliveira", 123, "Rua X", "01/04/2005");
		Contato contato2 = new Contato("Marcela", "Oliveira", 123, "Rua X", "01/04/2005");
		Contato contato3 = new Contato("Maria", "Oliveira", 123, "Rua X", "01/04/2005");
		Contato contato4 = new Contato("Omar", "Oliveira", 123, "Rua X", "01/04/2005");
		
		AgendaContatos agenda = new AgendaContatos();
		
		agenda.adicionarContato(contato1);
		agenda.adicionarContato(contato2);
		agenda.adicionarContato(contato3);
		agenda.adicionarContato(contato4);
//		agenda.exibirContatos();
		
		agenda.buscarContatos("om");		
	}
}
