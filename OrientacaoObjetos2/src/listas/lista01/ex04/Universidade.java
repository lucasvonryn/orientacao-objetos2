package listas.lista01.ex04;

import java.util.ArrayList;
import java.util.List;

public class Universidade {
	private List<Funcionario> funcionarios;
	
	public Universidade() {
		this.funcionarios = new ArrayList<>();
	}
	
	public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
        System.out.println("Funcionário adicionado: " + funcionario.nome);
    }

    public void exibirRelatorios() {
        System.out.println("\nRELATÓRIO DE FUNCIONÁRIOS DA UNIVERSIDADE");
        System.out.println("--------------------------------------------");
        for (Funcionario funcionario : funcionarios) {
            funcionario.exibirRelatorio();
            System.out.println("--------------------------------------------");
        }
    }
}
