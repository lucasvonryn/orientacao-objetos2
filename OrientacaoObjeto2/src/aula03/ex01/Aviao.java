package aula03.ex01;

public class Aviao extends Veiculo {

    private Integer altitudeMaxima;

    public Aviao(String modelo, String fabricante, Integer ano, Integer numeroPassageiros, String combustivel,
            Integer altitudeMaxima) {

        super(modelo, fabricante, ano, numeroPassageiros, combustivel);
        this.altitudeMaxima = altitudeMaxima;
    }

    public void voar () {
        
        System.out.println(this.modelo + " está voando.");
    }

    public Integer getAltitudeMaxima() {

        return altitudeMaxima;
    }

    public void setAltitudeMaxima(Integer altitudeMaxima) {
        
        this.altitudeMaxima = altitudeMaxima;
    }
}
