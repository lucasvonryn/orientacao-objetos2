package lista01.ex01;

public class Sala {

    private int id;
    private int capacidadeMax;

    public Sala(int id, int capacidadeMax) {

        this.id = id;
        this.capacidadeMax = capacidadeMax;
    }

    public int getCapacidadeMax() {

        return capacidadeMax;
    }
    
    public int getId() {
    	
    	return id;
    }
}
