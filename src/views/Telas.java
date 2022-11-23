package views;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Telas extends Application {
	private static Stage stage;
	public static void main(String[] args) {
		launch();
	}
	
	private void setStage(Stage st) {
		stage = st;
	}
	
	@Override
	public void start(Stage arg0) throws Exception {
		setStage(arg0);
		arg0.setTitle("Home Page");
		telaLogin();
	}
	
	public static void telaLogin() {
		try {
			Parent root = FXMLLoader.load(Telas.class.getResource("resources/Login.fxml"));
			Scene scene = new Scene (root);
			stage.setScene(scene);
			stage.setTitle("Tela inicial da Editora");
			stage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void telaHomePage() {
        try {
            Parent root = FXMLLoader.load(Telas.class.getResource("resources/HomePage.fxml"));
            Scene scene = new Scene (root);
            stage.setScene(scene);
            stage.setTitle("Tela inicial da Editora");
            stage.show();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void listAuthorScreen() {
        try {
            Parent root = FXMLLoader.load(Telas.class.getResource("resources/ListAuthors.fxml"));
            Scene scene = new Scene (root);
            stage.setScene(scene);
            stage.setTitle("Tela de listagem de autores");
            stage.show();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void registerAuthorScreen() {
        try {
            Parent root = FXMLLoader.load(Telas.class.getResource("resources/registerAuthor.fxml"));
            Scene scene = new Scene (root);
            stage.setScene(scene);
            stage.setTitle("Tela de cadastro de autores");
            stage.show();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void editAuthorScreen() {
        try {
            Parent root = FXMLLoader.load(Telas.class.getResource("resources/UpdateAuthor.fxml"));
            Scene scene = new Scene (root);
            stage.setScene(scene);
            stage.setTitle("Tela de listagem de autores");
            stage.show();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    //telas de avaliadores
    public static void listEvaluatorScreen() {
        try {
            Parent root = FXMLLoader.load(Telas.class.getResource("resources/ListEvaluator.fxml"));
            Scene scene = new Scene (root);
            stage.setScene(scene);
            stage.setTitle("Tela de listagem de avaliadores");
            stage.show();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void registerEvaluatorScreen() {
        try {
            Parent root = FXMLLoader.load(Telas.class.getResource("resources/registerEvaluator2.fxml"));
            Scene scene = new Scene (root);
            stage.setScene(scene);
            stage.setTitle("Tela de cadastro de avaliadores");
            stage.show();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void editEvaluatorScreen() {
        try {
            Parent root = FXMLLoader.load(Telas.class.getResource("resources/updateEvaluators2.fxml"));
            Scene scene = new Scene (root);
            stage.setScene(scene);
            stage.setTitle("Tela de atualização de avaliadores");
            stage.show();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void EvaluatorScreen() {
        try {
            Parent root = FXMLLoader.load(Telas.class.getResource("resources/Evaluator.fxml"));
            Scene scene = new Scene (root);
            stage.setScene(scene);
            stage.setTitle("Tela de Avaliar Obras");
            stage.show();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    //Telas de Obras
    public static void editBookScreen(){
        try {
            Parent root = FXMLLoader.load(Telas.class.getResource("resources/UpdateBook.fxml"));
            Scene scene = new Scene (root);
            stage.setScene(scene);
            stage.setTitle("Tela de Edicao de Obras");
            stage.show();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void listBookScreen(){
        try {
            Parent root = FXMLLoader.load(Telas.class.getResource("resources/ListBook.fxml"));
            Scene scene = new Scene (root);
            stage.setScene(scene);
            stage.setTitle("Tela de listagem de Obras");
            stage.show();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void registerBookScreen() {
        try {
            Parent root = FXMLLoader.load(Telas.class.getResource("resources/registerBook.fxml"));
            Scene scene = new Scene (root);
            stage.setScene(scene);
            stage.setTitle("Tela de cadastro de Obras");
            stage.show();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    

}
