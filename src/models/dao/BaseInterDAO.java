package models.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface BaseInterDAO<entity> {
	public entity inserir (entity e) throws SQLException;
	public boolean deletar(entity e);
	public boolean alterar(entity e);
	public entity findById(entity e);
	public ResultSet findAll();
	public ResultSet findBySpecifiedField(entity e, String field);
}
