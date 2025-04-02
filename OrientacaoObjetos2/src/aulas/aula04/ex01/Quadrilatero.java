package aulas.aula04.ex01;

public abstract class Quadrilatero {
	protected String cor;
	
	public Quadrilatero(String cor) {
		this.cor = cor;
	}
	
	public abstract void calcularArea();
	
	public abstract void calcularPerimetro();
	
	public String toString() {
		return cor;
	}
}
