package aulas.aula08.generics;

public class Caixa<T> {

	private T objeto;
	
	public void guardar(T objeto) {
		
		this.objeto = objeto;
	}
	
	public T verificar() {
		
		return this.objeto;
	}
}
