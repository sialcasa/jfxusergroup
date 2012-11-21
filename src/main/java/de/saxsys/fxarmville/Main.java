package de.saxsys.fxarmville;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Pane rootPane = (Pane) FXMLLoader.load(Main.class
				.getResource("/root.fxml"));

		Scene rootScene = new Scene(rootPane, 800, 500);

		stage.setScene(rootScene);

		stage.setTitle("FXarmVille");
		stage.show();

	}

}
