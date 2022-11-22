package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.ChoiceBox;
import java.sql.SQLException;

import controllers.dto.BookDTO;
import controllers.dto.AuthorDTO;
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
    @FXML private ChoiceBox<String> autor;
    @FXML private ChoiceBox<String> avaliador;

	private BookBO bo = new BookBO();
	
	public void cadastrar() throws SQLException {
		BookDTO dto = new BookDTO();
		dto.setTitle(titulo.getText());
		dto.setNeightboohood(descricao.getText());
		dto.setNumber(genero.getText());
		dto.setZipcode(ano.getText());
		
        //Sem autor e avaliador por enquanto :(
		bo.adicionar(dto); 
		
	}

	public void navigateToBookScr() {
        Telas.listBookScreen();
    }
	
	public void navigateToListAuthorsScreen() {
        Telas.listAuthorScreen();
    }
    
    public void navigateToListBooksScreen() {
        Telas.listBookScreen();
    }
    
    public void navigateToListEvaluatorsScreen() {
        Telas.listBookScreen();
    }
    
    public void navigateToListRelatoryScreen() {
        Telas.listAuthorScreen();
    }
}
