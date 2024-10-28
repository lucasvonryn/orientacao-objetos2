package aula05.ex02;

public class Pessoa {

    private String nome;
    private int idade;
    private String cpf;
    private String logradouro;
    private int numero;
    private String bairro;
    private String cidade;
    private String estado;
    private int cep;

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {

        try {
            
            this.nome = nome;

        } catch (Exception e) {

            System.err.println(e.getMessage());

        }
    }

    public int getIdade() {

        return idade;
    }

    public void setIdade(int idade) {

        this.idade = idade;
    }

    public String getCpf() {

        return cpf;
    }

    public void setCpf(String cpf) {

        this.cpf = cpf;
    }

    public String getLogradouro() {

        return logradouro;
    }

    public void setLogradouro(String logradouro) {

        this.logradouro = logradouro;
    }

    public int getNumero() {
        
        return numero;
    }

    public void setNumero(int numero) {

        this.numero = numero;
    }

    public String getBairro() {

        return bairro;
    }

    public void setBairro(String bairro) {

        this.bairro = bairro;
    }

    public String getCidade() {

        return cidade;
    }

    public void setCidade(String cidade) {

        this.cidade = cidade;
    }

    public String getEstado() {

        return estado;
    }

    public void setEstado(String estado) {

        this.estado = estado;
    }

    public int getCep() {

        return cep;
    }

    public void setCep(int cep) {

        this.cep = cep;
    }

    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + ", idade=" + idade + ", cpf=" + cpf + ", logradouro=" + logradouro + ", numero="
                + numero + ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado + ", cep=" + cep + "]";
    }
}
