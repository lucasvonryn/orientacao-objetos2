package aula02.ex01;

public class ContaBancaria {

	private int numeroConta;
	private double saldo;
	private String nomeTitular;
	
	public ContaBancaria(int numeroConta, String nomeTitular) {
		
		this.numeroConta = numeroConta;
		this.saldo = 0;
		this.nomeTitular = nomeTitular;
	}
	
	public void verificarSaldo() {
		
		System.out.println("Saldo atual: R$ " + this.saldo);
	}
	
	public void realizarSaque(Double valor) {
	
		if (valor > this.saldo) {
			
			System.out.println("Saldo insuficiente.");
		} else {
			
			this.saldo -= valor;
			System.out.println("Saque realizado.");
		}
	}
	
	public void realizarDeposito(Double valor) {
		
		this.saldo += valor;
		System.out.println("Depósito realizado.");
	}

	public int getNumeroConta() {
		
		return numeroConta;
	}

	@Override
	public String toString() {
		
		return "ContaBancaria [numeroConta=" + numeroConta + ", saldo=" + saldo + ", nomeTitular=" + nomeTitular + "]";
	}
}
