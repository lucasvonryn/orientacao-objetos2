package listas.lista01.ex01;

public class FiguraGeometricaTeste {

	public static void main(String[] args) {
		
		Quadrado quadrado = new Quadrado("Verde", 2.00);
		
		quadrado.calcularArea();
		quadrado.calcularPerimetro();
		
		Losango losango = new Losango("Amarelo", 8.00, 6.00, 6.00);
		
		losango.calcularArea();
		losango.calcularPerimetro();
	}
}
