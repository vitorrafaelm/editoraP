package controllers;

import views.Telas;

public class UpdateBook {  
    public void updateBook() {
        // deve conter toda a lógica para atualizar a obra
        Telas.listBookScreen();
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
        // adicionar tela de relatorios
    }
    
    public void logout() {
        Telas.telaLogin();
    }
}