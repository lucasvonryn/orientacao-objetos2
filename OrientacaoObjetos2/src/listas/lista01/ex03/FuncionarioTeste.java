package listas.lista01.ex03;

public class FuncionarioTeste {

    public static void main(String[] args) {

        Professor prof = new Professor(101, "Carlos Silva", Titulacao.DOUTOR, "01/03/2010", 5000.00);

        // Teste: adicionar disciplinas
        System.out.println("\n--- Adicionando disciplinas ---");
        prof.adicionarDisciplina(1, "Orientação a Objetos", "Conceitos de OO", 60);
        prof.adicionarDisciplina(2, "Estrutura de Dados", "Listas, filas e pilhas", 80);
        prof.adicionarDisciplina(3, "Banco de Dados", "SQL e modelagem", 60);

        // Teste: adicionar disciplina com código duplicado
        System.out.println("\n--- Tentando adicionar disciplina duplicada (código 1) ---");
        prof.adicionarDisciplina(1, "Duplicada", "Ementa qualquer", 40);

        // Teste: remover disciplina existente
        System.out.println("\n--- Removendo disciplina com código 2 ---");
        prof.removerDisciplina(2);

        // Teste: remover disciplina inexistente
        System.out.println("\n--- Tentando remover disciplina inexistente (código 99) ---");
        prof.removerDisciplina(99);

        // Teste: exibir relatório com salário calculado
        // Doutor = R$2000 gratificação + (60+60)*15 = R$1800 horas + R$5000 base = R$8800
        System.out.println("\n--- Relatório do Professor ---");
        prof.exibirRelatorio();

        // Teste com professor Mestre
        System.out.println("\n--- Professor Mestre (sem disciplinas) ---");
        Professor profMestre = new Professor(102, "Ana Souza", Titulacao.MESTRE, "15/06/2018", 4000.00);
        profMestre.exibirRelatorio();

        System.out.println("\n========================================");
        System.out.println("    TESTES - TÉCNICO ADMINISTRATIVO     ");
        System.out.println("========================================");

        // Criação do técnico
        TecnicoAdministrativo tec = new TecnicoAdministrativo(201, "João Pereira", "10/01/2015", 3000.00, 500.00);

        // Teste: adicionar processos
        System.out.println("\n--- Adicionando processos ---");
        tec.adicionarProcesso(1001, "01/01/2024", "Processo de compra de equipamentos");
        tec.adicionarProcesso(1002, "15/02/2024", "Processo de licitação");
        tec.adicionarProcesso(1003, "20/03/2024", "Processo de contratação");

        // Teste: adicionar processo com número duplicado
        System.out.println("\n--- Tentando adicionar processo duplicado (número 1001) ---");
        tec.adicionarProcesso(1001, "Qualquer data", "Descrição qualquer");

        // Teste: remover processo existente
        System.out.println("\n--- Removendo processo número 1002 ---");
        tec.removerProcesso(1002);

        // Teste: remover processo inexistente
        System.out.println("\n--- Tentando remover processo inexistente (número 9999) ---");
        tec.removerProcesso(9999);

        // Teste: exibir relatório
        // Salário = R$3000 + R$500 = R$3500
        System.out.println("\n--- Relatório do Técnico Administrativo ---");
        tec.exibirRelatorio();

        // Teste: técnico sem processos
        System.out.println("\n--- Técnico sem processos ---");
        TecnicoAdministrativo tecVazio = new TecnicoAdministrativo(202, "Maria Lima", "05/05/2020", 2800.00, 300.00);
        tecVazio.exibirRelatorio();
    }
}
