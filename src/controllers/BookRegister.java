package controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.ChoiceBox;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import controllers.dto.BookDTO;
import controllers.dto.AuthorDTO;
import models.entities.Book;
import models.services.BookBO;
import models.services.EvaluatorBO;
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
	private AuthorBO boAuthor = new AuthorBO();
	private EvaluatorBO boevaluator = new EvaluatorBO();
	
	public void cadastrar() throws SQLException {
		//BookDTO dto = new BookDTO();
		//dto.setTitle(titulo.getText());
		//dto.setNeightboohood(descricao.getText());
		//dto.setNumber(genero.getText());
		//dto.setZipcode(ano.getText());
		
        //Sem autor e avaliador por enquanto :(
		//bo.adicionar(dto); 
	    Telas.listBookScreen();
		
	}
	
	public void initialize() {
        // TODO Auto-generated method stub
	    adicionarInformacoes();
    }
	
	public void adicionarInformacoes() {
	   List<AuthorDTO> dtoAuthor = boAuthor.listar();
	   Map<Integer, String> authors = new HashMap<Integer, String>();
	   
	   for (int i = 0; i < dtoAuthor.size(); i++) {
	       authors.put(i , dtoAuthor.get(i).getId() + " - " + dtoAuthor.get(i).getName());
	   }
	   
	   autor.setItems(FXCollections.observableArrayList(authors.values()));
	   
	   // falta adicionar os avaliadores, segue o mesmo padrão
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
