package GUI;

import javax.swing.*;
import java.awt.*;


public class SimpleGUIApp {
    public static void main(String[] args) {
        // Create a new frame (window)
        JFrame frame = new JFrame("Simple GUI Application");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a label and a button
        JLabel label = new JLabel("Press the button!", SwingConstants.CENTER);
        JButton button = new JButton("Click Me");

        // Add an ActionListener to the button
        button.addActionListener(e -> label.setText("Button was clicked!"));

        // Set layout for the frame
        frame.setLayout(new BorderLayout());

        // Add the label and button to the frame
        frame.add(label, BorderLayout.CENTER);
        frame.add(button, BorderLayout.SOUTH);
        frame.add(new JLabel("This is a label at the top", SwingConstants.CENTER), BorderLayout.NORTH);

        // Make the frame visible
        frame.setVisible(true);
    }
}
