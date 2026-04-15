package aulas.aula06.ex01;

public class Calculadora {

	public Double somar(Double a, Double b) {
		
		return a + b;
	}
	
	public Double subtrair(Double a, Double b) {
		
		return a - b;
	}
	
	public Double multiplicar(Double a, Double b) {
		
		return a * b;
	}
	
	public Double dividir(Double a, Double b) {
		
		return a / b;
	}
	
	public Double potenciar(Double a, Double b) {
		
		return Math.pow(a, b);
	}
	
	public Double raiz(Double a) {
		
		return Math.sqrt(a);
	}
	
	public Double inverso(Double a) {
		
		return 1 / a;
	}
}
