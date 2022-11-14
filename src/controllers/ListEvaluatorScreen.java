package controllers;

import views.Telas;

public class ListEvaluatorScreen {
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
}
