package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import views.Telas;

public class Login {
    @FXML private TextField password;
    @FXML private TextField cpf;
    @FXML private TextField error;
    
    @FXML private TextField cpfInRecoverPasswordScreen;
    public String newPss;
    
    public void authenticateUser() {
//        if(this.password.getText().isEmpty() == false && this.cpf.getText().isEmpty() == false) {
            Telas.telaHomePage();
//        }
         // Pegar password e user
         // Tentar autenticar
         // Caso de erro exibir mensagem para o usuário
         // Se der certo redirecionar ele para a home screen  
    }
    
    public void goToLoginScreen() {
        Telas.telaLogin();
    }
    
    public void navigateToRecoverPasswordScreem() {
        Telas.RecoverPasswordScreen();
    }
    
    public void generateNewPasswordAndNavigate() {
        if(cpfInRecoverPasswordScreen.getText().isEmpty() == false) {
            this.newPss = "123456";
            Telas.PasswordInformationScreen();
        }
        
    }
}
