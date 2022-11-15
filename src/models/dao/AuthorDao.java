package models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.entities.Author;

public class AuthorDao extends BaseDao<Author> {
	Connection connection;
	
	public AuthorDao() {
		try {
			this.connection = new DatabaseConnection().getConnection();;
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
	
	@Override
    public ResultSet findAll() {
        String sql = "SELECT *, td2.id as id_address_table FROM tb_authors ta \n"
                + "LEFT JOIN tb_address ta2 ON ta2.id = ta.address_id;";
        
//        String sql = "SELECT * FROM tb_authors;";
        
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
	
	public Author inserir (Author author) throws SQLException {
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
			throw new SQLException();
		}				
	}
}
