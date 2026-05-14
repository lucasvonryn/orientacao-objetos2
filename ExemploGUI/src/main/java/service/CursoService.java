package service;

import java.util.ArrayList;
import java.util.List;

import dto.CursoDTO;

public class CursoService {

	private List<CursoDTO> cursos;

	public CursoService() {

		this.cursos = new ArrayList<>();

		this.cursos.add(new CursoDTO(1, "Bacharelado em Ciência da Computação", "Integral", 8));
		this.cursos.add(new CursoDTO(2, "Tecnologia em Análise e Desenvolvimento de Sistemas", "Noturno", 6));
		this.cursos.add(new CursoDTO(3, "Engenharia Mecânica", "Integral", 10));
		this.cursos.add(new CursoDTO(4, "Licenciatura em Ciências Biológicas", "Integral", 8));
	}

	public List<CursoDTO> buscarTodos() {

		return this.cursos;
	}
}
