/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import controllers.dto.BookDTO;
import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import models.entities.Book;
import models.services.BookBO;
import views.Telas;
/**
 * FXML Controller class
 *
 * @author mateu
 */
public class EvaluatorController {
    @FXML private Button avaliarButton;
    @FXML private Button obraRuim;
    
    @FXML private TableView<BookDTO> tableBook;
    @FXML private TableColumn<BookDTO, String> id;
    @FXML private TableColumn<BookDTO, String> status;
    @FXML
    private TableColumn<BookDTO, String> columnTitulo;
    @FXML
    private TableColumn<BookDTO, String> columnAno;
    @FXML
    private TableColumn<BookDTO, String> autor;
    private ObservableList<BookDTO> listBooks;
    
    private BookBO bookBO = new BookBO();
    
    public void initialize() {
        // TODO Auto-generated method stub
        listaObras();
    }
    
    public void listaObras() {
        List<BookDTO> books = bookBO.listarPorAvaliador(AuthController.loggedUser);
        
        listBooks = FXCollections.observableArrayList(books);
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnTitulo.setCellValueFactory(new PropertyValueFactory<>("title"));
        columnAno.setCellValueFactory(new PropertyValueFactory<>("dateLaunch"));
        autor.setCellValueFactory(new PropertyValueFactory<>("author"));
        status.setCellValueFactory(new PropertyValueFactory<>("status_register"));
        tableBook.setItems(listBooks);
    }  
    
    @FXML
    private void navigateToHomePage(ActionEvent event) {
    }
    
    public void logout() {
        Telas.telaLogin();
    }
    
    @FXML
    private void avaliar(ActionEvent event) throws SQLException {
        Book book = new Book(); 
        
        int id = tableBook.getSelectionModel().getSelectedItem().getId();
        book.setStatus_register("Livro bom");
        
        bookBO.atualizarStatus(book, id);
        
        Telas.EvaluatorScreen();
    }
    
    @FXML
    private void avaliarRuim(ActionEvent event) throws SQLException {
        Book book = new Book(); 
        
        int id = tableBook.getSelectionModel().getSelectedItem().getId();
        book.setStatus_register("Livro ruim");
        
        bookBO.atualizarStatus(book, id);
        
        Telas.EvaluatorScreen();
    }

}
