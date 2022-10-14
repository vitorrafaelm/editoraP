package main;

import java.sql.Connection;
import java.sql.SQLException;

import models.dao.DatabaseConnection;

public class Main {

	public static void main(String[] args) {
		Connection connection;
		
		try {
	       connection = new DatabaseConnection().getConnection();
	    } catch (SQLException ex) {
	       System.out.println("Database Connection Creation Failed : " + ex.getMessage());
	    }
	}

}
