package aula03;

public class Carro extends Veiculo {

    private Integer numeroPortas;

    public Carro(String modelo, String fabricante, Integer ano, Integer numeroPassageiros, String combustivel,
            Integer numeroPortas) {

        super(modelo, fabricante, ano, numeroPassageiros, combustivel);
    }

    public void calibrarPneus () {

    }

    public Integer getNumeroPortas() {

        return numeroPortas;
    }

    public void setNumeroPortas(Integer numeroPortas) {

        this.numeroPortas = numeroPortas;
    }
}
