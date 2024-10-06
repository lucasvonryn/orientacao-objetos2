package aula01.ex01;

public class Endereco {

    private String logradouro;
    private Integer numero;
    private String bairro;
    private String cidade;
    private String uf;

    public Endereco(String logradouro, Integer numero, String bairro, String cidade, String uf) {

        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
    }

    public void imprimirEndereco() {

        System.out.println(
            "--- ENDEREÇO ---" +
            "\nLogradouro: " + logradouro +
            "\nNumero: " + numero +
            "\nBairro: " + bairro +
            "\nCidade: " + cidade +
            "\nUF: " + uf
        );
    }
}
