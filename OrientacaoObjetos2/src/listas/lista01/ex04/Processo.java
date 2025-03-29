package listas.lista01.ex04;

public class Processo {
	private int numero;
	private String dataCriacao;
	private String descricao;
	
	public Processo(int numero, String dataCriacao, String descricao) {
		this.numero = numero;
		this.dataCriacao = dataCriacao;
		this.descricao = descricao;
	}
	
	@Override
    public String toString() {
        return "Número: " + numero + ", Data de Criação: " + dataCriacao + ", Descrição: " + descricao;
    }
}
