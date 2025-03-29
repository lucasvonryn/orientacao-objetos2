package listas.lista01.ex01;

public class Sala {

	private int id;
	private int capacidadeMax;
	
	public Sala(int id, int capacidadeMax) {

		this.id = id;
		this.capacidadeMax = capacidadeMax;
	}
	
	public int getNumero() {
		return this.id;
	}
	
	public int getCapacidadeMax() {
		return this.capacidadeMax;
	}
}
