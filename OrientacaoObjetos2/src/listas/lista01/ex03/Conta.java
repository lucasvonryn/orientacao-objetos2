package listas.lista01.ex03;

import java.util.ArrayList;
import java.util.List;

public class Conta {
	private int id;
	private List<Prato> pratosConsumidos;
	private double valorTotal;
	
	public Conta(int id) {
		this.id = id;
		this.pratosConsumidos = new ArrayList<Prato>();
		this.valorTotal = 0.0;
	}
	
	public void adicionarPrato(Prato prato) {
		pratosConsumidos.add(prato);
		System.out.println("Prato adicionado com sucesso.");
	}
	
	public void fechar() {
		int i = 1;
		
		if (pratosConsumidos.size() <= 0) {
			System.out.println("Nenhum prato consumido.");
		} else {
			System.out.println("Pratos consumidos:");
			for (Prato prato : pratosConsumidos) {
				System.out.println(i);
				System.out.println("Prato: " + prato.getNome() + " | Preço: R$ " + prato.getPreco());
				valorTotal += prato.getPreco();
				i++;
			}
			valorTotal *= 1.1;
		}
		
		System.out.println("Valor total da conta: R$ " + valorTotal);
	}
}
