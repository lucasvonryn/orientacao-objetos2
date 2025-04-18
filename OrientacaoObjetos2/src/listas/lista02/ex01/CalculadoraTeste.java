package listas.lista02.ex01;

public class CalculadoraTeste {
	
	public static void main(String[] args) {
		
		try {
			
			Calculadora calc = new Calculadora();
			
//			System.out.println(calc.dividir(10, 0));
			System.out.println(calc.calcularRaizQuadrada(81));
//			System.out.println(calc.calcularRaizQuadrada(-81));
			System.out.println(calc.calcularInverso(0));
			
		} catch (ArithmeticException e) {
			
			System.out.println(e.getMessage());
			
		} catch (Exception e) {
			
			System.out.println("Erro inesperado: " + e.getMessage());
		}	
	}
}
