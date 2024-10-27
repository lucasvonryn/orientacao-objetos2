package aula04.ex01;

public class Losango extends Quadrilatero {

    private Double diagonalMenor;
    private Double diagonalMaior;
    private Double lado;

    public Losango(String cor, Double diagonalMenor, Double diagonalMaior) {

        super(cor);
        this.diagonalMenor = diagonalMenor;
        this.diagonalMaior = diagonalMaior;
    }

    @Override
    public void calcularArea() {

        System.out.println("Área: " + ((diagonalMaior / diagonalMenor) / 2));
    }

    @Override
    public void calcularPerimetro() {

        System.out.println("Área: " + (4 * lado));
    }
}
