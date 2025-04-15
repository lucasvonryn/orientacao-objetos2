package aulas.aula05.ex01;

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
		calc.dividir(a, b);
		calc.potenciar(a, b);
		
		System.out.println("Continuando a execução do programa...");
		
		input.close();
	}
}
