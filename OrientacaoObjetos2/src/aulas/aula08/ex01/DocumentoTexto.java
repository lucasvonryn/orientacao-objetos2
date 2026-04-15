package aulas.aula08.ex01;

public class DocumentoTexto {

	private String conteudo;
	
	public DocumentoTexto(String conteudo) {
		
		this.conteudo = conteudo;
	}
	
	@Override
	public String toString() {
		
		return this.conteudo;
	}
}
