package aulas.aula08.ex01;

public class ImpressoraTeste {

	public static void main(String[] args) {
		
		Impressora<Lona> impressoraLona = new Impressora<>();
		impressoraLona.adicionarDocumento(new Lona("lona1"));
		impressoraLona.adicionarDocumento(new Lona("lona2"));
		
		Impressora<DocumentoTexto> impressoraDocumentoTexto = new Impressora<>();
		impressoraDocumentoTexto.adicionarDocumento(new DocumentoTexto("conteudo2"));
		impressoraDocumentoTexto.adicionarDocumento(new DocumentoTexto("conteudo1"));
		
		Impressora<Adesivo> impressoraAdesivo = new Impressora<>();
		impressoraAdesivo.adicionarDocumento(new Adesivo("arquivo3"));
		impressoraAdesivo.adicionarDocumento(new Adesivo("arquivo1"));
		impressoraAdesivo.adicionarDocumento(new Adesivo("arquivo2"));
		
		impressoraLona.imprimir();
		impressoraDocumentoTexto.imprimir();
		impressoraAdesivo.imprimir();
	}
}
