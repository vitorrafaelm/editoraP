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
	
	 public ResultSet searchByNameOrTitle(String name) {
	     String sql = "SELECT  *, ta.id as idAuhtor, ta.name as authorName, te.name as evalName FROM tb_books \n"
	             + "RIGHT JOIN tb_authors ta on ta.id = tb_books.id_author \n"
	             + "RIGHT JOIN books_evaluators eval on eval.id_book = tb_books.id \n"
	             + "RIGHT JOIN tb_evaluator te on te.id = eval.id_evaluator\n"
	             + "WHERE tb_books.title LIKE ?;";
	        
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
	 
	 public ResultSet generateRelatory(String dataIni, String dataFinal) {
	     String sql = "SELECT  *, ta.id as idAuhtor, ta.name as authorName, te.name as evalName FROM tb_books\n"
	             + "LEFT JOIN tb_authors ta on ta.id = tb_books.id_author \n"
	             + "LEFT JOIN books_evaluators eval on eval.id_book = tb_books.id \n"
	             + "RIGHT JOIN tb_evaluator te on te.id = eval.id_evaluator\n"
	             + "where tb_books.id is not null and tb_books.created_at BETWEEN ? AND ?";
            
            try {
                PreparedStatement pst = this.connection.prepareStatement(sql);
                pst.setString(1, dataIni);
                pst.setString(2, dataFinal);
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
        String sql = "SELECT  *, ta.id as idAuhtor, ta.name as authorName, te.name as evalName FROM tb_books\n"
                + "LEFT JOIN tb_authors ta on ta.id = tb_books.id_author \n"
                + "LEFT JOIN books_evaluators eval on eval.id_book = tb_books.id \n"
                + "RIGHT JOIN tb_evaluator te on te.id = eval.id_evaluator\n"
                + "where tb_books.id is not null;";
        
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
            pst.setInt(1, book.getId());
            pst.execute();
            
            return true;
        
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }   
    }

    public boolean alterar(Book book, int id) {
        // (id_evaluator,id_book) VALUES(?,?)
        String sql = "UPDATE tb_books SET title=?,description=?,gender=?,year=?, status_register=?, id_author=? WHERE id=? ";
        String sql2 = "UPDATE books_evaluators SET id_book=?, id_evaluator=? WHERE id_book=?;";
        System.out.print(book);
        try {
            PreparedStatement pst = this.connection.prepareStatement(sql);
            pst.setString(1, book.getTitle());
			pst.setString(2, book.getDescription());
			pst.setString(3, book.getGender());
			pst.setString(4, book.getDateLaunch());
            pst.setString(5, book.getStatus_register());
			pst.setInt(6, book.getAuthor().getId());
			pst.setInt(7, id);
            pst.executeUpdate();
            
            PreparedStatement pst2 = this.connection.prepareStatement(sql2);
            pst2.setInt(1, id);
            pst2.setInt(2, book.getEvaluator().getId());
            
            
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
    
    public ResultSet findByEvaluator(int id) {
        String sql = "SELECT  *, ta.id as idAuhtor, ta.name as authorName, te.name as evalName FROM tb_books " +
                    "LEFT JOIN tb_authors ta on ta.id = tb_books.id_author " +
                    "LEFT JOIN books_evaluators eval on eval.id_book = tb_books.id " +
                    "RIGHT JOIN tb_evaluator te on te.id = eval.id_evaluator WHERE te.id=?";
        
        try {
            PreparedStatement pst = this.connection.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            return rs;
        } catch (SQLException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
            return null;
        }
    }

    public Book findBySpecifiedFieldAdmin(Book book, String field) {
        String sql = "SELECT  *, ta.id as idAuhtor, ta.name as authorName, te.name as evalName, te.id as IdEval \n"
                + "FROM tb_books \n"
                + "LEFT JOIN tb_authors ta on ta.id = tb_books.id_author \n"
                + "LEFT JOIN books_evaluators eval on eval.id_book = tb_books.id \n"
                + "RIGHT JOIN tb_evaluator te on te.id = eval.id_evaluator \n"
                + "WHERE tb_books.id=?;";
        try {
            PreparedStatement pst = getConnection().prepareStatement(sql);
            switch (field) {
            case "id":
                pst.setInt(1, book.getId());
                break;
            default: 
                pst.setInt(1, book.getId());
            }
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()) {
                Book book2 = new Book();
                Author author = new Author(); 
                Evaluator eval = new Evaluator();
                
                author.setId(rs.getInt("idAuhtor"));
                author.setNome(rs.getString("authorName"));
                eval.setId(rs.getInt("IdEval"));
                eval.setNome(rs.getString("evalName"));
                
                book2.setId(rs.getInt("id"));
                book2.setTitle(rs.getString("title"));
                book2.setDescription(rs.getString("description"));
                book2.setGender(rs.getString("gender"));
                book2.setDateLaunch(rs.getString("year"));
                book2.setStatus_register(rs.getString("status_register"));
                book2.setAuthor(author);
                book2.setEvaluator(eval);; 
                
                return book2;
            }
            
            return null;
        
        } catch (SQLException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
            return null;
        }
    }
}
