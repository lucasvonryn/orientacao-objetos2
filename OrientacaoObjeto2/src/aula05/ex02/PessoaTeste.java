package aula05.ex02;

import java.util.Scanner;

public class PessoaTeste {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        
        Pessoa pessoa1 = new Pessoa();

        System.out.println("Informe os dados da pessoa");

        System.out.println("Nome: ");
        pessoa1.setNome(input.nextLine());

        System.out.println("Idade: ");
        pessoa1.setIdade(input.nextInt());

        System.out.println("CPF: ");
        pessoa1.setCpf(input.nextLine());

        System.out.println("Logradouro: ");
        pessoa1.setLogradouro(input.nextLine());

        System.out.println("Número: ");
        pessoa1.setNumero(input.nextInt());

        System.out.println("Bairro: ");
        pessoa1.setBairro(input.nextLine());

        System.out.println("Cidade: ");
        pessoa1.setCidade(input.nextLine());

        System.out.println("Estado: ");
        pessoa1.setEstado(input.nextLine());

        System.out.println("CEP: ");
        pessoa1.setCep(input.nextInt());
    }
}
