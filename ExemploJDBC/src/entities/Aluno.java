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
}
