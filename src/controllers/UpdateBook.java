package controllers;

import java.sql.SQLException;

import controllers.dto.BookDTO;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import models.entities.Author;
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
        
        bo.atualizar(dto);
        Telas.listBookScreen(); 
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