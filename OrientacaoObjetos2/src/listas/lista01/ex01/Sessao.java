package listas.lista01.ex01;

public class Sessao {

	private String data;
	private String horario;
	private int ingressosDisp;
	private Sala sala;
	private Filme filme;
	private int totIngressosVend;
	
	public Sessao(String data, String horario, Sala sala, Filme filme) {

		this.data = data;
		this.horario = horario;
		this.sala = sala;
		this.filme = filme;
		this.ingressosDisp = sala.getCapacidadeMax();
		this.totIngressosVend = 0;
	}
	
	public void venderIngressos(int qtd) {
		
		if (ingressosDisp >= qtd) {
			ingressosDisp -= qtd;
			totIngressosVend += qtd;
			System.out.println("Venda concluída.");
		} else {
			System.out.println("Essa quantidade de ingressos não está disponível.");
		}
	}
	
	public void exibirRelatorio() {
		
		System.out.println("--- Relatório ---");
		System.out.println("Data da sessão: " + data);
		System.out.println("Total de ingressos vendidos: " + totIngressosVend);
		System.out.println("Total de ingressos disponíveis: " + ingressosDisp);
		System.out.println("Número da sala: " + sala.getNumero());
		System.out.println("Título do filme: " + filme.getTitulo());
		System.out.println("Duração em min. do filme: " + filme.getDuracaoMinutos());
	}
}
