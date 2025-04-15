package aulas.aula06.ex02;

import java.util.Scanner;

public class Letra {
	private String a;
	private String b;
	
	public void solicitarStrings() throws Exception {
		
		Scanner input = new Scanner(System.in);
		
		try {
			
			System.out.println("Primeira string: ");
			a = input.nextLine();
			
			System.out.println("Segunda string: ");
			b = input.nextLine();
		} finally {
			
			input.close();
		}
	}
	
	public void compararStrings() throws Exception {
		
		if (a.equals(b)) {
			
			System.out.println("As strings são iguais.");
		} else {
			
			System.out.println("As strings são diferentes.");
		}
	}
	
	public void contarQtdCaracteres() throws Exception {
		
		int qtdCaracteresA = a.length();
		int qtdCaracteresB = b.length();
		
		System.out.println(a + " possui " + qtdCaracteresA + " caracteres.");
		System.out.println(b + " possui " + qtdCaracteresB + " caracteres.");
	}
	
	public void converterMinusculo() throws Exception {
		
		System.out.println("\"" + a + "\" em minúsculo: " + a.toLowerCase());
		System.out.println("\"" + b + "\" em minúsculo: " + b.toLowerCase());
	}
	
	public void converterMaiusculo() throws Exception {
	
		System.out.println("\"" + a + "\" em maiúsculo: " + a.toUpperCase());
		System.out.println("\"" + b + "\" em maiúsculo: " + b.toUpperCase());
	}
}
