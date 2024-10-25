package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ColorChkBoxApp {
    public static void main(String[] args){
        Abc abc = new Abc();
    }
}

class Abc extends JFrame {

    JTextField textField1 = new JTextField("Operand 1", 10);
    JTextField textField2 = new JTextField("Operand 2", 10);
    JLabel ans = new JLabel("Ans");
    JButton btn = new JButton("Add");
    JButton btn2 = new JButton("Subtract");

    public Abc() {

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        add(panel);

        textField1.setBounds(50, 50, 100, 30);
        add(textField1);

        textField2.setBounds(50, 100, 100, 30);
        add(textField2);

        btn.setBounds(50, 150, 100, 30);
        add(btn);

        btn2.setBounds(50, 250, 100, 30);
        add(btn2);

        btn.addActionListener((_) -> {
            try {
                int num1 = Integer.parseInt(textField1.getText());
                int num2 = Integer.parseInt(textField2.getText());
                int result = num1 + num2;
                ans.setText("Ans: " + result);
            } catch (NumberFormatException ex) {
                ans.setText("Invalid input");
            }
        });

        btn2.addActionListener((_) -> {
            try {
                int num1 = Integer.parseInt(textField1.getText());
                int num2 = Integer.parseInt(textField2.getText());
                int result = num1 - num2;
                ans.setText("Ans: " + result);
            } catch (NumberFormatException ex) {
                ans.setText("Invalid input");
            }
        });

        ans.setBounds(50, 200, 200, 30);
        add(ans);

        JRadioButton r1 = new JRadioButton("Red");
        JRadioButton r2 = new JRadioButton("Green");
        JRadioButton r3 = new JRadioButton("Blue");

        r1.setBounds(50, 300, 100, 30);
        r2.setBounds(50, 350, 100, 30);
        r3.setBounds(50, 400, 100, 30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);

        JLabel colorLabel = new JLabel("Color");
        colorLabel.setBounds(50, 450, 100, 30);
        add(colorLabel);

        add(r1);
        add(r2);
        add(r3);

        r1.addActionListener((_) -> {
            getContentPane().setBackground(Color.RED);
            colorLabel.setText("Color: Red");
        });

        r2.addActionListener((_) -> {
            getContentPane().setBackground(Color.GREEN);
            colorLabel.setText("Color: Green");
        });

        r3.addActionListener((_) -> {
            getContentPane().setBackground(Color.BLUE);
            colorLabel.setText("Color: Blue");
        });

        JCheckBox checkBox1 = new JCheckBox("Red");
        checkBox1.setBounds(50, 500, 100, 30);
        add(checkBox1);

        JCheckBox checkBox2 = new JCheckBox("Blue");
        checkBox2.setBounds(50, 550, 100, 30);
        add(checkBox2);

        JCheckBox checkBox3 = new JCheckBox("Green");
        checkBox3.setBounds(50, 600, 100, 30);
        add(checkBox3);

        JLabel colorLabel2 = new JLabel("Color");
        colorLabel2.setBounds(50, 650, 100, 30);
        add(colorLabel2);

        checkBox1.addItemListener((_) -> {
            int r = checkBox1.isSelected() ? 255 : 0;
            int g = checkBox2.isSelected() ? 255 : 0;
            int b = checkBox3.isSelected() ? 255 : 0;
            getContentPane().setBackground(new Color(r, g, b));
            colorLabel2.setText("Color: Red");
        });

        checkBox2.addItemListener((_) -> {
            int r = checkBox1.isSelected() ? 255 : 0;
            int g = checkBox2.isSelected() ? 255 : 0;
            int b = checkBox3.isSelected() ? 255 : 0;
            getContentPane().setBackground(new Color(r, g, b));
            colorLabel2.setText("Color: Blue");
        });

        checkBox3.addItemListener((_) -> {
            int r = checkBox1.isSelected() ? 255 : 0;
            int g = checkBox2.isSelected() ? 255 : 0;
            int b = checkBox3.isSelected() ? 255 : 0;
            getContentPane().setBackground(new Color(r, g, b));
            colorLabel2.setText("Color: Green");
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                getContentPane().setBackground(Color.WHITE);
                colorLabel2.setText("Color");
                int x = e.getX();
                int y = e.getY();
                setTitle("Mouse clicked at: " + x + ", " + y);
            }
        });

        setSize(400, 400);
        setTitle("Simple Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

