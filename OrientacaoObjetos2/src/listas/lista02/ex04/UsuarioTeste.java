package listas.lista02.ex04;

public class UsuarioTeste {

	public static void main(String[] args) {
		
		
		try {
			
			Usuario usuario = new Usuario("Lucas", "123");
			
//			usuario.realizarLogin("Ronaldo", "123");
//			usuario.realizarLogin("Lucas", "null");
			usuario.realizarLogin("Lucas", "123");
			usuario.alterarSenha("Lucas", "123", "LUCAS");
//			usuario.realizarLogin("Lucas", "123");
			usuario.realizarLogin("Lucas", "LUCAS");
			
		} catch (UsuarioInvalidoException | SenhaInvalidaException e) {
			
			System.out.println(e.getMessage());
			
		}
		
	}
}
