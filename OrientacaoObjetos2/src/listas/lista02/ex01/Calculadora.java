package listas.lista02.ex01;

public class Calculadora {
	
	public double somar(double x, double y) {
		
		return x + y;
	}
	
	public double subtrair(double x, double y) {
		
		return x - y;
	}
	
	public double multiplicar(double x, double y) {
		
		return x * y;
	}
	
	public double dividir(double x, double y) throws ArithmeticException {
		
		if (y == 0) {
			
			throw new ArithmeticException("Erro: Divisão por zero não é permitida.");
		}
		return x / y;
	}
	
	public double calcularPotenciacao(double x, double y) {
		
		return Math.pow(x, y);
	}
	
	public double calcularRaizQuadrada(double x) throws ArithmeticException {
		
		if (x < 0) {
			
			throw new ArithmeticException("Erro: Raiz quadrada de número negativo não é permitida.");
		}
		return Math.sqrt(x);
	}
	
	public double calcularInverso(double x) throws ArithmeticException {
		
		if (x == 0) {
			
            throw new ArithmeticException("Erro: Inverso de zero não é permitido.");
        }
		return 1 / x;
	}
}
