package service;

public class CalculadoraService {

	private boolean status;
	
	public CalculadoraService(String modelo, String marca) {
		
		this.status = false;
	}
	
	public void ligar() {
		
		this.status = true;
	}
	
	public void desligar() {
		
		this.status = false;
	}
	
	public double somar(double x, double y) {
		
		return x + y;
	}
	
	public double dividir(double x, double y) {
		
		if (y == 0.0) {
			
			throw new ArithmeticException("Impossível dividir por 0.");
		}
		
		return x / y;
	}
	
	public boolean isStatus() {
		
		return this.status;
	}
}
