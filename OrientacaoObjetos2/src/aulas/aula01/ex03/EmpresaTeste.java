package aulas.aula01.ex03;

public class EmpresaTeste {

	public static void main(String[] args) {
		
		Empresa empresa1 = new Empresa("Webfloat", "1111.123.213-11");
		
		empresa1.setUnidadeFederativa(UnidadeFederativa.PR);
		
		empresa1.imprimirDados();
	}
}
