package controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import controllers.dto.AuthorDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.services.AuthorBO;
import views.Telas;

public class ListAuthorScreen {
    @FXML private TableView<AuthorDTO> tableAuthor;
    @FXML private TableColumn<AuthorDTO, String> columnName;
    @FXML private TableColumn<AuthorDTO, String> columnCpf;
    @FXML private TableColumn<AuthorDTO, String> columnAddress;
    private AuthorBO authorBO = new AuthorBO();
    private ObservableList<AuthorDTO> listAuthors;
    
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        listAuthors();
    }
    
    public void listAuthors() {
        List<AuthorDTO> authors = authorBO.listar();
        
        listAuthors = FXCollections.observableArrayList(authors);
        columnCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        tableAuthor.setItems(listAuthors);
    }
    
    public void navigateToHomePage() {
        Telas.listAuthorScreen();
    }
    
    public void navigateToRegisterScreen() {
        Telas.registerAuthorScreen();
    }
    
    public void navigateToEditScreen() {
        Telas.editAuthorScreen();
    }
    
    public void deleteAuthor() {
        // toda a lógica para deletar author e no final redireciona para a listagem
        Telas.listAuthorScreen();
    }
}
