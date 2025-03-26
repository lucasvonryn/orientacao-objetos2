package aulas.aula02.ex01;

public class AgendaTeste {

	public static void main(String[] args) {
		
		Contato contato1 = new Contato("Lucas", "Von Ryn", "(42) 99999-9999", "01/04/2005");
		Contato contato2 = new Contato("Pedro", "Von Ryn", "(42) 99999-9999", "01/04/2005");
		Contato contato3 = new Contato("Alexandre", "Silva", "(42) 99999-9999", "01/04/2005");
		Contato contato4 = new Contato("Eduardo", "Martins", "(42) 99999-9999", "01/04/2005");

		Agenda agenda = new Agenda();
		
		agenda.adicionarContato(contato1);
		agenda.adicionarContato(contato2);
		agenda.adicionarContato(contato3);
		agenda.adicionarContato(contato4);
		
		agenda.pesquisarContatos("Vasdasd");
		agenda.pesquisarContatos("Ryn");
	}
}
