package controllers;

import java.util.List;

import controllers.dto.AuthorDTO;
import controllers.dto.BookDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import models.entities.Author;
import models.services.AuthorBO;
import views.Telas;

public class ListAuthorScreen {
    
    public static Author currentAuthorToEdit; 
    
    @FXML private TableView<AuthorDTO> tableAuthor;
    @FXML private TableColumn<AuthorDTO, String> columnName;
    @FXML private TableColumn<AuthorDTO, String> columnCpf;
    @FXML private TableColumn<AuthorDTO, String> columnAddress;
    
    @FXML private TextField buscar;
    
    private AuthorBO authorBO = new AuthorBO();
    private ObservableList<AuthorDTO> listAuthors;
    
    public void initialize() {
        // TODO Auto-generated method stub
        listAuthors();
    }
    
    public void listAuthors() {
        List<AuthorDTO> authors = authorBO.listar();
        
        // transformar de entidade para dto no controller
        
        listAuthors = FXCollections.observableArrayList(authors);
        columnCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        tableAuthor.setItems(listAuthors);
    }
    
    public void deleteAuthor() {
        try {
            Author author = new Author(); 
            
            String cpf = tableAuthor.getSelectionModel().getSelectedItem().getCpf();
            author.setCpf(cpf);
            authorBO.deletar(author); 
            
            tableAuthor.getItems().removeAll(
                    tableAuthor.getSelectionModel().getSelectedItems()
            );
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
    public void pesquisarObra() {
        List<AuthorDTO> authors = authorBO.search(buscar.getText());
        
        listAuthors = FXCollections.observableArrayList(authors);
        columnCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        tableAuthor.setItems(listAuthors);
    }
    
    
    public void navigateToRegisterScreen() {
        Telas.registerAuthorScreen();
    }
    
    public void navigateToEditScreen() {
        
        Author author = new Author(); 
        
        String cpf = tableAuthor.getSelectionModel().getSelectedItem().getCpf();
        author.setCpf(cpf);
        
        currentAuthorToEdit = author;
        Telas.editAuthorScreen();
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
