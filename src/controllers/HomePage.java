package controllers;

import views.Telas;

public class HomePage {
	
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
	    // tela ainda não existe
        Telas.listAuthorScreen();
    }
}
