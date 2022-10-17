package main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import models.dao.AddressDao;
import models.dao.DatabaseConnection;
import models.entities.Address;
import models.services.AddressBO;

public class Main {

	public static void main(String[] args) {
		Connection connection;
		
		try {
	       connection = new DatabaseConnection().getConnection();
	       
	       AddressDao dao = new AddressDao(connection);
	       AddressBO bo = new AddressBO(dao);
	       
	       Address ad = new Address(); 
	       ad.setStreet("null");
	       ad.setNeightboohood("null");
	       ad.setNumber("889655");
	       ad.setZipcode("5967-000");
	       	bo.adicionar(ad);
	       	List<Address> lista = bo.listar();
	       	System.out.println("aqui");
			for (Address a: lista) {
				System.out.println(a.getStreet());
			}
	       
	    } catch (SQLException ex) {
	       System.out.println("Database Connection Creation Failed : " + ex.getMessage());
	    }
		
		
	}

}
