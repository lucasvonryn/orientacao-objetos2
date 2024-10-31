package aula06.ex02;

public class ControleRemoto {

    private boolean televisaoLigada = false;

    public void ligarTelevisao() throws TelevisaoJaLigadaException {

        if (televisaoLigada) {

            throw new TelevisaoJaLigadaException("Televisão já ligada.");
        }

        televisaoLigada = true;
        System.out.println("Ligando televisão...");
    }

    public void desligarTelevisao() throws TelevisaoJaDesligadaException {

        if (!televisaoLigada) {

            throw new TelevisaoJaDesligadaException("Televisão já desligada.");
        }

        televisaoLigada = false;
        System.out.println("Desligando televisão...");
    }
}
