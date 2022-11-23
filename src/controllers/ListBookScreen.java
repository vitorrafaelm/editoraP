package controllers;

import java.util.List;

import controllers.dto.BookDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.entities.Book;
import models.services.BookBO;
import views.Telas;

public class ListBookScreen {
    @FXML private TableView<BookDTO> tableBook;
    @FXML private TableColumn<BookDTO, String> columnId;
    @FXML private TableColumn<BookDTO, String> columnTitulo;
    @FXML private TableColumn<BookDTO, String> columnAno;
    @FXML private TableColumn<BookDTO, String> columnAvaliador;
    @FXML private TableColumn<BookDTO, String> columnEndereco;
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
            //Book book = new Book(); 
            
            //String titulo = tableBook.getSelectionModel().getSelectedItem().getCpf();
            //book.setTitle(titulo);
            //BookBO.deletar(book); 
            
            //tableBook.getItems().removeAll(
                    //tableBook.getSelectionModel().getSelectedItems()
            //);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
    public void navigateToRegisterScreen() {
        Telas.registerBookScreen();
    }
    
    public void navigateToEditScreen() {
        Telas.editBookScreen();
    }
    
    public void pesquisarObra() {
        
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
        // adicionar tela derelatório;
    }
    
    public void logout() {
        Telas.telaLogin();
    }
}
