package aula02.ex02;

public class Endereco {

	private int numero;
	private String rua;
	private String bairro;
	private String cidade;
	private String estado;
	
	public Endereco(int numero, String rua, String bairro, String cidade, String estado) {
		
		this.numero = numero;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}

	public void imprimirDados () {

		System.out.println(
			"Número: " + this.numero +
			"\nRua: " + this.rua +
			"\nBairro: " + this.bairro +
			"\nCidade: " + this.cidade +
			"\nEstado: " + this.estado
		);
	}
}
