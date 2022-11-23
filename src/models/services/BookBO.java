package models.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controllers.dto.BookDTO;
import controllers.dto.EvaluatorDTO;
import controllers.dto.AddressDTO;
import models.dao.BookDao;
import models.dao.BaseInterDAO;
import models.entities.Book;
import models.entities.Evaluator;
import models.entities.Address;

public class BookBO{
    BaseInterDAO<Book> dao = new BookDao();
    
    public Book adicionar(BookDTO dto) throws SQLException {
        Book book = Book.converter(dto);
        
        return dao.inserir(book);
    }
    
    public List<Book> listar(){
        List<Book> books = new ArrayList<Book>();
        ResultSet rs = dao.findAll();
        try {   
            while(rs.next()) {
                Book book = new Book();
                book.getTitle();
                book.getDescription();
                book.getGender();
                book.getDateLaunch();
                book.getStatus_register();
                book.getAuthor().getId();
                book.getEvaluator().getId();
                book.getId();
                
            }
            return books;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
    
    public boolean atualizar (BookDTO book) throws SQLException {
        Book bookss = Book.converter(book);
        
        Book boook = dao.findById(bookss);
        
        if(boook.getTitle().isEmpty()) {
            return false; 
        } else {
            if(dao.alterar(boook) == true)
                return true;
                else return false;
        }
    }
    
    
    public boolean apagar (Book book) {
        ResultSet rs = dao.findBySpecifiedField(book, "id");
        try {
            if(rs!=null && rs.next() ) {
                if(dao.deletar(book) == true)
                    return true;
                    else return false;
            }
            else return false;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }   
    }
}