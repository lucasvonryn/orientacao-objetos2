package aulas.aula06.ex01;

import java.util.InputMismatchException;

public class Calculadora {
	
	public void somar(int a, int b) {
		
		try {
			
			int resultado = a + b;
			System.out.println(a + " + " + b + " = " + resultado);

		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
	}
	
	public void subtrair(int a, int b) {
		
		try {
			
			int resultado = a - b;
			System.out.println(a + " - " + b +  " = " + resultado);
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
	}
	
	public void multiplicar(int a, int b) {
		
		try {
			
			int resultado = a * b;
			System.out.println(a + " x " + b + " = " + resultado);
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
	}
	
	public void dividir(int numerador, int denominador) throws ArithmeticException, InputMismatchException, Exception {
		
		double resultado = numerador / denominador;
		System.out.println(numerador + " / " + denominador + " = " + resultado);
	}
	
	public void potenciar(int a, int b) {
		
		try {
			
			double resultado = Math.pow(a, b);
			System.out.println(a + " ** " + b + " = " + resultado);
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
	}
}
