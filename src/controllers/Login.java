package controllers;

import views.Telas;

public class Login {
    
    public void authenticateUser() {
        
         // Pegar password e user
         // Tentar autenticar
         // Caso de erro exibir mensagem para o usuário
         // Se der certo redirecionar ele para a home screen
        
        Telas.telaHomePage();
    }
    
    public void goToLoginScreen() {
        Telas.telaLogin();
    }
    
    public void navigateToRecoverPasswordScreem() {
        Telas.RecoverPasswordScreen();
    }
    
    public void generateNewPasswordAndNavigate() {
        String newpassword = "123456";
        
        Telas.PasswordInformationScreen();
    }
}
