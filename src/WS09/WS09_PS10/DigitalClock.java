package WS09.WS09_PS10;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.text.Text;

import java.time.LocalTime;

public class DigitalClock extends Parent implements ClockTimer.TimerEvent {

    Digit h1, h2, m1, m2, s1, s2;
    Text amPmText;

    public DigitalClock()
    {

        Group hoursMinSpacer,
                minSecSpacer,
                digitsHours,
                digitsMins,
                digitsSecs;

        h1 = new Digit();
        h1.setLayoutX(20);
        h1.setLayoutY(20);

        h2 = new Digit();
        h2.setLayoutX(20+Digit.getWidth()+20);
        h2.setLayoutY(20);

        Dot top1 = new Dot();
        top1.setLayoutX(20 + Digit.getWidth() * 2 + 20 + 20);
        top1.setLayoutY(50);
        Dot bottom1 = new Dot();
        bottom1.setLayoutX(20 + Digit.getWidth() * 2 + 20 + 20);
        bottom1.setLayoutY(100);

        m1 = new Digit();
        m1.setLayoutX(20);
        m1.setLayoutY(20);
        m2 = new Digit();
        m2.setLayoutX(20+Digit.getWidth()+20);
        m2.setLayoutY(20);

        Dot top2 = new Dot();
        top2.setLayoutX(20 + Digit.getWidth() * 2 + 20 + 20);
        top2.setLayoutY(50);
        Dot bottom2 = new Dot();
        bottom2.setLayoutX(20 + Digit.getWidth() * 2 + 20 + 20);
        bottom2.setLayoutY(100);

        s1 = new Digit();
        s1.setLayoutX(20);
        s1.setLayoutY(20);
        s2 = new Digit();
        s2.setLayoutX(20+Digit.getWidth()+20);
        s2.setLayoutY(20);

        digitsHours = new Group(h1,h2);
        digitsMins  = new Group(m1, m2);
        digitsMins.setLayoutX(digitsMins.getLayoutX() + Digit.getWidth()*2 + 35 + 20);
        digitsSecs = new Group(s1, s2);
        digitsSecs.setLayoutX(digitsSecs.getLayoutX() + + Digit.getWidth()*4 + 70 + 40);

        hoursMinSpacer = new Group(top1, bottom1);
        minSecSpacer = new Group(top2, bottom2);

        minSecSpacer.setLayoutX( minSecSpacer.getLayoutX() + Digit.getWidth() * 2 + 35 + 20 );

        super.getChildren().addAll(digitsHours, digitsMins, digitsSecs, hoursMinSpacer, minSecSpacer);

        // Initialize and set up the AM/PM text
        amPmText = new Text();
        amPmText.setLayoutX(digitsSecs.getLayoutX() + Digit.getWidth() * 3 + 10); // Adjust position as needed
        amPmText.setLayoutY(125); // Set Y position to align with the seconds display
        amPmText.setStyle("-fx-font-size: 10px;"); // Set font size to be small
        super.getChildren().add(amPmText);
    }

    @Override
    public void timeGiven(SevenSegTime t) {

        SevenSegDigit[] time = t.getTime();

        h1.set(time[SevenSegTime.DIGIT_H1]);
        h2.set(time[SevenSegTime.DIGIT_H2]);
        m1.set(time[SevenSegTime.DIGIT_M1]);
        m2.set(time[SevenSegTime.DIGIT_M2]);
        s1.set(time[SevenSegTime.DIGIT_S1]);
        s2.set(time[SevenSegTime.DIGIT_S2]);

        // Get current hour using LocalTime
        LocalTime now = LocalTime.now();
        int hour = now.getHour(); // Get the current hour (0-23)

        // Determine AM or PM and update the text
        amPmText.setText(hour < 12 ? "AM" : "PM");
    }
}
