package aula01.ex02;

public class Pedido {

    private Integer id;
    private String dataGeracao;
    private Status status;

    public Pedido (Integer id, String dataGeracao) {

        this.id = id;
        this.dataGeracao = dataGeracao;
        this.status = Status.AGUARDANDO_PAGAMENTO;
    }

    public void imprimirPedido () {

        System.out.println(
            "-----------------------------" +
            "\nCódigo: " + this.id +
            "\nData: " + this.dataGeracao +
            "\nStatus: " + this.status
        );
    }

    public void setStatus (Status novoStatus) {

        this.status = novoStatus;
    }
}
