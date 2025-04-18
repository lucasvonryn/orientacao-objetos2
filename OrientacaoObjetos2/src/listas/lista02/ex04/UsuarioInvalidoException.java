package listas.lista02.ex04;

@SuppressWarnings("serial")
public class UsuarioInvalidoException extends Exception {

	public UsuarioInvalidoException() {
		
		super("Erro: O usuário inserido é inválido.");
	}
}
