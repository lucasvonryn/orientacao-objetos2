package dto;

public class CursoDTO {

	private Integer codigo;
	private String nome;
	private String periodo;
	private Integer duracao;
	
	public CursoDTO() {

	}
	
	public CursoDTO(Integer codigo, String nome, String periodo, Integer duracao) {
		
		this.codigo = codigo;
		this.nome = nome;
		this.periodo = periodo;
		this.duracao = duracao;
	}
	
	@Override
	public String toString() {
		return "CursoDTO [codigo=" + codigo + ", nome=" + nome + ", periodo=" + periodo + ", duracao=" + duracao + "]";
	}


	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
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

	public Integer getDuracao() {
		return duracao;
	}

	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}
}
