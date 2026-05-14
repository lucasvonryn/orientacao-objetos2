package dto;

import java.sql.Date;

public class AlunoDTO {

	private int registroAcademico;
	private String nome;
	private String sexo;
	private CursoDTO cursoDTO;
	private Date dataIngresso;
	private int periodo;
	private double coeficiente;
	
	public AlunoDTO() {
	
		this.cursoDTO = new CursoDTO();
	}

	public AlunoDTO(int registroAcademico, String nome, String sexo, CursoDTO cursoDTO, Date dataIngresso, int periodo,
			double coeficiente) {

		this.registroAcademico = registroAcademico;
		this.nome = nome;
		this.sexo = sexo;
		this.cursoDTO = cursoDTO;
		this.dataIngresso = dataIngresso;
		this.periodo = periodo;
		this.coeficiente = coeficiente;
	}

	public int getRegistroAcademico() {
		return registroAcademico;
	}

	public void setRegistroAcademico(int registroAcademico) {
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

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public double getCoeficiente() {
		return coeficiente;
	}

	public void setCoeficiente(double coeficiente) {
		this.coeficiente = coeficiente;
	}
}
