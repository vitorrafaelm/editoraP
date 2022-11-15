package models.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface BaseInterDAO<entity> {

    public Connection getConnection();
    public abstract entity inserir (entity e);
	//public entity inserir (entity e) throws SQLException;
	public boolean deletar(entity e);
	public boolean alterar(entity e);
	public boolean alterar(entity e, String search);
	public entity findById(entity e);
	public ResultSet findAll();
	public ResultSet findBySpecifiedField(entity e, String field);
}
