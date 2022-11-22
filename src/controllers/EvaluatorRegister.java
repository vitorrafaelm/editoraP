package controllers;

import java.sql.SQLException;

import controllers.dto.AddressDTO;
import controllers.dto.EvaluatorDTO;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import models.entities.Address;
import models.entities.Evaluator;
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
  
//        AddressDTO dtoA = new AddressDTO();
//      
//         dtoA.setStreet(rua.getText());
//         dtoA.setNeightboohood(bairro.getText());
//         dtoA.setNumber(numero.getText());
//         dtoA.setCity(cidade.getText());
//         dtoA.setZipcode(cep.getText());
//         Address address = bo.adicionar(dtoA);
//         
//         EvaluatorDTO dtoEvaluator = new EvaluatorDTO();
//         dtoEvaluator.setName(nome.getText());
//         dtoEvaluator.setCpf(cpf.getText());
//         dtoEvaluator.setAddress(address);
//         
//         Evaluator eval = boEvaluator.adicionar(dtoEvaluator);
//         boEvaluator.adicionar(dtoEvaluator);
            
        Telas.listEvaluatorScreen();
    }
    
    public void navigateToListAuthorsScreen() {
        Telas.listAuthorScreen();
    }
    
    public void navigateToListBooksScreen() {
        Telas.listBookScreen();
    }
    
    public void navigateToListEvaluatorsScreen() {
        Telas.listBookScreen();
    }
    
    public void navigateToListRelatoryScreen() {
        Telas.listAuthorScreen();
    }
}
