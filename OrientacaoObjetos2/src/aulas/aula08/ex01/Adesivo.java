package aulas.aula08.ex01;

public class Adesivo {

	private String nomeArquivo;
	
	public Adesivo(String nomeArquivo) {
		
		this.nomeArquivo = nomeArquivo;
	}
	
	@Override
	public String toString() {
		
		return this.nomeArquivo;
	}
}
