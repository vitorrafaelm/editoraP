/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import controllers.dto.BookDTO;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.entities.Book;
import models.entities.Evaluator;
import views.Telas;

import models.services.BookBO;
/**
 * FXML Controller class
 *
 * @author mateu
 */
public class EvaluatorController implements Initializable {

    @FXML private TableView<BookDTO> tableBook;
    @FXML
    private TableColumn<BookDTO, String> columnTitulo;
    @FXML
    private TableColumn<BookDTO, String> columnAno;
    @FXML
    private TableColumn<BookDTO, String> columnAvaliador;
    @FXML
    private TableColumn<BookDTO, String> columnStatus;
    
    private ObservableList<BookDTO> listBooks;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb ) {
        // TODO
        listBooks();
    }  
    
//    public static void main(String[] args) {
//        EvaluatorController ev = new EvaluatorController();
//        
//        
//    }
    
    public void listBooks() {
        //List<BookDTO> books = bookBO.listar();
        BookBO books = new BookBO();
        
        List<BookDTO> Books = books.listarPorAvaliador(AuthController.loggedUser);
        
        
        //listBooks = FXCollections.observableArrayList(books);
        //columnTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        //columnAno.setCellValueFactory(new PropertyValueFactory<>("ano"));
        //columnAvaliador.setCellValueFactory(new PropertyValueFactory<>("avaliador"));
        //columnEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        //tableBook.setItems(listBooks);
        listBooks = FXCollections.observableArrayList(Books);
        columnTitulo.setCellValueFactory(new PropertyValueFactory<>("title"));
        columnAno.setCellValueFactory(new PropertyValueFactory<>("dateLaunch"));
        columnAvaliador.setCellValueFactory(new PropertyValueFactory<>("evaluator"));
        columnStatus.setCellValueFactory(new PropertyValueFactory<>("status_register"));
        tableBook.setItems(listBooks);
    }
    
    @FXML
    private void navigateToHomePage(ActionEvent event) {
        
    }
    
    public void logout() {
        Telas.telaLogin();
    }
    
    @FXML
    private void avaliar(ActionEvent event) {
        
    }

}
