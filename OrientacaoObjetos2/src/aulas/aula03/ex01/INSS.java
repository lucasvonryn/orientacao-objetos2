package aulas.aula03.ex01;

public class INSS implements Imposto {
	
	@Override
	public double calcularImposto(double valor) {
		
		return valor * 0.11;
	}
}
