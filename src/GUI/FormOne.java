package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormOne {
    private JPanel panel1;
    private JTextField enterYourNameTextField;
    private JTextField enterYourClassTextField;
    private JButton button1;

    public FormOne() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = enterYourNameTextField.getText();
                String className = enterYourClassTextField.getText();
                JOptionPane.showMessageDialog(null, "Name: " + name + "\nClass: " + className);

            }
        });

        enterYourNameTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = enterYourNameTextField.getText();
                String className = enterYourClassTextField.getText();
                JOptionPane.showMessageDialog(null, "Name: " + name + "\nClass: " + className);

            }
        });

        enterYourClassTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = enterYourNameTextField.getText();
                String className = enterYourClassTextField.getText();
                JOptionPane.showMessageDialog(null, "Name: " + name + "\nClass: " + className);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("FormOne");
        frame.setContentPane(new FormOne().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

