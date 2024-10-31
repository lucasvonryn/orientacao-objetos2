package aula06.ex02;

public class ControleRemotoTeste {

    public static void main(String[] args) {
        
        ControleRemoto controle = new ControleRemoto();

        try {

            controle.desligarTelevisao();

        } catch (TelevisaoJaDesligadaException tjde) {

            System.out.println(tjde.getMessage());
        }

        try {

            controle.ligarTelevisao();

        } catch (TelevisaoJaLigadaException tjle) {

            System.out.println(tjle.getMessage());
        }

        try {

            controle.ligarTelevisao();

        } catch (TelevisaoJaLigadaException tjle) {

            System.out.println(tjle.getMessage());
        }
    }
}
