package models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.entities.Address;
import models.entities.Author;
import models.entities.Evaluator;

public class AuthorDao extends BaseDao<Author> {
	Connection connection;
	
	public AuthorDao() {
		try {
			this.connection = new DatabaseConnection().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
	
	public ResultSet searchByNameOrTitle(String name) {
        String sql = "SELECT * FROM tb_authors ta LEFT JOIN tb_address ta2 ON ta2.id = ta.address_id\n"
                + "WHERE ta.name LIKE ?; ";
        
        try {
            PreparedStatement pst = this.connection.prepareStatement(sql);
            pst.setString(1, "%"+name+"%");
            ResultSet rs = pst.executeQuery();
            return rs;
        } catch (SQLException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
            return null;
        }
    }
	
	@Override
    public ResultSet findAll() {
        String sql = "SELECT * FROM tb_authors ta LEFT JOIN tb_address ta2 ON ta2.id = ta.address_id;";
        
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
	
	public Author inserir (Author author) {
		String sql = "INSERT INTO tb_authors (name, taxId, address_id) VALUES (?,?,?);";
		try {
			PreparedStatement pst = this.connection.prepareStatement(sql);
			pst.setString(1, author.getNome());
			pst.setString(2, author.getCpf());
			pst.setInt(3, author.getAdress().getId());
			pst.execute();
			
			return author;		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}				
	}
	
	public boolean deletar(Author author) {
	    String sql = "DELETE FROM tb_authors WHERE taxId=?;";
        try {
            PreparedStatement pst = this.connection.prepareStatement(sql);
            pst.setString(1, author.getCpf());
            pst.execute();
            
            return true;
        
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }   
    }

    public boolean alterar(Author author, String cpf) {
        String sql = "UPDATE tb_authors SET name=?,taxId=? WHERE taxId=? ";
        try {
            PreparedStatement pst = this.connection.prepareStatement(sql);
            pst.setString(1, author.getNome());
            pst.setString(2, author.getCpf());
            pst.setString(3, cpf);
            pst.executeUpdate();
            return true;        
        
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }   
        
    }

    public Author findById(Author author) {
        String sql = "SELECT * FROM tb_authors as ath LEFT JOIN tb_address as tba on tba.id = ath.address_id WHERE ath.taxId=? ;";
        try {
            PreparedStatement pst = this.connection.prepareStatement(sql);
            pst.setString(1, author.getCpf());
            ResultSet rs = pst.executeQuery();
            if(rs.next()) {
                Author author2 = new Author();
                Address address = new Address();
                
                address.setId(rs.getInt("address_id"));
                address.setCity(rs.getString("city"));
                address.setNeightboohood(rs.getString("neightboohood"));
                address.setNumber(rs.getString("number_house"));
                address.setStreet(rs.getString("street"));
                address.setZipcode(rs.getString("zipcode"));
                
                author2.setNome(rs.getString("name"));
                author2.setCpf(rs.getString("taxId"));
                author2.setAdress(address);

                return author2;
            }
            else return null;
        
        } catch (SQLException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
            return null;
        }
    }

    public ResultSet findBySpecifiedField(Author author, String field) {
        return null;
    }
}

