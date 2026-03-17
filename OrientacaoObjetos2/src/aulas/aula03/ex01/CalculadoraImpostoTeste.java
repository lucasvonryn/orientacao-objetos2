package aulas.aula03.ex01;

public class CalculadoraImpostoTeste {

	public static void main(String[] args) {
		
		CalculadoraImposto calculadoraImpostoINSS = new CalculadoraImposto(100, new INSS());
		CalculadoraImposto calculadoraImpostoIOF = new CalculadoraImposto(100, new IOF());
		CalculadoraImposto calculadoraImpostoIPVA = new CalculadoraImposto(100, new IPVA());
		CalculadoraImposto calculadoraImpostoIRPF = new CalculadoraImposto(100, new IRPF());
		
		calculadoraImpostoINSS.calcularImposto();
		calculadoraImpostoIOF.calcularImposto();
		calculadoraImpostoIPVA.calcularImposto();
		calculadoraImpostoIRPF.calcularImposto();
	}
}
