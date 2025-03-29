package listas.lista01.ex02;

public class Filme {
	private String titulo;
	private int duracao;
	private double precoDiaria;
	private boolean locado;
	private int diaLocacao;
	private int diaPrevistoDevolucao;
	private int diaDevolucao;
	private Cliente clienteLocacao;
	private double multa;
	
	public Filme(String titulo, int duracao, double precoDiaria) {
		this.titulo = titulo;
		this.duracao = duracao;
		this.precoDiaria = precoDiaria;
		this.locado = false;
	}

	public boolean isLocado() {
		return locado;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void locar(Cliente cliente, int diaLocacao) {
		this.locado = true;
		this.clienteLocacao = cliente;
		this.diaLocacao = diaLocacao;
		this.diaPrevistoDevolucao = diaLocacao + 3;
		this.multa = 0;
	}
	
	public void devolver(int diaDevolucao) {
		this.diaDevolucao = diaDevolucao;
		this.locado = false;
		
		if (diaDevolucao > diaPrevistoDevolucao) { 
			int diasAtraso = diaDevolucao - diaPrevistoDevolucao;
			this.multa = diasAtraso * 2.0;
		} else {
			this.multa = 0;
		}
	}
	
	public void gerarRelatorio() {
        double valorTotal = precoDiaria + multa;
        System.out.println("\nRelatório da Locação:");
        System.out.println("Filme: " + titulo);
        System.out.println("Duração: " + duracao);
        System.out.println("Cliente: " + clienteLocacao.getNome());
        System.out.println("Dia da Locação: " + diaLocacao);
        System.out.println("Dia Previsto para Devolução: " + diaPrevistoDevolucao);
        System.out.println("Dia da Devolução: " + diaDevolucao);
        System.out.println("Valor da Locação: R$ " + precoDiaria);
        System.out.println("Multa: R$ " + multa);
        System.out.println("Valor Total: R$ " + valorTotal);
    }
}
