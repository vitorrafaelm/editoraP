/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.TableColumn;
import views.Telas;
/**
 * FXML Controller class
 *
 * @author mateu
 */
public class EvaluatorController implements Initializable {


    @FXML
    private TableColumn<?, ?> columnTitulo;
    @FXML
    private TableColumn<?, ?> columnAno;
    @FXML
    private TableColumn<?, ?> columnAvaliador;
    @FXML
    private TableColumn<?, ?> columnEndereco;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void navigateToHomePage(ActionEvent event) {
    }
    
    public void logout() {
        Telas.telaLogin();
    }
    
    @FXML
    private void avaliar(ActionEvent event) {
        
    }

}
