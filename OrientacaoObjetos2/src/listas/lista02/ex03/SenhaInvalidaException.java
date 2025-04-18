package listas.lista02.ex03;

@SuppressWarnings("serial")
public class SenhaInvalidaException extends Exception {

	public SenhaInvalidaException() {
		
		super("Erro: A senha inserida é inválida.");
	}
}
