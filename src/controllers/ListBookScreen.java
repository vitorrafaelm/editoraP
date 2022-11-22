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
        //List<BookDTO> books = bookBO.listar();
        
        //listBooks = FXCollections.observableArrayList(books);
        //columnTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        //columnAno.setCellValueFactory(new PropertyValueFactory<>("ano"));
        //columnAvaliador.setCellValueFactory(new PropertyValueFactory<>("avaliador"));
        //columnEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        //tableBook.setItems(listBooks);
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
    
    public void navigateToHomePage() {
        Telas.listBookScreen();
    }
    
    public void navigateToRegisterScreen() {
        Telas.registerBookScreen();
    }
    
    public void navigateToEditScreen() {
        Telas.editBookScreen();
    }
    
    public void pesquisarObra() {
        
    }
}
