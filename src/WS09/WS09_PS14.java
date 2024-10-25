package WS09;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;
import javafx.scene.text.Font;

public class WS09_PS14 extends Application {

    private long startTime = 0;
    private long elapsedTime = 0;
    private boolean running = false;
    private AnimationTimer timer;

    private Text timeDisplay;
    private Button controlButton;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Stopwatch");

        // Time display
        timeDisplay = new Text("00:00:00");
        timeDisplay.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 68));

        // Control buttons
        controlButton = new Button("Start");
        Button clearButton = new Button("Clear");

        // HBox for buttons
        HBox buttonPane = new HBox(10, controlButton, clearButton);
        buttonPane.setStyle("-fx-alignment: center; -fx-padding: 10;");

        controlButton.setOnAction(_ -> toggleTimer());
        clearButton.setOnAction(_ -> clearTimer());

        BorderPane mainLayout = new BorderPane();
        mainLayout.setCenter(timeDisplay);
        mainLayout.setBottom(buttonPane);

        Scene scene = new Scene(mainLayout, 300, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void toggleTimer() {
        if (!running) {
            startTime = System.currentTimeMillis() - elapsedTime;
            timer = new AnimationTimer() {
                @Override
                public void handle(long now) {
                    elapsedTime = System.currentTimeMillis() - startTime;
                    updateDisplay(); // Update display
                }
            };
            timer.start();
            controlButton.setText("Pause");
            running = true;
        } else {
            timer.stop();
            controlButton.setText("Resume");
            running = false;
        }
    }

    private void clearTimer() {
        if (running) {
            timer.stop();
        }
        elapsedTime = 0;
        updateDisplay();
        controlButton.setText("Start");
        running = false;
    }

    private void updateDisplay() {
        long seconds = (elapsedTime / 1000) % 60;
        long minutes = (elapsedTime / (1000 * 60)) % 60;
        long hours = (elapsedTime / (1000 * 60 * 60)) % 24;

        timeDisplay.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
    }
}
