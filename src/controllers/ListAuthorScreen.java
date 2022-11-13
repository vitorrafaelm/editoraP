package controllers;

import views.Telas;

public class ListAuthorScreen {
    public void navigateToHomePage() {
        Telas.listAuthorScreen();
    }
    
    public void navigateToRegisterScreen() {
        Telas.registerAuthorScreen();
    }
    
    public void navigateToEditScreen() {
        Telas.editAuthorScreen();
    }
    
    public void deleteAuthor() {
        // toda a lógica para deletar author e no final redireciona para a listagem
        Telas.listAuthorScreen();
    }
}
