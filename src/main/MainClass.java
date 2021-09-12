package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainClass extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginView.fxml"));
		Parent root = loader.load();	//여기서 컨트롤러의 initialize가 실행됨 
		Scene scene = new Scene(root);
	
		MainController ctrl = loader.getController();
		ctrl.setRoot(root);
		
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}


	public static void main(String[] args) {
		launch(args);

	}

	
}
