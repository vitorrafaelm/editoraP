package controllers;

import java.sql.SQLException;

import controllers.dto.AddressDTO;
import controllers.dto.AuthorDTO;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import models.entities.Address;
import models.entities.Author;
import models.services.AddressBO;
import models.services.AuthorBO;
import views.Telas;

public class UpdateAuthor {
    
    public int addressId;
    public String currentCpf;
    
    @FXML private TextField name;
    @FXML private TextField cpf;
    @FXML private TextField street;
    @FXML private TextField neighboorhood;
    @FXML private TextField number;
    @FXML private TextField city;
    @FXML private TextField zipcode;
    
    private AuthorBO authorBO = new AuthorBO();
    private AddressBO boA = new AddressBO();
    
    public void initialize() {
        // TODO Auto-generated method stub
        getAuthorsInformations();
    }
    
    public void navigateToListAuthors() {
        Telas.listAuthorScreen();
    }
    
    public void updateAuthor() throws SQLException {
        AddressDTO dto = new AddressDTO();
        
        dto.setId(addressId);
        dto.setStreet(street.getText());
        dto.setNeightboohood(neighboorhood.getText());
        dto.setNumber(number.getText());
        dto.setZipcode(zipcode.getText());
        dto.setCity(city.getText());
        
        boA.atualizar(dto);
        
        AuthorDTO dtoAuthor = new AuthorDTO(); 
        
        dtoAuthor.setName(name.getText());
        dtoAuthor.setCpf(cpf.getText());
        
        authorBO.updateAuthor(dtoAuthor, this.currentCpf);
        
        Telas.listAuthorScreen();
    }
    
    public void getAuthorsInformations() {
        Author author = authorBO.findAuthorUnique(ListAuthorScreen.currentAuthorToEdit);
           
        this.name.setText(author.getNome());
        this.cpf.setText(author.getCpf());
        
        this.street.setText(author.getAdress().getStreet());
        this.neighboorhood.setText(author.getAdress().getNeightboohood());
        this.number.setText(author.getAdress().getNumber());
        this.city.setText(author.getAdress().getCity());
        this.zipcode.setText(author.getAdress().getZipcode());
        
        this.addressId = author.getAdress().getId();
        this.currentCpf = author.getCpf(); 
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
