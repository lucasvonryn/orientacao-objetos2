package aula02.ex01;

public class BancoTeste {

	public static void main(String[] args) {
		
		Banco banco = new Banco(123456, "New Bank");
		
		banco.adicionarNovaConta(111, "Lucas Gabriel");
		banco.adicionarNovaConta(222, "João da Silva");
		banco.adicionarNovaConta(333, "Nathan de Paula");
		
		banco.realizarDepositoConta(222, 100.00);
		banco.realizarSaqueConta(222, 99.00);
		banco.verificarSaldoConta(222);
	}
}
