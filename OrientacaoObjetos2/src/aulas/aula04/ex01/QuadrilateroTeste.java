package aulas.aula04.ex01;

public class QuadrilateroTeste {
	public static void main(String[] args) {
		Quadrado quadrado = new Quadrado("Azul", 20.0);
		Retangulo retangulo = new Retangulo("Amarelo", 20.0, 10.0);
		Losango losango = new Losango("Vermelho", 10.0, 15.0, 5.0);
		
		ObraArte obraArte = new ObraArte("Lucas");
		obraArte.desenhar(quadrado);
		obraArte.desenhar(retangulo);
		obraArte.desenhar(losango);
		
		quadrado.calcularArea();
		quadrado.calcularPerimetro();
		
		System.out.println("===================================");
		
		retangulo.calcularArea();
		retangulo.calcularPerimetro();
		
		System.out.println("===================================");
		
		losango.calcularArea();
		losango.calcularPerimetro();
		
		System.out.println("===================================");
		
		obraArte.exibirObra();
		
	}
}
