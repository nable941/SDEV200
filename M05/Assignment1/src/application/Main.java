package application;
/*
 * Nathan Able
 * SDEV 200
 * M05	Chapter 14 Exercise 14.1
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		GridPane pane = new GridPane();

		// Place nodes in the pane
		//Note 2 flags do not match the book flags
		pane.add(new ImageView(new Image("image/uk.gif")), 0, 0);
		pane.add(new ImageView(new Image("image/ca.gif")), 0, 1);
		pane.add(new ImageView(new Image("image/china.gif")), 1, 0);
		pane.add(new ImageView(new Image("image/us.gif")), 1, 1);

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Able_Nathan_M05_Exercise_14_01"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage.
	
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
