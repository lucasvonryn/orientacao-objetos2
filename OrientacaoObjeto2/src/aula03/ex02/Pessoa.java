package aula03.ex02;

public class Pessoa {

    protected String nome;
    protected Integer idade;

    public Pessoa(String nome, Integer idade) {

        this.nome = nome;
        this.idade = idade;
    }

    public void imprimirDados () {
        
        System.out.println(
            "--- DADOS ---" +
            "\nNome: " + this.nome +
            "\nIdade: " + this.idade
        );
    }
}
