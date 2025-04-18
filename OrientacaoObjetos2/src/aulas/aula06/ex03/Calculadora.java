package aulas.aula06.ex03;

import java.util.InputMismatchException;
import java.util.Scanner;

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
	
	public void dividir(int numerador, int denominador) {
		
		try {
			
			double resultado = numerador / denominador;
			System.out.println(numerador + " / " + denominador + " = " + resultado);
			
		} catch (ArithmeticException e) {
			
			System.out.println("Impossível dividir por 0.");
			
		} catch (InputMismatchException e) {
			
			System.out.println("Apenas valores inteiros devem ser informados.");
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
	}
	
	public void potenciar(int a, int b) {
		
		try {
			
			double resultado = Math.pow(a, b);
			System.out.println(a + " ** " + b + " = " + resultado);
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
	}
	
	public void calcularRaizQuadrada() {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Informe o valor de x: ");
		input.nextLine();
	}
}
