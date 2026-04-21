package listas.lista01.ex02;

public class Boleto extends FormaPagamento {
	
	private String dataVencimento;
	private String codigoBarras;

	public Boleto(Double valorTotalCompra, String dataVencimento, String codigoBarras) {
		super(valorTotalCompra);
		this.dataVencimento = dataVencimento;
		this.codigoBarras = codigoBarras;
	}

	@Override
	public void efetuarPagamentoTotal() {
		System.out.println(
			valorTotalCompra + "\n"	+
			dataVencimento + "\n" +
			codigoBarras + "\n"
		);
	}

}
