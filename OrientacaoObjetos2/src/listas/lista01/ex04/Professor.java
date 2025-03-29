package listas.lista01.ex04;

public class Professor extends Funcionario {
	private String titulacao;
	private Disciplina disciplina;
	
	public Professor(int registro, String nome, String dataAdmissao, double salarioBase, String titulacao,
			Disciplina disciplina) {
		super(registro, nome, dataAdmissao, salarioBase);
		this.titulacao = titulacao;
		this.disciplina = disciplina;
	}
	
	@Override
    public double calcularSalario() {
        double gratificacao = titulacao.equalsIgnoreCase("Doutor") ? 2000.00 : 1000.00;
        return salarioBase + gratificacao;
    }
	
	@Override
    public void exibirRelatorio() {
        System.out.println("Professor");
        System.out.println("Registro: " + registro);
        System.out.println("Nome: " + nome);
        System.out.println("Titulação: " + titulacao);
        System.out.println("Data de Admissão: " + dataAdmissao);
        System.out.println("Salário Total: R$ " + calcularSalario());
        System.out.println("Disciplina Ministrada: " + disciplina);
    }
}
