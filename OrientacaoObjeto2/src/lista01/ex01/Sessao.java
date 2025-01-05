package lista01.ex01;

public class Sessao {

    private String data;
    private String horario;
    private int numIngressosDisp;
    private Sala sala;
    private Filme filme;
    private int totIngressosVendidos;

    public Sessao(String data, String horario, Sala sala, Filme filme) {
    	
        this.data = data;
        this.horario = horario;
        this.numIngressosDisp = sala.getCapacidadeMax();
        this.sala = sala;
        this.filme = filme;
        this.totIngressosVendidos = 0;
    }

    public void venderIngresso(int qtd) {
    	
        if (qtd > numIngressosDisp) {
            System.out.println("Quantidade de ingressos não disponíveis.");
        } else {
            numIngressosDisp -= qtd;
            totIngressosVendidos += qtd;
            System.out.println("Venda realizada com sucesso.");
        }
    }

    public void imprimirRelatorio() {

        System.out.println("Data: " + this.data);
        System.out.println("\nHorário: " + this.horario);
        System.out.println("\nTotal de ingressos vendidos: " + this.totIngressosVendidos);
        System.out.println("\nIngressos disponíveis: " + this.numIngressosDisp);
        System.out.println("\nNúmero da sala da sessão: " + this.sala.getId());
        System.out.println("\nTítulo do filme: " + this.filme.getTitulo());
        System.out.println("\nDuração em minutos" + this.filme.getDuracao());
    }
}
