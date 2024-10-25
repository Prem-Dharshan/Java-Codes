package WS09.WS09_PS10;

import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class Dot extends Parent {

    public Dot() {
        Ellipse circle = new Ellipse(5, 5); // Set the radii directly
        circle.setStrokeWidth(0.5);
        circle.setStroke(Color.color(0d, 0d, 0d, 0.3d));
        circle.setFill(Color.BLACK);
        circle.setTranslateX(0); // Set centerX
        circle.setTranslateY(0); // Set centerY

        getChildren().add(circle);
    }
}
