package aula03.ex01;

public class Carro extends Veiculo {

    private Integer numeroPortas;

    public Carro(String modelo, String fabricante, Integer ano, Integer numeroPassageiros, String combustivel,
            Integer numeroPortas) {

        super(modelo, fabricante, ano, numeroPassageiros, combustivel);
    }

    public void calibrarPneus () {
        
        System.out.println(this.modelo + " está calibrando os pneus.");
    }

    public Integer getNumeroPortas() {

        return numeroPortas;
    }

    public void setNumeroPortas(Integer numeroPortas) {

        this.numeroPortas = numeroPortas;
    }
}
