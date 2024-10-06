package aula02.ex02;

public class AgendaTeste {

    public static void main(String[] args) {
        
        Endereco endereco1 = new Endereco(1, "Rua1", "Bairro1", "Cidade1", "Estado1");
        Endereco endereco2 = new Endereco(2, "Rua2", "Bairro2", "Cidade2", "Estado2");
        Endereco endereco3 = new Endereco(3, "Rua3", "Bairro3", "Cidade3", "Estado3");

        Contato contato1 = new Contato("Nome1", "Sobrenome1", 1111, endereco1, "01/10/2010");
        Contato contato2 = new Contato("Nome2", "Sobrenome2", 2222, endereco2, "01/10/2010");
        Contato contato3 = new Contato("Nome3", "Sobrenome3", 3333, endereco3, "01/10/2010");
        Contato contato4 = new Contato("Marcus", "Vinícius", 4444, endereco3, "01/10/2010");

        Agenda agenda = new Agenda();

        agenda.adicionarContato(contato1);
        agenda.excluirContato(contato1);
        agenda.exibirContatos();

        agenda.adicionarContato(contato1);
        agenda.adicionarContato(contato2);
        agenda.adicionarContato(contato3);
        agenda.adicionarContato(contato4);
        agenda.exibirContatos();

        agenda.pesquisarContato("marc");
    }
}
