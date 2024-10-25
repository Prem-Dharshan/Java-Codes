package WS09.WS09_PS10;

import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.StrokeLineJoin;

public class Digit extends Parent {

    private final Color colorLit = Color.BLACK,
            strokeColor = Color.color(0d,0d,0d,0.3d),
            colorUnlit = Color.TRANSPARENT;

    private class Segment extends Polygon {

        public Segment(double[] d)
        {
            super(d);
            setStroke(strokeColor);
            setStrokeWidth(0.5);
            setStrokeLineJoin(StrokeLineJoin.ROUND);
        }

    }

    private final Segment[] polygons = new Segment[]{
            new Segment(new double[]{0,  2,  10, 12, 10, 47,  0,  52 }),
            new Segment(new double[]{0,  56, 10, 61, 10, 96,  0,  106}),
            new Segment(new double[]{2,  0,  52, 0,  42, 10,  12, 10 }),
            new Segment(new double[]{12, 49, 42, 49, 52, 54,  42, 59, 12d, 59d, 2d, 54d}),
            new Segment(new double[]{12, 98, 42, 98, 52, 108, 2,  108}),
            new Segment(new double[]{44, 12, 54, 2,  54, 52,  44, 47 }),
            new Segment(new double[]{44, 61, 54, 56, 54, 106, 44, 96 })};

    public Digit()
    {
        super.getChildren().addAll(polygons);
    }


    public void set(final SevenSegDigit dig)
    {
        assert dig!=null : "digits null";
        SevenSegDigit.ElState[] states = dig.getSegStates();
        assert states.length==7 : "need 7 segments";

        for (int i=0; i<7; i++)
        {
            if (SevenSegDigit.ElState.ON.equals(states[i]))
            {
                assert Platform.isFxApplicationThread();
                polygons[i].setFill(colorLit);
            } else
            {
                assert Platform.isFxApplicationThread();
                polygons[i].setFill(colorUnlit);
            }
        }


    }



    public static int getWidth() {
        return 50;
    }


}