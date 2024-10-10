package aula03.ex02;

public class Professor extends Pessoa{

    private Double salarioBase;
    private Double salarioTitulacao;

    public Professor(String nome, Integer idade, Double salarioBase, Double salarioTitulacao) {

        super(nome, idade);
        this.salarioBase = salarioBase;
        this.salarioTitulacao = salarioTitulacao;
    }

    public Double calcularSalario () {

        return salarioBase + salarioTitulacao;
    }

    public void imprimirDados () {

        System.out.println(
            "\nSalário base: " + this.salarioBase +
            "\nSalário titulação: " + this.salarioTitulacao
        );
    }
}
