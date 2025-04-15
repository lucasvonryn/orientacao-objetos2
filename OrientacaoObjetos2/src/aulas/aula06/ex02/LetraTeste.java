package aulas.aula06.ex02;

public class LetraTeste {
	
	public static void main(String[] args) {
		
		Letra letra = new Letra();
		
		try {
			letra.solicitarStrings();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			letra.compararStrings();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			letra.contarQtdCaracteres();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			letra.converterMinusculo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			letra.converterMaiusculo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}