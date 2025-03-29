package listas.lista01.ex02;

public class Cliente {
	private String nome;
	private String dataNascimento;
	private String cpf;
	private String telefone;
	private Endereco endereco;
	
	public Cliente(String nome, String dataNascimento, String cpf, String telefone, Endereco endereco) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Cliente: " + nome + " | CPF: " + cpf + " | Tel: " + telefone + " | Endereço: " + endereco + " | Data Nac.: " + dataNascimento;
    }
}
