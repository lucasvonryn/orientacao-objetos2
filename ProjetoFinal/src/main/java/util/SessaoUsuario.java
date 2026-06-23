package util;

public class SessaoUsuario {

	private static String usuarioLogado = "Sistema";

	public static String getUsuarioLogado() {
		return usuarioLogado;
	}

	public static void setUsuarioLogado(String usuario) {
		if (usuario == null || usuario.trim().isEmpty()) {
			usuarioLogado = "Sistema";
		} else {
			usuarioLogado = usuario.trim();
		}
	}
}
