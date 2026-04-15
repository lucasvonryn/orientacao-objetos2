package aulas.aula06.ex01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculadoraTeste {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		try {
			
			System.out.println("Informe o valor a: ");
			Double numerador = input.nextDouble();
			
			System.out.println("Informe o valor b: ");
			Double denominador = input.nextDouble();
			
		} catch (ArithmeticException ae) {
			
			System.out.println("Não é possível dividor por 0.");
			
		} catch (InputMismatchException ime) {
			
			System.out.println("Entrada de dados inválida.");
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		} finally {
			
			input.close();
			System.out.println("Executando o bloco finally.");
		}
	}
}
