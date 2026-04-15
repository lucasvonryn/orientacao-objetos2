package aulas.aula06.excecao;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculadora {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		try {
			
			System.out.println("Informe o valor do numerador: ");
			Integer numerador = input.nextInt();
			
			System.out.println("Informe o valor do denominador: ");
			Integer denominador = input.nextInt();
			
			Integer resultado = numerador / denominador;
			
			System.out.println("Resultado: " + resultado);
			
		} catch (ArithmeticException ae) {
			
			System.out.println("Não é possível dividor por 0.");
			
		} catch (InputMismatchException ime) {
			
			System.out.println("Entrada de dados inválida.");
			
		} catch (Exception e) {
			
			System.out.println("Ocorreu uma exceção.");
			
		} finally {
			
			input.close();
			System.out.println("Executando o bloco finally.");
		}
		
	}
}
