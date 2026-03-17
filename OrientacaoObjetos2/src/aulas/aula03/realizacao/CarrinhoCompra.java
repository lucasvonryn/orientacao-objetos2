package aulas.aula03.realizacao;

public class CarrinhoCompra {
	
	private double valorCompra;
	private int distancia;
	
	private Frete frete;

	public CarrinhoCompra(double valorCompra, int distancia, Frete frete) {
		
		this.valorCompra = valorCompra;
		this.distancia = distancia;
		
		// Pode ser qualquer classe que é implementa Frete
		this.frete = frete;
	}
	
	public void realizarCompra() {
		
		double valorTotal = this.valorCompra + this.frete.calcularFrete(distancia);
		
		System.out.println("Valor total: R$" + valorTotal);
	}
}
