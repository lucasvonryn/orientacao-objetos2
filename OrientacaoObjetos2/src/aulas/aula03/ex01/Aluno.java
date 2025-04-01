package aulas.aula03.ex01;

public class Aluno extends Pessoa {
	private String curso;
	
	public Aluno(String nome, int idade, Endereco endereco) {
		super(nome, idade, endereco);
	}
	
	public void realizarMatricula(String curso) {
		this.curso = curso;
		System.out.println("Matrícula realizada.");
	}
	
	public void imprimirDados() {
	   System.out.println("---------------------------");
       System.out.println("Curso: " + curso);
       super.imprimirDados();
       System.out.println("---------------------------");
    }
}
