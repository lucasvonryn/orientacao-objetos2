package service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import dto.AlunoDTO;
import dto.CursoDTO;

public class AlunoService {

	private List<AlunoDTO> alunos;

	public AlunoService() {

		this.alunos = new ArrayList<>();

		this.alunos.add(new AlunoDTO(111111, "João da Silva", "Masculino", new CursoDTO(2, "Tecnologia em Análise e Desenvolvimento de Sistemas", "Noturno", 6), new Date(2020 - 1900, 02 - 1, 1), 4, 0.58));
		this.alunos.add(new AlunoDTO(222222, "Maria de Oliveira", "Feminino", new CursoDTO(4, "Licenciatura em Ciências Biológicas", "Integral", 8), new Date(2023 - 1900, 10 - 1, 20), 1, 0.00));
		this.alunos.add(new AlunoDTO(333333, "Ricardo Carvalho", "Masculino", new CursoDTO(1, "Bacharelado em Ciência da Computação", "Integral", 8), new Date(2020 - 1900, 10 - 1, 15), 6, 0.83));
	}

	public int cadastrar(AlunoDTO alunoDTO) {

		this.alunos.add(alunoDTO);
		return 1;
	}
	
	public List<AlunoDTO> buscarTodos() {

		return this.alunos;
	}
	
	public int atualizar(AlunoDTO alunoDTO) {
		
		for (int i = 0; i < this.alunos.size(); i++) {

	        AlunoDTO registroAluno = this.alunos.get(i);

	        if (registroAluno.getRegistroAcademico() == alunoDTO.getRegistroAcademico()) {

	            this.alunos.set(i, alunoDTO);
	            return 1;
	        }
	    }
		
		return 0;
	}
	
	public int excluir(int registroAcademico) {
		
		for (AlunoDTO alunoDTO : alunos) {
			
			if (alunoDTO.getRegistroAcademico() == registroAcademico) {
				
				alunos.remove(alunoDTO);
				return 1;
			}
		}
		
		return 0;
	}
}
