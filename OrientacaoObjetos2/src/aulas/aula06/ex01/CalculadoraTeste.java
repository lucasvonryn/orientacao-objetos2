package aulas.aula06.ex01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculadoraTeste {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		Calculadora calc = new Calculadora();
		
		System.out.println("Primeiro valor: ");
		int a = input.nextInt();
		
		System.out.println("Segundo valor: ");
		int b = input.nextInt();
		
		calc.somar(a, b);
		calc.subtrair(a, b);
		calc.multiplicar(a, b);
		try {
			calc.dividir(a, b);
		} catch (ArithmeticException e) {
			System.out.println("Impossível dividir por 0.");
		} catch (InputMismatchException e) {
			System.out.println("Apenas valores inteiros devem ser informados.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		calc.potenciar(a, b);
		
		System.out.println("Continuando a execução do programa...");
		
		input.close();
	}
}
