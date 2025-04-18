package listas.lista02.ex04;

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
	
	public void alterarSenha(String nome, String senhaAtual, String novaSenha)
			throws UsuarioInvalidoException, SenhaInvalidaException {
		
		if (!this.nome.equals(nome)) {
			
			throw new UsuarioInvalidoException();
		}
		
		if (!this.senha.equals(senhaAtual)) {
			
			throw new SenhaInvalidaException();
		}
		
		// Se chegou aqui é por que nenhuma exceção foi disparada
		
		// VALIDAR NOVA SENHA
		// - A nova senha deve ser formada apenas por caracteres maíusculos
		// - Não deve conter números
		// - Utilizar dicas da lista02
		
		if (isValida(novaSenha)) {
			
			this.senha = novaSenha;
			System.out.println("A senha é válida. Alterada com sucesso.");
			
		} else {
			
			System.out.println("A senha é inválida. Não foi possível realizar a alteração.");
			
		}
	}
	
	protected boolean isValida(String novaSenha) {
		
		boolean senhaValida = false;
		
		for (char caractere : novaSenha.toCharArray()) {
			
			if (!Character.isLetter(caractere) || !Character.isUpperCase(caractere)) {
				senhaValida = false;
				break;
			}
			
			senhaValida = true;
		}
		
		return senhaValida; 
	}
}
