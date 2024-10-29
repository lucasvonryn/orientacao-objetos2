package aula05.ex02;

import java.util.Scanner;

public class Pessoa {

    private String nome;
    private int idade;
    private String cpf;
    private String logradouro;
    private int numero;
    private String bairro;
    private String cidade;
    private String estado;
    private int cep;

    Scanner input = new Scanner(System.in);

    public void informarDados() {

        System.out.println("Informe os dados da pessoa");

        System.out.println("Nome: ");
        nome = input.nextLine();

        System.out.println("Idade: ");
        idade = input.nextInt();

        System.out.println("CPF: ");
        cpf = input.nextLine();

        System.out.println("Logradouro: ");
        logradouro = input.nextLine();

        System.out.println("Número: ");
        numero = input.nextInt();

        System.out.println("Bairro: ");
        bairro = input.nextLine();

        System.out.println("Cidade: ");
        cidade = input.nextLine();

        System.out.println("Estado: ");
        estado = input.nextLine();

        System.out.println("CEP: ");
        cep = input.nextInt();
    }
    
    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + ", idade=" + idade + ", cpf=" + cpf + ", logradouro=" + logradouro + ", numero="
                + numero + ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado + ", cep=" + cep + "]";
    }
}
