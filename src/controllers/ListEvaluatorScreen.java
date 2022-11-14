package controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import controllers.dto.EvaluatorDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.services.EvaluatorBO;
import views.Telas;

public class ListEvaluatorScreen implements Initializable{
    @FXML private TableView<EvaluatorDTO> tabelaAvaliadores;
    @FXML private TableColumn<EvaluatorDTO, String> columnNome;
    @FXML private TableColumn<EvaluatorDTO, String> columnCpf;
    private EvaluatorBO bo = new EvaluatorBO();
    private ObservableList<EvaluatorDTO> listaDeAvaliadores;
    public void listarAvaliadores() {
        List<EvaluatorDTO> evaluators = bo.listar();
        listaDeAvaliadores = FXCollections.observableArrayList(evaluators);
        columnCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        columnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tabelaAvaliadores.setItems(listaDeAvaliadores);
    }
    public void navigateToHomePage() {
        Telas.listEvaluatorScreen();
    }
    
    public void navigateToRegisterScreen() {
        Telas.registerEvaluatorScreen();
    }
    
    public void navigateToEditScreen() {
        Telas.editEvaluatorScreen();
    }
    
    public void deleteEvaluator() {
        // toda a lógica para deletar author e no final redireciona para a listagem
        Telas.listEvaluatorScreen();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        
    }
}
