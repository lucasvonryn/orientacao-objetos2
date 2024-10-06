package aula01.ex04;

public enum DiaSemana {

    DOMINGO(1, "domingo"),
    SEGUNDA(2, "segunda-feira"),
    TERCA(3, "terça-feira"),
    QUARTA(4, "quarta-feira"),
    QUINTA(5, "quinta-feira"),
    SEXTA(6, "sexta-feira"),
    SABADO(7, "sábado");

    private Integer numero;
    private String dia;

    private DiaSemana (Integer numero, String dia) {

        this.numero = numero;
        this.dia = dia;
    }

    public Integer getNumero () {

        return numero;
    }

    public String getDia () {

        return dia;
    }
}
