package aula06.ex01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Letra {

    private String string1;
    private String string2;

    Scanner input = new Scanner(System.in);

    public void solicitarStrings() throws InputMismatchException, Exception {

        System.out.println("Escreva a primeira String: ");
        string1 = input.nextLine();

        System.out.println("Escreva a segunda String: ");
        string2 = input.nextLine();
    }

    public void compararStrings() {

        System.out.println("Escreva a primeira String: ");
        string1 = input.nextLine();

        System.out.println("Escreva a segunda String: ");
        string2 = input.nextLine();

        if (string1 == string2) {
            
            System.out.println("As strings são iguais.");

        } else {

            System.out.println("As string são diferentes.");

        }
    }

    public void contarCacteresString() throws InputMismatchException, Exception {

        String string;

        System.out.println("Digite a string que deseja contar os caracteres: ");
        string = input.nextLine();

        System.out.println("A string digitada contêm " + string.length() + " caracteres.");
    }

    public void converterMaiusculo(String string) {

        System.out.println("String em maiúsculo: " + string.toUpperCase());

    }

    public void converterMinusculo(String string) {

        System.out.println("String em minúsculo: " + string.toLowerCase());

    }
}
