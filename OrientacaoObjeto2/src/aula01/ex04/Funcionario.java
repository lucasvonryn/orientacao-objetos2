package aula01.ex04;

public class Funcionario {

    private Integer registro;
    private String nome;
    private String cpf;
    private DiaSemana folga;

    public Funcionario(Integer registro, String nome, String cpf) {

        this.registro = registro;
        this.nome = nome;
        this.cpf = cpf;
    }

    public void setFolga (DiaSemana folga) {

        this.folga = folga;
    }

    public void imprimirRelatorio () {

        System.out.println(
            "----------------------" +
            "\nRegistro: " + this.registro +
            "\nNome: " + this.nome +
            "\nCPF: " + this.cpf +
            "\nNúmero do dia da semana: " + this.folga.getNumero() +
            "\nDia da semana de folga: " + this.folga.getDia()
        );
    }
}
