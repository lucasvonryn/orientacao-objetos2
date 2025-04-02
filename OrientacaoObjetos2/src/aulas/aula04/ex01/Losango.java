package aulas.aula04.ex01;

public class Losango extends Quadrilatero {
	public double diagonalMenor;
	public double diagonalMaior;
	public double lado;
	
	public Losango(String cor, double diagonalMenor, double diagonalMaior, double lado) {
		super(cor);
		this.diagonalMenor = diagonalMenor;
		this.diagonalMaior = diagonalMaior;
		this.lado = lado;
	}
	
	@Override
	public void calcularArea() {
		System.out.println("Área do losango: " + (diagonalMenor * diagonalMaior) / 2);
	}
	
	@Override
	public void calcularPerimetro() {
		System.out.println("Perimetro do losango: " + (4 * lado));
	}
	
	@Override
	public String toString() {
		return "\nLosango " + cor;
	}
}
