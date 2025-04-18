package listas.lista02.ex02;

public class ConversorInteiroTeste {

	public static void main(String[] args) {
		
		ConversorInteiro conversor = new ConversorInteiro();
		
		long valorLong = 123456789L;
        float valorFloat = 123.45f;
        double valorDouble = 456.78;
        String valorStringValida = "789";
        String valorStringInvalida = "abc";

        System.out.println("Long para int: " + conversor.longToInt(valorLong));
        System.out.println("Float para int: " + conversor.floatToInt(valorFloat));
        System.out.println("Double para int: " + conversor.doubleToInt(valorDouble));
        System.out.println("String válida para int: " + conversor.stringToInt(valorStringValida));
        System.out.println("String inválida para int: " + conversor.stringToInt(valorStringInvalida));
	}
}
