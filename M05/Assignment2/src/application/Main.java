package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.layout.StackPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		StackPane pane = new StackPane();

		// Create a circle and set its properties
		Circle circle = new Circle(100);
		circle.setFill(Color.WHITE);
		circle.setStroke(Color.BLACK);
		pane.getChildren().add(circle);

		// Create and register the handler
		pane.setOnMousePressed(e -> {
			circle.setFill(Color.BLACK);
		});

		pane.setOnMouseReleased(e -> {
			circle.setFill(Color.WHITE);
			circle.setStroke(Color.BLACK);
		});

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 240, 240);
		primaryStage.setTitle("Able_Nathan_M05_Exercise_15_07"); 
		primaryStage.setScene(scene); 
		primaryStage.show(); 
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
