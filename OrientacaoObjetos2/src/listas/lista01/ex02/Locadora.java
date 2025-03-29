package listas.lista01.ex02;

import java.util.ArrayList;
import java.util.List;

public class Locadora {
	private List<Cliente> clientes;
	private List<Filme> filmes;
	
	public Locadora() {
		this.clientes = new ArrayList<Cliente>();
		this.filmes = new ArrayList<Filme>();
	}
	
	public void cadastrarCliente(String nome, String dataNascimento, String cpf, String telefone, Endereco endereco) {
		Cliente cliente = new Cliente(nome, dataNascimento, cpf, telefone, endereco);
		clientes.add(cliente);
		System.out.println("Cliente cadastrado com sucesso.");
	}
	
	public void cadastrarFilme(String titulo, int duracao, double precoDiaria) {
		Filme filme = new Filme(titulo, duracao, precoDiaria);
		filmes.add(filme);
		System.out.println("Filme cadastrado com sucesso.");
	}
	
	public void locarFilme(String cpf, String titulo, int diaLocacao) {
		Cliente cliente = buscarClientePorCpf(cpf);
		Filme filme = buscarFilmePorTitulo(titulo);
		
		if (cliente == null) {
			System.out.println("Cliente não encontrado.");
			return;
		}
		if (filme == null) {
			System.out.println("Filme não encontrado.");
			return;
		}
		if (filme.isLocado()) {
			System.out.println("Filme já está locado.");
			return;
		}
		
		filme.locar(cliente, diaLocacao);
		System.out.println("Filme locado com sucesso para " + cliente.getNome() + ". Devolução prevista para o dia " + (diaLocacao + 3));
	}
	
	public void devolverFilme(String titulo, int diaDevolucao) {
		Filme filme = buscarFilmePorTitulo(titulo);
		
		if (filme == null) {
			System.out.println("Filme não encontrado.");
			return;
		}
		if (!filme.isLocado()) {
			System.out.println("Filme não está locado.");
			return;
		}
		
		filme.devolver(diaDevolucao);
		System.out.println("Filme devolvido com sucesso.");
		filme.gerarRelatorio();
	}
	
	private	Cliente buscarClientePorCpf(String cpf) {
		for (Cliente cliente : clientes) {
			if (cliente.getCpf().equals(cpf)) {
				return cliente;
			}
		}
		return null;
	}
	
	private Filme buscarFilmePorTitulo(String titulo) {
		for (Filme filme : filmes) {
			if (filme.getTitulo().equals(titulo)) {
				return filme;
			}
		}
		return null;
	}
}
