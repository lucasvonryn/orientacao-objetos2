package aula03.ex02;

public class Aluno extends Pessoa {

    private String curso;

    public Aluno(String nome, Integer idade, String curso) {

        super(nome, idade);
        this.curso = curso;
    }

    public void imprimirDados () {

        System.out.println(
            "\nCurso: " + this.curso
        );
    }
}
