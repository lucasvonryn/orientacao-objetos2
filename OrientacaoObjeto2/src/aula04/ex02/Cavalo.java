package aula04.ex02;

public class Cavalo extends Mamifero {

    public Cavalo(String nome, String raca) {

        super(nome, raca);
    }

    public void emitirSom() {

        System.out.println(this.nome + " está grosnando.");
    }
}
