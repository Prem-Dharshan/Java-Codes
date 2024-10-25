package WS09.WS09_PS10;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    private ClockTimer ct;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("7 Segment Clock");
        Group root = new Group();


        DigitalClock dc = new DigitalClock();
        ct = new ClockTimer();
        ct.start(dc);
        root.getChildren().add(dc);

        primaryStage.setScene(new Scene(root, 475, 150, Color.WHITE));
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        try {
            ct.stop();
        } finally {
            super.stop();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}