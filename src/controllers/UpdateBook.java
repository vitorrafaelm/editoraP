package controllers;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import controllers.dto.AuthorDTO;
import controllers.dto.BookDTO;
import controllers.dto.EvaluatorDTO;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import models.entities.Author;
import models.entities.Book;
import models.entities.Evaluator;
import models.services.AuthorBO;
import models.services.BookBO;
import models.services.EvaluatorBO;
import views.Telas;

public class UpdateBook {
    @FXML private TextField titulo;
    @FXML private TextField descricao;
    @FXML private TextField genero;
    @FXML private TextField ano;
    @FXML private ChoiceBox<String> autor;
    @FXML private ChoiceBox<String> avaliador;

    private BookBO bo = new BookBO();
    private AuthorBO boAuthor = new AuthorBO();
    private EvaluatorBO boevaluator = new EvaluatorBO();
    
    public void updateBook() throws SQLException {
        BookDTO dto = new BookDTO();
        dto.setTitle(titulo.getText());
        dto.setDescription(descricao.getText());
        dto.setGender(genero.getText());
        dto.setDateLaunch(ano.getText());
        dto.setStatus_register("criado");
        
        int authr = Integer.parseInt(autor.getSelectionModel().getSelectedItem().replaceAll("\\s*-\\D*", ""));
        int evaluat = Integer.parseInt(avaliador.getSelectionModel().getSelectedItem().replaceAll("\\s*-\\D*", ""));
        
        Author dto1 = new Author();
        dto1.setId(authr);
        dto.setAuthor(dto1);
        Evaluator dto2 = new Evaluator();
        dto2.setId(evaluat);
        dto.setEvaluator(dto2);
        
        bo.atualizar(dto, ListBookScreen.currentBookToEdit.getId());
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
       
       List<EvaluatorDTO> dtoEvaluator = boevaluator.listar();
       Map<Integer, String> evaluators = new HashMap<Integer, String>();
       
       for (int i = 0; i < dtoEvaluator.size(); i++) {
           evaluators.put(i , dtoEvaluator.get(i).getId() + " - " + dtoEvaluator.get(i).getName());
       }
       
       avaliador.setItems(FXCollections.observableArrayList(evaluators.values()));
       
       Book book = bo.findBookUnique(ListBookScreen.currentBookToEdit);

       titulo.setText(book.getTitle());
       descricao.setText(book.getDescription());
       genero.setText(book.getGender());
       ano.setText(book.getDateLaunch());
         
       autor.setValue(book.getAuthor().getId() + " - " + book.getAuthor().getNome());
       avaliador.setValue(book.getEvaluator().getId() + " - " + book.getEvaluator().getNome());
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
        Telas.listEvaluatorScreen();
    }
    
    public void navigateToListRelatoryScreen() {
        // adicionar tela de relatorios
    }
    
    public void logout() {
        Telas.telaLogin();
    }
}