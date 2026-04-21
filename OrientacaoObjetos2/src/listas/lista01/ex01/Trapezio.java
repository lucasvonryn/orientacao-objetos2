package listas.lista01.ex01;

public class Trapezio extends FiguraGeometrica {

	private Double baseMaior;
	private Double baseMenor;
	private Double altura;
	private Double lado;
	
	public Trapezio(String cor, Double baseMaior, Double baseMenor, Double altura, Double lado) {
		super(cor);
		this.baseMaior = baseMaior;
		this.baseMenor = baseMenor;
		this.altura = altura;
		this.lado = lado;
	}

	@Override
	public void calcularArea() {
		System.out.println("Área do Trapézio: " + ((baseMaior * baseMenor) * altura) / 2);		
	}

	@Override
	public void calcularPerimetro() {
		System.out.println("Perímetro do Trapézio: " + (baseMaior + baseMenor + lado + lado));
	}
}
