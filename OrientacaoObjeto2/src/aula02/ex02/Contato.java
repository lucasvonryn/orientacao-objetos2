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

	@Override
	public String toString() {
		
		return "Contato [nome=" + nome + ", sobrenome=" + sobrenome + ", numeroTelefone=" + numeroTelefone
				+ ", endereco=" + endereco + ", dataAniversario=" + dataAniversario + "]";
	}
}
