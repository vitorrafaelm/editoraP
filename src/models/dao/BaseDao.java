package models.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import controllers.dto.UserDTO;
import exceptions.AuthenticationException;

public class BaseDao<entity> implements BaseInterDAO<entity> {
    private Connection con;
    
    synchronized public Connection getConnection() {
        if(con == null) {
            try {
                // con = DriverManager.getConnection("jdbc:mysql://localhost/editorap","ufersa","ufersa123");
                con = DriverManager.getConnection("jdbc:mysql://www.db4free.net:3306/editorap","ufersa","ufersa123");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return con;
        }
        else return con;
    }

    
    @Override
    public entity inserir(entity e) {
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
	
	public boolean alterar(entity e, String search) {
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


    @Override
    public entity findBySpecifiedFieldAdmin(entity e, String field) {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public boolean alterar(entity e, int search) {
        // TODO Auto-generated method stub
        return false;
    }


    @Override
    public ResultSet searchByNameOrTitle(String name) {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public ResultSet generateRelatory(String dataIni, String dataFinal) {
        // TODO Auto-generated method stub
        return null;
    }
}
