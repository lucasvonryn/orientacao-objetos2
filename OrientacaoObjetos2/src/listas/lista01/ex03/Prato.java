package listas.lista01.ex03;

public class Prato {
	private int id;
	private String nome;
	private String descIngredientes;
	private double preco;
	private String tipo;
	
	public Prato(int id, String nome, String descIngredientes, double preco, String tipo) {
		this.id = id;
		this.nome = nome;
		this.descIngredientes = descIngredientes;
		this.preco = preco;
		this.tipo = tipo;
	}
	
	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public double getPreco() {
		return preco;
	}
	
	@Override
	public String toString() {
		return "ID: " + id + " | Nome: " + nome + " | Descrição: " + descIngredientes + " | Preço: R$ " + preco + " | Tipo: " + tipo;
	}
}
