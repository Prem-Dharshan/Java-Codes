package WS09;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class WS09_PS12 extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Chessboard");

        GridPane grid = new GridPane();

        int SIZE = 8;
        int SQUARE_SIZE = 60;
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                Rectangle square = new Rectangle(SQUARE_SIZE, SQUARE_SIZE);
                // Alternate colors based on the position
                if ((row + col) % 2 == 0) {
                    square.setFill(Color.WHITE);
                } else {
                    square.setFill(Color.BLACK);
                }
                grid.add(square, col, row);
            }
        }

        Scene scene = new Scene(grid, SIZE * SQUARE_SIZE, SIZE * SQUARE_SIZE);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
