package listas.lista02.ex03;

@SuppressWarnings("serial")
public class UsuarioInvalidoException extends Exception {

	public UsuarioInvalidoException() {
		
		super("Erro: O usuário inserido é inválido.");
	}
}
