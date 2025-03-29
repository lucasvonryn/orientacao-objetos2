package listas.lista01.ex03;

public class Cliente {
	private String nome;
	private String cpf;
	private Conta conta;
	
	public Cliente(String nome, String cpf, Conta conta) {
		this.nome = nome;
		this.cpf = cpf;
		this.conta = conta;
	}
	
	public void fecharConta() {
		conta.fechar();
		System.out.println("Conta fechada com sucesso.");
	}
}
