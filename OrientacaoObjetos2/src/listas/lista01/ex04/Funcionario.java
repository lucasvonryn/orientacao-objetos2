package listas.lista01.ex04;

public abstract	 class Funcionario {
	protected int registro;
	protected String nome;
	protected String dataAdmissao;
	protected double salarioBase;
	
	public Funcionario(int registro, String nome, String dataAdmissao, double salarioBase) {
		this.registro = registro;
		this.nome = nome;
		this.dataAdmissao = dataAdmissao;
		this.salarioBase = salarioBase;
	}
	
	public abstract double calcularSalario();
	
	public abstract void exibirRelatorio();
}
