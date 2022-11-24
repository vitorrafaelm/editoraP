package controllers;

import java.util.List;

import javafx.scene.control.Button;
import controllers.dto.BookDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import models.services.BookBO;
import views.Telas;

public class relatory {
    @FXML private TableView<BookDTO> tableBook;
    @FXML private TableColumn<BookDTO, String> columnId;
    @FXML private TableColumn<BookDTO, String> columnTitulo;
    @FXML private TableColumn<BookDTO, String> columnAno;
    @FXML private TableColumn<BookDTO, String> columnAvaliador;
    @FXML private TableColumn<BookDTO, String> columnEndereco;
    @FXML private TableColumn<BookDTO, String> columnEndereco1;
    
    @FXML private TextField buscar;
    @FXML private TextField buscar1;
    
    private BookBO bookBO = new BookBO();
    private ObservableList<BookDTO> listBooks;
    
    public void pesquisarObra() {
        List<BookDTO> books = bookBO.relatory(buscar.getText(), buscar1.getText());
        
        listBooks = FXCollections.observableArrayList(books);
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnTitulo.setCellValueFactory(new PropertyValueFactory<>("title"));
        columnAno.setCellValueFactory(new PropertyValueFactory<>("dateLaunch"));
        columnAvaliador.setCellValueFactory(new PropertyValueFactory<>("evaluator"));
        columnEndereco.setCellValueFactory(new PropertyValueFactory<>("author"));
        columnEndereco1.setCellValueFactory(new PropertyValueFactory<>("created"));
        tableBook.setItems(listBooks);
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
        Telas.relatoryScreen(); 
    }
    
    public void logout() {
        Telas.telaLogin();
    }
}
