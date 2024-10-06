package aula01.ex02;

public class PedidoTeste {

    public static void main(String[] args) {
        
        Pedido pedido1 = new Pedido(1, "01/01/2001");
        
        pedido1.imprimirPedido();

        pedido1.setStatus(Status.PROCESSANDO);
        pedido1.imprimirPedido();

        pedido1.setStatus(Status.ENVIADO);
        pedido1.imprimirPedido();

        pedido1.setStatus(Status.ENTREGUE);
        pedido1.imprimirPedido();
    }
}
