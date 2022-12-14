package controllers;

import java.util.List;

import controllers.dto.BookDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import models.entities.Author;
import models.entities.Book;
import models.services.BookBO;
import views.Telas;

public class ListBookScreen {
    
    public static Book currentBookToEdit; 
    
    @FXML private TableView<BookDTO> tableBook;
    @FXML private TableColumn<BookDTO, String> columnId;
    @FXML private TableColumn<BookDTO, String> columnTitulo;
    @FXML private TableColumn<BookDTO, String> columnAno;
    @FXML private TableColumn<BookDTO, String> columnAvaliador;
    @FXML private TableColumn<BookDTO, String> columnEndereco;
    
    @FXML private TextField buscar;
    
    private BookBO bookBO = new BookBO();
    private ObservableList<BookDTO> listBooks;
    
    public void initialize() {
        // TODO Auto-generated method stub
        listBooks();
    }
    
    public void listBooks() {
        List<BookDTO> books = bookBO.listar();
             
        listBooks = FXCollections.observableArrayList(books);
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnTitulo.setCellValueFactory(new PropertyValueFactory<>("title"));
        columnAno.setCellValueFactory(new PropertyValueFactory<>("dateLaunch"));
        columnAvaliador.setCellValueFactory(new PropertyValueFactory<>("evaluator"));
        columnEndereco.setCellValueFactory(new PropertyValueFactory<>("author"));
        tableBook.setItems(listBooks);
    }
    
    public void deleteBook() {
        try {
            Book book = new Book(); 
            
            int id = tableBook.getSelectionModel().getSelectedItem().getId();
            book.setId(id);
            bookBO.apagar(book);
            
            tableBook.getItems().removeAll(
                    tableBook.getSelectionModel().getSelectedItems()
            );
        } catch (Exception e) {
        }
    }
    
    
    public void navigateToRegisterScreen() {
        Telas.registerBookScreen();
    }
    
    public void navigateToEditScreen() {
        Book book = new Book(); 
        
        int id = tableBook.getSelectionModel().getSelectedItem().getId();
        book.setId(id);
        
        currentBookToEdit = book;  
        Telas.editBookScreen();
    }
    
    public void pesquisarObra() {
        List<BookDTO> books = bookBO.search(buscar.getText());
        
        listBooks = FXCollections.observableArrayList(books);
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnTitulo.setCellValueFactory(new PropertyValueFactory<>("title"));
        columnAno.setCellValueFactory(new PropertyValueFactory<>("dateLaunch"));
        columnAvaliador.setCellValueFactory(new PropertyValueFactory<>("evaluator"));
        columnEndereco.setCellValueFactory(new PropertyValueFactory<>("author"));
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
