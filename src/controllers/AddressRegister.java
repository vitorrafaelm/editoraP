package controllers;


import java.sql.SQLException;

import controllers.dto.AddressDTO;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import models.services.AddressBO;
import views.Telas;

public class AddressRegister {
	@FXML private TextField street;
	@FXML private TextField neightboohood;
	@FXML private TextField number;
	@FXML private TextField zipcode;
	private AddressBO bo = new AddressBO();
	
	public void cadastrar() throws SQLException {
		AddressDTO dto = new AddressDTO();
		dto.setStreet(street.getText());
		dto.setNeightboohood(neightboohood.getText());
		dto.setNumber(number.getText());
		dto.setZipcode(zipcode.getText());
		
		bo.adicionar(dto); 
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
