package aulas.aula01.ex01;

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
		System.out.println("Nome: " + nome);
		System.out.println("Data de nascimento: " + dataNascimento);
		System.out.println("Sexo: " + sexo);
		System.out.println("E-mail: " + email);
		System.out.println("Estado civil: " + estadoCivil);
		System.out.println("------------------");
		System.out.println("ENDEREÇO:");
		System.out.println("Logradouro: " + endereco.getLogradouro());
		System.out.println("Número: " + endereco.getNumero());
		System.out.println("Bairro: " + endereco.getBairro());
		System.out.println("Cidade: " + endereco.getCidade());
		System.out.println("UF: " + endereco.getUf());
	}
}
