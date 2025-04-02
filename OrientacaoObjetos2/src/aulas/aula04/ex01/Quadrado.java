package aulas.aula04.ex01;

public class Quadrado extends Quadrilatero {
	public double lado;
	
	public Quadrado(String cor, double lado) {
		super(cor);
		this.lado = lado;
	}
	
	@Override
	public void calcularArea() {
		System.out.println("Área do quadrado: " + Math.pow(lado, 2));
	}
	
	@Override
	public void calcularPerimetro() {
		System.out.println("Perimetro do quadrado: " + (4 * lado));
	}
	
	@Override
	public String toString() {
		return "\nQuadrado " + cor;
	}
}
