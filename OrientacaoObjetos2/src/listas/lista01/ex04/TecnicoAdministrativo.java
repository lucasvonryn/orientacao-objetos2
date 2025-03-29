package listas.lista01.ex04;

public class TecnicoAdministrativo extends Funcionario {
    private double adicionalNoturno;
    private Processo processo;

    public TecnicoAdministrativo(int registro, String nome, String dataAdmissao, double salarioBase, double adicionalNoturno, Processo processo) {
        super(registro, nome, dataAdmissao, salarioBase);
        this.adicionalNoturno = adicionalNoturno;
        this.processo = processo;
    }

    @Override
    public double calcularSalario() {
        return salarioBase + adicionalNoturno;
    }

    @Override
    public void exibirRelatorio() {
        System.out.println("\nTécnico Administrativo");
        System.out.println("Registro: " + registro);
        System.out.println("Nome: " + nome);
        System.out.println("Data de Admissão: " + dataAdmissao);
        System.out.println("Salário Total: R$ " + calcularSalario());
        System.out.println("Processo Controlado: " + processo);
    }
}
