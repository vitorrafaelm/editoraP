package models.dao;

import java.sql.ResultSet;

public interface BaseInterDAO<entity> {
	public boolean inserir (entity e);
	public boolean deletar(entity e);
	public boolean alterar(entity e);
	public entity findById(entity e);
	public ResultSet findAll();
	public ResultSet findBySpecifiedField(entity e, String field);
}
