package aulas.aula08.ex01;

public class Lona {

	private String dimensoes;
	
	public Lona(String dimensoes) {
		
		this.dimensoes = dimensoes;
	}
	
	@Override
	public String toString() {
		
		return this.dimensoes;
	}
}
