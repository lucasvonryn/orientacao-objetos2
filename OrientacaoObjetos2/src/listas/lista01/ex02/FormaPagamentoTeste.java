package listas.lista01.ex02;

public class FormaPagamentoTeste {

	public static void main(String[] args) {
		CartaoCredito cc = new CartaoCredito(1000.00, 123, "Lucas", "01/04/2030", 884);
		cc.efetuarPagamentoTotal();
	}
}
