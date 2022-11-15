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
          private EvaluatorBO bo= new EvaluatorBO();
          private AddressBO boA = new AddressBO();
    
    public void cadastrar() throws SQLException {
     AddressDTO dtoA = new AddressDTO();
      
     dtoA.setStreet(rua.getText());
     dtoA.setNeightboohood(bairro.getText());
     dtoA.setNumber(numero.getText());
     dtoA.setCity(cidade.getText());
     dtoA.setZipcode(cep.getText());
     Address address = boA.adicionar(dtoA);
     
     EvaluatorDTO dto = new EvaluatorDTO();
     dto.setName(nome.getText());
     dto.setCpf(cpf.getText());
     dto.setAddress(address);
        bo.adicionar(dto);
        Telas.listEvaluatorScreen();
    }
    public void navigateToEvaluatorScren() {
        Telas.listEvaluatorScreen();
    }
}
