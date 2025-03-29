package listas.lista01.ex04;

public class UniversidadeTeste {
	public static void main(String[] args) {
        Universidade universidade = new Universidade();

        Disciplina disciplina1 = new Disciplina(1, "Programação Java", "Estruturas de Controle, Classes e Métodos", 60);
        Processo processo1 = new Processo(202401, "20/03/2025", "Controle de matrícula dos alunos");
        Professor professor1 = new Professor(1, "Ana Souza", "20/03/2025", 5000.00, "Doutor", disciplina1);
        TecnicoAdministrativo tecnico1 = new TecnicoAdministrativo(1, "Carlos Silva", "20/03/2025", 3500.00, 800.00, processo1);

        // Adicionando funcionários à universidade
        universidade.adicionarFuncionario(professor1);
        universidade.adicionarFuncionario(tecnico1);

        // Exibindo relatórios
        universidade.exibirRelatorios();
    }
}
