package models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	
	public Author inserir (Author author) throws SQLException {
		String sql = "INSERT INTO tb_authors (name, cpf, id_address) VALUES (?,?,?);";
		try {
			PreparedStatement pst = this.connection.prepareStatement(sql);
			pst.setString(1, author.getNome());
			pst.setString(2, author.getCpf());
			pst.setString(2, author.getAdress().getId());
			pst.execute();
			
			return author;		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new SQLException();
		}				
	}
}

// onde o dt deve ser retornado ?
// essa é a melhor forma de pegar exceptions ?
