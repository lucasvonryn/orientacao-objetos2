package aula07.service;

public class CalculadoraService {

	private boolean status;

	public CalculadoraService() {

		this.status = false;
	}

	public void ligar() {

		this.status = true;
	}

	public void desligar() {

		this.status = false;
	}

	public double somar(double a, double b) {

		return a + b;
	}

	public double subtrair(double a, double b) {

		return a - b;
	}

	public double multiplicar(double a, double b) {

		return a * b;
	}

	public double dividir(double a, double b) throws DivisaoImpossivelException {

		if (b == 0) {

			throw new DivisaoImpossivelException("Impossível dividir por zero.");
		}
		
		return a / b;
	}

	public boolean isStatus() {

		return status;
	}
}