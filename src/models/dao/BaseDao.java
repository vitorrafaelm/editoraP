package models.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao<entity> implements BaseInterDAO<entity> {
	@Override
	public entity inserir(entity e) throws SQLException {
		// TODO Auto-generated method stub
		return e;
	}

	@Override
	public boolean deletar(entity e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean alterar(entity e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public entity findById(entity e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet findBySpecifiedField(entity e, String field) {
		// TODO Auto-generated method stub
		return null;
	}
}
