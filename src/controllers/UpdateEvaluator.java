package controllers;

import java.sql.SQLException;

import controllers.dto.AddressDTO;
import controllers.dto.EvaluatorDTO;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import models.entities.Evaluator;
import models.services.AddressBO;
import models.services.EvaluatorBO;
import views.Telas;

public class UpdateEvaluator {
    
    public int adressId;
    public String currentCpf;
    
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
   
    public void initialize() {
       getEvaluatorsInformations();
    }

    public void updateEvaluator() throws SQLException {
        AddressDTO dto = new AddressDTO();
        dto.setId(adressId);
        dto.setStreet(rua.getText());
        dto.setNeightboohood(bairro.getText());
        dto.setNumber(numero.getText());
        dto.setCity(cidade.getText());
        dto.setZipcode(cep.getText());
        bo.atualizar(dto);
        
        EvaluatorDTO dtoEvaluator = new EvaluatorDTO();
        
        dtoEvaluator.setName(nome.getText());
        dtoEvaluator.setCpf(cpf.getText());
        dtoEvaluator.setEmail(email.getText());
        dtoEvaluator.setSenha(senha.getText());
        
        boEvaluator.atualizar(dtoEvaluator, this.currentCpf);
        Telas.listEvaluatorScreen();
    }
    
    public void getEvaluatorsInformations() {
        Evaluator evaluator = boEvaluator.findEvaluatorUnique(ListEvaluatorScreen.currentEvaliatorToEdit);
        
        this.cpf.setText(evaluator.getCPF());
        this.email.setText(evaluator.getEmail());
        this.senha.setText(evaluator.getPassword());
        this.nome.setText(evaluator.getNome());
        this.rua.setText(evaluator.getAddress().getStreet());
        this.bairro.setText(evaluator.getAddress().getNeightboohood());
        this.numero.setText(evaluator.getAddress().getNumber());
        this.cidade.setText(evaluator.getAddress().getCity());
        this.cep.setText(evaluator.getAddress().getZipcode());
        
        this.adressId = evaluator.getAddress().getId();
        this.currentCpf = evaluator.getCPF();
        
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
