package models.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controllers.dto.BookDTO;
import controllers.dto.EvaluatorDTO;
import controllers.dto.UserDTO;
import controllers.dto.AddressDTO;
import models.dao.BookDao;
import models.dao.BaseInterDAO;
import models.entities.Book;
import models.entities.Evaluator;
import models.entities.Address;
import models.entities.Author;

public class BookBO{
    BookDao dao = new BookDao();

    private EvaluatorBO evaluatorBO = new EvaluatorBO();
    
    public Book adicionar(BookDTO dto) throws SQLException {
        Book book = Book.converter(dto);
        
        return dao.inserir(book);
    }
    
    public List<BookDTO> listar(){
        List<BookDTO> books = new ArrayList<BookDTO>();
        ResultSet rs = dao.findAll();
        try {
            while (rs.next()) {
                BookDTO book = new BookDTO();
                Author author = new Author(); 
                Evaluator eval = new Evaluator();
                   
                System.out.print(rs.getString("title"));
                System.out.print(rs.getString("description"));
                System.out.print(rs.getString("authorName"));
                
                book.setTitle(rs.getString("title"));
                book.setDescription(rs.getString("description"));
                book.setId(rs.getInt("id"));
                book.setGender(rs.getString("gender"));
                book.setDateLaunch(rs.getString("year"));
                book.setStatus_register(rs.getString("status_register"));
                
                author.setNome(rs.getString("authorName"));
                eval.setNome(rs.getString("evalName"));
               
                book.setAuthor(author);
                book.setEvaluator(eval);
                
                books.add(book);
                
            }
            return books;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
    
    public List<BookDTO> listarPorAvaliador(UserDTO user){
        List<BookDTO> books = new ArrayList<BookDTO>();
        
        
        
        ResultSet rs = dao.findByEvaluator(2);
        try {
            while (rs.next()) {
                BookDTO book = new BookDTO();
                Author author = new Author(); 
                Evaluator eval = new Evaluator();
                   
                System.out.print(rs.getString("title"));
                System.out.print(rs.getString("description"));
                System.out.print(rs.getString("authorName"));
                
                book.setTitle(rs.getString("title"));
                book.setDescription(rs.getString("description"));
                book.setId(rs.getInt("id"));
                book.setGender(rs.getString("gender"));
                book.setDateLaunch(rs.getString("year"));
                book.setStatus_register(rs.getString("status_register"));
                
                author.setNome(rs.getString("authorName"));
                eval.setNome(rs.getString("evalName"));
               
                book.setAuthor(author);
                book.setEvaluator(eval);
                
                books.add(book);
                
            }
            return books;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
    
    public List<BookDTO> search(String name){
        List<BookDTO> books = new ArrayList<BookDTO>();
        ResultSet rs = dao.searchByNameOrTitle(name);
        try {
            while (rs.next()) {
                BookDTO book = new BookDTO();
                Author author = new Author(); 
                Evaluator eval = new Evaluator();
                
                book.setTitle(rs.getString("title"));
                book.setDescription(rs.getString("description"));
                book.setId(rs.getInt("id"));
                book.setGender(rs.getString("gender"));
                book.setDateLaunch(rs.getString("year"));
                book.setStatus_register(rs.getString("status_register"));
                
                author.setNome(rs.getString("authorName"));
                eval.setNome(rs.getString("evalName"));
               
                book.setAuthor(author);
                book.setEvaluator(eval);
                
                books.add(book);
            }
            return books;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
    
    public List<BookDTO> relatory(String dataI, String dataF){
        List<BookDTO> books = new ArrayList<BookDTO>();
        ResultSet rs = dao.generateRelatory(dataI, dataF);
        try {
            while (rs.next()) {
                BookDTO book = new BookDTO();
                Author author = new Author(); 
                Evaluator eval = new Evaluator();
                
                book.setTitle(rs.getString("title"));
                book.setDescription(rs.getString("description"));
                book.setId(rs.getInt("id"));
                book.setGender(rs.getString("gender"));
                book.setDateLaunch(rs.getString("year"));
                book.setStatus_register(rs.getString("status_register"));
                
                author.setNome(rs.getString("authorName"));
                eval.setNome(rs.getString("evalName"));
               
                book.setAuthor(author);
                book.setEvaluator(eval);
                
                books.add(book);
            }
            return books;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
    
    public boolean atualizar (BookDTO book, int id) throws SQLException {
        Book bookss = Book.converter(book);
        if(dao.alterar(bookss, id) == true)
            return true;
            else return false;
        
    }
    
    public boolean apagar (Book book) throws SQLException {
        
        if(dao.deletar(book) == true) {
              return true;
          } else return false;   
    }
    
    public Book findBookUnique(Book book) {
        try {
            return dao.findBySpecifiedFieldAdmin(book, "tb_books.id");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }
    
    
    
}