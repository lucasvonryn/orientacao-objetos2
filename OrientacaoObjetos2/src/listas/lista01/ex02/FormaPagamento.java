package listas.lista01.ex02;

public abstract class FormaPagamento {

	protected Double valorTotalCompra;
	
	public FormaPagamento(Double valorTotalCompra) {
		this.valorTotalCompra = valorTotalCompra;
	}
	
	public abstract void efetuarPagamentoTotal();
}
