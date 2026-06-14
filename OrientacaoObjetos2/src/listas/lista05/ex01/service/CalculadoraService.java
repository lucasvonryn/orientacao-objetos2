package listas.lista05.ex01.service;

public class CalculadoraService {
	
	private String visor = "0";
	private Double operandoAnterior;
	private String operador;
	private boolean novaEntrada = true;
	private Double memoria;

	public void adicionarDigito(String digito) {
		if ("Erro".equals(visor)) {
			limpar();
		}
		if (novaEntrada) {
			visor = digito.equals("0") ? "0" : digito;
			novaEntrada = false;
		} else {
			if (visor.equals("0") && !digito.equals("0"))
				visor = digito;
			else if (!visor.equals("0"))
				visor += digito;
		}
	}
	
	public void adicionarVirgula() {
		if ("Erro".equals(visor)) {
			limpar();
		}
		if (novaEntrada) {
			visor = "0,";
			novaEntrada = false;
		} else if (!visor.contains(",")) {
			visor += ",";
		}
	}
	
	public Double somar(Double a, Double b) {return a + b;}
	
	public Double subtrair(Double a, Double b) {return a - b;}
	
	public Double multiplicar(Double a, Double b) {return a * b;}
	
	public Double dividir(Double a, Double b) {
		if (b == 0) throw new ArithmeticException("Divisão por zero.");
		return a / b;
	}
	
	public void definirOperador(String op) {
		if ("Erro".equals(visor)) {
			return;
		}
		
		try {
			Double valorAtual = parseVisor();
			
			if (operador != null && !novaEntrada) {
				operandoAnterior = calcular(operandoAnterior, valorAtual, operador);
				visor = formatar(operandoAnterior);
			} else {
				operandoAnterior = valorAtual;
			}
			
			operador = op;
			novaEntrada = true;
		} catch (ArithmeticException e) {
			exibirErro();
		}
	}
	
	public void calcularResultado() {
		if (operador == null || operandoAnterior == null) {
			return;
		}
		
		try {
			Double valorAtual = parseVisor();
			Double resultado = calcular(operandoAnterior, valorAtual, operador);
			
			visor = formatar(resultado);
			operandoAnterior = null;
			operador = null;
			novaEntrada = true;
		} catch (ArithmeticException e) {
			exibirErro();
		}
	}
	
	private Double calcular(Double a, Double b, String op) {
		return switch (op) {
			case "+" -> somar(a, b);
			case "-" -> subtrair(a, b);
			case "*" -> multiplicar(a, b);
			case "/" -> dividir(a, b);
			default -> b;
		};
	}
	
	public void limpar() {
	    visor = "0";
	    operandoAnterior = null;
	    operador = null;
	    novaEntrada = true;
	}
	
	public void memoriaSalvar() {
		if ("Erro".equals(visor)) {
			return;
		}
		memoria = parseVisor();
	}
	public void memoriaRecuperar() { visor = formatar(memoria); novaEntrada = true; }
	public void memoriaLimpar() { memoria = null; }
	
	public String getVisor() { return visor; }

	private Double parseVisor() {
	    if (visor.endsWith(",")) {
	        visor = visor.substring(0, visor.length() - 1);
	    }
	    return Double.parseDouble(visor.replace(",", "."));
	}
	private String formatar(Double valor) {
	    if (valor == null) {
	        return "0";
	    }
	    String texto = String.valueOf(valor).replace(".", ",");
	    if (texto.endsWith(",0")) {
	        texto = texto.substring(0, texto.length() - 2);
	    }
	    return texto;
	}
	
	private void exibirErro() {
		visor = "Erro";
		operandoAnterior = null;
		operador = null;
		novaEntrada = true;
	}
}
