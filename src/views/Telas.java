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
	
	public static void RecoverPasswordScreen() {
        try {
            Parent root = FXMLLoader.load(Telas.class.getResource("resources/RecoverPassword.fxml"));
            Scene scene = new Scene (root);
            stage.setScene(scene);
            stage.setTitle("Tela de recuperação de senha");
            stage.show();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
	
	public static void PasswordInformationScreen() {
        try {
            Parent root = FXMLLoader.load(Telas.class.getResource("resources/PasswordInformation.fxml"));
            Scene scene = new Scene (root);
            stage.setScene(scene);
            stage.setTitle("Tela de senha gerada");
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

}
