package listas.lista01.ex02;

public class CartaoCredito extends FormaPagamento {

	private Integer numeroCartao;
	private String nomeTitular;
	private String dataValidade;
	private Integer codigoSeguranca;
	
	public CartaoCredito(Double valorTotalCompra, Integer numeroCartao, String nomeTitular, String dataValidade,
			Integer codigoSeguranca) {
		super(valorTotalCompra);
		this.numeroCartao = numeroCartao;
		this.nomeTitular = nomeTitular;
		this.dataValidade = dataValidade;
		this.codigoSeguranca = codigoSeguranca;
	}
	
	@Override
	public void efetuarPagamentoTotal() {
		System.out.println(
			valorTotalCompra + "\n"	+
			numeroCartao + "\n"	+
			nomeTitular + "\n" +
			dataValidade + "\n"	+ 
			codigoSeguranca + "\n"	
		);
	}
}
