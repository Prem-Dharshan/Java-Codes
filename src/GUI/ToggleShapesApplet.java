package GUI;

import javax.swing.*;
import java.applet.Applet;
import java.awt.*;

public class ToggleShapesApplet {

    public static void main(String[] args) {
        // Create a JFrame for the Swing application
        JFrame frame = new JFrame("Concentric Shapes Applet Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        // Create an instance of the applet and initialize it
        AppletExample applet = new AppletExample();
        applet.init();  // Call the applet's init method

        // Add the applet to the JFrame's content pane
        frame.getContentPane().add(applet, BorderLayout.CENTER);

        // Start a timer to toggle shapes every second
        Timer timer = new Timer(1000, _ -> {
            applet.toggleShapes();  // Toggle shapes
            applet.repaint();       // Request a repaint to redraw shapes
        });
        timer.start();  // Start the timer

        // Make the JFrame visible
        frame.setVisible(true);
    }
}

// A simple Applet that draws shapes
class AppletExample extends Applet {
    private boolean drawCircles = true;

    // Initialize the applet
    public void init() {
        setBackground(Color.GRAY);  // Set the background color to gray
        System.out.println("Applet initialized.");
    }

    // Method to toggle between shapes
    public void toggleShapes() {
        drawCircles = !drawCircles;  // Toggle between circles and squares
        System.out.println("Shapes toggled.");
    }

    // Paint method to draw shapes
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // Get the size of the applet
        int width = getWidth();
        int height = getHeight();

        // Calculate the center and sizes for the shapes
        int centerX = width / 2;
        int centerY = height / 2;
        int outerSize = Math.min(width, height) - 50;
        int midSize = outerSize - 40;
        int innerSize = midSize - 40;

        // Draw outer shape (circle or square) filled with Saffron color
        g.setColor(Color.ORANGE);  // Saffron color
        if (drawCircles) {
            g.fillOval(centerX - outerSize / 2, centerY - outerSize / 2, outerSize, outerSize);  // Circle
        } else {
            g.fillRect(centerX - outerSize / 2, centerY - outerSize / 2, outerSize, outerSize);  // Square
        }

        // Draw middle shape filled with White
        g.setColor(Color.WHITE);
        if (drawCircles) {
            g.fillOval(centerX - midSize / 2, centerY - midSize / 2, midSize, midSize);  // Circle
        } else {
            g.fillRect(centerX - midSize / 2, centerY - midSize / 2, midSize, midSize);  // Square
        }

        // Draw inner shape filled with Green
        g.setColor(Color.GREEN);
        if (drawCircles) {
            g.fillOval(centerX - innerSize / 2, centerY - innerSize / 2, innerSize, innerSize);  // Circle
        } else {
            g.fillRect(centerX - innerSize / 2, centerY - innerSize / 2, innerSize, innerSize);  // Square
        }
    }
}
