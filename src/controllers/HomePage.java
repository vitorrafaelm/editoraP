package controllers;

import views.Telas;

public class HomePage {
	
	public void navigateToHomePageAuthors() {
		Telas.listAuthorScreen();
	}

	public void navigateToHomePageBooks() {
		Telas.listBookScreen();
	}

	public void navigateToHomePageEvaluators() {
		Telas.listEvaluatorScreen();
	}

}
