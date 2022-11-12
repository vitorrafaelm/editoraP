package models.services;

import java.sql.SQLException;

import controllers.dto.AuthorDTO;
import models.dao.AuthorDao;
import models.dao.BaseInterDAO;
import models.entities.Author;

public class AuthorBO {
	BaseInterDAO<Author> dao = new AuthorDao();
	
	public Author adicionar(AuthorDTO dto) {
		
		
		// verificar se o autor já está cadastrado
		
		Author author = Author.converter(dto);
		
		try {
			return dao.inserir(author);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}	
		
	}
}
