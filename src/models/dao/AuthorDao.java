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
			this.connection = new DatabaseConnection().getConnection();;
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
    }
	
	public Author inserir (Author author) throws SQLException {
		String sql = "INSERT INTO tb_author (name, cpf, id_address) VALUES (?,?,?);";
		try {
			PreparedStatement pst = this.connection.prepareStatement(sql);
			pst.setString(1, author.getNome());
			pst.setString(2, author.getCpf());
			pst.setString(3, author.getAdress().getId());
			pst.execute();
			
			return author;		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new SQLException();
		}				
	}

    public boolean deletar(Author author) {
        String sql = "DELETE FROM tb_author WHERE cpf=?;";
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

    public boolean alterar(Author author) {
        String sql = "UPDATE tb_author SET name=?,cpf=?,id_address=? WHERE cpf=? ";
        try {
            PreparedStatement pst = this.connection.prepareStatement(sql);
            pst.setString(1, author.getNome());
            pst.setString(2, author.getCpf() );
            pst.setString(3, author.getAdress().getId());
            pst.executeUpdate();
            return true;        
        
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }   
        
    }

    public Author findById(Author author) {
        String sql = "SELECT * FROM tb_author WHERE cpf=? ;";
        try {
            PreparedStatement pst = this.connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if(rs.next()) {
                Author a = new Author();
                a.setNome(rs.getString("name"));
                a.setCpf(rs.getString("cpf"));
              /*a.setAdress(rs.getString("adress"));
                como faz pra endereço ser reconhecido como string?*/

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
        String sql = "SELECT * FROM tb_author;";
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

    public ResultSet findBySpecifiedField(Author author, String field) {
        return null;
    }
}

// onde o dt deve ser retornado ?
// essa é a melhor forma de pegar exceptions ?
