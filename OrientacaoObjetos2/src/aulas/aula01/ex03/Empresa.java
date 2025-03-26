package aulas.aula01.ex03;

public class Empresa {

	public String razaoSocial;
	public String cnpj;
	public UnidadeFederativa uf;
	
	public Empresa(String razaoSocial, String cnpj) {

		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
	}
	
	public void setUnidadeFederativa(UnidadeFederativa unidadeFederativa) {
		this.uf = unidadeFederativa;
	}
	
	public void imprimirDados() {
		
		System.out.println("Razão social: " + razaoSocial);
		System.out.println("CNPJ: " + cnpj);
		System.out.println("UF: " + uf);
		System.out.println("Nome da UF: " + uf.getNomeUnidadeFederativa());
		System.out.println("Capital da UF: " + uf.getNomeCapital());
	}
}
