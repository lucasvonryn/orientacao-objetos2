package aulas.aula03.ex01;

public class CalculadoraImposto {

	private double valor;
	private Imposto imposto;
	
	public CalculadoraImposto(double valor, Imposto imposto) {
		
		this.valor = valor;
		this.imposto = imposto;
	}
	
	public void calcularImposto() {
		
		double valorImposto = imposto.calcularImposto(valor);
		double valorTotal = valor + imposto.calcularImposto(valor);
		
		System.out.println("Valor imposto: R$" + valorImposto);
		System.out.println("Valor total: R$" + valorTotal + "\n");
	}
}
