package aula03.ex01;

public class VeiculoTeste {

    public static void main(String[] args) {
        
        Carro carro1 = new Carro("Gol", "VW", 2005, 5, "Gasolina", 2);
        carro1.abastecer();
        carro1.calibrarPneus();

        Aviao aviao1 = new Aviao("A320", "Airbus", 2000, 198, "Querosene", 4000);
        aviao1.abastecer();
        aviao1.voar();
    }
}
