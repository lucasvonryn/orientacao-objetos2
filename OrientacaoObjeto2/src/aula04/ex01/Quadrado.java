package aula04.ex01;

public class Quadrado extends Quadrilatero{

    private Double lado;

    public Quadrado(String cor, Double lado) {

        super(cor);
        this.lado = lado;
    }

    @Override
    public void calcularArea () {

        System.out.println("Área: " + Math.pow(lado, 3));
    }

    @Override
    public void calcularPerimetro () {

        System.out.println("Perímetro: " + (lado * 4));
    }
}