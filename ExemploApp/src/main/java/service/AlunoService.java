package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.AlunoDAO;
import dao.BancoDados;
import dto.AlunoDTO;
import dto.CursoDTO;

public class AlunoService {

	public AlunoService() {

	}

	public List<AlunoDTO> buscarTodos() throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		List<AlunoDTO> listaAlunos = new AlunoDAO(conn).buscarTodos();
		
		for (AlunoDTO alunoDTO : listaAlunos) {
			CursoDTO cursoDTO = new CursoService().buscarPorChave(alunoDTO.getCursoDTO().getCodigo());
			alunoDTO.setCursoDTO(cursoDTO);
		}
		return listaAlunos;
	}
	
	public int cadastrar(AlunoDTO alunoDTO) throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		return new AlunoDAO(conn).cadastrar(alunoDTO);
	}
	
	public int atualizar(AlunoDTO alunoDTO) throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		return new AlunoDAO(conn).atualizar(alunoDTO);
	}
	
	public int excluir(int registroAcademico) throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		return new AlunoDAO(conn).excluir(registroAcademico);
	}
}
