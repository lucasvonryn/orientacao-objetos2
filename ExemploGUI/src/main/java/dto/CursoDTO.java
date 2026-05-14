package dto;

public class CursoDTO {

	private int codigo;
	private String nome;
	private String periodo;
	private int duracao;
	
	public CursoDTO() {
	
	}
	
	public CursoDTO(int codigo, String nome, String periodo, int duracao) {
		
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	@Override
	public String toString() {
		return getNome();
	}
}
