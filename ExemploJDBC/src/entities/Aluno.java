package entities;

import java.sql.Date;

public class Aluno {

	private int registroAcademico;
	private String nome;
	private String sexo;
	private Curso curso;
	private Date dataIngresso;
	private int periodo;
	private double coeficiente;
	
	public Aluno() {
		
		this.curso = new Curso();
	}
	
	public Aluno(int registroAcademico,
				 String nome,
				 String sexo,
				 Date dataIngresso,
				 int periodo,
				 double coeficiente) {
		
		this.registroAcademico = registroAcademico;
		this.nome = nome;
		this.sexo = sexo;
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

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
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
