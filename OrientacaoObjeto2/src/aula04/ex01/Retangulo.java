package aula04.ex01;

public class Retangulo extends Quadrilatero {

    private Double base;
    private Double altura;

    public Retangulo(String cor, Double base, Double altura) {
        super(cor);
        this.base = base;
        this.altura = altura;
    }
    
    @Override
    public void calcularArea () {

        System.out.println("Área: " + (base * altura));
    }

    @Override
    public void calcularPerimetro () {
        System.out.println("Perímetro: " + ((base * 2) + (altura * 2)));
    }
}
