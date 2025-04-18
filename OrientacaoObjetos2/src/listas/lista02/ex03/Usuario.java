package listas.lista02.ex03;

public class Usuario {

	private String nome;
	private String senha;
	
	public Usuario(String nome, String senha) {
		
		this.nome = nome;
		this.senha = senha;
	}
	
	public void realizarLogin(String nome, String senha) 
			throws UsuarioInvalidoException, SenhaInvalidaException {
		
		if (!this.nome.equals(nome)) {
			
			throw new UsuarioInvalidoException();
		}
		
		if (!this.senha.equals(senha)) {
			
			throw new SenhaInvalidaException();
		}
		
		System.out.println("Login realizado com sucesso.");
	}
}
