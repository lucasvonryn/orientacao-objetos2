package listas.lista01.ex01;

public class SessaoTeste {

	public static void main(String[] args) {
		
		Filme filme = new Filme("Carros", 180);
		Sala sala = new Sala(1, 100);
		Sessao sessao = new Sessao("01/04/2005", "18:00", sala, filme);
		
		sessao.exibirRelatorio();
		sessao.venderIngressos(101);
		sessao.venderIngressos(50);
		sessao.exibirRelatorio();
	}
}
