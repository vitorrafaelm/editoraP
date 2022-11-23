package controllers;

import javafx.scene.control.TextField;
import java.sql.SQLException;

import controllers.dto.AddressDTO;
import controllers.dto.AuthorDTO;
import javafx.fxml.FXML;
import models.entities.Address;
import models.entities.Author;
import models.services.AddressBO;
import models.services.AuthorBO;
import views.Telas;

public class AuthorRegister {
	@FXML private TextField name;
	@FXML private TextField cpf;
	@FXML private TextField street;
	@FXML private TextField neighboorhood;
	@FXML private TextField number;
	@FXML private TextField city;
	@FXML private TextField zipcode;
	
	private AddressBO bo = new AddressBO();
	private AuthorBO boAuthor = new AuthorBO();
	
	public void register() throws SQLException{
		AddressDTO dto = new AddressDTO();
		
		dto.setStreet(street.getText());
		dto.setNeightboohood(neighboorhood.getText());
		dto.setNumber(number.getText());
		dto.setZipcode(zipcode.getText());
		dto.setCity(city.getText());
		
		Address address = bo.adicionar(dto);
		
		AuthorDTO dtoAuthor = new AuthorDTO(); 
		
		dtoAuthor.setName(name.getText());
		dtoAuthor.setCpf(cpf.getText());
		dtoAuthor.setAddress(address);
		
		Author auth = boAuthor.adicionar(dtoAuthor);
		
	    Telas.listAuthorScreen();
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
        // adicionar tela de relatorio
    }
    
    public void logout() {
        Telas.telaLogin();
    }
}
