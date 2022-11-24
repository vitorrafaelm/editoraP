package controllers;

import java.sql.SQLException;

import controllers.dto.AddressDTO;
import controllers.dto.EvaluatorDTO;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import models.entities.Address;
import models.services.AddressBO;
import models.services.EvaluatorBO;
import views.Telas;

public class EvaluatorRegister {
    @FXML private TextField nome;
    @FXML private TextField cpf;
    @FXML private TextField rua;
    @FXML private TextField bairro;
    @FXML private TextField numero;
    @FXML private TextField cidade;
    @FXML private TextField cep;
    @FXML private TextField email;
    @FXML private TextField senha;
    
    private EvaluatorBO boEvaluator= new EvaluatorBO();
    private AddressBO bo = new AddressBO();
    
    public void cadastrar() throws SQLException {
  
        AddressDTO dtoA = new AddressDTO();
          
        dtoA.setStreet(rua.getText());
        dtoA.setNeightboohood(bairro.getText());
        dtoA.setNumber(numero.getText());
        dtoA.setCity(cidade.getText());
        dtoA.setZipcode(cep.getText());
        Address address = bo.adicionar(dtoA);
        
         EvaluatorDTO dtoEvaluator = new EvaluatorDTO();
         dtoEvaluator.setName(nome.getText());
         dtoEvaluator.setEmail(email.getText());
         dtoEvaluator.setSenha(senha.getText());
         dtoEvaluator.setCpf(cpf.getText());
         dtoEvaluator.setAddress(address);
         
         boEvaluator.adicionar(dtoEvaluator);
                
         Telas.listEvaluatorScreen();
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
