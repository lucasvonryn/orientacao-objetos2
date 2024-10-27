package aula04.ex02;

public class Gato extends Mamifero {

    public Gato(String nome, String raca) {

        super(nome, raca);
    }

    public void emitirSom() {

        System.out.println(this.nome + " está miando.");
    }
}
