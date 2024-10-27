package aula04.ex01;

public class QuadrilateroTeste {

    public static void main(String[] args) {
        
        Quadrado quadrado1 = new Quadrado("Azul", 3.0);
        Retangulo retangulo1 = new Retangulo("Verde", 30.0, 20.2);

        retangulo1.calcularArea();
        quadrado1.calcularPerimetro();
    }
}
