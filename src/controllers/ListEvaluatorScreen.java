package api.controllers;

import java.util.List;

import api.dto.EvaluatorDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.entities.Evaluator;
import models.services.EvaluatorBO;
import views.Telas;

public class ListEvaluatorScreen {
    @FXML private TableView<EvaluatorDTO> tabelaAvaliadores;
    @FXML private TableColumn<EvaluatorDTO, String> columnNome;
    @FXML private TableColumn<EvaluatorDTO, String> columnCpf;
    @FXML private TableColumn<EvaluatorDTO, String> columnEndereco;
    private EvaluatorBO bo = new EvaluatorBO();
    private ObservableList<EvaluatorDTO> listaDeAvaliadores;
   
    public void listarAvaliadores() {
        List<EvaluatorDTO> evaluators = bo.listar();
        listaDeAvaliadores = FXCollections.observableArrayList(evaluators);
        columnCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        columnNome.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnEndereco.setCellValueFactory(new PropertyValueFactory<>("address"));
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
        try {
            Evaluator evaluator = new Evaluator();
            
            String cpf = tabelaAvaliadores.getSelectionModel().getSelectedItem().getCpf();
            evaluator.setCPF(cpf);
            bo.deletar(evaluator);
            
            tabelaAvaliadores.getItems().removeAll(
                    tabelaAvaliadores.getSelectionModel().getSelectedItems()
            );
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
