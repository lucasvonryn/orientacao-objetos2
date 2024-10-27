package aula04.ex02;

import java.util.List;

public class Clinica {

    @SuppressWarnings("unused")
    private String cnpj;
    @SuppressWarnings("unused")
    private String razaoSocial;
    private List<Mamifero> animais;

    public Clinica(String cnpj, String razaoSocial) {

        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
    }

    public void cadastrar(Mamifero animal) {

        animais.add(animal);
    }

    public void listarAnimais() {

        for (Mamifero animal : animais) {
            
            animal.exibirDados();
        }
    }
}
