package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.BancoDados;
import dao.CursoDAO;
import dto.CursoDTO;

public class CursoService {

	public CursoService() {
		
	}
	
	public int cadastrar(CursoDTO cursoDTO) throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		return new CursoDAO(conn).cadastrar(cursoDTO);
	}

	public List<CursoDTO> buscarTodos() throws SQLException, IOException {

		Connection conn = BancoDados.conectar();
		return new CursoDAO(conn).buscarTodos();
	}
	
	public CursoDTO buscarPorChave(Integer chavePrimaria) throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		return new CursoDAO(conn).buscarPorChave(chavePrimaria);
	}
}
