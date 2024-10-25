package GUI;

import javax.swing.*;
import java.awt.*;

public class Panels {

    public static void main(String[] args){

        JFrame frame = new JFrame("Panels");

        frame.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setBounds(50, 50, 100, 100);

        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.RED);
        panel1.setBounds(150, 50, 100, 100);

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.BLUE);
        panel2.setBounds(50, 150, 100, 100);

        ImageIcon icon = new ImageIcon("src/GUI/1.png");
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);

        icon = new ImageIcon(newImg);

        JLabel label = new JLabel(icon);
        label.setBounds(150, 150, 100, 100);
        label.setText("Image");
        label.setIcon(icon);

        panel.add(label);

        frame.add(panel);
        frame.add(panel1);
        frame.add(panel2);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setVisible(true);

    }
}
