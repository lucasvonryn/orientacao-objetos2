package lista01.ex01;

public class Sessao {

    private String data;
    private String horario;
    private int numIngressos;
    private Sala sala;
    private Filme filme;

    public Sessao(String data, String horario, Sala sala, Filme filme) {

        this.data = data;
        this.horario = horario;
        this.numIngressos = sala.getCapacidadeMax();
        this.sala = sala;
        this.filme = filme;
    }

    public void venderIngresso(int qtd) {

        if (qtd > numIngressos) {
            System.out.println("Quantidade de ingressos não disponíveis.");
        } else {
            numIngressos -= qtd;
            System.out.println("Venda realizada com sucesso.");
        }
    }

    public void imprimirRelatorio() {

        System.out.println("Data: ");
    }
}
