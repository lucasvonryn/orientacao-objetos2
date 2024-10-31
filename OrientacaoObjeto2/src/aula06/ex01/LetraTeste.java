package aula06.ex01;

import java.util.InputMismatchException;

public class LetraTeste {

    public static void main(String[] args) {

        Letra letra = new Letra();
        
        // try {

        //     letra.solicitarStrings();

        // } catch (InputMismatchException ime) {

        //     System.out.println("Entrada de dados inválida.");

        // } catch (Exception e) {

        //     System.out.println("Ocorreu uma exceção.");
        // }

        // try {

        //     letra.compararStrings();

        // } catch (InputMismatchException ime) {

        //     System.out.println("Entrada de dados inválida.");

        // } catch (Exception e) {

        //     System.out.println("Ocorreu uma exceção.");
        // }

        letra.converterMaiusculo("Teste");
        letra.converterMinusculo("Teste");
    }
}
