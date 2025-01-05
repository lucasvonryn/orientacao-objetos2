package lista01.ex01;

public class SessaoTeste {

	public static void main(String[] args) {
		
		Sala sala1 = new Sala(1, 50);
		Filme filme1 = new Filme("Mad Max", 124);
		
		Sessao sessao1 = new Sessao("01/10/2010", "18:00", sala1, filme1);
		
		sessao1.imprimirRelatorio();
		sessao1.venderIngresso(51);
		sessao1.venderIngresso(20);
		sessao1.imprimirRelatorio();
	}
}