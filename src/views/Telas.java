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
		telaHomePage();
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
	
	public static void registerAuthorScreen() {
		try {
			Parent root = FXMLLoader.load(Telas.class.getResource("resources/registerAuthorScreen.fxml"));
			Scene scene = new Scene (root);
			stage.setScene(scene);
			stage.setTitle("Tela de cadastro de autor");
			stage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
