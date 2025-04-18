package listas.lista02.ex02;

public class ConversorInteiro {

	public int longToInt(long valor) {
		
		return (int) valor;
	}
	
	public int floatToInt(float valor) {
		
		return (int) valor;
	}
	
	public int doubleToInt(double valor) {
		
		return (int) valor;
	}
	
	public int stringToInt(String valor) {
		
		try {
			
			return Integer.parseInt(valor);
			
		} catch (NumberFormatException e) {
			
			System.out.println("Erro: A string fornecida não é um número válido.");
			return 0;
		}
	}
}
