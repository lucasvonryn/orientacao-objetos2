package aulas.aula03.realizacao;

public class CarrinhoCompraTeste {

	public static void main(String[] args) {
		
		CarrinhoCompra carrinhoCompra1 = new CarrinhoCompra(500.00, 100, new Correios());
		CarrinhoCompra carrinhoCompra2 = new CarrinhoCompra(500.00, 100, new Sedex());
		CarrinhoCompra carrinhoCompra3 = new CarrinhoCompra(500.00, 100, new Sedex10());
		
		carrinhoCompra1.realizarCompra();
		carrinhoCompra2.realizarCompra();
		carrinhoCompra3.realizarCompra();
	}
}
