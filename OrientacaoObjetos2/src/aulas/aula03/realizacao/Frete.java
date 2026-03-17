package aulas.aula03.realizacao;

public interface Frete {

	// Não precisa colocar "abstract" explicitamente no método pois todo método de interface é abstrato
	
	// Método abstrato é aquele que só possui a sua assinatura
	
	public double calcularFrete(int distancia);
	
//	public abstract void imprimirDados();
}
