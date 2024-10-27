package aula04.ex02;

public class Mamifero {

    protected String nome;
    protected String raca;

    public Mamifero(String nome, String raca) {

        this.nome = nome;
        this.raca = raca;
    }

    public void emitirSom() {

    }

    public void exibirDados() {

        System.out.println("Nome: " + this.nome);
        System.out.println("Raça: " + this.raca);
    }
}
