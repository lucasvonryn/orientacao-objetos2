package entities;

public class Curso {

	private int codigo;
	private String nome;
	private String periodo;
	private int duracao;
	
	public Curso() {
		
	}
	
	public Curso(int codigo,
				 String nome,
				 String periodo,
				 int duracao) {
		
		this.codigo = codigo;
		this.nome = nome;
		this.periodo = periodo;
		this.duracao = duracao;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getPeriodo() {
		return periodo;
	}
	
	public int getDuracao() {
		return duracao;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
}
