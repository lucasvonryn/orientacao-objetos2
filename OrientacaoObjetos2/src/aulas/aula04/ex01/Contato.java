package aulas.aula04.ex01;

public class Contato {

	private String nome;
	private String sobrenome;
	private int numeroTelefone;
	private String endereco;
	private String dataAniversario;
	
	public Contato(String nome, String sobrenome, int numeroTelefone, String endereco, String dataAniversario) {
	
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.numeroTelefone = numeroTelefone;
		this.endereco = endereco;
		this.dataAniversario = dataAniversario;
	}

	public String getNomeCompleto() {
	
		return nome + " " + sobrenome;
	}

	@Override
	public String toString() {
		return "Contato [nome=" + nome + ", sobrenome=" + sobrenome + ", numeroTelefone=" + numeroTelefone
				+ ", endereco=" + endereco + ", dataAniversario=" + dataAniversario + "]";
	}
}
