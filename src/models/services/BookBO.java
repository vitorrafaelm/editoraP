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

public class BookBO {
    BaseInterDAO<Book> dao = new BookDao();
	
	public Book adicionar(BookDTO dto) throws SQLException {
		Book book = Book.converter(dto);
		
		return dao.inserir(book);	
	}
	
	public List<BookDTO> listar() {
	    List<BookDTO> books = new ArrayList<BookDTO>();
        ResultSet rs = dao.findAll();
        
        try {
            while(rs.next()) {
                BookDTO book = new BookDTO();
                EvaluatorDTO evaluator = new EvaluatorDTO();
                AddressDTO address = new AddressDTO();

                
                address.setCity(rs.getString("city"));
                address.setNeightboohood(rs.getString("neightboohood"));
                address.setNumber(rs.getString("number_house"));
                address.setStreet(rs.getString("street"));
                address.setZipcode(rs.getString("zipcode"));
                
                evaluator.setCpf(rs.getString("cpf"));
                evaluator.setAddress(address);
                evaluator.setName(rs.getString("nome"));

                book.setTitle(rs.getString("titulo"));
                book.setDateLaunch(rs.getString("ano"));
                book.setDescription(rs.getString("descricao"));
                book.setGender(rs.getString("genero"));
                //book.setEvaluator()
                
                book.add(book);
            }
            return books;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
	}
	
	public boolean deletar(Book book) {
	    try {
            return dao.deletar(book);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
	    
	}
}
