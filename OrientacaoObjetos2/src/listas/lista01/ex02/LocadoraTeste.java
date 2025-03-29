package listas.lista01.ex02;

public class LocadoraTeste {
	public static void main(String[] args) {
		Locadora locadora = new Locadora();
		
		Endereco endereco = new Endereco("Rua A", 123, "Centro", "12345-678", "São Paulo", "SP");
        locadora.cadastrarCliente("João Silva", "01/01/1990", "12345678900", "11999999999", endereco);
        
        locadora.cadastrarFilme("Vingadores", 120, 10.0);
        locadora.cadastrarFilme("Batman", 150, 12.5);
        
        locadora.locarFilme("12345678900", "Vingadores", 5);
        locadora.devolverFilme("Vingadores", 9); // Deve gerar multa
	}
}
