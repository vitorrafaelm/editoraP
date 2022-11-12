package models;

import java.sql.Connection;
import java.sql.SQLException;

import models.dao.DatabaseConnection;

public class mainTest {

    public static void main(String[] args) throws SQLException {
        
        DatabaseConnection con = new DatabaseConnection(); 
        
        Connection c = con.getConnection(); 

    }

}
