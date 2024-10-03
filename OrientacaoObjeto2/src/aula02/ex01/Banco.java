package aula02.ex01;

import java.util.List;
import java.util.ArrayList;

public class Banco {

	private int cnpj;
	private String nomeBanco;
	private List<ContaBancaria> contasBancarias;
	
	public Banco(int cnpj, String nomeBanco) {
		
		this.cnpj = cnpj;
		this.nomeBanco = nomeBanco;
		this.contasBancarias = new ArrayList<ContaBancaria>();
	}
	
	public void adicionarNovaConta(int numeroConta, String nomeTitular) {
		
		// ContaBancaria contaBancaria = new ContaBancaria(numeroConta, nomeTitular);
		// this.contasBancarias.add(contaBancaria);
		
		this.contasBancarias.add(new ContaBancaria(numeroConta, nomeTitular));
	}
	
	public void listarContas() {
		
		for (ContaBancaria contaBancaria : contasBancarias) {
			System.out.println(contaBancaria);
		}
	}
	
	public void verificarSaldoConta(int numeroConta) {
		
		for (ContaBancaria contaBancaria : contasBancarias) {
			
			if (contaBancaria.getNumeroConta() == numeroConta) {
				
				contaBancaria.verificarSaldo();
				return;
			}
		}
		
		System.out.println("Conta inexistente.");
	}
	
	public void realizarSaqueConta(int numeroConta, Double valor) {
		
		for (ContaBancaria contaBancaria : contasBancarias) {
			
			if (contaBancaria.getNumeroConta() == numeroConta) {
				
				contaBancaria.realizarSaque(valor);
				return;
			}
		}
		
		System.out.println("Conta não encontrada.");
	}
	
	public void realizarDepositoConta(int numeroConta, Double valor) {
		
		for (ContaBancaria contaBancaria : contasBancarias) {
			
			if (contaBancaria.getNumeroConta() == numeroConta) {
				
				contaBancaria.realizarDeposito(valor);
				return;
			}
		}
		
		System.out.println("Conta não encontrada.");
	}
}
