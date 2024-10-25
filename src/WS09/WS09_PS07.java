/* 7. Develop a simple calculator using Swings & JavaFX components. */

package WS09;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class SwingCalculator extends JFrame {
    private final JTextField tfDisplay;
    private int result = 0;
    private String numberInStr = "";
    private char previousOpr = ' ';
    private char currentOpr = ' ';

    public SwingCalculator() {
        tfDisplay = new JTextField(20);
        tfDisplay.setEditable(false);
        tfDisplay.setHorizontalAlignment(JTextField.RIGHT);
        JPanel displayPanel = new JPanel();
        displayPanel.add(tfDisplay);

        JPanel btnPanel = new JPanel(new GridLayout(4, 4, 5, 5));
        NumberBtnListener numListener = new NumberBtnListener();
        OprBtnListener oprListener = new OprBtnListener();

        String[] buttons = {"7", "8", "9", "+", "4", "5", "6", "-",
                "1", "2", "3", "*", "C", "0", "=", "/"};
        for (String text : buttons) {
            JButton btn = new JButton(text);
            if (text.matches("\\d")) btn.addActionListener(numListener);
            else btn.addActionListener(oprListener);
            btnPanel.add(btn);
        }

        setLayout(new BorderLayout());
        add(displayPanel, BorderLayout.NORTH);
        add(btnPanel, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setTitle("Swing Calculator");
        setVisible(true);
    }

    class NumberBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            numberInStr += evt.getActionCommand();
            tfDisplay.setText(numberInStr);
        }
    }

    class OprBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            previousOpr = currentOpr;
            currentOpr = evt.getActionCommand().charAt(0);
            if (currentOpr == 'C') {
                result = 0;
                numberInStr = "";
                tfDisplay.setText("");
            } else if (currentOpr == '=') {
                calculate();
                tfDisplay.setText(result + "");
                numberInStr = "";
            } else {
                if (!numberInStr.isEmpty()) calculate();
                tfDisplay.setText(result + "");
                numberInStr = "";
            }
        }
    }

    private void calculate() {
        int num = numberInStr.isEmpty() ? 0 : Integer.parseInt(numberInStr);
        switch (previousOpr) {
            case ' ': result = num; break;
            case '+': result += num; break;
            case '-': result -= num; break;
            case '*': result *= num; break;
            case '/': result /= num; break;
        }
    }

    public static void main() {
        new SwingCalculator();
    }
}
