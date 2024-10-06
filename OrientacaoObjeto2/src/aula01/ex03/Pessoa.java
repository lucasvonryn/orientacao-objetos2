package aula01.ex03;

public class Pessoa {

    private String nome;
    private String dataNascimento;
    private String sexo;
    private String email;
    private Endereco endereco;
    private EstadoCivil estadoCivil;

    public Pessoa(String nome, String dataNascimento, String sexo, String email, Endereco endereco) {

        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.email = email;
        this.endereco = endereco;
        this.estadoCivil = EstadoCivil.CASADO;
    }

    public void imprimirDados() {

        System.out.println(
            "--- DADOS ---" +
            "\nNome: " + nome +
            "\nData de nascimento: " + dataNascimento +
            "\nSexo: " + sexo +
            "\nEmail: " + email +
            "\nEstado civil: " + estadoCivil +
            "\n"
        );
        endereco.imprimirEndereco();
    }
}
