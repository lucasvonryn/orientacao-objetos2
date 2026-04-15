package aulas.aula08.generics;

public class CaixaTeste {

	public static void main(String[] args) {
		
		Bola bola = new Bola();
		Carrinho carrinho = new Carrinho();
		
		Caixa<Bola> caixaBola = new Caixa<Bola>();
		Caixa<Carrinho> caixaCarrinho = new Caixa<Carrinho>();
		
		caixaBola.guardar(bola);
		caixaCarrinho.guardar(carrinho);
		
		System.out.println("Caixa Bola: " + caixaBola.verificar());
		System.out.println("Caixa Carrinho: " + caixaCarrinho.verificar());
	}
}
