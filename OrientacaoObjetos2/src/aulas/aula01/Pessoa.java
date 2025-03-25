package aulas.aula01;

public class Pessoa {
	
	public String nome;
	public String dataNascimento;
	public String sexo;
	public String email;
	public String estadoCivil;
	public Endereco endereco;
	
	public Pessoa(String nome, String dataNascimento, String sexo, String email, String estadoCivil, Endereco endereco) {

		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.email = email;
		this.estadoCivil = estadoCivil;
		this.endereco = endereco;
	}
	
	public void imprimirDados() {
		
	}
}
