package aulas.aula01.ex02;

public class PessoaTeste {
	
	public static void main(String[] args) {
		
		Endereco endereco1 = new Endereco("Rua da Liberdade", 12, "Centro", "Rio Azul", "PR");
		Pessoa pessoa1 = new Pessoa("Lucas", "01/04/2005", "Masculino", "lvonryn@gmail.com", endereco1);
		
		System.out.println("==================");
		pessoa1.setEstadoCivil(EstadoCivil.SOLTEIRO);
		pessoa1.imprimirDados();
		System.out.println("==================");
		pessoa1.setEstadoCivil(EstadoCivil.CASADO);
		pessoa1.imprimirDados();
		System.out.println("==================");
		pessoa1.setEstadoCivil(EstadoCivil.DIVORCIADO);
		pessoa1.imprimirDados();
		System.out.println("==================");
		pessoa1.setEstadoCivil(EstadoCivil.VIUVO);
		pessoa1.imprimirDados();
	}

}
