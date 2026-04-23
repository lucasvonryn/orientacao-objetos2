package dto;

import java.sql.Date;

public class AlunoDTO {

	private Integer registroAcademico;
	private String nome;
	private String sexo;
	private CursoDTO cursoDTO;
	private Date dataIngresso;
	private Integer periodo;
	private Double coeficiente;
	
	public AlunoDTO() {
		
	}

	public AlunoDTO(Integer registroAcademico, String nome, String sexo, CursoDTO cursoDTO, Date dataIngresso,
			Integer periodo, Double coeficiente) {
		
		this.registroAcademico = registroAcademico;
		this.nome = nome;
		this.sexo = sexo;
		this.cursoDTO = cursoDTO;
		this.dataIngresso = dataIngresso;
		this.periodo = periodo;
		this.coeficiente = coeficiente;
	}
	
	@Override
	public String toString() {
		return "AlunoDTO [registroAcademico=" + registroAcademico + ", nome=" + nome + ", sexo=" + sexo + ", cursoDTO="
				+ cursoDTO + ", dataIngresso=" + dataIngresso + ", periodo=" + periodo + ", coeficiente=" + coeficiente
				+ "]";
	}

	public Integer getRegistroAcademico() {
		return registroAcademico;
	}

	public void setRegistroAcademico(Integer registroAcademico) {
		this.registroAcademico = registroAcademico;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public CursoDTO getCursoDTO() {
		return cursoDTO;
	}

	public void setCursoDTO(CursoDTO cursoDTO) {
		this.cursoDTO = cursoDTO;
	}

	public Date getDataIngresso() {
		return dataIngresso;
	}

	public void setDataIngresso(Date dataIngresso) {
		this.dataIngresso = dataIngresso;
	}

	public Integer getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}

	public Double getCoeficiente() {
		return coeficiente;
	}

	public void setCoeficiente(Double coeficiente) {
		this.coeficiente = coeficiente;
	}
}
