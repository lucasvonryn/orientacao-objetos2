package aula01.ex03;

public class PessoaTeste {

    public static void main(String[] args) {
        
        Endereco endereco1 = new Endereco("Rua Bagre", 123, "Centro", "Ponta Grossa", "PR");
        Pessoa pessoa1 = new Pessoa("Lucas Von Ryn", "01/04/2005", "Masculino", "lvon@gmail.com", endereco1);

        pessoa1.imprimirDados();
    }
}
