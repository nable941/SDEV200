package application;


import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    private TextField tfHour = new TextField();
    private TextField tfMinute = new TextField();
    private TextField tfSecond = new TextField();
    private ClockPane clockPane = new ClockPane();
    private Label lblHour = new Label("Hour: ");
    private Label lblMinute = new Label("Minute: ");
    private Label lblSecond = new Label("Second: ");
    
    @Override
    public void start(Stage stage) {
    	
    	//Prepopulate  and align textboxes
		tfHour.setPrefColumnCount(3);
		tfHour.setAlignment(Pos.CENTER_RIGHT);
		tfHour.setText(String.valueOf(clockPane.getHour()));
		tfMinute.setPrefColumnCount(3);
		tfMinute.setAlignment(Pos.CENTER_RIGHT);
		tfMinute.setText(String.valueOf(clockPane.getMinute()));
		tfSecond.setPrefColumnCount(3);
		tfSecond.setAlignment(Pos.CENTER_RIGHT);
		tfSecond.setText(String.valueOf(clockPane.getSecond()));
		
		//Horizontal pane for the text boxes to align elements left to right
		HBox tfBox = new HBox(1);
		tfBox.setAlignment(Pos.CENTER);
		tfBox.getChildren().addAll(lblHour, tfHour, lblMinute, tfMinute, lblSecond, tfSecond);
		
		//Vertical pane to hold clock above the tfBox
        VBox mainBox = new VBox(75);
        mainBox.setPadding(new Insets(50));
        mainBox.setAlignment(Pos.CENTER);
        mainBox.getChildren().addAll(clockPane, tfBox);
       
        // Watch Keypress and look for Enter press. If enter call setClock
        tfHour.setOnKeyPressed(e -> {
        	if (e.getCode() == KeyCode.ENTER) {
        		setClock();
        	}
        });
        tfMinute.setOnKeyPressed(e -> {
        	if (e.getCode() == KeyCode.ENTER) {
        		setClock();
        	}
        });
        tfMinute.setOnKeyPressed(e -> {
        	if (e.getCode() == KeyCode.ENTER) {
        		setClock();
        	}
        });


        //Build and display stage
        Scene scene = new Scene(mainBox);     
        stage.setTitle("Nathan Able Exercise 16_7");
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
        


    }
    private void setClock() {
		clockPane.setHour(Integer.parseInt(tfHour.getText()));
		clockPane.setMinute(Integer.parseInt(tfMinute.getText())); 
		clockPane.setSecond(Integer.parseInt(tfSecond.getText()));
	}
    
	public static void main(String[] args) {
		launch(args);
	}
}

