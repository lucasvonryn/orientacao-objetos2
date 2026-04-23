package dao;

import java.sql.SQLException;
import java.util.List;

// T é o obejto e K é a chave do objeto
public interface DAO<T, K> {

	int cadastrar(T entidade) throws SQLException;
	
	List<T> buscarTodos() throws SQLException;
	
	T buscarPorChave(K chavePrimaria) throws SQLException;
	
	int atualizar(T entidade) throws SQLException;
	
	int excluir(K chavePrimaria) throws SQLException;
}
