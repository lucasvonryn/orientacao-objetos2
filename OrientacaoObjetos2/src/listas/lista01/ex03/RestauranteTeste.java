package listas.lista01.ex03;

public class RestauranteTeste {
	public static void main(String[] args) {
		Prato prato1 = new Prato(1, "Macarronada", "Macarrão integral com molho.", 31.90, "Principal");
		Prato prato2 = new Prato(2, "Arrozonada", "Arroz integral com molho.", 19.10, "Sobremesa");
		Conta conta = new Conta(1);
		Cliente cliente = new Cliente("Lucas", "129.967.706-17", conta);
		
		conta.adicionarPrato(prato1);
		conta.adicionarPrato(prato2);
		
		cliente.fecharConta();
	}
}
