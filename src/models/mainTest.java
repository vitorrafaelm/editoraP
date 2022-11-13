package models;

import java.sql.Connection;
import java.sql.SQLException;

import models.dao.DatabaseConnection;

public class mainTest {


        
        DatabaseConnection con = new DatabaseConnection(); 
        
        Connection c = con.getConnection(); 

}
