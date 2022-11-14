package models.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao<entity> implements BaseInterDAO<entity> {
    private Connection con;
    
    synchronized public Connection getConnection() {
        if(con == null) {
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost/editorap","ufersa","ufersa123");
              //  con = DriverManager.getConnection("jdbc:mysql://www.db4free.net:3306/editorap","ufersa","ufersa123");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return con;
        }
        else return con;
    }

    
    @Override
    public boolean inserir(entity e) {
        // TODO Auto-generated method stub
        return false;
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
