package models.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controllers.dto.AddressDTO;
import controllers.dto.AuthorDTO;
import models.dao.AuthorDao;
import models.dao.BaseInterDAO;
import models.entities.Address;
import models.entities.Author;

public class AuthorBO {
	BaseInterDAO<Author> dao = new AuthorDao();
	
	public Author adicionar(AuthorDTO dto) throws SQLException {
		Author author = Author.converter(dto);
		
		return dao.inserir(author);	
	}
	
	public List<AuthorDTO> search(String name) {
        List<AuthorDTO> authors = new ArrayList<AuthorDTO>();
        ResultSet rs = dao.searchByNameOrTitle(name);
        
        try {
            while(rs.next()) {
                AuthorDTO author = new AuthorDTO();
                Address address = new Address();
                
                address.setCity(rs.getString("city"));
                address.setNeightboohood(rs.getString("neightboohood"));
                address.setNumber(rs.getString("number_house"));
                address.setStreet(rs.getString("street"));
                address.setZipcode(rs.getString("zipcode"));
                
                author.setCpf(rs.getString("taxId"));
                author.setAddress(address);
                author.setName(rs.getString("name"));
                author.setId(rs.getInt("id"));
                
                authors.add(author);
            }
            return authors;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
	
	public List<AuthorDTO> listar() {
	    List<AuthorDTO> authors = new ArrayList<AuthorDTO>();
        ResultSet rs = dao.findAll();
        
        try {
            while(rs.next()) {
                AuthorDTO author = new AuthorDTO();
                Address address = new Address();
                
                address.setCity(rs.getString("city"));
                address.setNeightboohood(rs.getString("neightboohood"));
                address.setNumber(rs.getString("number_house"));
                address.setStreet(rs.getString("street"));
                address.setZipcode(rs.getString("zipcode"));
                
                author.setCpf(rs.getString("taxId"));
                author.setAddress(address);
                author.setName(rs.getString("name"));
                author.setId(rs.getInt("id"));
                
                authors.add(author);
            }
            return authors;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
	}
	
	public boolean deletar(Author author) {
	    try {
            return dao.deletar(author);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
	}
	
	public Author findAuthorUnique(Author author) {
	    try {
            return dao.findById(author);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
	}
	
	public boolean updateAuthor(AuthorDTO author, String cpf) {
	    Author ath = Author.converter(author);
	    
	    try {
            return dao.alterar(ath, cpf);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
	}
}
