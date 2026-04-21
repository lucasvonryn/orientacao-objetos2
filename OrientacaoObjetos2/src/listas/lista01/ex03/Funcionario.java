package listas.lista01.ex03;

public abstract class Funcionario {

	protected Integer registro;
	protected String nome;
	protected String dataAdmissao;
	protected Double salarioBase;
	
	public Funcionario(Integer registro, String nome, String dataAdmissao, Double salarioBase) {
		this.registro = registro;
		this.nome = nome;
		this.dataAdmissao = dataAdmissao;
		this.salarioBase = salarioBase;
	}
	
	public abstract Double calcularSalario();
	
	public abstract void exibirRelatorio();
}
