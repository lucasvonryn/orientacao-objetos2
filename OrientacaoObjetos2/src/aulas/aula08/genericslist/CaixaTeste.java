package aulas.aula08.genericslist;

public class CaixaTeste {

	public static void main(String[] args) {
		
		Bola bola = new Bola();
		Carrinho carrinho = new Carrinho();
		Prato prato = new Prato();
		Copo copo = new Copo();
		
		Caixa<Brinquedo> caixaBrinquedo = new Caixa<>();
		caixaBrinquedo.guardar(carrinho);
		caixaBrinquedo.guardar(bola);
		
		Caixa<Louca> caixaLouca = new Caixa<>();
		caixaLouca.guardar(prato);
		caixaLouca.guardar(copo);
		
		caixaBrinquedo.verificarConteudo();
		caixaLouca.verificarConteudo();
	}
}
