package controllers;

import javafx.scene.control.TextField;
import java.sql.SQLException;

import controllers.dto.AddressDTO;
import controllers.dto.AuthorDTO;
import javafx.fxml.FXML;
import models.entities.Address;
import models.services.AddressBO;
import models.services.AuthorBO;

public class AuthorRegister {
	@FXML private TextField name;
	@FXML private TextField cpf;
	@FXML private TextField street;
	@FXML private TextField neighboorhood;
	@FXML private TextField number;
	@FXML private TextField city;
	@FXML private TextField zipcode;
	
//	private AddressBO bo = new AddressBO();
//	private AuthorBO boAuthor = new AuthorBO();
	
	public void register(){
//		AddressDTO dto = new AddressDTO();
//		
//		dto.setStreet(street.getText());
//		dto.setNeightboohood(neighboorhood.getText());
//		dto.setNumber(street.getText());
//		dto.setZipcode(street.getText());
//		dto.setCity(city.getText());
//		
//		Address address = bo.adicionar(dto);
//		
//		AuthorDTO dtoAuthor = new AuthorDTO(); 
//		
//		dtoAuthor.setName(name.getText());
//		dtoAuthor.setCpf(cpf.getText());
//		dtoAuthor.setAddress(address);
//		
//		boAuthor.adicionar(dtoAuthor);
	}
}
