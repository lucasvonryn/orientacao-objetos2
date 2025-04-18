package listas.lista02.ex03;

public class UsuarioTeste {

	public static void main(String[] args) {
		
		
		try {
			
			Usuario usuario = new Usuario("Lucas", "123");
			
//			usuario.realizarLogin("Ronaldo", "123");
			usuario.realizarLogin("Lucas", "null");
			usuario.realizarLogin("Lucas", "123");
			
		} catch (UsuarioInvalidoException | SenhaInvalidaException e) {
			
			System.out.println(e.getMessage());
			
		}
		
	}
}
