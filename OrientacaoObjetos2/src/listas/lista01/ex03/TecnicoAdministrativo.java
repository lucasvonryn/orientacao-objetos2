package listas.lista01.ex03;

import java.util.ArrayList;
import java.util.List;

public class TecnicoAdministrativo extends Funcionario {
	
	private Double adicionalNoturno;
	private List<Processo> processos;
	
	public TecnicoAdministrativo(Integer registro, String nome, String dataAdmissao,
			Double salarioBase, Double adicionalNoturno) {
		super(registro, nome, dataAdmissao, salarioBase);
		this.adicionalNoturno = adicionalNoturno;
		this.processos = new ArrayList<Processo>();
	}
	
	public void adicionarProcesso(Integer numero, String dataCriacao, String descricao) {
		boolean jaExiste = this.processos.stream().anyMatch(p -> p.getNumero().equals(numero));
		
		if (!jaExiste) {
			this.processos.add(new Processo(numero, dataCriacao, descricao));
			System.out.println("Processo adicionado.");
		} else {
			System.out.println("Número de processo já adicionado.");
		}
	}
	
	public void removerProcesso(Integer numero) {
		boolean encontrou = this.processos.stream().anyMatch(p -> p.getNumero().equals(numero));
		
		if (encontrou) {
			this.processos.removeIf(p -> p.getNumero().equals(numero));
			System.out.println("Processo removido.");
		} else {
			System.out.println("Processo com o número " + numero + " não encontrado.");
		}
	}
	
	@Override
	public Double calcularSalario() {
		return salarioBase + adicionalNoturno;
	}
	
	@Override
	public void exibirRelatorio() {
		System.out.println("=== Dados do Técnico Administrativo ===");
        System.out.println("Registro: " + registro);
        System.out.println("Nome: " + nome);
        System.out.println("Data de Admissão: " + dataAdmissao);
        System.out.println("Salário Base: R$ " + salarioBase);
        System.out.println("Adicional Noturno: R$ " + adicionalNoturno);
        System.out.println("Salário Total: R$ " + calcularSalario());
	
		System.out.println("--- Processos ---");
		if (!processos.isEmpty()) {
			for (Processo p : processos) {
				System.out.println(p);
			}
		} else {
			System.out.println("Nenhum processo encontrado.");
		}
	}
}
