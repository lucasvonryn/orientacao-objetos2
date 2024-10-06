package aula01.ex04;

public class FuncionarioTeste {

    public static void main(String[] args) {
        
        Funcionario funcionario1 = new Funcionario(1, "Lucas", "123981297-12");

        funcionario1.setFolga(DiaSemana.QUINTA);

        funcionario1.imprimirRelatorio();
    }
}
