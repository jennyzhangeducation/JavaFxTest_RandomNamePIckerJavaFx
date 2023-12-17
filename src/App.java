
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import javafx.stage.Stage;
import javafx.util.Duration;
 // Import the ActionEvent class

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a label with the text "Hello, World!"
        Label label = new Label("Student Name: ");
        Label studentName = new Label("");
        label.setStyle("-fx-font-size: 24px; -fx-text-fill: #000000;");
        studentName.setStyle("-fx-font-size: 24px; -fx-text-fill: #0000ff; -fx-font-weight: bold;");
        Button buttonPlay = new Button("Play");
        buttonPlay.setStyle("-fx-font-size: 24px; -fx-text-fill: #000000;");
        Button buttonStop = new Button("Stop");
        buttonStop.setStyle("-fx-font-size: 24px; -fx-text-fill: #000000;");

        // Create a layout pane and add the label and button to it
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER_LEFT);
        //root.setHgap(30);
        root.setVgap(30);
        root.setPadding(new Insets(30));
        root.add(label, 0, 0);
        root.add(studentName, 1, 0);
        root.add(buttonPlay, 0, 1);
        root.add(buttonStop, 0, 2);
        
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.1), event -> {
                studentName.setText(randomName());
            }));

        buttonPlay.setOnAction( e -> {
            timeline.setCycleCount(Timeline.INDEFINITE);
            //timeline.setCycleCount(10);
            timeline.play();
        });

        buttonStop.setOnAction( e -> {
            timeline.stop();
        });
           
        Scene scene = new Scene(root, 500, 500);
        // Set the scene on the primary stage and show it
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX Application");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public String randomName() {
        String[] names = {"John Doe", "Jane Doe", "John Smith", "Jane Smith", "John Jones", "Jane Jones", "John Williams", "Jane Williams", "John Brown", "Jane Brown"};
        int random = (int) (Math.random() * 10);
        return names[random];
    }
}
