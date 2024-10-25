package WS09;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Calendar;

public class WS09_PS11 extends Application {

    private final int WIDTH = 800;
    private final int HEIGHT = 400;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Analog Clock");

        Group root = new Group();
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        root.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawClock(gc);

        // Timeline for animation
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> drawClock(gc)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void drawClock(GraphicsContext gc) {
        // Clear the canvas
        gc.clearRect(0, 0, WIDTH, HEIGHT);

        // Get the current time
        Calendar time = Calendar.getInstance();
        int hour = time.get(Calendar.HOUR_OF_DAY);
        int minute = time.get(Calendar.MINUTE);
        int second = time.get(Calendar.SECOND);

        // Convert to 12-hour format
        if (hour > 12) {
            hour -= 12;
        }

        // Draw clock body
        gc.setFill(Color.WHITE);
        gc.fillOval(300, 100, 200, 200);

        gc.setStroke(Color.BLACK);
        gc.setLineWidth(1);
        gc.strokeOval(300, 100, 200, 200);

        // Labeling the clock
        gc.setFill(Color.BLACK);
        gc.fillText("12", 390, 120);
        gc.fillText("3", 480, 200);
        gc.fillText("6", 400, 290);
        gc.fillText("9", 310, 200);

        // Draw the hands of the clock
        drawHand(gc, (15 - second) * 6, 100, Color.RED);   // Second hand
        drawHand(gc, (15 - minute) * 6, 80, Color.BLUE);   // Minute hand
        drawHand(gc, (15 - (hour * 5)) * 6, 50, Color.BLACK); // Hour hand
    }

    private void drawHand(GraphicsContext gc, double angle, double length, Color color) {
        double radians = Math.toRadians(angle);
        int x = (int) (Math.cos(radians) * length);
        int y = (int) (Math.sin(radians) * length);
        gc.setStroke(color);
        gc.strokeLine(400, 200, 400 + x, 200 - y);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
