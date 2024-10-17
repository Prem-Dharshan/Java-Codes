package GUI;

import javax.swing.*;

public class LookAndFeelExample {
    public static void main(String[] args) {
        // Set the Nimbus look and feel
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

            // Set the system look and feel
             UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Create a simple GUI
        JFrame frame = new JFrame("Pluggable Look and Feel Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JButton button = new JButton("Click Me");
        frame.add(button);

        frame.setVisible(true);
    }
}
