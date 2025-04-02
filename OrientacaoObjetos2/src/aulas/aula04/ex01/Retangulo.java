package aulas.aula04.ex01;

public class Retangulo extends Quadrilatero {
	public double base;
	public double altura;
	
	public Retangulo(String cor, double base, double altura) {
		super(cor);
		this.base = base;
		this.altura = altura;
	}
	
	@Override
	public void calcularArea() {
		System.out.println("Área do retangulo: " + (base * altura));
	}
	
	@Override
	public void calcularPerimetro() {
		System.out.println("Perimetro do retangulo: " + (2 * (base + altura)));
	}
	
	@Override
	public String toString() {
		return "\nRetangulo " + cor;
	}
}
