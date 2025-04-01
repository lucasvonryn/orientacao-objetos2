package aulas.aula03.ex01;

public class Professor extends Pessoa {
	private String titulacao;
	private double salarioBase;
	private double salarioTitulacao;
	
	public Professor(String nome, int idade, Endereco endereco, String titulacao, double salarioBase) {
		super(nome, idade, endereco);
		this.titulacao = titulacao;
		this.salarioBase = salarioBase;
	}
	
	public double calcularSalario() {
        double gratificacao = titulacao.equalsIgnoreCase("Doutor") ? 2000.00 : 1000.00;
        salarioTitulacao = salarioBase + gratificacao;
        return salarioTitulacao;
    }
	
	public void imprimirDados() {
	   System.out.println("---------------------------");
       System.out.println("Titulação: " + titulacao);
       System.out.println("Salário base: R$ " + salarioBase);
       System.out.println("Salário calculado: " + this.calcularSalario());
       super.imprimirDados();
       System.out.println("---------------------------");
    }
}
