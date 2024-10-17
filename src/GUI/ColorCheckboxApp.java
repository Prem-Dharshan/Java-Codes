package GUI;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ColorCheckboxApp {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Color Checkbox App");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create checkboxes for RED, GREEN, and BLUE
        JCheckBox redCheckBox = new JCheckBox("RED");
        JCheckBox greenCheckBox = new JCheckBox("GREEN");
        JCheckBox blueCheckBox = new JCheckBox("BLUE");

        // Set up a panel to hold the checkboxes
        JPanel checkboxPanel = new JPanel();
        checkboxPanel.setLayout(new GridLayout(3, 1));
        checkboxPanel.add(redCheckBox);
        checkboxPanel.add(greenCheckBox);
        checkboxPanel.add(blueCheckBox);

        // Add the checkbox panel to the EAST side of the frame
        frame.add(checkboxPanel, BorderLayout.EAST);

        // Set initial background color to white
        frame.getContentPane().setBackground(Color.WHITE);

        // Add item listeners for each checkbox
        ItemListener itemListener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                updateBackgroundColor(redCheckBox, greenCheckBox, blueCheckBox, frame);
            }
        };

        redCheckBox.addItemListener(itemListener);
        greenCheckBox.addItemListener(itemListener);
        blueCheckBox.addItemListener(itemListener);

        // Make the frame visible
        frame.setVisible(true);
    }

    // Method to update the background color based on selected checkboxes
    private static void updateBackgroundColor(JCheckBox red, JCheckBox green, JCheckBox blue, JFrame frame) {
        int r = red.isSelected() ? 255 : 0;
        int g = green.isSelected() ? 255 : 0;
        int b = blue.isSelected() ? 255 : 0;

        // Set the background color based on selected RGB values
        frame.getContentPane().setBackground(new Color(r, g, b));
    }
}
