package listas.lista01.ex01;

public abstract class FiguraGeometrica {

	protected String cor;
	
	public FiguraGeometrica(String cor) {
		
		this.cor = cor;
	}
	
	public abstract void calcularArea();
	
	public abstract void calcularPerimetro();
}
