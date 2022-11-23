package controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.ChoiceBox;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import controllers.dto.BookDTO;
import controllers.dto.AuthorDTO;
import models.entities.Book;
import models.entities.Evaluator;
import models.services.BookBO;
import models.services.EvaluatorBO;
import controllers.dto.EvaluatorDTO;
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
		BookDTO dto = new BookDTO();
		dto.setTitle(titulo.getText());
		dto.setDescription(descricao.getText());
		dto.setGender(genero.getText());
		dto.setDateLaunch(ano.getText());
		dto.setStatus_register("criado");
		
        Author dto1 = new Author();
        dto.setAuthor(dto1);
        Evaluator dto2 = new Evaluator();
        dto.setEvaluator(dto2);
		
        bo.adicionar(dto);
	    Telas.listBookScreen();
		
	    String authr = autor.getSelectionModel().getSelectedItem();
	    String evaluat = avaliador.getSelectionModel().getSelectedItem();
	    System.out.println(authr);
	    System.out.println(evaluat);
	    
	    Pattern pattern = Pattern.compile("(\\d*)\\s*-", Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(authr);
	    
	    System.out.println(matcher.group());
	    matcher = pattern.matcher(evaluat);
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
	   
	   List<EvaluatorDTO> dtoEvaluator = boevaluator.listar();
       Map<Integer, String> evaluators = new HashMap<Integer, String>();
       
       for (int i = 0; i < dtoEvaluator.size(); i++) {
           evaluators.put(i , dtoEvaluator.get(i).getId() + " - " + dtoEvaluator.get(i).getName());
       }
       
       avaliador.setItems(FXCollections.observableArrayList(evaluators.values()));
	   
	   // falta adicionar os avaliadores, segue o mesmo padrão
	}

	public void navigateToHomeScreen() {
        Telas.telaHomePage();
    }
    
    public void navigateToListAuthorsScreen() {
        Telas.listAuthorScreen();
    }
    
    public void navigateToListBooksScreen() {
        Telas.listBookScreen();
    }
    
    public void navigateToListEvaluatorsScreen() {
        Telas.listEvaluatorScreen();;
    }
    
    public void navigateToListRelatoryScreen() {
        // adicionar tela de relatório
    }
    
    public void logout() {
        Telas.telaLogin();
    }
}
