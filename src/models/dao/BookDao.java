package models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Calendar;
import models.entities.Book;
import models.entities.Author;
import models.entities.Evaluator;

public class BookDao extends BaseDao<Book> {
	Connection connection;
	
	public BookDao() {
		try {
			this.connection = new DatabaseConnection().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
	
	@Override
    public ResultSet findAll() {
        String sql = "SELECT * FROM tb_books ta LEFT JOIN tb_address ta2 ON ta2.id = ta.address_id;";
        
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
	
	public Book inserir (Book book){
		String sql = "INSERT INTO tb_books(title,description,gender, year, status_register, id_author)VALUES (?,?,?,?,?,?);";
		String sql2 = "INSERT INTO books_evaluators(id_evaluator,id_book) VALUES(?,?);";
		try {
			PreparedStatement pst = this.connection.prepareStatement(sql);
            pst.setString(1, book.getTitle());
			pst.setString(2, book.getDescription());
			pst.setString(3, book.getGender());
			pst.setString(4, book.getDateLaunch());
            pst.setString(5, book.getStatus_register());
			pst.setInt(6, book.getAuthor().getId());
            pst.execute();
            
            String sqlSelect = "select * from tb_books where title=? and description=?;";
            PreparedStatement pstSelect = this.connection.prepareStatement(sqlSelect);
            
            pstSelect.setString(1, book.getTitle());
            pstSelect.setString(2, book.getDescription());
      
            ResultSet rs = pstSelect.executeQuery(); 
            
            if(rs.next()) {
                book.setId(rs.getInt("id"));
                PreparedStatement pstSelect1 = this.connection.prepareStatement(sql2);
                
                pstSelect1.setInt(1, book.getEvaluator().getId());
                pstSelect1.setInt(2, book.getId());
                pstSelect1.execute();
            }
            
            
			
			return book;		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}				
	}
	
	public boolean deletar(Book book) {
	    String sql = "DELETE FROM tb_books WHERE id=?;";
        try {
            PreparedStatement pst = this.connection.prepareStatement(sql);
            pst.setString(1, book.getTitle());
            pst.execute();
            
            return true;
        
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }   
    }

    public boolean alterar(Book book) {
        String sql = "UPDATE tb_books SET title=?,description=?,gender=?,dateLaunch=?, status_register=? WHERE title=? ";
        try {
            PreparedStatement pst = this.connection.prepareStatement(sql);
            pst.setString(1, book.getAuthor());
			pst.setString(2, book.getTitle());
			pst.setString(3, book.getDescription());
			pst.setString(4, book.getGender());
            pst.setString(5, book.getDateLaunch());
			pst.setString(6, book.getStatus_register());
            pst.executeUpdate();
            return true;        
        
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }   
        
    }

    public Book findByTitle(Book book) {
        String sql = "SELECT * FROM tb_books WHERE title=? ;";
        try {
            PreparedStatement pst = this.connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if(rs.next()) {
                Book a = new Book();
                a.setTitle(rs.getString("title"));
                a.setDescription(rs.getString("description"));
                a.setGender(rs.getString("gender"));
                a.setDateLaunch(null);
              /*a.setDateLaunch(rs.getString("dateLaunch"));
                como faz pra dateLaunch ser reconhecido como string?*/
                a.setStatus_register(rs.getString("status_register"));
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
        String sql = "SELECT * FROM tb_books;";
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

    public ResultSet findBySpecifiedField(Book book, String field) {
        return null;
    }
}
