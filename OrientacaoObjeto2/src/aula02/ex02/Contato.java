package aula02.ex02;

public class Contato {

	private String nome;
	private String sobrenome;
	private int numeroTelefone;
	private Endereco endereco;
	private String dataAniversario;
	
	public Contato(String nome, String sobrenome, int numeroTelefone, Endereco endereco, String dataAniversario) {
		
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.numeroTelefone = numeroTelefone;
		this.endereco = endereco;
		this.dataAniversario = dataAniversario;
	}

	public String getNome () {

		return this.nome;
	}

	public void imprimirDados () {

		System.out.println(
			"--- DADOS ---" +
			"\nNome: " + this.nome +
			"\nSobrenome: " + this.sobrenome +
			"\nNumero de telefone: " + this.numeroTelefone +
			"\nData de aniversário: " + this.dataAniversario +
			"\n--- Endereço ---"
		);
		this.endereco.imprimirDados();
	}
}
