package aula05.ex01;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.math.*;

public class Calculadora {

    Scanner input = new Scanner(System.in);

    public void somar () {

        try {

            System.out.println("Informe o primeiro número: ");
            int primeiroNumero = input.nextInt();

            System.err.println("Informe o segundo número: ");
            int segundoNumero = input.nextInt();

            int resultado = primeiroNumero + segundoNumero;
            System.out.println(primeiroNumero + " + " + segundoNumero + " = " + resultado);

        } catch (InputMismatchException ime) {

            System.out.println("Os valores devem ser inteiros.");

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }
    }


    public void subtrair () {

        try {

            System.out.println("Informe o primeiro número: ");
            int primeiroNumero = input.nextInt();

            System.err.println("Informe o segundo número: ");
            int segundoNumero = input.nextInt();

            int resultado = primeiroNumero - segundoNumero;
            System.out.println(primeiroNumero + " - " + segundoNumero + " = " + resultado);

        } catch (InputMismatchException ime) {

            System.out.println("Os valores devem ser inteiros.");

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }
    }


    public void multiplicar () {

        try {

            System.out.println("Informe o primeiro número: ");
            int primeiroNumero = input.nextInt();

            System.err.println("Informe o segundo número: ");
            int segundoNumero = input.nextInt();

            int resultado = primeiroNumero * segundoNumero;
            System.out.println(primeiroNumero + " x " + segundoNumero + " = " + resultado);

        } catch (InputMismatchException ime) {

            System.out.println("Os valores devem ser inteiros.");

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }
    }


    public void dividir () {

        try {

            System.out.println("Informe o numerador: ");
            int numerador = input.nextInt();

            System.out.println("Informe o denominador: ");
            int denominador = input.nextInt();

            double resultado = numerador / denominador;
            System.out.println(numerador + " / " + denominador + " = " + resultado);

        //                           ae = ArithmeticException - nomeObjeto
        } catch (ArithmeticException ae) {

            System.err.println("Impossível dividir por zero.");

        } catch (InputMismatchException ime) {

            System.out.println("Os valores devem ser inteiros.");

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }
    }


    public void calcularPotencia () {

        try {

            System.out.println("Informe a base: ");
            int primeiroNumero = input.nextInt();

            System.err.println("Informe o expoente: ");
            int segundoNumero = input.nextInt();

            double resultado = Math.pow(primeiroNumero, segundoNumero);
            System.out.println(primeiroNumero + " ** " + segundoNumero + " = " + resultado);

        } catch (InputMismatchException ime) {

            System.out.println("Os valores devem ser inteiros.");

        } catch (Exception e) {

            System.out.println(e.getMessage());

        } finally {

            input.close();
            System.out.println("Executando o bloco finally.");
        }
    }

    
    public void calcularRaizQuadrada () {

        try {

            System.out.println("Informe o radicando: ");
            int numero = input.nextInt();

            double resultado = Math.sqrt(numero);
            System.out.println("Raiz quadrada de " + numero + " = " + resultado);

        } catch (InputMismatchException ime) {

            System.out.println("Os valores devem ser inteiros.");

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }
    }


    public void cacularInverso () {

        try {

            System.out.println("Informe o número: ");
            int numero = input.nextInt();

            double resultado = (1 / numero);
            System.out.println("Inverso de " + numero + " = " + resultado);

        } catch (InputMismatchException ime) {

            System.out.println("Os valores devem ser inteiros.");

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }
    }
}
