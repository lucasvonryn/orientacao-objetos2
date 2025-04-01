package aulas.aula03.ex01;

public class PessoaTeste {
	public static void main(String[] args) {
		Endereco endereco = new Endereco("Rua", 123, "Centro", "Ponta Grossa", "PR");
		Professor professor = new Professor("Lucas", 32, endereco, "Doutor", 5000.00);
		Aluno aluno = new Aluno("Fernando", 20, endereco);
		
		professor.imprimirDados();
		aluno.imprimirDados();
		aluno.realizarMatricula("Análise e Desenvolvimento de Sistemas");
		aluno.imprimirDados();
	}
}
