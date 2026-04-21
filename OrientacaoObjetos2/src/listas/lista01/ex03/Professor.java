package listas.lista01.ex03;

import java.util.ArrayList;
import java.util.List;

public class Professor extends Funcionario {

	private Titulacao titulacao;
	private List<Disciplina> disciplinasMinistradas;
	
	public Professor(Integer registro, String nome, Titulacao titulacao, String dataAdmissao, 
			Double salarioBase) {
		super(registro, nome, dataAdmissao, salarioBase);
		this.titulacao = titulacao;
		this.disciplinasMinistradas = new ArrayList<>();
	}
	
	public void adicionarDisciplina(Integer codigo, String nome, String ementa,
			Integer cargaHoraria) {
		boolean jaExiste = this.disciplinasMinistradas.stream()
				.anyMatch(d -> d.getCodigo().equals(codigo));
		
		if (!jaExiste) {
			this.disciplinasMinistradas.add(new Disciplina(codigo, nome, ementa, cargaHoraria));
			System.out.println("Disciplina adicionada.");
		} else {
			System.out.println("Código de disciplina já adicionado.");
		}
	}
	
	public void removerDisciplina(Integer codigo) {
		boolean encontrou = this.disciplinasMinistradas.stream()
				.anyMatch(d -> d.getCodigo().equals(codigo));
		
		if (encontrou) {
			this.disciplinasMinistradas.removeIf(d -> d.getCodigo().equals(codigo));
			System.out.println("Disciplina removida.");
		} else {
			System.out.println("Disciplina com o código " + codigo + " não encontrada.");
		}
	}
	
	@Override
	public Double calcularSalario() {
		Double gratificacao = switch (titulacao) {
			case MESTRE -> 1000.00;
			case DOUTOR -> 2000.00;
		};
		
		int totalHoras = this.disciplinasMinistradas.stream()
				.mapToInt(d -> d.getCargaHoraria())
				.sum();
		
		return this.salarioBase + gratificacao + (totalHoras * 15.00);
	}

	@Override
	public void exibirRelatorio() {
		Double gratificacao = switch (titulacao) {
	        case MESTRE -> 1000.00;
	        case DOUTOR -> 2000.00;
	    };
	
	    int totalHoras = this.disciplinasMinistradas.stream()
	    		.mapToInt(d -> d.getCargaHoraria())
	    		.sum();
			
		System.out.println("=== Dados do Professor ===");
        System.out.println("Registro: " + registro);
        System.out.println("Nome: " + nome);
        System.out.println("Titulação: " + titulacao);
        System.out.println("Data de Admissão: " + dataAdmissao);
        System.out.println("Salário Base: R$ " + salarioBase);
        System.out.println("Gratificação: R$ " + gratificacao);
        System.out.println("Total de Horas: " + totalHoras + "h");
        System.out.println("Salário Total: R$ " + calcularSalario());

        System.out.println("--- Disciplinas ---");
        if (!disciplinasMinistradas.isEmpty()) {
            for (Disciplina d : disciplinasMinistradas) {
                System.out.println(d);
            }
        } else {
            System.out.println("Nenhuma disciplina atribuída.");
        }	
	}
}
