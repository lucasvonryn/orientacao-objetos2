package aulas.aula01.ex01;

public class PessoaTeste {
	
	public static void main(String[] args) {
		
		Endereco endereco1 = new Endereco("Rua da Liberdade", 12, "Centro", "Rio Azul", "PR");
		Pessoa pessoa1 = new Pessoa("Lucas", "01/04/2005", "Masculino", "lvonryn@gmail.com", "Solteiro", endereco1);
		
		pessoa1.imprimirDados();
	}

}
