package listas.lista01.ex01;

public class Quadrado extends FiguraGeometrica {
	
	private Double lado;

	public Quadrado(String cor, Double lado) {
		
		super(cor);
		this.lado = lado;
	}

	@Override
	public void calcularArea() {
		System.out.println("Área do Quadrado: " + (Math.pow(lado, 2)));
	}

	@Override
	public void calcularPerimetro() {
		System.out.println("Perímetro do Quadrado: " + (4 * lado));
	}	
}
