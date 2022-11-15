package controllers;

import javafx.scene.control.TextField;
import javafx.scene.control.SplitMenuButton;
import java.sql.SQLException;

import controllers.dto.BookDTO;
import controllers.dto.AuthorDTO;
import javafx.fxml.FXML;
import models.entities.Book;
import models.services.BookBO;
import models.entities.Author;
import models.services.AuthorBO;
import views.Telas;


public class BookRegister {
    @FXML private TextField titulo;
	@FXML private TextField descricao;
	@FXML private TextField genero;
	@FXML private TextField ano;
    @FXML private SplitMenuButton autor;
    @FXML private SplitMenuButton avaliador;

	private BookBO bo = new BookBO();
	
	public void cadastrar() throws SQLException {
		BookDTO dto = new BookDTO();
		dto.setTitle(titulo.getText());
		dto.setNeightboohood(descricao.getText());
		dto.setNumber(genero.getText());
		dto.setZipcode(ano.getText());
		
        
		bo.adicionar(dto); 
		
	}
}
