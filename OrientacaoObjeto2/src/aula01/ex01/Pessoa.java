package aula01.ex01;

public class Pessoa {

    private String nome;
    private String dataNascimento;
    private String sexo;
    private String email;
    private String estadoCivil;
    private Endereco endereco;

    public Pessoa(String nome, String dataNascimento, String sexo, String email, String estadoCivil,
            Endereco endereco) {

        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.email = email;
        this.estadoCivil = estadoCivil;
        this.endereco = endereco;
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
