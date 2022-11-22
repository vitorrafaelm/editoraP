package controllers;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import controllers.dto.UserDTO;
import exceptions.AuthError;
import exceptions.AuthenticationException;
import javafx.fxml.FXML;
import models.services.AdminBO;
import models.services.EvaluatorBO;
import views.Telas;

public class AuthController {
    @FXML private Label error;
    @FXML private TextField email;
    @FXML private TextField password;
    
    private static UserDTO loggedUser;
    private AdminBO adminBO = new AdminBO();
    private EvaluatorBO evaluatorBO = new EvaluatorBO();
    
    public void initialize() {
        loggedUser = null;
    }
    
    public void authenticate() {
//        if (error.getText().length() != 0) {
//            error.setText("");
//        }

        try {
            UserDTO user = new UserDTO(); 
            
            user.setEmail(email.getText());
            user.setPassword(password.getText());

            try {
                adminBO.authenticate(user);
                loggedUser = user; 
                Telas.telaHomePage();
                return;
            } catch (AuthenticationException e) {
                if (e.getReason() != AuthError.NOT_FOUND)
                    throw e;
            }

            try {
                evaluatorBO.authenticate(user);
                loggedUser = user; 
                Telas.telaHomePage();
                return;
            } catch (AuthenticationException e) {
                if (e.getReason() != AuthError.NOT_FOUND)
                    throw e;
            }

            throw new AuthenticationException(AuthError.NOT_FOUND);
        } catch (Exception e) {
            error.setText(e.getMessage());
        }
    }
    
    public void navigateToRecoverPasswordScreem() {
        Telas.RecoverPasswordScreen();
    }
}
