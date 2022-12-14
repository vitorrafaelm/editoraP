package models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.entities.Address;

public class AddressDao extends BaseDao<Address> {
	
	Connection connection;
	
	public AddressDao() {
		try {
			this.connection = new DatabaseConnection().getConnection();;
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
    }
	
	public Address inserir (Address address) {
		String sql = "INSERT INTO tb_address (street,neightboohood,number_house,zipcode,city) VALUES (?,?,?,?,?);";
		try {
		    System.out.println(address.getStreet() + address.getNeightboohood() + address.getNumber() + address.getZipcode() + address.getCity());
			PreparedStatement pst = this.connection.prepareStatement(sql);
			pst.setString(1, address.getStreet());
			pst.setString(2, address.getNeightboohood());
			pst.setString(3, address.getNumber());
			pst.setString(4, address.getZipcode());
			pst.setString(5, address.getCity());
			pst.execute();
			
			String sqlSelect = "select * from tb_address where street=? and neightboohood=? and number_house=? and zipcode=?;";
			PreparedStatement pstSelect = this.connection.prepareStatement(sqlSelect);
			
			pstSelect.setString(1, address.getStreet());
			pstSelect.setString(2, address.getNeightboohood());
			pstSelect.setString(3, address.getNumber());
			pstSelect.setString(4, address.getZipcode());
			ResultSet rs = pstSelect.executeQuery(); 
			
			if(rs.next()) {
                address.setId(rs.getInt("id"));
                return address;
            }
			
			return null;		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}				
	}
	
	public boolean deletar(Address address) {
		String sql = "DELETE FROM tb_address WHERE id=?;";
		try {
			PreparedStatement pst = this.connection.prepareStatement(sql);
			pst.setInt(1, address.getId());
			pst.execute();
			
			return true;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	
	}
	
	public boolean alterar(Address address) {
		String sql = "UPDATE tb_address SET street=?,neightboohood=?,number_house=?,zipcode=?, city=? WHERE id=? ";
		try {
			PreparedStatement pst = this.connection.prepareStatement(sql);
			pst.setString(1, address.getStreet());
			pst.setString(2, address.getNeightboohood() );
			pst.setString(3, address.getNumber() );
			pst.setString(4, address.getZipcode());
			pst.setString(5, address.getCity());
			pst.setInt(6, address.getId());
			pst.executeUpdate();
			return true;		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	
		
	}
	
	public Address findById(Address address) {
		String sql = "SELECT * FROM tb_address WHERE id=? ;";
		try {
			PreparedStatement pst = this.connection.prepareStatement(sql);
			pst.setInt(1, address.getId());
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				Address a = new Address();
				a.setStreet(rs.getString("street"));
				a.setNeightboohood(rs.getString("neightboohood"));
				a.setNumber(rs.getString("number_house"));
				a.setZipcode(rs.getString("zipcode"));
				a.setId(address.getId());
				a.setCity(rs.getString("city"));
				return a;
			}
			else return null;
		
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			return null;
		}
	}

	public ResultSet findAll() {
		String sql = "SELECT * FROM tb_address;";
		try {
			PreparedStatement pst = this.connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			return rs;
		
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			return null;
		}
	}
	
	public ResultSet findBySpecifiedField(Address address, String field) {
		return null;
	}
}
