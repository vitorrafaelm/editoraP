package models.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.entities.Address;

public class AddressDao extends BaseDao<Address> {
	
	Connection connection;
	
	public AddressDao(Connection connection) throws SQLException {
        this.connection = connection;
    }
	
	public boolean inserir (Address address) {
		String sql = "INSERT INTO tb_address (cpf,nome,telefone,endereco) VALUES (?,?,?,?);";
		try {
			PreparedStatement pst = this.connection.prepareStatement(sql);
			pst.setString(1, address.getStreet());
			pst.setString(2, address.getNeightboohood() );
			pst.setString(3, address.getNumber());
			pst.setString(4, address.getZipcode());
			pst.execute();
			return true;		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}				
	}
	
	public boolean deletar(Address address) {
		String sql = "DELETE FROM tb_address WHERE id=?;";
		try {
			PreparedStatement pst = this.connection.prepareStatement(sql);
			pst.setString(1, address.getId());
			pst.execute();
			
			return true;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	public boolean alterar(Address address) {
		String sql = "UPDATE tb_address SET cpf=?,nome=?,telefone=?,endereco=? WHERE cpf=? ";
		try {
			PreparedStatement pst = this.connection.prepareStatement(sql);
			pst.setString(1, address.getStreet());
			pst.setString(2, address.getNeightboohood() );
			pst.setString(3, address.getZipcode());
			pst.setString(4, address.getNumber());
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
				a.setStreet(rs.getString("street");
				a.setNeightboohood(rs.getString("neightboohood");
				a.setNumber(rs.getString("nome"));
				a.setZipcode(rs.getString("telefone"));
				a.setId(address.getId());
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
		// TODO Auto-generated method stub
		return null;
	}
}
