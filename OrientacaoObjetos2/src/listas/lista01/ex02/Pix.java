package listas.lista01.ex02;

public class Pix extends FormaPagamento {
	
	private String chavePix;
	private String nomeDestinatario;
	
	public Pix(Double valorTotalCompra, String chavePix, String nomeDestinatario) {
		super(valorTotalCompra);
		this.chavePix = chavePix;
		this.nomeDestinatario = nomeDestinatario;
	}
	
	@Override
	public void efetuarPagamentoTotal() {
		System.out.println(
			valorTotalCompra + "\n"	+
			chavePix + "\n"	+
			nomeDestinatario + "\n"
		);
	}
}
