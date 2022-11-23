package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import models.services.AddressBO;
import models.services.EvaluatorBO;
import views.Telas;

public class UpdateEvaluator {
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
    
    public void updateEvaluator() {
        // deve conter toda a lógica para atualizar author
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
        // adicionar tela de relatório
    }
    
    public void logout() {
        Telas.telaLogin();
    }
}
