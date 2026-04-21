package listas.lista01.ex01;

public class Losango extends FiguraGeometrica {

	private Double diagonalMaior;
	private Double diagonalMenor;
	private Double lado;
	
	public Losango(String cor, Double diagonalMaior, Double diagonalMenor, Double lado) {
		
		super(cor);
		this.diagonalMaior = diagonalMaior;
		this.diagonalMenor = diagonalMenor;
		this.lado = lado;
	}

	@Override
	public void calcularArea() {
		System.out.println("Área do Losango: " + ((diagonalMaior * diagonalMenor) / 2));
	}

	@Override
	public void calcularPerimetro() {
		System.out.println("Perímetro do Losango: " + (4 * lado));
	}
}
